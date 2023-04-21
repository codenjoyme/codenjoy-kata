/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2012 - 2022 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

var boardPageLoad = function() {

    if (setup.debug) {
        setup.debugger();
    }

    var libs = setup.contextPath + '/resources/' + setup.game + '/js';
    if (setup.demo) {
        libs = 'js';
    }

    // ------------------------ headers/footers/board --------------------
    if (!setup.enableHeader) {
        $('.header-container').hide();
    }
    if (!setup.enableFooter) {
        $('footer.footer').hide();
    }
    if (!setup.drawCanvases) {
        $('#main').addClass('editor-fullscreen');
        $('#editor-panel').hide();
    }

    // ----------------------- disable backspace -------------------
    $(document).on('keydown', function(e) {
        if ((e.which === 8 || e.which === 32
            || e.which === 37 || e.which === 38
            || e.which === 39 || e.which === 40)
                && !$(e.target).is('input, textarea'))
        {
            e.preventDefault();
        }
    });
    // ----------------------- init tooltip -------------------
    $('[data-toggle="tooltip"]').tooltip();

    // ----------------------- init logger -------------------
    var logger = initLogger();
    logger.printCongrats = function() {
        logger.print('Congrats ' + setup.readableName + '! You have passed the puzzle!!! Please press RESET and go to next level.');
    }

    logger.printHello = function() {
        logger.print('Hello ' + setup.readableName + '. Waiting for your program...');
    }

    // ----------------------- init slider -------------------
    var setupSlider = function() {
        $("#console-panel").click(function(){
            if ($("#console").hasClass("open")) {
                $("#console").removeClass("open").addClass("close");
                $("#block").removeClass("console-open").addClass("console-close");
                $("#console-panel-icon").removeClass("fa-angle-right").addClass("fa-angle-left");
            } else {
                $("#console").removeClass("close").addClass("open");
                $("#block").removeClass("console-close").addClass("console-open");
                $("#console-panel-icon").removeClass("fa-angle-left").addClass("fa-angle-right");
            }
        });

        $("#editor-panel").click(function(){
            if (!$("#main").hasClass("editor-fullscreen")) {
                $("#main").addClass("editor-fullscreen");
                $("#editor-panel-icon").removeClass("fa-angle-left").addClass("fa-angle-right");
            } else {
                $("#main").removeClass("editor-fullscreen");
                $("#editor-panel-icon").removeClass("fa-angle-right").addClass("fa-angle-left");
            }
        });
    }
    setupSlider();

    // ----------------------- win window --------------
    var initWin = function() {
        var close = $("#close-level-modal");
        var next = $("#next-level-modal");
        var previous = $("#previous-level-modal");

        var show = function() {
            $("#modal-level").removeClass("close");
        };

        var hide = function() {
            $("#modal-level").addClass("close");
        };

        var hidePrevious = function() {
            // previous.hide() мы не можем использовать потому
            // что элемент еще не отображен
            previous.css('visibility', 'hidden');
        }

        close.click(function(){
            hide();
        });

        next.click(function(){
            hide();
        });

        previous.click(function(){
            hide();
        });

        $("body").keydown(function(event){
            if (event.which == 27){
                close.click();
            }
        });

        hidePrevious();

        return {
            show : show,
            hidePrevious: hidePrevious
        };
    };
    var win = initWin();

    // ----------------------- init help modal -------------------
    $("#close").click(function(){
        $("#modal").addClass("close");
    });
    $("body").keydown(function(event){
        if (event.which == 27){
            $("#close").click();
        }
    });

    // ----------------------- init buttons -------------------
    var onCommitClick = function() {
        buttons.disableAll();
        resetRobot();
        controller.commit();
    }
    var onResetClick = function() {
        buttons.disableAll();
        controller.reset();
    }
    var onHelpClick = function() {
        var levelNumber = levelProgress.getCurrentLevel();
        var level = levelInfo.getLevel(levelNumber);
        if (!!level) {
            help = level.help;
        } else if (!!description) {
            help = description;
        } else {
            help = ["No help for this level"];
        }

        if (help.toString().includes("Wait for next level")) {
            help = ["Wait for next level. Please click RESET button."];
        }

        var unescape = function(string) {
            return string.replace(/\n/g, "<br>")
                        .replace(/\\n/g, "<br>");
        }

        help = help.map(string => unescape(string));

        var containerId = '#ide-help-window';
        var container = $(containerId);
        container.html(copyToClipboardMessageContainer(help[0]));
        copyToClipboardButtonHandler(containerId, function(data) {
            return 'Info:\n' + data;
        });

        $("#modal").removeClass("close");
    };
    var buttons = initButtons(onCommitClick, onResetClick, onHelpClick);

    // ----------------------- init storage -------------------
    var storage = {
        getKey : function(property) {
            return property + '[' + setup.playerId + ']';
        },
        load : function(property) {
            return JSON.parse(localStorage.getItem(this.getKey(property)));
        },
        save : function(property, data) {
            localStorage.setItem(this.getKey(property), JSON.stringify(data));
        }
    };
    // ----------------------- init level info -----------------------------
    var levelInfo = initLevelInfo(setup.contextPath);
    levelInfo.load(
        function() {
            nextStep();
        },
        function(error){
            alert('Error when loading levels from server: ' + error);
        });
    var getCurrentLevelInfo = function(level){
        var forLevel = (typeof level != 'undefined') ? level : levelProgress.getCurrentLevel();
        return levelInfo.getLevel(forLevel);
    };

    var runner = null;
    var levelProgress = null;
    var controller = null;
    var resetRobot = null;

    var nextStep = function() {
        // ----------------------- init runner -------------------
        runner = initRunnerJs(setup, libs, getCurrentLevelInfo, storage);
        // ------------------------ init socket ----------------------
        var onSocketMessage = function(data) {
            controller.onMessage(data);
        }
        var onSocketClose = function() {
            controller.reconnect();
        }
        var socket = initSocket(setup, buttons, logger, onSocketMessage, onSocketClose);

        // ----------------------- init progressbar -------------------
        var onChangeLevel = function(level, multiple, lastPassed, isLevelIncreased, isWin) {
            if (isWin) {
                win.show();
                logger.clean();
                logger.printHello();
            }
            if (isLevelIncreased) {
                runner.levelUpdate(level, multiple, lastPassed);
            }
            initAutocomplete(level, levelInfo);

            sendParentMessage('change-level', level);
        }
        levelProgress = initLevelProgress(setup, onChangeLevel);

        // ------------------------ init controller ----------------------
        controller = initController(socket, runner, logger, buttons, levelProgress, function() {
            return robot;
        });

        var robot = null;
        resetRobot = function() {
            robot = initRobot(logger, controller);
        }
        resetRobot();

        // ----------------------- starting UI -------------------
        if (setup.demo) {
            var data = '{"' + setup.playerId + '":{"board":"{"levelProgress":{"total":18,"current":3,"lastPassed":15,"multiple":false},"layers":["OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOCDDDDEOOOOOOOOOOJXBBYFOOOOOOOOOOIHHHHGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAcAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"]}","game":"kata","score":150,"maxLength":0,"length":0,"level":1,"boardSize":16,"info":"","scores":"{"' + setup.playerId + '":150}","coordinates":"{"' + setup.playerId + '":{"y":8,"x":9}}"}}';
            $('body').trigger('board-updated', JSON.parse(data));
        }
        buttons.disableAll();
        $(document.body).show();

        if (setup.unauthorized) {
            buttons.disableHelp();

            var loginLink = $('#login-logout-link');
            var link = loginLink.attr('href');
            loginLink.text('Login');
            logger.print('<a href="' + link + '">Please login</a>');

            runner.setStubValue();
            return;
        }

        runner.loadSettings();

        socket.connect(function() {
            buttons.enableAll();
        });
    }
};