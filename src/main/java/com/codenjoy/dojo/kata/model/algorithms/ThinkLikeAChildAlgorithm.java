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

import java.util.Arrays;
import java.util.List;

public class ThinkLikeAChildAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        return input.chars().map(this::getCircleCount).sum() + "";
    }

    private int getCircleCount(int c) {
        switch (c) {
            case '0':
            case '6':
            case '9':
                return 1;
            case '8':
                return 2;

           default:
                return 0;
        }
    }

    @Override
    public String winCode() {
        return
                "function program(input) {\n" +
                "return input.chars().map(this::getCircleCount).sum() + \"\";\n" +
                "    }\n" +
                "\n" +
                "    private int getCircleCount(int c) {\n" +
                "        switch (c) {\n" +
                "            case '0':\n" +
                "            case '6':\n" +
                "            case '9':\n" +
                "                return 1;\n" +
                "            case '8':\n" +
                "                return 2;\n" +
                "\n" +
                "            default:\n" +
                "                return 0;\n" +
                "        }\n" +
                "    }\n" +
                "}"
                ;
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "Think like a child...\n " +
                "Implement an algorithm that can solve the following tasks:" +
                "For example: \n" +
                "8809 = 6\n" +
                "7111 = 0\n" +
                "2172 = 0\n" +
                "6666 = 4\n" +
                "1111 = 0\n" +
                "3213 = 0\n" +
                "7662 = 2\n" +
                "9312 = 1\n" +
                "0000 = 4\n" +
                "2222 = 0\n" +
                "3333 = 0\n" +
                "5555 = 0\n" +
                "8193 = 3\n" +
                "8096 = 5\n" +
                "7777 = 0\n" +
                "9999 = 4");
    }

    @Override
    public List<String> getQuestions() {
        return List.of(
                "0000",
                "0123",
                "4567",
                "8901",
                "1111",
                "3366",
                "8899",
                "0896",
                "3333",
                "4444",
                "6677",
                "8809",
                "7111",
                "2172",
                "6666",
                "3213",
                "7662",
                "9312",
                "2222",
                "5555",
                "8193",
                "8096",
                "7777",
                "9999",
                "7756",
                "6855",
                "9881",
                "5531",
                "1234567890",
                "0987654321",
                "1029384756",
                "6574839201",
                "9298089492",
                "8734092357",
                "2083464833",
                "0000000000"
        );
    }

    @Override
    public int complexity() {
        //todo review complexity
        return 12;
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
