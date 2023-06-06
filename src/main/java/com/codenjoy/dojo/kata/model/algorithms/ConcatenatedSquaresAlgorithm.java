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
import java.util.stream.Collectors;

public class ConcatenatedSquaresAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .map(d -> d * d)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "return Array.from(input)\n" +
                "    .map(Number)\n" +
                "    .map(d => d * d)\n" +
                "    .join('');" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList("Hello there\n" +
                "You are asked to square every digit of a number and concatenate them.\n" +
                "For example, if we run 123 through the function, 149 will come out\n " +
                "because 1^2 is 1 and 2^2 is 4, 3^3=9. (1-4-9)\n" +
                "Example #2: An input of 465 will/should return 163625\n" +
                "because 4^2 is 16, 6^2 is 36, and 5^2 is 25. (16-36-25)\n"
        );
    }

    @Override
    public List<String> getQuestions() {
        return List.of("123",
                "465",
                "0",
                "5813",
                "7264",
                "1369",
                "7952",
                "9425",
                "4759",
                "4777",
                "2040",
                "6176",
                "1308",
                "2784",
                "1868",
                "4289",
                "8703",
                "1690",
                "2722",
                "2332",
                "5152",
                "1399",
                "794",
                "9906",
                "2157",
                "586",
                "720",
                "8626"
        );
    }

    @Override
    public int complexity() {
        //todo review
        return 11;
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
