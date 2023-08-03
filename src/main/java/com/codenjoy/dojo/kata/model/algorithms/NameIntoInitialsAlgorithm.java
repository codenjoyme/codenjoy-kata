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
import java.util.stream.Collectors;

public class NameIntoInitialsAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        return Arrays.stream(input.split(" ")).map(w -> w.substring(0, 1)).collect(Collectors.joining(".")).toUpperCase();
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "return input.split(\" \").map(w => w.substring(0, 1)).join(\".\").toUpperCase();\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList("Write a function to convert a name into initials. \n" +
                "This kata strictly takes two words with one space in between them.\n" +
                "The output should be two capital letters with a dot separating them.\n" +
                "Example:\n" +
                "Tom Harris=>T.H\n" +
                "garlick looney=>G.L",
                
                "Rewrite this function in JavaScript.",

                "Use a map method th solve this task.",

                "Rewrite this function in a shorter way.",

                "Remove everything from the script except for the function.",

                "Use function keyword.");
    }

    @Override
    public List<String> getQuestions() {
        return List.of("Tom Harris",
                "garlick looney",
                "Ethan parker",
                "olivia Campbell",
                "Liam Jenkins",
                "Emma Bryant",
                "Noah Reed",
                "Ava Coleman",
                "William Barnes",
                "Sophia Mitchell",
                "James Hughes",
                "Isabella Foster",
                "Benjamin Evans",
                "Mia Murphy",
                "Mason Richardson",
                "Charlotte Peterson",
                "Elijah Cooper",
                "Amelia Cox",
                "Alexander Griffin",
                "Harper Brooks",
                "Daniel Turner",
                "Abigail Kelly",
                "Henry Price",
                "Emily Ross",
                "Samuel Ward",
                "Elizabeth Morgan",
                "Joseph Watson",
                "Ella Bennett",
                "David Bailey",
                "Avery Howard",
                "Michael Nelson",
                "Lily Anderson"
        );
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
