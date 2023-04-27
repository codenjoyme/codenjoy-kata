package com.codenjoy.dojo.kata.model.level;

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


import com.codenjoy.dojo.services.questionanswer.levels.Level;
import com.codenjoy.dojo.services.questionanswer.levels.LevelsLoader;
import javassist.Modifier;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class LevelsLoaderTest {

    @Test
    public void test() {
        List<Level> levels = LevelsLoader.getAlgorithmsOrderedByComplexity();
        assertTrue(!levels.isEmpty());

        for (Level level : levels) {
            Class<? extends Level> aClass = level.getClass();

            assertFalse(Modifier.isAbstract(aClass.getModifiers()));
            assertFalse(Modifier.isInterface(aClass.getModifiers()));
        }

        assertEquals("HelloWorldAlgorithm,\n" +
                        "FizzBuzzAlgorithm,\n" +
                        "FizzBuzzMultiplierAlgorithm,\n" +
                        "SumSquareDifferenceAlgorithm,\n" +
                        "SimpleMathAlgorithm,\n" +
                        "CharOrderAlgorithm,\n" +
                        "NumberOrderAlgorithm,\n" +
                        "Sequence1Algorithm,\n" +
                        "FibonacciNumbersAlgorithm,\n" +
                        "PrimeFactoryAlgorithm,\n" +
                        "PowerDigitSumAlgorithm,\n" +
                        "MakeBricksAlgorithm,\n" +
                        "FactorialAlgorithm,\n" +
                        "ReverseAddPalindromeAlgorithm,\n" +
                        "Sequence2Algorithm,\n" +
                        "XthPrimeAlgorithm,\n" +
                        "LongDivisionAlgorithm,\n" +
                        "NullLevel",
                levels.stream()
                        .sorted(Comparator.comparingInt(Level::complexity))
                        .map(it -> it.getClass().getSimpleName())
                        .collect(Collectors.joining(",\n")));
    }
}
