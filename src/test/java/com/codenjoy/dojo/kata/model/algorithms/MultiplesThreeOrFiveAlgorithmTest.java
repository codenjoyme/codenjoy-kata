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

public class MultiplesThreeOrFiveAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new MultiplesThreeOrFiveAlgorithm();
    }

    @Override
    public String answers() {
        return "10=>23\n" +
                "20=>78\n" +
                "30=>195\n" +
                "100=>2318\n" +
                "200=>9168\n" +
                "300=>20850\n" +
                "500=>57918\n" +
                "1000=>233168\n" +
                "2000=>931668\n" +
                "3000=>2098500\n" +
                "5000=>5829168\n" +
                "10000=>23331668\n" +
                "22222=>115229219\n" +
                "66666=>1036996298\n" +
                "99999=>2333216669\n" +
                "1234567=>355636612814\n" +
                "7654321=>13670680581720";
    }
}