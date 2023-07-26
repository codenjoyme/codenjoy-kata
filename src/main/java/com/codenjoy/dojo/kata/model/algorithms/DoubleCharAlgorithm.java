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

import com.codenjoy.dojo.services.questionanswer.levels.AlgorithmLevelImpl;

import java.util.Arrays;
import java.util.List;

public class DoubleCharAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        return input.replaceAll(".", "$0$0");
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "  return input.replace(/./g, '$&$&');\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "Given a string, you have to return a string in which each character (case-sensitive) is repeated once.",
                "Write a javascript method.",
                "Example:\n" +
                "String=>SSttrriinngg\n" +
                "Hello World=>HHeelllloo  WWoorrlldd\n" +
                "1234!_ =>11223344!!__  ",
                "Use regular expressions to solve this problem."
        );
    }

    @Override
    public List<String> getQuestions() {
        return List.of("String",
                "Hello World",
                "1234!_ ",
                "____ _ _ __ ___ _ ____ ",
                "(-_-)",
                "123456",
                "Scrub Lords",
                "bruh",
                "illuminati",
                "Adidas",
                "!#%G#DGY^RC",
                "Donald Duck",
                "Kanye 2020",
                "Bernie Sanders is Bae",
                "Peanut Butter",
                "1337",
                "h*o@D7an& a",
                "Y!S47Y @",
                ".-&dFI8",
                "!Zq+",
                "g%;U*!a/[pZ4V3/&",
                "7f5nF=:b8eo&+7",
                "*2SNm#Lo&Y",
                "3ZVm",
                "]C06*Ec$62o!7][/9",
                "^q%]VoKhh9j5-",
                "$2EZGQ",
                "`U9@h",
                "k^F [",
                "@Y(-SAZa<S2OS**i",
                "h*?RW_i+<",
                "FACBT+3YC9m3+a0Q",
                "KS):jY?+S9",
                "JBWh",
                "ONm3l))H@Gf(",
                "fk6Kg 7&",
                "*A&2SJUb#(Vc(OjC`W1",
                "`S9ONu001E83+!",
                "(YQ^/2]7c$8L*,]:+",
                "7Pla G3*C[=%`d=l$",
                "12mq,<[:FdF&^2P",
                "l#NRT7nn+p&",
                "9.d(Q;D(L.*",
                "nq0CMEg`)?nJ$M$GG;,;>"
        );
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
