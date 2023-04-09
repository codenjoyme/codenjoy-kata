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

public class FizzBuzzAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(int number) {
        String result = "";
        if (number % 3 == 0) {
            result += "Fizz";
        }
        if (number % 5 == 0) {
            result += "Buzz";
        }
        if (result.length() == 0) {
            result = String.valueOf(number);
        }
        return result;
    }

    @Override
    public String winCode() {
        return "function program(question) {\n" +
                "    let number = parseInt(question);\n" +
                "    return (number % 3 === 0 && number % 5 === 0) ? 'FizzBuzz' \n" +
                "        : (number % 3 === 0) ? 'Fizz' \n" +
                "        : (number % 5 === 0) ? 'Buzz' \n" +
                "        : number;\n" +
                "}";
    }

    @Override
    public String description() {
        return "Write a method that takes one int argument and " +
                "that returns a String. For those numbers that are divisible by 3, " +
                "the method should return 'Fizz', for those numbers divisible by 5 " +
                "it should return 'Buzz', for those numbers divisible " +
                "by both 3 and 5 - 'FizzBuzz', and for all others - the number itself.";
    }

    @Override
    public int complexity() {
        return 5;
    }

    @Override
    public String author() {
        return "Алгоритм взят из тренинга, где он был использован в " +
                "качестве вербальной разминки. Судя по всему автор " +
                "Janet Rees (http://www.goodreads.com/book/show/1176717.Fizz_Buzz)";
    }
}
