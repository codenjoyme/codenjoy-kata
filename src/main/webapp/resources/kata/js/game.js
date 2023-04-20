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

// ========================== for debugging ==========================

function compileProgram(code) {
    try {
        eval(code);
        eval(`function get() {
            return ${getMainFunctionName(code)};
        }`);
        return get();
    } catch (e) {
        throw e;
    }
}

function runProgram(program, question, robot) {
    try {
        return program(question, robot);
    } catch (e) {
        throw e;
    }
}

function getMainFunctionName(code) {
    const regex = /function\s+([a-zA-Z$_][a-zA-Z0-9$_]*)\s*\(/g;
    var result = [];
    var match;
    while ((match = regex.exec(code))) {
        result.push(match[1]);
    }
    if (result.length == 0) {
        return null;
    }
    if (result.includes('program')) {
        return 'program';
    }
    return result[0];
}

// ===================== copy text to clipboard ======================

var copyToClipboard = function(text) {
    $("body").append("<textarea id='copyArea' style='position:absolute;left:-100%'>" + text + "</textarea>");
    $("#copyArea").select();
    try {
        document.execCommand("copy");
    } catch (e) {
        console.log('Oops, unable to copy');
    }
    $("#copyArea").remove();
}

var copyToClipboardButton = function() {
    return '<span class="copy-text">[copy]</span>';
}

var copyToClipboardMessageContainer = function(message) {
    return '<span class="test-result">'
            + '<span>' + message + '</span>'
            + copyToClipboardButton()
            + '</span>';
}

var copyToClipboardButtonHandler = function(parent, getText) {
    $(parent).on('click', '.copy-text', function() {
        var data = $(this).parent().children().first().html()
                        .replace(/<br>/g, '\n')
                        .replace(/&nbsp;/g, ' ')
        var text = getText(data);
        copyToClipboard(text);
        sendParentMessage('send-content', text);
        $('<span class="copied-info">').text('copied')
            .appendTo($(this))
            .fadeIn('slow', function() {
                $(this).fadeOut('slow', function() {
                    $(this).remove();
                });
            });
    });
}

// ================== communication with parent window ======================

var addParentListener = function(messageType, onEvent) {
    window.addEventListener('message', function(event) {
        if (event.data.type !== messageType) {
            return;
        }

        if (!!onEvent) {
            onEvent(event.data);
        }
    });
}

var sendParentMessage = function(messageType, data) {
    if (!window.parent) {
        return;
    }
    window.parent.postMessage({ 'type' : messageType, 'value' : data}, "*");
}

// ========================== leaderboard page ==========================

var initLeaderboardLink = function() {
    var room = getSettings('room')
    $('#leaderboard-link').attr('href', setup.contextPath + '/board/room/' + room);
}

var initHelpLink = function() {
    var pageName = setup.gameMode.split(' ').join('-').toLowerCase();
    $('#help-link').attr('href', setup.contextPath + '/resources/kata/landing-' + pageName + '.html')
}

var initAdditionalLink = function() {
    if (setup.onlyLeaderBoard) {
        $('#additional-link').attr('href', 'https://github.com/codenjoyme/codenjoy-clients.git')
        $('#additional-link').text('Get client')
    }
}

var initLoginLogoutLink = function() {
    if (!!setup.code) {
        var link = setup.contextPath + '/process_logout';
        $('#login-logout-link').attr('href', link);
        $('#login-logout-link').html('Logout');
    } else {
        var link = setup.contextPath + '/login?game=kata';
        $('#login-logout-link').attr('href', link);
        $('#login-logout-link').html('Login');
    }
}

// ========================== user page ==========================

var leaderBoard = function(showProgress) {
    initLayout(setup.game, 'leaderboard.html', setup.contextPath,
        null,
        [],
        function() {
            boardAllPageLoad(!!showProgress);
            initHelpLink();
            initAdditionalLink();
            initLoginLogoutLink();
        });
}

var playerBoard = function() {
    initLayout(setup.game, 'board.html', setup.contextPath,
        null,
        [],
        function() {
            if (this.hasOwnProperty('boardPageLoad')) {
                boardPageLoad();
                initLeaderboardLink();
                initHelpLink();
                initAdditionalLink();
                initLoginLogoutLink();
            }
        });
}

// ========================== game setup ==========================

if (typeof setup == 'undefined') {
    setup = {};
    setup.demo = true;
    setup.code = 123;
    setup.playerId = 'userId';
    setup.readableName = 'Stiven Pupkin';
    initLayout = function(setup, html, context, transformations, scripts, onLoad) {
        onLoad();
    }
}

var controller;

setup.setupGame = function() {
    setup.enableDonate = false;
    setup.enableJoystick = false;
    setup.enablePlayerInfo = false;
    setup.enablePlayerInfoLevel = false;
    setup.enableLeadersTable = false;
    setup.enableChat = false;
    setup.enableInfo = false;
    setup.enableHotkeys = true;
    setup.enableForkMe = false;
    setup.enableAdvertisement = false;
    setup.showBody = false;
    setup.debug = false;
}

setup.onPageLoad = function(allPlayers) {
    if (allPlayers) {
        leaderBoard(false);
    } else if (setup.onlyLeaderBoard) {
        leaderBoard(true);
    } else {
        playerBoard();
    }
}

if (setup.demo) {
    setup.onPageLoad(false);
}