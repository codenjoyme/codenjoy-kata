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

public class IsogramWordsAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        return String.valueOf(
                input.toLowerCase().chars().distinct().count() == input.length());
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "   return (new Set(input.toLowerCase())).size === input.length;" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList("An isogram is a word that has no repeating letters, consecutive or non-consecutive.\n" +
                "Implement a function that determines whether a string that contains only letters is an isogram.\n" +
                "Assume the empty string is an isogram. Ignore letter case.\n" +
                "Conjugated=>true\n" +
                "cappa=>false\n" +
                "moOn=>false");
    }

    @Override
    public List<String> getQuestions() {
        return List.of("Dermatoglyphics",
                "cappa",
                "moOn",
                "",
                "Ambidextrously",
                "Aqueducts",
                "Bilabial",
                "Caramelized",
                "Conjugated",
                "Denouement",
                "Disinfectant",
                "Embezzler",
                "Enzymology",
                "Fluoride",
                "Glycogen",
                "Humidity",
                "Juxtapose",
                "Kilobytes",
                "Locomotive",
                "Monolithic",
                "Nauseously",
                "Oblongata",
                "Permeable",
                "Quizzical",
                "Rhinoceros",
                "Sequences",
                "Symmetrical",
                "Tesseract",
                "Unconquered",
                "Ventriloquism",
                "Xenophobia",
                "Yellowish",
                "Zamboni",
                "Zygotes"
        );
    }

    @Override
    public int complexity() {
        //todo review
        return 12;
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
