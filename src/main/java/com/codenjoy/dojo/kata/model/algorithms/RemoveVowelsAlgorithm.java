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

public class RemoveVowelsAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        return input.replaceAll("(?i)[aeiou]" , "");
    }

    @Override
    public String winCode() {
        return
                "function get(input) {\n" +
                "    return input.replace(/(?i)[aeiou]/g, \"\");\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList("Oh my, it seems that trolls have taken over your comment section!\n" +
                "However, fear not, for there is a simple solution to deal with these troublesome creatures.\n" +
                "You may remove all vowels from their comments, rendering them powerless.\n" +
                "I implore you to create a function that can execute this task, for instance,\n" +
                "transforming \"This website is for losers LOL!\" into \"Ths wbst s fr lsrs LL!\". \n" +
                "Please take note that for this exercise, the letter 'y' is not considered a vowel.");
    }

    @Override
    public List<String> getQuestions() {
        return List.of(
                "Hello World!!",
                "The quick brown fox jumps over the lazy dog.",
                "I'm sorry, Dave. I'm afraid I can't do that.",
                "To be or not to be, that is the question.",
                "The world is a book, and those who do not travel read only a page.",
                "The five boxing wizards jump quickly.",
                "Why did the tomato turn red? Because it saw the salad dressing!",
                "She sells seashells by the seashore.",
                "How much wood would a woodchuck chuck if a woodchuck could chuck wood?",
                "All work and no play makes Jack a dull boy.",
                "The cat in the hat had a bat and a hat.",
                "I before E except after C.",
                "The rain in Spain stays mainly in the plain.",
                "Supercalifragilisticexpialidocious."
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
