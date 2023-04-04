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
function initRobot(logger, controller) {
    
    if (setup.debug) {
        setup.debugger();
    }
    
    var memory = null;

    memory = [];

    return {
        nextLevel: function() {
            controller.winCommand();
            controller.waitCommand();
        },
        reset: function() {
            controller.cleanCommand();
        },
        log : function(message) {
            if (typeof message == 'function') {
                message = message();
            }
            if (typeof message == 'object') {
                message = JSON.stringify(message);
            }
            logger.print(message);
        },
        getMemory : function() {
            return {
                has : function(key) {
                    return memory[key] != undefined;
                },
                save : function(key, value) {
                    memory[key] = value;
                },
                remove : function(key) {
                    var old = memory[key];
                    delete memory[key];
                    return old;
                },
                load : function(key) {
                    return memory[key];
                },
                clean : function() {
                    memory = [];
                }
            };
        },
        getScanner : function() {
            var b = new Board(board);

            var getWholeBoard = function() {
                return b.getWholeBoard();
            }

            var getQuestions = function() {
                return b.getQuestions();
            }

            var getLastQuestion = function() {
                return b.getLastQuestion();
            }

            var getLevel = function() {
                return b.getLevel();
            }

            return {
                getWholeBoard : getWholeBoard,
                getQuestions : getQuestions,
                getLastQuestion : getLastQuestion,
                getLevel : getLevel
            }
        }
    };
};