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

public class NumberOrderAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new NumberOrderAlgorithm();
    }

    @Override
    public String answers() {
        return "111=>222\n" +
                "222=>333\n" +
                "333=>444\n" +
                "444=>555\n" +
                "555=>666\n" +
                "100=>121\n" +
                "123=>423\n" +
                "999=>000\n" +
                "789=>089\n" +
                "000=>111\n" +
                "909=>001\n" +
                "090=>110";
    }
}