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

public class MakeBricksAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new MakeBricksAlgorithm();
    }

    @Override
    public String answers() {
        return "0, 1, 5=>true\n" +
                "1, 0, 1=>true\n" +
                "1, 0, 2=>false\n" +
                "3, 1, 7=>true\n" +
                "4, 2, 14=>true\n" +
                "3, 2, 14=>false\n" +
                "0, 2, 5=>true\n" +
                "3, 1, 6=>true\n" +
                "3, 1, 9=>false\n" +
                "3, 2, 9=>false\n" +
                "10, 10, 0=>true\n" +
                "0, 0, 1=>false\n" +
                "0, 1, 1=>false\n" +
                "0, 0, 2=>false\n" +
                "2, 0, 2=>true\n" +
                "0, 1, 2=>false\n" +
                "1, 1, 2=>false\n" +
                "2, 1, 3=>false\n" +
                "3, 1, 4=>false\n" +
                "2, 1, 1=>true\n" +
                "2, 2, 6=>true\n" +
                "6, 1, 11=>true\n" +
                "5, 0, 1=>true\n" +
                "3, 1, 8=>true\n" +
                "3, 2, 10=>true\n" +
                "3, 2, 8=>true\n" +
                "6, 0, 11=>false\n" +
                "1, 4, 11=>true\n" +
                "0, 3, 10=>true\n" +
                "1, 4, 12=>false\n" +
                "1, 1, 7=>false\n" +
                "2, 1, 7=>true\n" +
                "7, 1, 11=>true\n" +
                "7, 1, 8=>true\n" +
                "7, 1, 13=>false\n" +
                "43, 1, 46=>true\n" +
                "40, 1, 46=>false\n" +
                "40, 2, 47=>true\n" +
                "40, 2, 50=>true\n" +
                "40, 2, 52=>false\n" +
                "22, 2, 33=>false\n" +
                "0, 2, 10=>true\n" +
                "1000000, 1000, 1000100=>true\n" +
                "2, 1000000, 100003=>false\n" +
                "20, 0, 19=>true\n" +
                "20, 0, 21=>false\n" +
                "20, 4, 51=>false\n" +
                "20, 4, 39=>true";
    }

    @Override
    public String cornerCases() {
        return "FILE:MakeBricksAlgorithmTest.cornerCases.txt";
    }
}