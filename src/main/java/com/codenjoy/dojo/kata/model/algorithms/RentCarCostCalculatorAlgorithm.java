package com.codenjoy.dojo.kata.model.algorithms;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2012 - 2023 Codenjoy
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

import com.codenjoy.dojo.services.questionanswer.levels.AlgorithmLevelImpl;

import java.util.Arrays;
import java.util.List;

public class RentCarCostCalculatorAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        int d = Integer.parseInt(input);
        return Integer.toString((d * 40) - (d >= 7 ? 50 : (d >= 3 ? 20 : 0)));
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "  return (input * 40) - (input >= 7 ? 50 : (input >= 3 ? 20 : 0));\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "Rent car cost calculator\n " +
                        "Every day you rent the car costs $40. If you rent the car for 7 or more days, you get $50 off your total. \n" +
                        "Alternatively, if you rent the car for 3 or more days, you get $20 off your total.\n" +
                        "Write a code that gives out the total amount for different days(d)." +
                        "Example: 1=>40, 2=>80, 3=>100, 4=>140, 6=>220, 7=>230, 15=>550");
    }

    @Override
    public List<String> getQuestions() {
        return List.of("1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "22",
                "33",
                "44",
                "55",
                "66",
                "77",
                "88",
                "99",
                "100"
        );
    }

    @Override
    public int complexity() {
        // todo review
        return 12;
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
