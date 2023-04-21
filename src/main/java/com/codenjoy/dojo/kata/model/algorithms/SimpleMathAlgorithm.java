package com.codenjoy.dojo.kata.model.algorithms;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2012 - 2023 Codenjoy
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleMathAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(int input) {
        return Integer.toString(input % 2 == 0 ? input + 1 : input - 1);
    }

    @Override
    public String winCode() {
        return "function get(input) {\n" +
                "    let number = parseInt(input);\n" +
                "    return (number % 2 == 0)\n" +
                "        ? number + 1\n" +
                "        : number - 1;\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "Given the sequence: 1, 0, 3, 2, 5, 4, 7, 6, 9, 8, 11, 10, 13, 12, 15, 14...\n" +
                "The sequence starts with element number 0: f(0)=1.\n" +
                "Your task is to write a function that returns the element at index n: f(n)=?");
    }

    @Override
    public List<String> getQuestions() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= 25; i++) {
            result.add(Integer.toString(i * i / 10 + i));
        }
        return result;
    }

    @Override
    public int complexity() {
        return 11;
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
