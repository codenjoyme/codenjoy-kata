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

const PARAM_GAME_MODE = 'gameMode';

const MODE_JS = 'javascript';
const MODE_CONTEST = 'contest';

setup.setupSprites = function() {

    var toLowerCase = function (param) {
        return (!!param) ? param.toLowerCase() : param;
    }

    setup.gameMode = toLowerCase(getSettings(PARAM_GAME_MODE, '#query'));
    setup.onlyControls = getSettings('controlsOnly', '#query');
    setup.onlyBoard = getSettings('only', '#query');

    if (setup.onlyControls) {
        setup.drawCanvases = false;
        setup.enableHeader = false;
        setup.enableFooter = false;
        if (!setup.gameMode) { // TODO удалить if после изменения линков на dojorena
            setup.gameMode = MODE_JS;
        }
    } else {
        setup.enableHeader = true;
        setup.enableFooter = true;
    }

    if (!setup.gameMode) {
        // check KEYS constants in register.js
        setup.gameMode = toLowerCase(localStorage.getItem(PARAM_GAME_MODE));

        // TODO почему-то сторится в сторадж строчка "undefined"
        if (setup.gameMode == 'undefined') {
            localStorage.removeItem(PARAM_GAME_MODE);
            setup.gameMode = null;
        }
    }

    // TODO это тут надо потому что join на main page и
    //      форма регистрации иногда отпускает без указания мода
    if (!setup.gameMode) {
        setup.gameMode = MODE_JS;
    }

    if (setup.gameMode == MODE_JS) {
        // do nothing
    } else if (setup.gameMode == MODE_CONTEST) {
        setup.onlyLeaderBoard = true;
    } else {
        throw new Error("Unknown Kata mode: " + setup.gameMode);
    }
}

// ========================== draw board ==========================

var description = null;
var setDescription = function(text) {
    description = text;
}

var getQuestionFormatted = function(item) {
    var equality = (item.last) ? '=' : (item.valid) ? '=' : '=';
    var answer = (!!item.answer) ? item.answer : item.expected;
    var expected = (!item.answer) ? '' : (!!item.expected) ? ' != ' + item.expected : '';
    return `f(${item.question}) ${equality} ${answer}${expected}`;
}

var getQuestionsFormatted = function(board) {
    var questions = board.history;
    if (questions.length == 0) {
        questions = [{
            last: true,
            valid: false,
            question: board.nextQuestion,
            answer: null,
            expected: board.expectedAnswer
        }];
    }
    return questions.map(item => {
        if (item.question == board.nextQuestion) {
            var valid = board.expectedAnswer == item.answer;
            item = {
                last: true,
                valid: valid,
                question: board.nextQuestion,
                answer: item.answer,
                expected: (!valid) ? board.expectedAnswer : null
            };
        }
        return {
            text : getQuestionFormatted(item),
            valid : item.valid
        };
    });
}

setup.drawBoard = function(drawer) {
    var getQuestionCoordinate = function(x, y) {
        return {x:(setup.onlyBoard ? x : 7), y:y + 1};
    }

    function unescapeUnicode(unicode) {
        var r = /\\u([\d\w]{4})/gi;
        var temp = unicode.replace(r, function (match, grp) {
            return String.fromCharCode(parseInt(grp, 16));
        });
        return decodeURIComponent(temp).split("\\\"").join("\"");
    }

    drawer.clear();
    var centerX = (drawer.canvas.width() / drawer.canvas.plotSize())/2;

    var board = drawer.playerData.board;
    if (typeof setDescription != 'undefined' && !!board.description) {
        setDescription(board.description.map(string => unescapeUnicode(string)));
    }

    if (setup.unauthorized) {
        drawer.drawText('Please login...',
            getQuestionCoordinate(centerX, 0), '#03cece');
        return;
    }

    var isWaitNext = (board.questions.length == 0);
    if (isWaitNext) {
        drawer.drawText('Algorithm done! Wait next...',
            getQuestionCoordinate(centerX, 0), '#03cece');
        return;
    }

    var index = -1;
    var isNewLevel = (board.questions.length < board.history.length);
    if (!isNewLevel) {
        getQuestionsFormatted(board)
            .forEach(item => {
                drawer.drawText(item.text,
                    getQuestionCoordinate(centerX, ++index),
                    (item.valid) ? '#4fee4f' : '#ff6e6e');
            });
    }
}