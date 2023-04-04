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
        return program;
    } catch (e) {
        throw e;
    }
}

function runProgram(program, robot) {
    try {
        program(robot);
    } catch (e) {
        throw e;
    }
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

// ========================== draw board ==========================

var getQuestionCoordinate = function(x, y) {
    return {x:(setup.onlyBoard ? x : 7), y:y + 1};
}

var getQuestionFormatted = function(value) {
    if (!!value.question) {
        var equals = (value.valid)?'==':'!=';
        var message = 'f(' + value.question + ') '
            + equals + ' ' + value.answer;
        return message;
    } else {
        var message = 'f(' + value + ') = ?';
        return message;
    }
}

function unescapeUnicode(unicode) {
    var r = /\\u([\d\w]{4})/gi;
    var temp = unicode.replace(r, function (match, grp) {
        return String.fromCharCode(parseInt(grp, 16));
    });
    return decodeURIComponent(temp).split("\\\"").join("\"");
}

var description = null;
var setDescription = function(text) {
    description = text;
}

setup.drawBoard = function(drawer) {
    drawer.clear();
    var centerX = (drawer.canvas.width() / drawer.canvas.plotSize())/2;

    var data = drawer.playerData.board;
    if (typeof setDescription != 'undefined') {
        setDescription(unescapeUnicode(data.description));
    }

    var isWaitNext = (data.questions.length == 0);
    if (isWaitNext) {
        drawer.drawText('Algorithm done! Wait next...',
            getQuestionCoordinate(centerX, 0), '#099');
        return;
    }

    var index = -1;
    var isNewLevel = (data.questions.length < data.history.length);
    if (!isNewLevel) {
        for (var key in data.history) {
            var value = data.history[key];
            if (value.question == data.nextQuestion) continue;

            drawer.drawText(getQuestionFormatted(value),
                getQuestionCoordinate(centerX, ++index),
                (value.valid)?'#090':'#900');
        }
    }

    drawer.drawText(getQuestionFormatted(data.nextQuestion),
        getQuestionCoordinate(centerX, ++index), '#099');
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