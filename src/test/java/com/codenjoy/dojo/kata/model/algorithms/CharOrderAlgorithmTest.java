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

public class CharOrderAlgorithmTest {
    @Test
    public void shouldWork() {
        assertAlgorithm(new CharOrderAlgorithm(),
                "abc=>cab\n" +
                "cad=>dca\n" +
                "asd=>das\n" +
                "xyz=>zxy\n" +
                "aaa=>aaa\n" +
                "123=>312\n" +
                "dEf=>fdE\n" +
                "zxc=>czx\n" +
                "qwe=>eqw\n" +
                "rty=>yrt\n" +
                "mnb=>bmn\n" +
                "vbn=>nvb\n" +
                "fgh=>hfg\n" +
                "ijk=>kij\n" +
                "lmn=>nlm\n" +
                "pqr=>rpq\n" +
                "stu=>ust\n" +
                "wxy=>ywx\n" +
                "222=>222\n" +
                "789=>978\n" +
                "090=>009"
        );
    }

    @Test
    public void questionTest(){
        assertEquals(
                "abc\n" +
                "cad\n" +
                "asd\n" +
                "xyz\n" +
                "aaa\n" +
                "123\n" +
                "dEf\n" +
                "zxc\n" +
                "qwe\n" +
                "rty\n" +
                "mnb\n" +
                "vbn\n" +
                "fgh\n" +
                "ijk\n" +
                "lmn\n" +
                "pqr\n" +
                "stu\n" +
                "wxy\n" +
                "222\n" +
                "789\n" +
                "090",
                StringUtils.join(new CharOrderAlgorithm().getQuestions(),"\n"));
    }
}