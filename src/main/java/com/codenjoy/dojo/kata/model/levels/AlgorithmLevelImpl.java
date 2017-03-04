package com.codenjoy.dojo.kata.model.levels;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 - 2017 Codenjoy
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


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by indigo on 2017-03-04.
 */
public abstract class AlgorithmLevelImpl extends QuestionAnswerLevelImpl implements Algorithm {

    public AlgorithmLevelImpl(String... questions) {
        this.questions = Arrays.asList(questions);
        prepareAnswers(questions);
    }

    private void prepareAnswers(String[] questions) {
        this.answers = new LinkedList<>();
        for (String question : questions) {
            answers.add(get(question));
        }
    }

    @Override
    public List<String> getQuestions() {
        return questions;
    }

    public abstract String get(String input);

}
