package com.codenjoy.dojo.kata.services;

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

import com.codenjoy.dojo.client.Utils;
import com.codenjoy.dojo.kata.model.algorithms.*;
import com.codenjoy.dojo.services.multiplayer.LevelProgress;
import com.codenjoy.dojo.services.questionanswer.levels.Level;
import com.codenjoy.dojo.services.questionanswer.levels.LevelsLoader;
import com.codenjoy.dojo.utils.JsonUtils;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public final class Levels {

    private Levels() {
        throw new IllegalAccessError("Utility class");
    }

    public static final Map<Integer, Class<? extends Level>> COMPLEXITIES = new HashMap<>() {{
        put(0, HelloWorldAlgorithm.class);
        put(5, FizzBuzzAlgorithm.class);
        put(6, OddOrEvenAlgorithm.class);
        put(7, DoubleCharAlgorithm.class);
        put(8, SimpleMathAlgorithm.class);
        put(9, NameIntoInitialsAlgorithm.class);
        put(10, ConcatenatedSquaresAlgorithm.class);
        put(11, SumSquareDifferenceAlgorithm.class);
        put(12, HighestAndLowestAlgorithm.class);
        put(13, RemoveVowelsAlgorithm.class);
        put(14, ExesAndOhsAlgorithm.class);
        put(15, CharOrderAlgorithm.class);
        put(16, IsogramWordsAlgorithm.class);
        put(17, RentCarCostCalculatorAlgorithm.class);
        put(20, DuplicateRemoveAlgorithm.class);
        put(21, ThinkLikeAChildAlgorithm.class);
        put(22, MultiplesThreeOrFiveAlgorithm.class);
        put(23, CreditCardNumberAlgorithm.class);
        put(24, DNASequenceAlgorithm.class);
        put(25, MiddleCharacterAlgorithm.class);
        put(26, NumberOrderAlgorithm.class);
        put(27, Sequence1Algorithm.class);
        put(28, NumeralSystemAlgorithm.class);
        put(30, FibonacciNumbersAlgorithm.class);
        put(35, PrimeFactoryAlgorithm.class);
        put(36, PowerDigitSumAlgorithm.class);
        put(37, MakeBricksAlgorithm.class);
        put(40, ArabicToRomanAlgorithm.class);
        put(41, RomanToArabicAlgorithm.class);
        put(42, FactorialAlgorithm.class);
        put(45, ReverseAddPalindromeAlgorithm.class);
        put(50, Sequence2Algorithm.class);
        put(51, MaxSquareAlgorithm.class);
        put(55, XthPrimeAlgorithm.class);
        put(57, FizzBuzzMultiplierAlgorithm.class);
        put(60, LongDivisionAlgorithm.class);
    }};

    private static List<Level> all() {
        return LevelsLoader.getAlgorithms(COMPLEXITIES);
    }

    public static void setup(GameSettings settings) {
        AtomicInteger index = new AtomicInteger();
        all().forEach(level -> settings.setLevelMap(index.incrementAndGet(), json(level)));
    }

    private static String json(Level level) {
        return escape2(new JSONObject(){{
            put("name", escape(level.name()));
            put("winCode", escape(level.winCode()));
            put("defaultCode", escape(level.defaultCode()));
            put("help", level.description().stream()
                            .map(Levels::escape)
                            .collect(toList()));
        }}.toString());
    }

    private static String escape(String input) {
        return Utils.escapeApostrophe(input);
    }

    private static String escape2(String input) {
        return Utils.replaceNewLine(JsonUtils.asString(input));
    }

    public static List<Level> sorted(GameSettings settings) {
        List<String> sorted = IntStream.range(0, settings.getLevelsCount())
                .map(index -> index + LevelProgress.levelsStartsFrom1)
                .mapToObj(settings::getLevelMap)
                .map(json -> new JSONObject(json).getString("name"))
                .collect(toList());

        return all().stream()
                .sorted(comparingInt(level -> sorted.indexOf(level.name())))
                .filter(level -> sorted.contains(level.name()))
                .collect(toList());
    }
}