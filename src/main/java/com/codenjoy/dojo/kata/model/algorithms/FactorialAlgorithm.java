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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FactorialAlgorithm extends AlgorithmLevelImpl {

    private static Map<Integer, BigInteger> cache = new ConcurrentHashMap<>();

    @Override
    public String get(int number) {
        BigInteger result;
        if (number == 0) {
            return "1";
        }
        if (null != (result = cache.get(number))) {
            return result.toString();
        }
        result = BigInteger.valueOf(number).multiply(new BigInteger(get(String.valueOf(number - 1))));
        cache.put(number, result);
        return result.toString();
    }

    @Override
    public String winCode() {
        return "function program(number) {\n" +
                "    const cache = {};\n" +
                "\n" +
                "    function calculate(number) {\n" +
                "        if (number == 0) {\n" +
                "            return 1n;\n" +
                "        }\n" +
                "\n" +
                "        if (number in cache) {\n" +
                "            return cache[number];\n" +
                "        }\n" +
                "\n" +
                "        const result = BigInt(number) * calculate(number - 1);\n" +
                "        cache[number] = result;\n" +
                "\n" +
                "        return result;\n" +
                "    }\n" +
                "\n" +
                "    return calculate(number).toString();\n" +
                "}\n";
    }

    @Override
    public String description() {
        return "Write a method that takes one int argument and \n" +
                "that returns the factorial of that number as a String.\n" +
                "Warning: Int/long overflow is possible.";
    }

    @Override
    public int complexity() {
        return 40;
    }

    @Override
    public String author() {
        return "Александр Баглай (apofig@gmail.com)";
    }
}
