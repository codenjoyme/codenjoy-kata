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

var initLevelInfo = function(contextPath) {
    var settings = null;
    var count = 0;

    var decode = function(value) {
        return value;
    }

    var encode = function(value) {
        return value;
    }

    var filterKeys = function(settings, prefix) {
        return Object.keys(settings).filter(function(key) {
            return key.startsWith(prefix);
        });
    };

    var load = function(onLoad, onError) {
        var ajax = new AdminSettings(contextPath, 'kata', '_settings_');
        ajax.load(function(data) {
            settings = data.parameters;
            var keys = filterKeys(settings, '[Level] Map');
            var count = keys.length;
            if (!!onLoad) {
                onLoad(count);
            }
        }, onError);
    }

    var saveParameter = function(name, value) {
        get(name).value = value;

        // TODO не городить столько запросов, а послать 1
        var ajax = new AdminSettings(contextPath, 'kata', name);
        ajax.save(value);
    }

    var save = function(level, data) {
        var prefix = 'Level' + level + ' ';
        saveParameter(prefix + 'name', encode(data.name));
        saveParameter(prefix + 'help', encode(data.help));
        saveParameter(prefix + 'default code', encode(data.defaultCode));
        saveParameter(prefix + 'win code', encode(data.winCode));
    }

    var getLevel = function(level) {
        if (level > count) {
            return {
                name:'',
                help:'<pre>// under construction</pre>',
                defaultCode:'function program(question) {\n'  +
                '    // TODO write your code here\n' +
                '}',
                winCode:'function program(question) {\n'  +
                '    robot.nextLevel();\n' +
                '}'
            };
        }

        var prefix = 'Level' + level + ' ';
        return {
            name :             decode(get(prefix + 'name').value)
            // help :            decode(get(prefix + 'help').value),
            // defaultCode :     decode(get(prefix + 'default code').value),
            // winCode :         decode(get(prefix + 'win code').value)
        };
    }

    return {
        save : save,
        load : load,
        getLevel : getLevel,
        getCount : function() {
            return count;
        }
    }
}