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

public class HelloWorldAlgorithm extends AlgorithmLevelImpl {

    public static final String HELLO = "hello";
    public static final String WORLD = "world";

    @Override
    public String get(String question) {
        if (question.equals(HELLO)) {
            return WORLD;
        } 
        
        if (question.equals(WORLD)) {
            return HELLO;
        } 
        
        return question;
    }

    @Override
    public String winCode() {
        return "function program(question) {\n" +
                "    if (question == 'hello'){\n" +
                "        return 'world';\n" +
                "    }\n" +
                "    if (question == 'world'){\n" +
                "        return 'hello';\n" +
                "    }\n" +
                "    return question;\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "Write a method that takes a single string argument " +
                "and return the string 'world' if 'hello' came in.",

                "Please write js method.",

                "Now please improve the algorithm so that it returns" +
                "'hello' if 'world' came in. Previous logic should work also",

                "One more improvement: in other cases the algorithm " +
                "should return the same string that came in.");
    }

    @Override
    public List<String> getQuestions() {
        return Arrays.asList(
                HELLO,
                WORLD,
                "qwe",
                "asd",
                "zxc");
    }

    @Override
    public String author() {
        return "Александр Баглай (apofig@gmail.com)";
    }
}
