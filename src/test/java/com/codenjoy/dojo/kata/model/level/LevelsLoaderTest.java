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


import com.codenjoy.dojo.kata.services.Levels;
import com.codenjoy.dojo.services.questionanswer.levels.Level;
import com.codenjoy.dojo.services.questionanswer.levels.LevelsLoader;
import javassist.Modifier;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class LevelsLoaderTest {

    @Test
    public void test() {
        List<Level> levels = LevelsLoader.getAlgorithms(Levels.COMPLEXITIES);
        assertTrue(!levels.isEmpty());

        for (Level level : levels) {
            Class<? extends Level> aClass = level.getClass();

            assertFalse(Modifier.isAbstract(aClass.getModifiers()));
            assertFalse(Modifier.isInterface(aClass.getModifiers()));
        }

        assertEquals("  1 complexity:   0, name: HelloWorldAlgorithm,\n" +
                        "  2 complexity:   5, name: FizzBuzzAlgorithm,\n" +
                        "  3 complexity:   6, name: OddOrEvenAlgorithm,\n" +
                        "  4 complexity:   7, name: DoubleCharAlgorithm,\n" +
                        "  5 complexity:   8, name: SimpleMathAlgorithm,\n" +
                        "  6 complexity:   9, name: SumSquareDifferenceAlgorithm,\n" +
                        "  7 complexity:  10, name: CharOrderAlgorithm,\n" +
                        "  8 complexity:  11, name: NumeralSystemAlgorithm,\n" +
                        "  9 complexity:  12, name: FibonacciNumbersAlgorithm,\n" +
                        " 10 complexity:  13, name: PrimeFactoryAlgorithm,\n" +
                        " 11 complexity:  14, name: NameIntoInitialsAlgorithm,\n" +
                        " 12 complexity:  15, name: ConcatenatedSquaresAlgorithm,\n" +
                        " 13 complexity:  16, name: HighestAndLowestAlgorithm,\n" +
                        " 14 complexity:  17, name: RemoveVowelsAlgorithm,\n" +
                        " 15 complexity:  18, name: ExesAndOhsAlgorithm,\n" +
                        " 16 complexity:  19, name: IsogramWordsAlgorithm,\n" +
                        " 17 complexity:  20, name: RentCarCostCalculatorAlgorithm,\n" +
                        " 18 complexity:  21, name: DuplicateRemoveAlgorithm,\n" +
                        " 19 complexity:  22, name: ThinkLikeAChildAlgorithm,\n" +
                        " 20 complexity:  23, name: MultiplesThreeOrFiveAlgorithm,\n" +
                        " 21 complexity:  24, name: CreditCardNumberAlgorithm,\n" +
                        " 22 complexity:  25, name: DNASequenceAlgorithm,\n" +
                        " 23 complexity:  26, name: MiddleCharacterAlgorithm,\n" +
                        " 24 complexity:  27, name: NumberOrderAlgorithm,\n" +
                        " 25 complexity:  28, name: Sequence1Algorithm,\n" +
                        " 26 complexity:  36, name: PowerDigitSumAlgorithm,\n" +
                        " 27 complexity:  37, name: MakeBricksAlgorithm,\n" +
                        " 28 complexity:  40, name: ArabicToRomanAlgorithm,\n" +
                        " 29 complexity:  41, name: RomanToArabicAlgorithm,\n" +
                        " 30 complexity:  42, name: FactorialAlgorithm,\n" +
                        " 31 complexity:  45, name: ReverseAddPalindromeAlgorithm,\n" +
                        " 32 complexity:  50, name: Sequence2Algorithm,\n" +
                        " 33 complexity:  51, name: MaxSquareAlgorithm,\n" +
                        " 34 complexity:  55, name: XthPrimeAlgorithm,\n" +
                        " 35 complexity:  57, name: FizzBuzzMultiplierAlgorithm,\n" +
                        " 36 complexity:  60, name: LongDivisionAlgorithm,\n" +
                        " 37 complexity:2147483647, name: NullLevel",
                levels.stream()
                        .map(it -> String.format("%3d complexity:%4s, name: %s",
                                        levels.indexOf(it) + 1,
                                        it.complexity(),
                                        it.name()
                                )
                        )
                        .collect(Collectors.joining(",\n")));
    }
}
