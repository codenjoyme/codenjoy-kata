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

        // todo fix me after complexity review
        assertEquals("  1 complexity:   0, name: HelloWorldAlgorithm,\n" +
                        "  2 complexity:   5, name: FizzBuzzAlgorithm,\n" +
                        "  3 complexity:  10, name: SumSquareDifferenceAlgorithm,\n" +
                        "  4 complexity:  11, name: NameIntoInitialsAlgorithm,\n" +
                        "  5 complexity:  11, name: ConcatenatedSquaresAlgorithm,\n" +
                        "  6 complexity:  11, name: SimpleMathAlgorithm,\n" +
                        "  7 complexity:  12, name: DNASequenceAlgorithm,\n" +
                        "  8 complexity:  12, name: ThinkLikeAChildAlgorithm,\n" +
                        "  9 complexity:  12, name: MiddleCharacterAlgorithm,\n" +
                        " 10 complexity:  12, name: IsogramWordsAlgorithm,\n" +
                        " 11 complexity:  12, name: DuplicateRemoveAlgorithm,\n" +
                        " 12 complexity:  12, name: CreditCardNumberAlgorithm,\n" +
                        " 13 complexity:  12, name: MultiplesThreeOrFiveAlgorithm,\n" +
                        " 14 complexity:  12, name: RemoveVowelsAlgorithm,\n" +
                        " 15 complexity:  12, name: CharOrderAlgorithm,\n" +
                        " 16 complexity:  13, name: NumberOrderAlgorithm,\n" +
                        " 17 complexity:  15, name: Sequence1Algorithm,\n" +
                        " 18 complexity:  20, name: FibonacciNumbersAlgorithm,\n" +
                        " 19 complexity:  25, name: PrimeFactoryAlgorithm,\n" +
                        " 20 complexity:  28, name: NumeralSystemAlgorithm,\n" +
                        " 21 complexity:  30, name: PowerDigitSumAlgorithm,\n" +
                        " 22 complexity:  35, name: MakeBricksAlgorithm,\n" +
                        " 23 complexity:  37, name: ArabicToRomanAlgorithm,\n" +
                        " 24 complexity:  38, name: RomanToArabicAlgorithm,\n" +
                        " 25 complexity:  40, name: FactorialAlgorithm,\n" +
                        " 26 complexity:  45, name: ReverseAddPalindromeAlgorithm,\n" +
                        " 27 complexity:  50, name: Sequence2Algorithm,\n" +
                        " 28 complexity:  55, name: XthPrimeAlgorithm,\n" +
                        " 29 complexity:  57, name: FizzBuzzMultiplierAlgorithm,\n" +
                        " 30 complexity:  60, name: LongDivisionAlgorithm,\n" +
                        " 31 complexity:2147483647, name: NullLevel",
                levels.stream()
                        .sorted(Comparator.comparingInt(Level::complexity))
                        .map(it -> String.format("%3d complexity:%4s, name: %s",
                                        levels.indexOf(it) + 1,
                                        it.complexity(),
                                        it.name()
                                )
                        )
                        .collect(Collectors.joining(",\n")));
    }
}
