package com.codenjoy.dojo.kata.model.algorithms;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2012 - 2023 Codenjoy
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

public class CharOrderAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        return input.substring(2) + input.substring(0, 2);
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "    return input.substring(2)\n" +
                "        + input.substring(0, 2);\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "The order matters...\n " +
                "Everything is quite simple. \n" +
                "In a string of three characters, the last character becomes the first one,\n " +
                "and the first two characters shift one position to the right. \n" +
                "For example: abc=>cab...");
    }

    @Override
    public List<String> getQuestions() {
        return List.of("abc",
                "cad",
                "asd",
                "xyz",
                "aaa",
                "123",
                "dEf",
                "zxc",
                "qwe",
                "rty",
                "mnb",
                "vbn",
                "fgh",
                "ijk",
                "lmn",
                "pqr",
                "stu",
                "wxy",
                "222",
                "789",
                "090"
        );
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
