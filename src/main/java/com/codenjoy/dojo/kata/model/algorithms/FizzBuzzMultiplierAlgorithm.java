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
        if (index < 1 || index > 26) {
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
    public List<String> getQuestions() {
        return prepareQuestions(27);
    }

    @Override
    public String winCode() {
        return "function program(index) {\n" +
                "    if (index < 1 || index > 26) {\n" +
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
                "    const divisors = [3, 5, 7, 11, 13];\n" +
                "    const strings = ['Fizz', 'Buzz', 'Muzz', 'Duzz', 'Cazz'];\n" +
                "    let str = '';\n" +
                "    for (let i = 0; i < divisors.length; i++) {\n" +
                "        if (number % divisors[i] === 0) {\n" +
                "            str += strings[i];\n" +
                "        }\n" +
                "    }\n" +
                "    return str || number.toString();\n" +
                "}";
    }


    @Override
    public List<String> description() {
        return Arrays.asList(
                "Write a js function that takes an integer index as input " +
                "and returns a string in the format 'number:divisors:fizzBuzz', " +
                "where 'number' is the nth positive integer that has at " +
                "least two distinct dividers [3, 5, 7, 9, 13] and is " +
                "divisible by them without a rest, 'divisors' is a separated " +
                "by '*' list of the distinct prime factors of 'number', " +
                "and 'fizzBuzz' is the result of calling a function 'fizzBuzz(number)'. " +
                "If the input index is less than or equal to 0 or greater " +
                "than or equal to 25, return 'none'.",

                "JavaScript program:\n" +
                "function fizzBuzz(number) {\n" +
                "    const divisors = [3, 5, 7, 11, 13];\n" +
                "    const strings = ['Fizz', 'Buzz', 'Muzz', 'Duzz', 'Cazz'];\n" +
                "    let str = '';\n" +
                "    for (let i = 0; i < divisors.length; i++) {\n" +
                "        if (number % divisors[i] === 0) {\n" +
                "            str += strings[i];\n" +
                "        }\n" +
                "    }\n" +
                "    return str || number.toString();\n" +
                "}",

                "For example:\n" +
                "1=>15:3*5:FizzBuzz\n" +
                "2=>21:3*7:FizzMuzz\n" +
                "3=>33:3*11:FizzDuzz\n" +
                "10=>105:3*5*7:FizzBuzzMuzz\n" +
                "12=>165:3*5*11:FizzBuzzDuzz\n" +
                "13=>195:3*5*13:FizzBuzzCazz\n" +
                "21=>1155:3*5*7*11:FizzBuzzMuzzDuzz\n" +
                "23=>2145:3*5*11*13:FizzBuzzDuzzCazz\n" +
                "24=>3003:3*7*11*13:FizzMuzzDuzzCazz\n" +
                "26=>15015:3*5*7*11*13:FizzBuzzMuzzDuzzCazz");
    }

    @Override
    public String author() {
        return "The algorithm came as a extension of the famous " +
                "FizzBuzz problem during the ChatGPT challenge on Dojorena. " +
                "Created by Oleksandr Baglai (apofig@gmail.com).";
    }
}
