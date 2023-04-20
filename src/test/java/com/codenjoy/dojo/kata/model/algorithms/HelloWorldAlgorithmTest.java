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

public class HelloWorldAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new HelloWorldAlgorithm();
    }

    @Override
    public String questions() {
        return "hello=>\n" +
                "world=>\n" +
                "qwe=>\n" +
                "asd=>\n" +
                "zxc=>";
    }

    @Override
    public String answers() {
        return "hello=>world\n" +
                "world=>hello\n" +
                "qwe=>qwe\n" +
                "asd=>asd";
    }
}