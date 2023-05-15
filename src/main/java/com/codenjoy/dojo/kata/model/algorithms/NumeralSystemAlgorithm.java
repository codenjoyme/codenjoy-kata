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


import com.codenjoy.dojo.services.questionanswer.levels.AlgorithmLevelImpl;

import java.util.Arrays;
import java.util.List;

public class NumeralSystemAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String... input) {
        String number = input[0];
        int source = Integer.parseInt(input[1]);
        int target = Integer.parseInt(input[2]);

        return Integer.toString(Integer.parseInt(number, source), target);
    }

    @Override
    public List<String> getQuestions() {
        return Arrays.asList(
                "10, 10, 10", 
                "10, 10, 2", 
                "10, 2, 10", 
                "1000, 10, 16", 
                "1000, 16, 10", 
                "1000, 16, 2", 
                "1ACD, 16, 2", 
                "ABCD, 16, 2", 
                "34BE, 16, 10", 
                "1000, 2, 16", 
                "1010, 2, 16", 
                "1010101, 2, 4", 
                "1010101, 2, 6", 
                "1010101, 2, 8", 
                "1010101, 2, 10", 
                "1010101, 2, 12", 
                "1010101, 2, 14", 
                "1010101, 2, 16", 
                "0, 2, 16", 
                "360, 10, 60", 
                "360, 10, 12"
        );
    }

    @Override
    public String winCode() {
        return "function get(...input) {\n" +
                "    const number = input[0];\n" +
                "    const source = parseInt(input[1]);\n" +
                "    const target = parseInt(input[2]);\n" +
                "    \n" +
                "    return parseInt(number, source).toString(target);\n" +
                "}";
    }

    @Override
    public int complexity() {
        return 28;
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "Please implement algorithm that converts " +
                "number from one numeral system to another. Method should accept " +
                "number, source numeral system and target numeral system.");
    }

    @Override
    public String author() {
        return "Oleksandr Baglai";
    }
}
