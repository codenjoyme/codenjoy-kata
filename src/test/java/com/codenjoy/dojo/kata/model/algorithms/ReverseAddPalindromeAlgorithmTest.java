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

public class ReverseAddPalindromeAlgorithmTest {

    @Test
    public void shouldWork() {
        assertAlgorithm(new ReverseAddPalindromeAlgorithm(),
                "1=>2\n" +
                "2=>4\n" +
                "3=>6\n" +
                "4=>8\n" +
                "5=>11\n" +
                "6=>33\n" +
                "7=>55\n" +
                "8=>77\n" +
                "9=>99\n" +
                "10=>11\n" +
                "11=>22\n" +
                "12=>33\n" +
                "13=>44\n" +
                "14=>55\n" +
                "15=>66\n" +
                "16=>77\n" +
                "17=>88\n" +
                "18=>99\n" +
                "20=>22\n" +
                "21=>33\n" +
                "22=>44\n" +
                "23=>55\n" +
                "24=>66\n" +
                "25=>77\n" +
                "89=>8813200023188\n" +
                "123=>444\n" +
                "127=>848\n" +
                "254=>4444\n" +
                "3421=>4664\n" +
                "12345678=>99999999");
    }
}