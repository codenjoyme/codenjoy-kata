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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ArabicToRomanAlgorithm extends AlgorithmLevelImpl {

    public String get(int input) {
        Map<Integer, String> numerals = new LinkedHashMap<>() {{
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }};

        if (input < 1 || input > 3999) {
            return "Input must be between 1 and 3999";
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : numerals.entrySet()) {
            int value = entry.getKey();
            String numeral = entry.getValue();
            while (input >= value) {
                result.append(numeral);
                input -= value;
            }
        }
        return result.toString();
    }

    @Override
    public String winCode() {
        return "function get(input) {\n" +
                "  const numerals = [\n" +
                "    [1000, 'M'],\n" +
                "    [900, 'CM'],\n" +
                "    [500, 'D'],\n" +
                "    [400, 'CD'],\n" +
                "    [100, 'C'],\n" +
                "    [90, 'XC'],\n" +
                "    [50, 'L'],\n" +
                "    [40, 'XL'],\n" +
                "    [10, 'X'],\n" +
                "    [9, 'IX'],\n" +
                "    [5, 'V'],\n" +
                "    [4, 'IV'],\n" +
                "    [1, 'I'],\n" +
                "  ];\n" +
                "\n" +
                "  if (input < 1 || input > 3999) {\n" +
                "    return 'Input must be between 1 and 3999';\n" +
                "  }\n" +
                "\n" +
                "  let result = '';\n" +
                "  numerals.forEach(([value, numeral]) => {\n" +
                "    while (input >= value) {\n" +
                "      result += numeral;\n" +
                "      input -= value;\n" +
                "    }\n" +
                "  });\n" +
                "\n" +
                "  return result;\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "Roman number algorithm. Convert arabic number to roman number.");
    }

    @Override
    public List<String> getQuestions() {
        return Arrays.asList(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "30",
            "35",
            "36",
            "46",
            "57",
            "67",
            "89",
            "123",
            "234",
            "345",
            "456",
            "567",
            "678",
            "890",
            "1234",
            "2345",
            "3456");
    }

    @Override
    public String author() {
        return "Author: Oleksandr Baglai (apofig@gmail.com)";
    }
}
