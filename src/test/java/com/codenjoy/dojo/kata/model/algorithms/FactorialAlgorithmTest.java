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


import org.junit.Test;

import static com.codenjoy.dojo.kata.model.algorithms.Assertions.assertAlgorithm;

public class FactorialAlgorithmTest {

    @Test
    public void shouldWork() {
        assertAlgorithm(new FactorialAlgorithm(),
                "0=>1\n" +
                "1=>1\n" +
                "2=>2\n" +
                "3=>6\n" +
                "4=>24\n" +
                "5=>120\n" +
                "6=>720\n" +
                "7=>5040\n" +
                "8=>40320\n" +
                "9=>362880\n" +
                "10=>3628800\n" +
                "11=>39916800\n" +
                "12=>479001600\n" +
                "13=>6227020800\n" +
                "14=>87178291200\n" +
                "15=>1307674368000\n" +
                "16=>20922789888000\n" +
                "17=>355687428096000\n" +
                "18=>6402373705728000\n" +
                "19=>121645100408832000\n" +
                "20=>2432902008176640000\n" +
                "21=>51090942171709440000\n" +
                "22=>1124000727777607680000\n" +
                "23=>25852016738884976640000\n" +
                "24=>620448401733239439360000\n" +
                "25=>15511210043330985984000000\n" +
                "26=>403291461126605635584000000\n" +
                "27=>10888869450418352160768000000\n" +
                "28=>304888344611713860501504000000\n" +
                "29=>8841761993739701954543616000000\n" +
                "30=>265252859812191058636308480000000\n" +
                "31=>8222838654177922817725562880000000\n" +
                "32=>263130836933693530167218012160000000\n" +
                "33=>8683317618811886495518194401280000000\n" +
                "34=>295232799039604140847618609643520000000\n" +
                "35=>10333147966386144929666651337523200000000");
    }
}