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
import org.junit.Assert;
import org.junit.Test;

import static com.codenjoy.dojo.kata.model.algorithms.Assertions.assertAlgorithm;

public class SimpleMathAlgorithmTest {

    @Test
    public void shouldWork() {
        assertAlgorithm(new SimpleMathAlgorithm(),
                "0=>1\n" +
                "1=>0\n" +
                "2=>3\n" +
                "3=>2\n" +
                "4=>5\n" +
                "5=>4\n" +
                "6=>7\n" +
                "7=>6\n" +
                "8=>9\n" +
                "9=>8\n" +
                "10=>11\n" +
                "11=>10\n" +
                "12=>13\n" +
                "13=>12\n" +
                "14=>15\n" +
                "15=>14\n" +
                "16=>17\n" +
                "17=>16\n" +
                "18=>19\n" +
                "19=>18\n" +
                "20=>21\n" +
                "21=>20\n" +
                "22=>23\n" +
                "23=>22\n" +
                "24=>25\n" +
                "25=>24\n" +
                "26=>27\n" +
                "27=>26\n" +
                "28=>29\n" +
                "29=>28\n" +
                "30=>31\n" +
                "31=>30\n" +
                "32=>33\n" +
                "33=>32\n" +
                "34=>35\n" +
                "35=>34");
    }

    @Test
    public void questionTest(){
        Assert.assertEquals(
                "0\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "5\n" +
                "7\n" +
                "9\n" +
                "11\n" +
                "14\n" +
                "17\n" +
                "20\n" +
                "23\n" +
                "26\n" +
                "29\n" +
                "33\n" +
                "37\n" +
                "41\n" +
                "45\n" +
                "50\n" +
                "55\n" +
                "60\n" +
                "65\n" +
                "70\n" +
                "75\n" +
                "81\n" +
                "87\n" +
                "93\n" +
                "99\n" +
                "106\n" +
                "113\n" +
                "120\n" +
                "127\n" +
                "134\n" +
                "141\n" +
                "149\n" +
                "157\n" +
                "165\n" +
                "173\n" +
                "182\n" +
                "191\n" +
                "200",
                StringUtils.join(new SimpleMathAlgorithm().getQuestions(),"\n"));
    }
}