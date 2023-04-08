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
import static org.junit.Assert.assertEquals;

public class XthPrimeAlgorithmTest {

    private XthPrimeAlgorithm algorithm = new XthPrimeAlgorithm();

    @Test
    public void shouldWork() {
        assertAlgorithm(algorithm,
                "0=>1\n" +
                "1=>2\n" +
                "2=>3\n" +
                "3=>5\n" +
                "4=>7\n" +
                "5=>11\n" +
                "6=>13\n" +
                "7=>17\n" +
                "8=>19\n" +
                "9=>23\n" +
                "10=>29\n" +
                "11=>31\n" +
                "12=>37\n" +
                "13=>41\n" +
                "14=>43\n" +
                "15=>47\n" +
                "16=>53\n" +
                "17=>59\n" +
                "18=>61\n" +
                "19=>67\n" +
                "20=>71\n" +
                "21=>73\n" +
                "22=>79\n" +
                "23=>83\n" +
                "24=>89\n" +
                "25=>97\n" +
                "100=>541\n" +
                "500=>3571");
    }

    @Test
    public void shouldWorkWithCache() {
        assertEquals("17", algorithm.get("7"));
        shouldWork();
    }
}
