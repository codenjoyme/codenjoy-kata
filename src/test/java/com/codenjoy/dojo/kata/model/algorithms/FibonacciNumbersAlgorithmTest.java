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

public class FibonacciNumbersAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new FibonacciNumbersAlgorithm();
    }

    @Override
    public String answers() {
        return "1=>1\n" +
                "2=>1\n" +
                "3=>2\n" +
                "4=>3\n" +
                "5=>5\n" +
                "6=>8\n" +
                "7=>13\n" +
                "8=>21\n" +
                "9=>34\n" +
                "10=>55\n" +
                "11=>89\n" +
                "12=>144\n" +
                "13=>233\n" +
                "14=>377\n" +
                "15=>610\n" +
                "16=>987\n" +
                "17=>1597\n" +
                "18=>2584\n" +
                "19=>4181\n" +
                "20=>6765\n" +
                "21=>10946\n" +
                "22=>17711\n" +
                "23=>28657\n" +
                "24=>46368\n" +
                "25=>75025";
    }

    @Override
    public String cornerCases() {
        return "0=>0\n" +
                "80=>23416728348467685\n" +
                "81=>37889062373143906\n" +
                "82=>61305790721611591\n" +
                "83=>99194853094755497\n" +
                "84=>160500643816367088\n" +
                "85=>259695496911122585\n" +
                "86=>420196140727489673\n" +
                "87=>679891637638612258\n" +
                "88=>1100087778366101931\n" +
                "89=>1779979416004714189\n" +
                "90=>2880067194370816120\n" +
                "91=>4660046610375530309\n" +
                "92=>7540113804746346429\n" +
                "93=>-6246583658587674878\n" +  // TODO overflow
                "94=>1293530146158671551\n" +
                "95=>-4953053512429003327\n" +
                "96=>-3659523366270331776\n" +
                "97=>-8612576878699335103\n" +
                "98=>6174643828739884737\n" +
                "99=>-2437933049959450366\n" +
                "100=>3736710778780434371";
    }
}