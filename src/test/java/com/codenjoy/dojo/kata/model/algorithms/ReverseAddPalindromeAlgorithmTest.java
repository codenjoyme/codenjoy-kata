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

public class ReverseAddPalindromeAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new ReverseAddPalindromeAlgorithm();
    }

    @Override
    public String answers() {
        return "1=>2\n" +
                "2=>4\n" +
                "3=>6\n" +
                "4=>8\n" +
                "5=>11\n" +
                "6=>33\n" +
                "7=>55\n" +
                "9=>99\n" +
                "10=>11\n" +
                "11=>22\n" +
                "12=>33\n" +
                "123=>444\n" +
                "234=>666\n" +
                "345=>888\n" +
                "456=>1221\n" +
                "567=>3663\n" +
                "678=>23232\n" +
                "789=>66066\n" +
                "1234=>5555\n" +
                "2345=>7777\n" +
                "3456=>9999\n" +
                "4567=>12221\n" +
                "5678=>48884\n" +
                "6789=>993399\n" +
                "7890=>993399\n" +
                "12345=>66666\n" +
                "123456=>777777\n" +
                "1234567=>8888888\n" +
                "12345678=>99999999\n" +
                "123456789=>1222222221\n" +
                "1234567890=>3344444433";
    }

    @Override
    public String cornerCases() {
        return "13=>44\n" +
                "14=>55\n" +
                "15=>66\n" +
                "16=>77\n" +
                "17=>88\n" +
                "18=>99\n" +
                "20=>22\n" +
                "21=>33\n" +
                "22=>44\n" +
                "23=>55\n" +
                "24=>66\n" +
                "25=>77\n" +
                "89=>8813200023188\n" +
                "127=>848\n" +
                "254=>4444\n" +
                "3421=>4664";
    }
}