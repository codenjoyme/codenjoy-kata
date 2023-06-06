package com.codenjoy.dojo.kata.model.algorithms;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2012 - 2023 Codenjoy
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

public class MaxSquareAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new MaxSquareAlgorithm();
    }

    @Override
    public String answers() {
        return "3, 6, 2, 5, 4, 8, 3=>24:1,5\n" +
                "1, 1, 1, 1, 1=>4:0,4\n" +
                "1, 2, 1, 2, 1=>4:1,3\n" +
                "1, 1, 10, 1, 1=>4:0,4\n" +
                "1, 5, 10, 5, 1=>10:1,3\n" +
                "5, 1, 10, 1, 5=>20:0,4\n" +
                "100, 5, 1, 5, 100=>400:0,4\n" +
                "100, 1, 5, 1, 100=>400:0,4\n" +
                "1, 100, 1, 100, 1=>200:1,3";
    }
}
