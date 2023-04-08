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


//import org.approvaltests.legacycode.LegacyApprovals;
//import org.approvaltests.legacycode.Range;

import org.junit.Test;

import static com.codenjoy.dojo.kata.model.algorithms.Assertions.assertAlgorithm;

public class MakeBricksAlgorithmTest {

    @Test
    public void shouldWorkd() {
        assertAlgorithm(new MakeBricksAlgorithm(),
                "0, 1, 5=>true\n" +
                "1, 0, 1=>true\n" +
                "1, 0, 2=>false\n" +
                "3, 1, 7=>true\n" +
                "4, 2, 14=>true\n" +
                "3, 2, 14=>false\n" +
                "0, 2, 5=>true\n" +
                "3, 1, 6=>true\n" +
                "3, 1, 9=>false\n" +
                "3, 2, 9=>false\n" +
                "0, 1, 1=>false\n" +
                "0, 1, 1=>false\n" +
                "1, 1, 2=>false\n" +
                "2, 1, 3=>false\n" +
                "3, 1, 4=>false\n" +
                "2, 1, 1=>true\n" +
                "2, 2, 6=>true\n" +
                "6, 1, 11=>true\n" +
                "5, 0, 1=>true");

        // TODO вернуть тест без approvals
        // LegacyApprovals.LockDown(this, "method", Range.get(0, 10), Range.get(0, 10), Range.get(0, 100));
    }
}