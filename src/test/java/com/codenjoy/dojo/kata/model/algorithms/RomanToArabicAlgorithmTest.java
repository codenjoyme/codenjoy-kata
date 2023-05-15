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

import com.codenjoy.dojo.services.questionanswer.levels.Algorithm;

public class RomanToArabicAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new RomanToArabicAlgorithm();
    }

    @Override
    public String answers() {
        return "I=>1\n" +
                "II=>2\n" +
                "III=>3\n" +
                "IV=>4\n" +
                "V=>5\n" +
                "VI=>6\n" +
                "VII=>7\n" +
                "VIII=>8\n" +
                "IX=>9\n" +
                "X=>10\n" +
                "XI=>11\n" +
                "XII=>12\n" +
                "XIII=>13\n" +
                "XIV=>14\n" +
                "XV=>15\n" +
                "XVI=>16\n" +
                "XVII=>17\n" +
                "XVIII=>18\n" +
                "XIX=>19\n" +
                "XX=>20\n" +
                "XXX=>30\n" +
                "XXXV=>35\n" +
                "XXXVI=>36\n" +
                "XLVI=>46\n" +
                "LVII=>57\n" +
                "LXVII=>67\n" +
                "LXXXIX=>89\n" +
                "CXXIII=>123\n" +
                "CCXXXIV=>234\n" +
                "CCCXLV=>345\n" +
                "CDLVI=>456\n" +
                "DLXVII=>567\n" +
                "DCLXXVIII=>678\n" +
                "DCCCXC=>890\n" +
                "MCCXXXIV=>1234\n" +
                "MMCCCXLV=>2345\n" +
                "MMMCDLVI=>3456";
    }
}
