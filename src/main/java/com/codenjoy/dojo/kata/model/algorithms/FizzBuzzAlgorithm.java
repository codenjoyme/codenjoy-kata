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

public class FizzBuzzAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(int number) {
        int[] divisors = {3, 5, 7, 11, 13};
        String[] strings = {"Fizz", "Buzz", "Muzz", "Duzz", "Cazz"};
        String str = "";
        for (int i = 0; i < divisors.length; i++) {
            if (number % divisors[i] == 0) {
                str += strings[i];
            }
        }
        return str.isEmpty() ? Integer.toString(number) : str;
    }

    @Override
    public String winCode() {
        return "function getWord(number) {\n" +
                "  const map = new Map([\n" +
                "    [3, 'Fizz'],\n" +
                "    [5, 'Buzz'],\n" +
                "    [7, 'Muzz'],\n" +
                "    [11, 'Duzz'],\n" +
                "    [13, 'Cazz']\n" +
                "  ]);\n" +
                "\n" +
                "  let result = '';\n" +
                "  map.forEach((word, divisor) => {\n" +
                "    if (number % divisor === 0) {\n" +
                "      result += word;\n" +
                "    }\n" +
                "  });\n" +
                "\n" +
                "  return result || number.toString();\n" +
                "}";
    }


    @Override
    public List<String> description() {
        return Arrays.asList(
                "Write a javascript method that takes one int argument " +
                "and returns a string containing the number itself.",

                "For those numbers that are divisible by 3, " +
                "the method should return 'Fizz'",

                "For those numbers divisible by 5 it should return 'Buzz'.",

                "For those numbers divisible by both 3 and 5 - 'FizzBuzz'.",

                "Proceed in the same way if there is a number " +
                "with a divisor of 7. The word 'Muzz' is used for it. .",

                "Please write optimized code without any duplication.",

                "For divider 11 - the word must be 'Duzz'.",

                "For divider 13 - the word must be 'Cazz'.",

                "Please use a map with constants and dividers to avoid multiple ifs.");
    }

    @Override
    public List<String> getQuestions() {
        return Arrays.asList(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17",
                String.valueOf(3*7),
                String.valueOf(3*11),
                String.valueOf(5*7),
                String.valueOf(3*13),
                String.valueOf(7*7),
                String.valueOf(5*11),
                String.valueOf(5*13),
                String.valueOf(7*11),
                String.valueOf(7*13),
                String.valueOf(3*5*7),
                String.valueOf(3*5*11),
                String.valueOf(3*5*13),
                String.valueOf(3*7*11),
                String.valueOf(3*7*13),
                String.valueOf(5*7*11),
                String.valueOf(5*7*13),
                String.valueOf(5*11*13),
                String.valueOf(7*11*13),
                String.valueOf(3*5*7*11),
                String.valueOf(3*5*7*13),
                String.valueOf(3*5*11*13),
                String.valueOf(3*7*11*13),
                String.valueOf(5*7*11*13),
                String.valueOf(3*5*7*11*13));
    }

    @Override
    public String author() {
        return "The algorithm is taken from the training, where it was used " +
                "as a verbal warm-up. Judging by all the information " +
                "from the Internet the author is Janet Rees " +
                "(http://www.goodreads.com/book/show/1176717.Fizz_Buzz). " +
                " The task was supplemented with new conditions for " +
                "other prime numbers. Updated by Oleksandr Baglai (apofig@gmail.com).";
    }
}
