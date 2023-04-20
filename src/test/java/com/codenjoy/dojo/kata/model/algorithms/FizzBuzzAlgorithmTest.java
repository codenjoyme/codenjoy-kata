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


import com.codenjoy.dojo.services.questionanswer.levels.Algorithm;

public class FizzBuzzAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new FizzBuzzAlgorithm();
    }

    @Override
    public String answers() {
        return "1=>1\n" +
                "2=>2\n" +
                "3=>Fizz\n" +
                "4=>4\n" +
                "5=>Buzz\n" +
                "6=>Fizz\n" +
                "7=>7\n" +
                "8=>8\n" +
                "9=>Fizz\n" +
                "10=>Buzz\n" +
                "11=>11\n" +
                "12=>Fizz\n" +
                "13=>13\n" +
                "14=>14\n" +
                "15=>FizzBuzz\n" +
                "16=>16\n" +
                "17=>17\n" +
                "18=>Fizz\n" +
                "19=>19\n" +
                "20=>Buzz\n" +
                "21=>Fizz\n" +
                "22=>22\n" +
                "23=>23\n" +
                "24=>Fizz\n" +
                "25=>Buzz";
    }
}