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

// ========================== board ==========================

var Board = function (boardString) {
    var board = eval(boardString);

    var questions = board.questions;
    var level = board.level;
    var lastQuestion = board.nextQuestion;

    var toString = function () {
        return board;
    };

    return {
        isLevelFinished: function() {
            return !lastQuestion;
        },
        toString: toString,
        getQuestions: function() {
            return questions;
        },
        getLastQuestion: function() {
            return lastQuestion;
        },
        getLevel: function() {
            return level;
        },
        getWholeBoard: function() {
            return board;
        },
        getQuestionAnswers : function () {
            if (board.history.length == 0) {
                return null;
            }
            var separator = '<br>&nbsp;&nbsp;'
            return separator +
                board.history.map(item => {
                    var equality = item.valid ? '==' : '!=';
                    var status = item.valid ? '✅' : '❌';
                    return `f(${item.question}) ${equality} ${item.answer} ${status}`;
                }).join(separator);
        }
    };
};