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

public class HighestAndLowestAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new HighestAndLowestAlgorithm();
    }

    @Override
    public String answers() {
        return "1 2 3 4 5=>5 1\n" +
                "1 2 -3 4 5=>5 -3\n" +
                "1 9 3 4 -5=>9 -5\n" +
                "8 3 -5 42 -1 0 0 -9 4 7 4 -4=>42 -9\n" +
                "1 2 3=>3 1\n" +
                "1=>1 1\n" +
                "-1=>-1 -1\n" +
                "-1 -1 0=>0 -1\n" +
                "1 1 0=>1 0\n" +
                "-1 -1=>-1 -1\n" +
                "1 -1 0=>1 -1\n" +
                "10 2 -1 -20=>10 -20\n" +
                "452 561 -686 679 476 -515 805 -739 571 791=>805 -739\n" +
                "-983 -111 -332 -973 47 728=>728 -983\n" +
                "268 -359 -513 -9 -86 -142 -779=>268 -779\n" +
                "556 32 866 -730 -367 -937 367 888 43 -510 773=>888 -937\n" +
                "646 261 609 -82 949 526 -449 -594 894=>949 -594\n" +
                "-950 909 424 834 -579 -275 -901 444=>909 -950\n" +
                "-857 43 444 158 510 -879 -350 705=>705 -879\n" +
                "-961 908 -769 980 407 -651 550 671 -996 215=>980 -996\n" +
                "483 -83 -229 -373 -812 335 -802=>483 -812\n" +
                "-968 -692 -566 -31 333 831 81 -476 828 -232=>831 -968\n" +
                "4 5 29 54 4 0 -214 542 -64 1 -3 6 -6=>542 -214";
    }
}