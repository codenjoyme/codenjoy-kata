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

public class PrimeFactoryAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(int number) {
        String result = "";
        if (number == 1) {
            return "[1]";
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            while (number % i == 0) {
                number /= i;
                result += i + ",";
            }
        }
        if (number > 1) {
            result += number + ",";
        }
        result = result.substring(0, result.length() - 1);
        return "[" + result + "]";
    }

    @Override
    public String winCode() {
        return "function program(number) {\n" +
                "    if (number == 1) {\n" +
                "        return '[1]';\n" +
                "    }\n" +
                "    const result = [];\n" +
                "    for (let i = 2; i <= Math.sqrt(number); i++) {\n" +
                "        while (number % i === 0) {\n" +
                "             result.push(i);\n" +
                "             number /= i;\n" +
                "        }\n" +
                "    }\n" +
                "    if (number > 1) {\n" +
                "        result.push(number);\n" +
                "    }\n" +
                "    return '[' + result.join(',') + ']';\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "Write a javascript function to find prime factors of a positive integer",

                "Store the result into an array.",

                "Use parseInt to parse input string arguments.",

                "Use let for variables and put variable declarations at the top of the script.",

                "Use separate variable to store the result of parseInt.",

                "Corner case: primeFactors(1) should return [1].",

                "Remove everything from the script except for the function logic.");
    }

    @Override
    public String author() {
        return "Алгоритм взят из доклада Johannes Brodwall о TDD" +
                "(http://szelenin.blogspot.com/2011_12_01_archive.html)";
    }
}
