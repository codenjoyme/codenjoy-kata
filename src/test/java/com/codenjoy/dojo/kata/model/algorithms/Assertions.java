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
import com.codenjoy.dojo.services.questionanswer.levels.QuestionAnswerLevelImpl;
import com.codenjoy.dojo.utils.SmokeUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.assertEquals;

public class Assertions {

    public static final String QA_SEPARATOR = "=>";

    public static void assertAlgorithm(Algorithm algorithm, String expected) {
        assertEquals(expected,
                answers(algorithm, expected));
    }

    private static String answers(Algorithm algorithm, String expected) {
        return Arrays.stream(expected.split("\n"))
                .map(line -> line.split(QA_SEPARATOR)[0])
                .map(arg -> arg + QA_SEPARATOR + algorithm.get(arg))
                .collect(joining("\n"));
    }

    public static void assertSmokeAlgorithm(Algorithm algorithm, String fileName) {
        File expectedFile = new File("src/test/java/"
                + Assertions.class.getPackageName().replace('.', '/')
                + '/' + fileName);

        String expected = "";
        if (expectedFile.exists()) {
            expected = SmokeUtils.load(expectedFile);
        }

        List<String> answers = Arrays.asList(answers(algorithm, expected).split("\n"));
        SmokeUtils.assertSmokeFile(expectedFile.getPath(), answers);
    }

    public static void assertQuestions(QuestionAnswerLevelImpl algorithm, String expected) {
        assertEquals(expected,
                StringUtils.join(algorithm.getQuestions(), QA_SEPARATOR + "\n") + QA_SEPARATOR);
    }
}