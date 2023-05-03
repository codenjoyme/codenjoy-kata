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
import java.util.stream.IntStream;

public class MultiplesThreeOrFiveAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        return Long.toString(
                IntStream.range(0, Integer.parseInt(input))
                        .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                        .asLongStream()
                        .sum()
        );
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "return String(\n" +
                "    [...Array(parseInt(input)).keys()]\n" +
                "      .filter(n => n % 3 === 0 || n % 5 === 0)\n" +
                "      .reduce((acc, n) => acc + n, 0)\n" +
                "  );\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList("If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.\n" +
                "The sum of these multiples is 23.\n" +
                "Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.\n" +
                "Additionally, if the number is negative, return 0 (for languages that do have them).\n" +
                "Note: If the number is a multiple of both 3 and 5, only count it once.");
    }

    @Override
    public List<String> getQuestions() {
        return List.of("10",
                "20",
                "30",
                "100",
                "200",
                "300",
                "500",
                "1000",
                "2000",
                "3000",
                "5000",
                "10000",
                "22222",
                "66666",
                "99999",
                "1234567",
                "987654321"
        );
    }

    @Override
    public int complexity() {
        //todo review
        return 12;
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
