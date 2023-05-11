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

public class DNASequenceAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new DNASequenceAlgorithm();
    }

    @Override
    public String answers() {
        return "TTTT=>AAAA\n" +
                "AAAA=>TTTT\n" +
                "TAACG=>ATTGC\n" +
                "ATTGC=>TAACG\n" +
                "CATA=>GTAT\n" +
                "GTAT=>CATA\n" +
                "TAGCCTAGCT=>ATCGGATCGA\n" +
                "GATCGATCGA=>CTAGCTAGCT\n" +
                "CTAGCTAGCTAGCTAGCT=>GATCGATCGATCGATCGA\n" +
                "ACGTAGCTAGCTAGCTA=>TGCATCGATCGATCGAT\n" +
                "CTAGCTAGCTAGCTAGCTAGCTAGCT=>GATCGATCGATCGATCGATCGATCGA\n" +
                "GCTAGCTAGCTAGCTAGCTAGCTAGC=>CGATCGATCGATCGATCGATCGATCG\n" +
                "CTAGCTAGCTAGCTAGCTAGCTAGCTAGC=>GATCGATCGATCGATCGATCGATCGATCG\n" +
                "AGCTAGCTAGCTAGCTAGCTAGCTAGCTA=>TCGATCGATCGATCGATCGATCGATCGAT\n" +
                "GCTAGCTAGCTAGCTAGCTAGCTAGCTAGC=>CGATCGATCGATCGATCGATCGATCGATCG\n" +
                "CTAGCTAGCTAGCTAGCTAGCTAGCTAGCT=>GATCGATCGATCGATCGATCGATCGATCGA\n" +
                "ATCGATCGATCGATCGATC=>TAGCTAGCTAGCTAGCTAG\n" +
                "CATCGATCGATCGATCGA=>GTAGCTAGCTAGCTAGCT\n" +
                "GATCGATCGATCGATCGATCGAT=>CTAGCTAGCTAGCTAGCTAGCTA\n" +
                "TCGATCGATCGATCGATCGA=>AGCTAGCTAGCTAGCTAGCT\n" +
                "GATCGATCGATCGATCGATCGATC=>CTAGCTAGCTAGCTAGCTAGCTAG\n" +
                "CTAGCTAGCTAGCTAGCTAG=>GATCGATCGATCGATCGATC\n" +
                "ACGTACGTACGTACGTAC=>TGCATGCATGCATGCATG\n" +
                "CACGACGACGACGACGA=>GTGCTGCTGCTGCTGCT\n" +
                "GTCAGTCAGTCAGTCA=>CAGTCAGTCAGTCAGT\n" +
                "CTAGCTAGCTAGCTAGC=>GATCGATCGATCGATCG\n" +
                "GTATCGATCGATCGATCGATTATATTTTCGACGAGATTTAAATATATATATATACGAGAGAATACAGATAGACAGATTA=>CATAGCTAGCTAGCTAGCTAATATAAAAGCTGCTCTAAATTTATATATATATATGCTCTCTTATGTCTATCTGTCTAAT"
                ;
    }

}