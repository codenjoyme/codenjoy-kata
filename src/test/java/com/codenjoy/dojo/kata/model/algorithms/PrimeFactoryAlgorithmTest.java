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

public class PrimeFactoryAlgorithmTest {

    @Test
    public void shouldWork() {
        assertAlgorithm(new PrimeFactoryAlgorithm(),
                "1=>[1]\n" +
                "2=>[2]\n" +
                "3=>[3]\n" +
                "4=>[2,2]\n" +
                "5=>[5]\n" +
                "6=>[2,3]\n" +
                "7=>[7]\n" +
                "8=>[2,2,2]\n" +
                "9=>[3,3]\n" +
                "10=>[2,5]\n" +
                "11=>[11]\n" +
                "12=>[2,2,3]\n" +
                "13=>[13]\n" +
                "14=>[2,7]\n" +
                "15=>[3,5]\n" +
                "16=>[2,2,2,2]\n" +
                "17=>[17]\n" +
                "18=>[2,3,3]\n" +
                "19=>[19]\n" +
                "20=>[2,2,5]\n" +
                "21=>[3,7]\n" +
                "22=>[2,11]\n" +
                "23=>[23]\n" +
                "24=>[2,2,2,3]\n" +
                "25=>[5,5]\n" +
                "26=>[2,13]");
    }
}