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

public class FizzBuzzMultiplierAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new FizzBuzzMultiplierAlgorithm();
    }

    @Override
    public String answers() {
        return "1=>15:3*5:FizzBuzz\n" +
                "2=>21:3*7:FizzMuzz\n" +
                "3=>33:3*11:FizzDuzz\n" +
                "4=>35:5*7:BuzzMuzz\n" +
                "5=>39:3*13:FizzCazz\n" +
                "6=>55:5*11:BuzzDuzz\n" +
                "7=>65:5*13:BuzzCazz\n" +
                "8=>77:7*11:MuzzDuzz\n" +
                "9=>91:7*13:MuzzCazz\n" +
                "10=>105:3*5*7:FizzBuzzMuzz\n" +
                "11=>143:11*13:DuzzCazz\n" +
                "12=>165:3*5*11:FizzBuzzDuzz\n" +
                "13=>195:3*5*13:FizzBuzzCazz\n" +
                "14=>231:3*7*11:FizzMuzzDuzz\n" +
                "15=>273:3*7*13:FizzMuzzCazz\n" +
                "16=>385:5*7*11:BuzzMuzzDuzz\n" +
                "17=>429:3*11*13:FizzDuzzCazz\n" +
                "18=>455:5*7*13:BuzzMuzzCazz\n" +
                "19=>715:5*11*13:BuzzDuzzCazz\n" +
                "20=>1001:7*11*13:MuzzDuzzCazz\n" +
                "21=>1155:3*5*7*11:FizzBuzzMuzzDuzz\n" +
                "22=>1365:3*5*7*13:FizzBuzzMuzzCazz\n" +
                "23=>2145:3*5*11*13:FizzBuzzDuzzCazz\n" +
                "24=>3003:3*7*11*13:FizzMuzzDuzzCazz\n" +
                "25=>none";
    }
}