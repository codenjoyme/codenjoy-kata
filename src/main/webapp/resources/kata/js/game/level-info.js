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
        return value.split("\\\\'").join("'").split('\\\\"').join('"');
    }

    var encode = function(value) {
        return value;
    }

    var filterKeys = function(settings, prefix) {
        return settings.map(obj => obj['name'].startsWith(prefix) ? [obj] : []).flat();
    };

    var load = function(onLoad, onError) {
        var ajax = new AdminSettings(contextPath, 'kata', '_settings_');
        ajax.load(function(data) {
            settings = data.parameters;
            var keys = filterKeys(settings, '[Level] Map');
            count = keys.length;
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
        var key = '[Level] Map[' + level + ']';
        var json = {
            name : data.name,
            help : data.help,
            defaultCode : data.defaultCode,
            winCode : data.winCode
        };
        saveParameter(key, encode(json));
    }

    var get = function(key) {
        return filterKeys(settings, key)[0].value;
    }

    var getLevel = function(level) {
        if (level > count) {
            return {
                name:'',
                help:'<pre>// under construction</pre>',
                defaultCode:'function program(question) {\n'  +
                '    // TODO implement your logic here\n' +
                '    return \'answer\';\n' +
                '}',
                winCode:'function program(question) {\n'  +
                '    robot.nextLevel();\n' +
                '}'
            };
        }

        var key = '[Level] Map[' + level + ']';
        return JSON.parse(decode(get(key)));
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