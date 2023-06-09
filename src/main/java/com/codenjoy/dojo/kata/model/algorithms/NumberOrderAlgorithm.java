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

public class NumberOrderAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        return getNextNumber(input.charAt(2)) +
                getNextNumber(input.charAt(0)) +
                getNextNumber(input.charAt(1));
    }

    private String getNextNumber(char number) {
        return Integer.toString((Integer.parseInt(String.valueOf(number)) + 1) % 10);
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "    return '' + getNextNumber(input.charAt(2))\n" +
                "        + getNextNumber(input.charAt(0))\n" +
                "        + getNextNumber(input.charAt(1));\n" +
                "}\n" +
                "\n" +
                "function getNextNumber(number) {\n" +
                "    return (parseInt(number) + 1) % 10;\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "Order matters...\n" +
                "You need to work with three-digit numbers. \n" +
                "Solve the algorithm for changing the number according to the given examples: \n" +
                "Examples: 111=>222, 123=>423, 679=>078, 999=>000, 012=>312, 090=>110, 444=>555, 090=>110, 916=>702");
    }

    @Override
    public List<String> getQuestions() {
        return List.of(
                "111",
                "222",
                "333",
                "444",
                "555",
                "100",
                "123",
                "999",
                "789",
                "000",
                "909",
                "090"
        );
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
