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

public class SumSquareDifferenceAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new SumSquareDifferenceAlgorithm();
    }

    @Override
    public String answers() {
        return "1=>0\n" +
                "2=>4\n" +
                "3=>22\n" +
                "4=>70\n" +
                "5=>170\n" +
                "6=>350\n" +
                "7=>644\n" +
                "8=>1092\n" +
                "9=>1740\n" +
                "10=>2640\n" +
                "11=>3850\n" +
                "12=>5434\n" +
                "13=>7462\n" +
                "14=>10010\n" +
                "15=>13160\n" +
                "16=>17000\n" +
                "17=>21624\n" +
                "18=>27132\n" +
                "19=>33630\n" +
                "20=>41230\n" +
                "21=>50050\n" +
                "22=>60214\n" +
                "23=>71852\n" +
                "24=>85100\n" +
                "25=>100100";
    }

    @Override
    public String cornerCases() {
        return "0=>0\n" +
                "26=>117000\n" +
                "27=>135954\n" +
                "28=>157122\n" +
                "29=>180670\n" +
                "30=>206770\n" +
                "31=>235600\n" +
                "32=>267344\n" +
                "100=>25164150\n" +
                "1000=>250166416500\n" +
                "10000=>2500166641665000";
    }
}