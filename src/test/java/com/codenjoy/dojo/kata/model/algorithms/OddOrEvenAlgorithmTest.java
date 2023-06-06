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

public class OddOrEvenAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new OddOrEvenAlgorithm();
    }

    @Override
    public String answers() {
        return "0=>even\n" +
                "0 1 4=>odd\n" +
                "0 -1 5=>even\n" +
                "1 2 3 4 5=>odd\n" +
                "1 2 -3 4 5=>odd\n" +
                "1 9 3 4 -5=>even\n" +
                "8 3 -5 42 -1 0 0 -9 4 7 4 -4=>odd\n" +
                "1 2 3=>even\n" +
                "1=>odd\n" +
                "-1=>odd\n" +
                "-1 -1 0=>even\n" +
                "1 1 0=>even\n" +
                "-1 -1=>even\n" +
                "1 -1 0=>even\n" +
                "10 2 -1 -20=>odd\n" +
                "452 561 -686 679 476 -515 805 -739 571 791=>odd\n" +
                "-983 -111 -332 -973 47 728=>even\n" +
                "268 -359 -513 -9 -86 -142 -779=>even\n" +
                "556 32 866 -730 -367 -937 367 888 43 -510 773=>odd\n" +
                "646 261 609 -82 949 526 -449 -594 894=>even\n" +
                "-950 909 424 834 -579 -275 -901 444=>even\n" +
                "-857 43 444 158 510 -879 -350 705=>even\n" +
                "-961 908 -769 980 407 -651 550 671 -996 215=>even\n" +
                "483 -83 -229 -373 -812 335 -802=>odd\n" +
                "-968 -692 -566 -31 333 831 81 -476 828 -232=>even\n" +
                "4 5 29 54 4 0 -214 542 -64 1 -3 6 -6=>even";
    }
}