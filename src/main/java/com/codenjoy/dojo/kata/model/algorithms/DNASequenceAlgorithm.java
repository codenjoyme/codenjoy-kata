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
import java.util.stream.Collectors;

public class DNASequenceAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        return input.toUpperCase().chars()
                .mapToObj(c -> {
                    switch (c) {
                        case 'T':
                            return "A";
                        case 'A':
                            return "T";
                        case 'C':
                            return "G";
                        case 'G':
                            return "C";
                        default:
                            return Character.toString(c);
                    }
                })
                .collect(Collectors.joining());
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "    return Array.from(input.toUpperCase()).map(c => {\n" +
                "        switch (c) {\n" +
                "            case 'T':\n" +
                "                return 'A';\n" +
                "            case 'A':\n" +
                "                return 'T';\n" +
                "            case 'C':\n" +
                "                return 'G';\n" +
                "            case 'G':\n" +
                "                return 'C';\n" +
                "            default:\n" +
                "                return c;\n" +
                "        }\n" +
                "    }).join('');\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList("The structure of the DNA double helix (type B-DNA).\n" +
                "If you want to know more: http://en.wikipedia.org/wiki/DNA\n" +
                "\n" +
                "In DNA strings, symbols 'A' and 'T' are complements of each other, as 'C' and 'G'. \n" +
                "Your function receives one side of the DNA (string). \n" +
                "You need to return the other complementary side. \n" +
                "DNA strand is never empty or there is no DNA at all (again, except for Haskell).\n" +
                "Example: TTTT=>AAAA, TAACG=>ATTGC etc.");
    }

    @Override
    public List<String> getQuestions() {
        return List.of("TTTT",
                "AAAA",
                "TAACG",
                "ATTGC",
                "CATA",
                "GTAT",
                "TAGCCTAGCT",
                "GATCGATCGA",
                "CTAGCTAGCTAGCTAGCT",
                "ACGTAGCTAGCTAGCTA",
                "CTAGCTAGCTAGCTAGCTAGCTAGCT",
                "GCTAGCTAGCTAGCTAGCTAGCTAGC",
                "CTAGCTAGCTAGCTAGCTAGCTAGCTAGC",
                "AGCTAGCTAGCTAGCTAGCTAGCTAGCTA",
                "GCTAGCTAGCTAGCTAGCTAGCTAGCTAGC",
                "CTAGCTAGCTAGCTAGCTAGCTAGCTAGCT",
                "ATCGATCGATCGATCGATC",
                "CATCGATCGATCGATCGA",
                "GATCGATCGATCGATCGATCGAT",
                "TCGATCGATCGATCGATCGA",
                "GATCGATCGATCGATCGATCGATC",
                "CTAGCTAGCTAGCTAGCTAG",
                "ACGTACGTACGTACGTAC",
                "CACGACGACGACGACGA",
                "GTCAGTCAGTCAGTCA",
                "CTAGCTAGCTAGCTAGC",
                "GTATCGATCGATCGATCGATTATATTTTCGACGAGATTTAAATATATATATATACGAGAGAATACAGATAGACAGATTA"

        );
    }

    @Override
    public int complexity() {
        // todo review
        return 12;
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
