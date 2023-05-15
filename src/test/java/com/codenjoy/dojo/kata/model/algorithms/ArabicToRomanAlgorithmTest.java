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

public class ArabicToRomanAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new ArabicToRomanAlgorithm();
    }

    @Override
    public String answers() {
        return "1=>I\n" +
                "2=>II\n" +
                "3=>III\n" +
                "4=>IV\n" +
                "5=>V\n" +
                "6=>VI\n" +
                "7=>VII\n" +
                "8=>VIII\n" +
                "9=>IX\n" +
                "10=>X\n" +
                "11=>XI\n" +
                "12=>XII\n" +
                "13=>XIII\n" +
                "14=>XIV\n" +
                "15=>XV\n" +
                "16=>XVI\n" +
                "17=>XVII\n" +
                "18=>XVIII\n" +
                "19=>XIX\n" +
                "20=>XX\n" +
                "30=>XXX\n" +
                "35=>XXXV\n" +
                "36=>XXXVI\n" +
                "46=>XLVI\n" +
                "57=>LVII\n" +
                "67=>LXVII\n" +
                "89=>LXXXIX\n" +
                "123=>CXXIII\n" +
                "234=>CCXXXIV\n" +
                "345=>CCCXLV\n" +
                "456=>CDLVI\n" +
                "567=>DLXVII\n" +
                "678=>DCLXXVIII\n" +
                "890=>DCCCXC\n" +
                "1234=>MCCXXXIV\n" +
                "2345=>MMCCCXLV\n" +
                "3456=>MMMCDLVI";
    }

    @Override
    public String cornerCases() {
        return "2365=>MMCCCLXV\n" +
                "2222=>MMCCXXII\n" +
                "1111=>MCXI\n" +
                "999=>CMXCIX\n" +
                "888=>DCCCLXXXVIII\n" +
                "777=>DCCLXXVII\n" +
                "666=>DCLXVI\n" +
                "555=>DLV\n" +
                "444=>CDXLIV\n" +
                "333=>CCCXXXIII\n" +
                "222=>CCXXII\n" +
                "111=>CXI\n" +
                "3999=>MMMCMXCIX\n" +
                "4000=>Input must be between 1 and 3999";
    }
}