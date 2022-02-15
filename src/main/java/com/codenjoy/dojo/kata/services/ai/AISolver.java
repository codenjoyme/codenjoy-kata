package com.codenjoy.dojo.kata.services.ai;

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


import com.codenjoy.dojo.client.AbstractTextBoard;
import com.codenjoy.dojo.games.kata.AbstractTextSolver;
import com.codenjoy.dojo.games.kata.Strings;
import com.codenjoy.dojo.kata.model.levels.Algorithm;
import com.codenjoy.dojo.kata.model.levels.Level;
import com.codenjoy.dojo.kata.model.levels.LevelsLoader;
import com.codenjoy.dojo.kata.model.levels.NullAlgorithm;
import com.codenjoy.dojo.services.Dice;

import java.util.List;

import static com.codenjoy.dojo.games.kata.Command.START_NEXT_LEVEL;

public class AISolver extends AbstractTextSolver {

    private AbstractTextBoard board;
    private List<Level> levels = LevelsLoader.getAlgorithms();

    public AISolver(Dice dice) {
        // do nothing
    }

    @Override
    public Strings getAnswers(int level, Strings questions) {
        if (!questions.iterator().hasNext()) {
            return new Strings(START_NEXT_LEVEL);
        }
        Algorithm algorithm = getAlgorithm(level);

        Strings answers = new Strings();
        for (String question : questions) {
//            if (question.equals("2")) {
//                answers.add("qwe");
//            } else
            answers.add(algorithm.get(question));
        }
        return answers;
    }

    private Algorithm getAlgorithm(int level) {
        if (level >= levels.size()) {
            return new NullAlgorithm();
        }
        return (Algorithm) levels.get(level);
    }
}
