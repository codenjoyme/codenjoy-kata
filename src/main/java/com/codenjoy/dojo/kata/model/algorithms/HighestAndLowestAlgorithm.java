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
import java.util.IntSummaryStatistics;
import java.util.List;

public class HighestAndLowestAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        IntSummaryStatistics result = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .summaryStatistics();

        return String.format("%s %s",
                result.getMax(), result.getMin());
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "  const result = input\n" +
                "    .split(\" \")\n" +
                "    .map(Number)\n" +
                "    .reduce(\n" +
                "      (stats, num) => {\n" +
                "        stats.max = Math.max(stats.max, num);\n" +
                "        stats.min = Math.min(stats.min, num);\n" +
                "        return stats;\n" +
                "      },\n" +
                "      { max: -Infinity, min: Infinity }\n" +
                "    );\n" +
                "\n" +
                "  return `${result.max} ${result.min}`;";
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.\n" +
                        "All numbers are valid Int32, no need to validate them.\n" +
                        "There will always be at least one number in the input string.\n" +
                        "Output string must be two numbers separated by a single space, and highest number is first." +
                        "Example: 1 2 3 4 5=>5 1\n" +
                        "1 2 -3 4 5=>5 -3\n" +
                        "1 9 3 4 -5=>9 -5");
    }

    @Override
    public List<String> getQuestions() {
        return List.of("1 2 3 4 5",
                "1 2 -3 4 5",
                "1 9 3 4 -5",
                "8 3 -5 42 -1 0 0 -9 4 7 4 -4",
                "1 2 3",
                "1",
                "-1",
                "-1 -1 0",
                "1 1 0",
                "-1 -1",
                "1 -1 0",
                "10 2 -1 -20",
                "452 561 -686 679 476 -515 805 -739 571 791",
                "-983 -111 -332 -973 47 728",
                "268 -359 -513 -9 -86 -142 -779",
                "556 32 866 -730 -367 -937 367 888 43 -510 773",
                "646 261 609 -82 949 526 -449 -594 894",
                "-950 909 424 834 -579 -275 -901 444",
                "-857 43 444 158 510 -879 -350 705",
                "-961 908 -769 980 407 -651 550 671 -996 215",
                "483 -83 -229 -373 -812 335 -802",
                "-968 -692 -566 -31 333 831 81 -476 828 -232",
                "4 5 29 54 4 0 -214 542 -64 1 -3 6 -6"
        );
    }

    @Override
    public int complexity() {
        return 12;
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
