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

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author http://euler.jakumo.org/problems/view/7.html
 */
public class XthPrimeAlgorithm extends AlgorithmLevelImpl {

    public static CopyOnWriteArrayList<Integer> primes = new CopyOnWriteArrayList<>();

    @Override
    public String get(int number) {
        if (number == 0) {
            return "1";
        }
        if (number <= primes.size()) {
            return String.valueOf(primes.get(number - 1));
        }
        int index = 1;
        int num = 1;
        if (primes.size() > 0) {
            index = primes.size() + 1;
            num = primes.get(primes.size() - 1);
        }
        while (true) {
            num++;
            boolean cont = false;
            for (int j = 0; j < index - 1; j++) {
                if (num % primes.get(j) == 0) {
                    cont = true;
                    break;
                }
            }
            if (cont) {
                continue;
            }

            if (!new String(new char[num]).matches(".?|(..+?)\\1+")) {
                if (primes.size() < index) {
                    primes.add(num);
                }
                if (number == index) {
                    return String.valueOf(num);
                }
                index++;
            }
        }
    }

    // TODO закончить и тут
    @Override
    public String winCode() {
        return "function program(number) {\n" +
                "    return '';\n" +
                "}";
    }

    @Override
    public String description() {
        return "The first 10 prime numbers are 2, 3, 5, 7, 11, 13, 17, 19, 23, 29. " +
                "Write a method that returns the i-th prime number.";
    }

    @Override
    public String author() {
        return "ProjectEuler (http://euler.jakumo.org/problems/view/7.html)";
    }

    @Override
    public int complexity() {
        return 55;
    }
}
