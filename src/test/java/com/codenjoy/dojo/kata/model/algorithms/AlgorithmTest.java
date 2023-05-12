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
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;

import java.util.Arrays;

import static com.codenjoy.dojo.kata.model.algorithms.Assertions.*;
import static java.util.stream.Collectors.joining;

public abstract class AlgorithmTest {

    protected Algorithm algorithm;

    public abstract Algorithm algorithm();

    public abstract String answers();

    public String cornerCases() {
        return "";
    }

    public String questions() {
        return Arrays.stream(answers().split("\n"))
                .map(line -> line.split(QA_SEPARATOR)[0] + QA_SEPARATOR)
                .collect(joining("\n"));
    }

    @Before
    public void setup() {
        algorithm = algorithm();
    }

    @Test
    public void answersTest() {
        try {
            assertAlgorithm(algorithm, answers());
        } catch (ComparisonFailure exception) {
            throwWith(exception, "answers");
        }

        try {
            cornerCasesAnswersTest();
        } catch (ComparisonFailure exception) {
            throwWith(exception, "cornerCases");
        }
    }

    private void throwWith(ComparisonFailure exception, String methodName) {
        throw StackTraceUtils.clarify(exception, methodName, getClass());
    }

    private void cornerCasesAnswersTest() {
        String cases = cornerCases();
        if (StringUtils.isEmpty(cases)) {
            return;
        }
        if (cases.startsWith("FILE:")) {
            String fileName = cases.substring("FILE:".length());
            assertSmokeAlgorithm(algorithm, fileName);
        } else {
            assertAlgorithm(algorithm, cases);
        }
    }

    @Test
    public void questionTest(){
        assertQuestions((QuestionAnswerLevelImpl) algorithm, questions());
    }
}