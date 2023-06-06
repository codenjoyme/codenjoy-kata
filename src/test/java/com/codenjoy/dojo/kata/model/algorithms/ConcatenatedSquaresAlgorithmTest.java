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

public class ConcatenatedSquaresAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new ConcatenatedSquaresAlgorithm();
    }

    @Override
    public String answers() {
        return "123=>149\n" +
                "465=>163625\n" +
                "0=>0\n" +
                "5813=>256419\n" +
                "7264=>4943616\n" +
                "1369=>193681\n" +
                "7952=>4981254\n" +
                "9425=>8116425\n" +
                "4759=>16492581\n" +
                "4777=>16494949\n" +
                "2040=>40160\n" +
                "6176=>3614936\n" +
                "1308=>19064\n" +
                "2784=>4496416\n" +
                "1868=>1643664\n" +
                "4289=>1646481\n" +
                "8703=>644909\n" +
                "1690=>136810\n" +
                "2722=>44944\n" +
                "2332=>4994\n" +
                "5152=>251254\n" +
                "1399=>198181\n" +
                "794=>498116\n" +
                "9906=>8181036\n" +
                "2157=>412549\n" +
                "586=>256436\n" +
                "720=>4940\n" +
                "8626=>6436436";
    }
}