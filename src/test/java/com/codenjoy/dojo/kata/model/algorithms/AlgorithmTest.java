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
import org.junit.Test;

import static com.codenjoy.dojo.kata.model.algorithms.Assertions.assertAlgorithm;
import static com.codenjoy.dojo.kata.model.algorithms.Assertions.assertQuestions;

public abstract class AlgorithmTest {

    public abstract Algorithm algorithm();

    public abstract String answers();

    public String questions() {
        return "1=>\n" +
                "2=>\n" +
                "3=>\n" +
                "4=>\n" +
                "5=>\n" +
                "6=>\n" +
                "7=>\n" +
                "8=>\n" +
                "9=>\n" +
                "10=>\n" +
                "11=>\n" +
                "12=>\n" +
                "13=>\n" +
                "14=>\n" +
                "15=>\n" +
                "16=>\n" +
                "17=>\n" +
                "18=>\n" +
                "19=>\n" +
                "20=>\n" +
                "21=>\n" +
                "22=>\n" +
                "23=>\n" +
                "24=>\n" +
                "25=>";
    }

    @Test
    public void shouldWork() {
        assertAlgorithm(algorithm(),
                answers()
        );
    }

    @Test
    public void questionTest(){
        assertQuestions((QuestionAnswerLevelImpl) algorithm(),
                questions());
    }
}
