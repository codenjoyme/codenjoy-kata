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

public class RentCarCostCalculatorAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new RentCarCostCalculatorAlgorithm();
    }

    @Override
    public String answers() {
        return "1=>40\n" +
                "2=>80\n" +
                "3=>100\n" +
                "4=>140\n" +
                "5=>180\n" +
                "6=>220\n" +
                "7=>230\n" +
                "8=>270\n" +
                "9=>310\n" +
                "10=>350\n" +
                "22=>830\n" +
                "33=>1270\n" +
                "44=>1710\n" +
                "55=>2150\n" +
                "66=>2590\n" +
                "77=>3030\n" +
                "88=>3470\n" +
                "99=>3910\n" +
                "100=>3950";
    }
}