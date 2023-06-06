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

public class CreditCardNumberAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new CreditCardNumberAlgorithm();
    }

    @Override
    public String answers() {
        return "456126121234546=>7\n" +
                "123456781234567=>0\n" +
                "183168009579826=>2\n" +
                "964720036906339=>7\n" +
                "613951967276640=>9\n" +
                "825813064400100=>7\n" +
                "239698713103140=>9\n" +
                "771412693933286=>7\n" +
                "254262384108564=>0\n" +
                "959681833483055=>7\n" +
                "210087745295982=>4\n" +
                "367683885386271=>2\n" +
                "894632429803471=>5\n" +
                "471260044736237=>5\n" +
                "916471602234329=>1\n" +
                "961073953339054=>4\n" +
                "917408439816341=>5\n" +
                "498078140932499=>4\n" +
                "686244896142849=>2\n" +
                "772287416460433=>2\n" +
                "207725984977363=>1\n" +
                "199776984753064=>2\n" +
                "498874493103145=>5\n" +
                "662571495734934=>1\n" +
                "287442129303575=>1\n" +
                "358353262548397=>0\n" +
                "576080532156469=>3";
    }
}