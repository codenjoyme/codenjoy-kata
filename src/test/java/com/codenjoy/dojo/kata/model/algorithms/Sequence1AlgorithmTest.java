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

public class Sequence1AlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new Sequence1Algorithm();
    }

    @Override
    public String answers() {
        return "1=>101\n" +
                "2=>112\n" +
                "3=>131\n" +
                "4=>415\n" +
                "5=>161\n" +
                "6=>718\n" +
                "7=>192\n" +
                "8=>021\n" +
                "9=>222\n" +
                "10=>324\n" +
                "11=>252\n" +
                "12=>627\n" +
                "13=>282\n" +
                "14=>930\n" +
                "15=>313\n" +
                "16=>233\n" +
                "17=>343\n" +
                "18=>536\n" +
                "19=>373\n" +
                "20=>839\n" +
                "21=>404\n" +
                "22=>142\n" +
                "23=>434\n" +
                "24=>445\n" +
                "25=>464";
    }

    @Override
    public String cornerCases() {
        return "100=>139\n" +
                "101=>140\n" +
                "102=>141\n" +
                "103=>142\n" +
                "104=>143\n" +
                "105=>144\n" +
                "106=>145\n" +
                "107=>146\n" +
                "1000=>029\n" +
                "1001=>103\n" +
                "1002=>010\n" +
                "1003=>311\n" +
                "1004=>032\n" +
                "1005=>103\n" +
                "1006=>310";
    }
}