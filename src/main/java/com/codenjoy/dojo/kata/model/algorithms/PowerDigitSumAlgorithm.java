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


import com.codenjoy.dojo.services.questionanswer.levels.AlgorithmLevelImpl;

import java.math.BigInteger;

/**
 * @author http://projecteuler.net/problem=16
 */
public class PowerDigitSumAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(int power) {
        String temp = BigInteger.ONE.shiftLeft(power).toString();
        int sum = 0;
        for (int i = 0; i < temp.length(); i++) {
            sum += temp.charAt(i) - '0'; // '0' is 48 in ASCII
        }
        return Integer.toString(sum);
    }

    @Override
    public String winCode() {
        return "function program(power) {\n" +
                "    const temp = (BigInt(1) << BigInt(power)).toString();\n" +
                "    let sum = 0;\n" +
                "    for (let i = 0; i < temp.length; i++) {\n" +
                "        sum += parseInt(temp[i]);\n" +
                "    }\n" +
                "    return sum.toString();\n" +
                "}";
    }

    @Override
    public String description() {
        return "2 to the power of 15 = 32768, the sum of digits " +
                "of the result 3 + 2 + 7 + 6 + 8 = 26. " +
                "What is the sum of the digits of 2 to the power of i?\n" +
                "Write a method for calculation that takes int " +
                "and returns the result as a String";
    }

    @Override
    public int complexity() {
        return 30;
    }

    @Override
    public String author() {
        return "ProjectEuler (http://projecteuler.net/problem=16)";
    }
}
