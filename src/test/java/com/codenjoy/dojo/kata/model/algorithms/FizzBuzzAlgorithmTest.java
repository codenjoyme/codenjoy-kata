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
                "7=>Muzz\n" +
                "8=>8\n" +
                "9=>Fizz\n" +
                "10=>Buzz\n" +
                "11=>Duzz\n" +
                "12=>Fizz\n" +
                "13=>Cazz\n" +
                "14=>Muzz\n" +
                "15=>FizzBuzz\n" +
                "16=>16\n" +
                "17=>17\n" +
                "21=>FizzMuzz\n" +
                "33=>FizzDuzz\n" +
                "35=>BuzzMuzz\n" +
                "39=>FizzCazz\n" +
                "49=>Muzz\n" +
                "55=>BuzzDuzz\n" +
                "65=>BuzzCazz\n" +
                "77=>MuzzDuzz\n" +
                "91=>MuzzCazz\n" +
                "105=>FizzBuzzMuzz\n" +
                "165=>FizzBuzzDuzz\n" +
                "195=>FizzBuzzCazz\n" +
                "231=>FizzMuzzDuzz\n" +
                "273=>FizzMuzzCazz\n" +
                "1155=>FizzBuzzMuzzDuzz\n" +
                "15015=>FizzBuzzMuzzDuzzCazz";
    }
}