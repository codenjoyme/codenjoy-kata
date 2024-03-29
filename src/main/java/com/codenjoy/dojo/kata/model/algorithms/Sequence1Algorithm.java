package com.codenjoy.dojo.kata.model.algorithms;

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


import com.codenjoy.dojo.services.questionanswer.levels.AlgorithmLevelImpl;

import java.util.Arrays;
import java.util.List;

public class Sequence1Algorithm extends AlgorithmLevelImpl {


    @Override
    public String get(int number) {
        final int START_WITH = 10;
        final int GROUP = 3;
        final int MAX = number * GROUP;
        int i = 0;
        StringBuilder buffer = new StringBuilder();
        while(buffer.length() < MAX) {
            buffer.append(START_WITH + i);
            i++;
        }
        return buffer.substring(MAX - GROUP, MAX);
    }

    @Override
    public String winCode() {
        return "function program(number) {\n" +
                "    const START_WITH = 10;\n" +
                "    const GROUP = 3;\n" +
                "    const MAX = number * GROUP;\n" +
                "    let i = 0;\n" +
                "    let buffer = \"\";\n" +
                "    while (buffer.length < MAX) {\n" +
                "        buffer += START_WITH + i;\n" +
                "        i++;\n" +
                "    }\n" +
                "    return buffer.substring(MAX - GROUP, MAX);\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "Continue the sequence 101, 112, 131, 415, 161, 718... \n" +
                "i.e f(1) = 101, f(2) = 112, ...\n" +
                "Hint: Look at the whole picture");
    }

    @Override
    public String author() {
        return "Alexey.Shcheglov (Alexey_Shcheglov@epam.com)\n" +
                "http://nazva.net/78";
    }
}
