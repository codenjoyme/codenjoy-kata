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

public class MiddleCharacterAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        int length = input.length();
        int middle = length / 2;
        return input.substring(length % 2 == 0 ? middle - 1 : middle, middle + 1);
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "  let length = input.length;\n" +
                "  let middle = Math.floor(length / 2);\n" +
                "\n" +
                "  if (length % 2 === 0) {\n" +
                "    return input.substring(middle - 1, middle + 1);\n" +
                "  } else {\n" +
                "    return input.substring(middle, middle + 1);\n" +
                "  }" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList("You are going to be given a word. \n" +
                "Your job is to return the middle character of the word. \n" +
                "If the word's length is odd, return the middle character. \n" +
                "If the word's length is even, return the middle 2 characters.\n" +
                "#Examples:test=>es, testing=>t, middle=>dd, A=>A"
        );
    }

    @Override
    public List<String> getQuestions() {
        return List.of("test",
                "testing",
                "middle",
                "A",
                "Hello",
                "Java",
                "OpenAI",
                "Testing",
                "ChatGPT",
                "Programming",
                "Algorithm",
                "DataStructures",
                "Hello, World!",
                "Java is awesome",
                "OpenAI ChatGPT",
                "12345",
                "ABCDE",
                "Testing 123",
                "Hello World",
                "Java Code",
                "OpenAI Model",
                "Lorem Ipsum"
        );
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
