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
function initLogger() {
    // ----------------------- init logger -------------------
    var container = $('#ide-console');
    var wrapper = $('.console-wrapper');
    container.empty();

    $('#ide-console').on('click', '.copy-text', function() {
        var text = 'Console output:' +
            $(this).nextAll('.test-result').first().html()
                .replace(/<br>/g, '\n')
                .replace(/&nbsp;/g, ' ');
        copyToClipboard(text);
        sendParentMessage('send-content', text);
    });

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

    var print = function(message) {
        var autoScroll = Math.abs(wrapper.scrollTop() + wrapper.height() - wrapper[0].scrollHeight) < 20;

        container.append('<span class="copy-text">[copy]</span> &gt;'
            + '<span class="test-result"> ' + message + '</span></br>');

        if (autoScroll) {
            wrapper.scrollTop(wrapper[0].scrollHeight);
        }
    }

    var error = function(error, isCompile) {
        console.log(error);
        print('Error: ' + error.message);
        if (!!isCompile) {
            print('For details please check browser console (Ctrl-Shift-J), ' +
                  'fix error in your code, ' +
                  'then press \'COMMIT\' again.');
        } else {
            print('For debug please open browser console (Ctrl-Shift-J), ' +
                  'write \'debugger;\' in your code, ' +
                  'then press \'COMMIT\' again.');
        }
    }

    var clean = function() {
        container.empty();
    }

    return {
        print : print,
        error : error,
        clean : clean
    };
};