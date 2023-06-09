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

/**
 * @author http://projecteuler.net/problem=6
 */
public class SumSquareDifferenceAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(int number) {
        long sum = 0;
        long sum2 = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
            sum2 += i * i;
        }
        return Long.toString(sum * sum - sum2);
    }

    @Override
    public String winCode() {
        return "function program(question) {\n" +
                "    let number = parseInt(question);\n" +
                "    let sumOfSquares = (number * (number + 1) * (2 * number + 1)) / 6;\n" +
                "    let squareOfSum = Math.pow((number * (number + 1)) / 2, 2);\n" +
                "    return squareOfSum - sumOfSquares;\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "The sum of the squares of the first ten positive integers \n" +
                "1^2 + 2^2 + ... + 10^2 = 385. \n" +
                "And the square of the sum is \n" +
                "(1 + 2 + ... + 10)^2 = 55^2 = 3025. \n" +
                "Therefore, the difference between the sum of the squares and " +
                "the square of the sum of the first ten natural " +
                "numbers is equal to 3025 - 385 = 2640. \n" +
                "Create a method that calculates the difference between the sum " +
                "squares and the square of the sum for the natural number i.");
    }

    @Override
    public String author() {
        return "ProjectEuler (http://projecteuler.net/problem=6)";
    }

}
