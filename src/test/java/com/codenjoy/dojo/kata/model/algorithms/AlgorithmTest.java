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
import org.junit.Test;

import java.util.Arrays;

import static com.codenjoy.dojo.kata.model.algorithms.Assertions.*;
import static java.util.stream.Collectors.joining;

public abstract class AlgorithmTest {

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

    @Test
    public void answersTest() {
        assertAlgorithm(algorithm(), answers());

        if (!StringUtils.isEmpty(cornerCases())) {
            assertAlgorithm(algorithm(), cornerCases());
        }
    }

    @Test
    public void questionTest(){
        assertQuestions((QuestionAnswerLevelImpl) algorithm(), questions());
    }
}