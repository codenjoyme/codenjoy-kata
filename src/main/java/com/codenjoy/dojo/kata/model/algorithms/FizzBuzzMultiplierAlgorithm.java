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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FizzBuzzMultiplierAlgorithm extends AlgorithmLevelImpl {

    private static final FizzBuzzAlgorithm ALGORITHM = new FizzBuzzAlgorithm();
    private static final int[] PRIMES = {3, 5, 7, 11, 13};

    @Override
    public String get(int index) {
        if (index <= 0 || index >= 25) {
            return "none";
        }

        int number = 0;
        int found = 0;

        List<Integer> divisors = new ArrayList<>();
        while (found != index) {
            number++;
            int rest = number;
            divisors.clear();

            for (int i = 0; i < PRIMES.length && rest > 1; i++) {
                if (rest < PRIMES[i]) {
                    break;
                }
                if (number % PRIMES[i] == 0) {
                    divisors.add(PRIMES[i]);
                    rest /= PRIMES[i];
                }
            }

            if (divisors.size() > 1 && rest == 1) {
                found++;
            }
        }

        return String.format("%s:%s:%s",
                number,
                divisors.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("*")),
                ALGORITHM.get(number));
    }

    @Override
    public String winCode() {
        return "function program(index) {\n" +
                "    if (index <= 0 || index >= 25) {\n" +
                "        return 'none';\n" +
                "    }\n" +
                "    \n" +
                "    const PRIMES = [3, 5, 7, 11, 13];\n" +
                "    \n" +
                "    let number = 0;\n" +
                "    let found = 0;\n" +
                "    \n" +
                "    const divisors = [];\n" +
                "    \n" +
                "    while (found != index) {\n" +
                "        number++;\n" +
                "        let rest = number;\n" +
                "        divisors.length = 0;\n" +
                "        \n" +
                "        for (let i = 0; i < PRIMES.length && rest > 1; i++) {\n" +
                "            if (rest <= PRIMES[i]) {\n" +
                "                break;\n" +
                "            }\n" +
                "            if (number % PRIMES[i] === 0) {\n" +
                "                divisors.push(PRIMES[i]);\n" +
                "                rest /= PRIMES[i];\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        if (divisors.length > 1 && rest === 1) {\n" +
                "            found++;\n" +
                "        }\n" +
                "    }\n" +
                "    \n" +
                "    const divisorsStr = divisors.join(\"*\");\n" +
                "    return `${number}:${divisorsStr}:${fizzBuzz(number)}`;\n" +
                "}" +
                "\n" +
                "function fizzBuzz(number) {\n" +
                "  let result = \"\";\n" +
                "  if (number % 3 === 0) {\n" +
                "    result += \"Fizz\";\n" +
                "  }\n" +
                "  if (number % 5 === 0) {\n" +
                "    result += \"Buzz\";\n" +
                "  }\n" +
                "  if (number % 7 === 0) {\n" +
                "    result += \"Muzz\";\n" +
                "  }\n" +
                "  if (number % 11 === 0) {\n" +
                "    result += \"Duzz\";\n" +
                "  }\n" +
                "  if (number % 13 === 0) {\n" +
                "    result += \"Cazz\";\n" +
                "  }\n" +
                "  return result || number.toString();\n" +
                "}";
    }


    @Override
    public List<String> description() {
        return Arrays.asList(
                "Write a javascript method that takes one int argument " +
                "and returns a string based on fizzBuzz algorithm:\n" +
                "1=>15:3*5:FizzBuzz\n" +
                "2=>21:3*7:FizzMuzz\n" +
                "3=>33:3*11:FizzDuzz\n" +
                "4=>35:5*7:BuzzMuzz\n" +
                "25=>none");
    }

    @Override
    public int complexity() {
        return 7;
    }

    @Override
    public String author() {
        return "The algorithm came as a extension of the famous " +
                "FizzBuzz problem during the ChatGPT challenge on Dojorena. " +
                "Created by Oleksandr Baglai (apofig@gmail.com).";
    }
}
