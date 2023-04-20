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


import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static com.codenjoy.dojo.kata.model.algorithms.Assertions.assertAlgorithm;
import static org.junit.Assert.assertEquals;

public class NumberOrderAlgorithmTest {

    @Test
    public void shouldWork() {
        assertAlgorithm(new NumberOrderAlgorithm(),
                "111=>222\n" +
                "123=>423\n" +
                "679=>078\n" +
                "999=>000\n" +
                "012=>312\n" +
                "090=>110\n" +
                "444=>555\n" +
                "090=>110\n" +
                "916=>702"
        );
    }

    @Test
    public void questionTest(){
        assertEquals("111\n" +
                "222\n" +
                "333\n" +
                "444\n" +
                "555\n" +
                "100\n" +
                "123\n" +
                "999\n" +
                "789\n" +
                "000\n" +
                "909\n" +
                "090",
                StringUtils.join(new NumberOrderAlgorithm().getQuestions(),"\n"));
    }
}