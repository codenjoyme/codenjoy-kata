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

public class PowerDigitSumAlgorithmTest {

    @Test
    public void shouldWork() {
        assertAlgorithm(new PowerDigitSumAlgorithm(),
                "0=>1\n" +
                "1=>2\n" +
                "2=>4\n" +
                "3=>8\n" +
                "4=>7\n" +
                "5=>5\n" +
                "6=>10\n" +
                "7=>11\n" +
                "8=>13\n" +
                "9=>8\n" +
                "10=>7\n" +
                "11=>14\n" +
                "12=>19\n" +
                "13=>20\n" +
                "14=>22\n" +
                "15=>26\n" +
                "16=>25\n" +
                "17=>14\n" +
                "18=>19\n" +
                "19=>29\n" +
                "20=>31\n" +
                "21=>26\n" +
                "22=>25\n" +
                "23=>41\n" +
                "24=>37\n" +
                "25=>29\n" +
                "26=>40\n" +
                "27=>35\n" +
                "28=>43\n" +
                "29=>41\n" +
                "30=>37\n" +
                "31=>47\n" +
                "32=>58\n" +
                "33=>62\n" +
                "34=>61\n" +
                "35=>59");
    }
}