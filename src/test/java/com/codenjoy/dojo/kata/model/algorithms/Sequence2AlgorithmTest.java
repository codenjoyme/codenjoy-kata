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

public class Sequence2AlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new Sequence2Algorithm();
    }

    @Override
    public String answers() {
        return "1=>971\n" +
                "2=>874\n" +
                "3=>787\n" +
                "4=>709\n" +
                "5=>639\n" +
                "6=>576\n" +
                "7=>519\n" +
                "8=>468\n" +
                "9=>422\n" +
                "10=>380\n" +
                "11=>342\n" +
                "12=>308\n" +
                "13=>278\n" +
                "14=>251\n" +
                "15=>226\n" +
                "16=>204\n" +
                "17=>184\n" +
                "18=>166\n" +
                "19=>150\n" +
                "20=>135\n" +
                "21=>122\n" +
                "22=>110\n" +
                "23=>99\n" +
                "24=>90\n" +
                "25=>81";
    }

    @Override
    public String cornerCases() {
        return "26=>73\n" +
                "27=>66\n" +
                "28=>60\n" +
                "29=>54\n" +
                "30=>49\n" +
                "31=>45\n" +
                "32=>41\n" +
                "33=>37\n" +
                "34=>34\n" +
                "35=>31\n" +
                "36=>28\n" +
                "37=>26\n" +
                "38=>24\n" +
                "39=>22\n" +
                "40=>20\n" +
                "41=>18\n" +
                "42=>17\n" +
                "43=>16\n" +
                "44=>15\n" +
                "45=>14\n" +
                "46=>13\n" +
                "47=>12\n" +
                "48=>11\n" +
                "49=>10\n" +
                "50=>9\n" +
                "51=>9\n" +
                "52=>9";
    }
}