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


import org.junit.Test;

import static com.codenjoy.dojo.kata.model.algorithms.Assertions.assertAlgorithm;

public class FibonacciNumbersAlgorithmTest {

    @Test
    public void shouldWork() {
        assertAlgorithm(new FibonacciNumbersAlgorithm(),
                "0=>0\n" +
                "1=>1\n" +
                "2=>1\n" +
                "3=>2\n" +
                "4=>3\n" +
                "5=>5\n" +
                "6=>8\n" +
                "7=>13\n" +
                "8=>21\n" +
                "9=>34\n" +
                "10=>55\n" +
                "11=>89\n" +
                "12=>144\n" +
                "13=>233\n" +
                "14=>377\n" +
                "15=>610\n" +
                "16=>987\n" +
                "17=>1597\n" +
                "18=>2584\n" +
                "19=>4181\n" +
                "20=>6765\n" +
                "21=>10946\n" +
                "23=>28657\n" +
                "24=>46368\n" +
                "25=>75025");
    }
}