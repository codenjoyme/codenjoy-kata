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

function cutFunction(data) {
    var pos = data.indexOf('```');
    if (pos != -1) {
        data = data.substring(pos + 3);
        data = data.substring(data.indexOf('\n') + 1, data.indexOf('\n```'));
        return data;
    }

    pos = data.indexOf('function ');
    if (pos != 0) {
        pos = data.indexOf('\nfunction ');
        if (pos == -1) {
            pos = data.indexOf('\n    function ');
            if (pos == -1) {
                pos = data.indexOf('\n  function ');
                if (pos == -1) {
                    return null;
                } else {
                    pos = pos + 1;
                }
            } else {
                pos = pos + 1;
            }
        } else {
            pos = pos + 1;
        }
    } else {
       // do nothing
    }

    var pos2 = data.indexOf('\n}\n\n');
    if (pos2 == -1) {
        pos2 = data.lastIndexOf('\n}\n');
        if (pos2 == -1) {
            pos2 = data.lastIndexOf('\n}');
            if (pos2 == -1) {
                pos2 = data.lastIndexOf('}');
            } else {
                pos2 = pos2 + 1;
            }
        } else {
            pos2 = pos2 + 1;
        }
    } else {
        pos2 = pos2 + 1;
    }
    if (pos2 == -1) {
        pos2 = data.length - 2;
    }
    data = data.substring(pos, pos2 + 1);
    return data;
}

function initRunnerJs(setup, libs, getLevelInfo, storage) {
    
    if (setup.debug) {
        setup.debugger();
    }
    
    var starting = true;

    var container = $('#ide-content');
    container.empty();
    container.append('<pre id="ide-block" class="editor"></pre>');

    var editor = initEditor(libs, 'ide-block', autocomplete);

    editor.on('focus', function() {
        setup.savedEnableJoystick = setup.enableJoystick;
        setup.enableJoystick = false;
    });

    editor.on('blur', function() {
        setup.enableJoystick = !!setup.savedEnableJoystick;
        setup.savedEnableJoystick = null;
    });

    var typeCounter = 0;
    var clean = null;
    editor.on('change', function() {
        if (setup.unauthorized) {
            return;
        }

        if (!starting && editor.getValue() == '') {
            clean = 0;
        }

        if (typeCounter++ % 10 == 0) {
            saveSettings();
        }
    });

    addParentListener('update-editor', function(data) {
        if (!!data.code) {
            var code = cutFunction(data.code); // TODO remove this hotfix
            if (code != null) {
                editor.setValue(code, 1);
            }
        }
    });

    $('body').bind("tick", function() {
        if (setup.unauthorized) {
            return;
        }

        if (clean != null) {
            clean++;
            if (clean == 2) {
                clean = null;
                if (editor.getValue() == '') {
                    editor.setValue(getDefaultEditorValue(), 1);
                } else if (editor.getValue() == 'win') {
                    editor.setValue(getWinEditorValue(), 1);
                }
            }
        }
    });

    var getDefaultEditorValue = function() {
        return getLevelInfo().defaultCode;
    }

    var getWinEditorValue = function() {
        return getLevelInfo().winCode;
    }

    // ----------------------- save ide code -------------------
    var saveSettings = function() {
        var text = editor.getValue();
        if (!!text && text != '') {
            var data = {
                code : text,
                position : editor.selection.getCursor()
            }
            storage.save('editor', data);
        }
    }
    var loadSettings = function() {
        try {
            var data = storage.load('editor');
            if (!!data && data.code != stubValue) {
                editor.setValue(data.code);
                editor.focus();
                editor.selection.moveTo(data.position.row, data.position.column);
            } else {
                editor.setValue(getDefaultEditorValue());
            }
        } catch (e) {
            // do nothing
        }
        if (starting) {
            starting = false;
        }
    }
    $(window).on('unload', saveSettings);

    var functionToRun = null;
    var stubValue = 'function program(question) {\n' +
        '    // PLEASE LOGIN\n' +
        '}';

    return {
        loadSettings : loadSettings,
        getValue : function() {
            return editor.getValue();
        },
        setStubValue : function() {
            editor.setValue(stubValue);
        },
        setDefaultValue : function() {
            editor.setValue(getDefaultEditorValue());
        },
        compileProgram : function(robot) {
            var code = editor.getValue();
            functionToRun = compileProgram(code); // TODO add robot here?
        },
        cleanProgram : function() {
            functionToRun = null;
        },
        isProgramCompiled : function() {
            return functionToRun != null;
        },
        runProgram : function(question, robot) {
            return runProgram(functionToRun, question, robot);
        },
        levelUpdate: function(level, multiple, lastPassed) {
            // do nothing
        }
    };
}