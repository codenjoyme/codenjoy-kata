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

public class MiddleCharacterAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new MiddleCharacterAlgorithm();
    }

    @Override
    public String answers() {
        return "test=>es\n" +
                "testing=>t\n" +
                "middle=>dd\n" +
                "A=>A\n" +
                "Hello=>l\n" +
                "Java=>av\n" +
                "OpenAI=>en\n" +
                "Testing=>t\n" +
                "ChatGPT=>t\n" +
                "Programming=>a\n" +
                "Algorithm=>r\n" +
                "DataStructures=>ru\n" +
                "Hello, World!=> \n" +
                "Java is awesome=> \n" +
                "OpenAI ChatGPT=> C\n" +
                "12345=>3\n" +
                "ABCDE=>C\n" +
                "Testing 123=>n\n" +
                "Hello World=> \n" +
                "Java Code=> \n" +
                "OpenAI Model=>I \n" +
                "Lorem Ipsum=> "
                ;
    }

}