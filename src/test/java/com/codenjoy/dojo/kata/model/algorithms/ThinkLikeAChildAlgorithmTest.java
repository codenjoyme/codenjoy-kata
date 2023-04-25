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

public class ThinkLikeAChildAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new ThinkLikeAChildAlgorithm();
    }

    @Override
    public String answers() {
        return
                "8809 =>6\n" +
                "7111 =>0\n" +
                "2172 =>0\n" +
                "6666 =>4\n" +
                "1111 =>0\n" +
                "3213 =>0\n" +
                "7662 =>2\n" +
                "9312 =>1\n" +
                "0000 =>4\n" +
                "2222 =>0\n" +
                "3333 =>0\n" +
                "5555 =>0\n" +
                "8193 =>3\n" +
                "8096 =>5\n" +
                "7777 =>0\n" +
                "9999 =>4\n" +
                "00000000 =>8"
                ;
    }

    @Override
    public String questions() {
        return
                "0000=>\n" +
                "0123=>\n" +
                "4567=>\n" +
                "8901=>\n" +
                "1111=>\n" +
                "3366=>\n" +
                "8899=>\n" +
                "0896=>\n" +
                "3333=>\n" +
                "4444=>\n" +
                "6677=>\n" +
                "8809=>\n" +
                "7111=>\n" +
                "2172=>\n" +
                "6666=>\n" +
                "3213=>\n" +
                "7662=>\n" +
                "9312=>\n" +
                "2222=>\n" +
                "5555=>\n" +
                "8193=>\n" +
                "8096=>\n" +
                "7777=>\n" +
                "9999=>\n" +
                "7756=>\n" +
                "6855=>\n" +
                "9881=>\n" +
                "5531=>\n" +
                "1234567890=>\n" +
                "0987654321=>\n" +
                "1029384756=>\n" +
                "6574839201=>\n" +
                "9298089492=>\n" +
                "8734092357=>\n" +
                "2083464833=>\n" +
                "0000000000=>"
                ;
    }
}