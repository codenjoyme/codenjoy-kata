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

public class ExesAndOhsAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new ExesAndOhsAlgorithm();
    }

    @Override
    public String answers() {
        return "ooxx=>true\n" +
                "xooxx=>false\n" +
                "ooxXm=>true\n" +
                "zpzpzpp=>true\n" +
                "zzoo=>false\n" +
                "xxxooo=>true\n" +
                "xxxXooOo=>true\n" +
                "xxx23424esdsfvxXXOOooo=>false\n" +
                "xXxxoewrcoOoo=>false\n" +
                "XxxxooO=>false\n" +
                "zssddd=>true\n" +
                "Xxxxertr34=>false\n" +
                "xXoXOFo=>true\n" +
                "ooXXoOO=>false\n" +
                "RXT0oo=>false\n" +
                "XXOAB0oxXx=>false\n" +
                "JxXAO=>false\n" +
                "PXXWXoO=>false\n" +
                "XO7XxX=>false\n" +
                "FGoXBOFO=>false\n" +
                "oO=>false\n" +
                "XCOXXXO=>false\n" +
                "WXXxXOXXT=>false\n" +
                "RXXoX=>false\n" +
                "oXOoxXW=>true\n" +
                "x=>false\n" +
                "Z7pfb0k598EWG2mK5FaJFQSVJWeROCs9X1qSJO6Kdb72=>false\n" +
                "5CAr7zsRke6Lb0Bi=>true\n" +
                "XsYSeqWBD1=>false\n" +
                "Dd6MxC0RceIFemDrmxbL7JegLx81pqszX5EQG04eA9yYhZnX=>false\n" +
                "tqM31hdjxhaPYLdght9ZZfWt0Tvy=>false\n" +
                "EMfqgqHIJAvjjdKhqS8uoa=>false\n" +
                "xQRJIiTxtmSEQX60PJvcVXA4X2YviIrMpCSb3BwAHB=>false\n" +
                "rYAducZzKNaZkfp3QNkTA7kaHdxu9KfFApJF=>false\n" +
                "i0XLMlDgITKfdEy=>false\n" +
                "pHMVG2TrpYC1VtmUgIV6V6Briic2q2bfvrKIvZmw=>true\n" +
                "cv6AvJpr1oTuEOJ5ox0jOb0dRQ4ClXk7asSX8QEPXn95nIm=>true\n" +
                "VZkOMeV8mcoie1vUroksxHKLfIxmj7mwZ=>false\n" +
                "TuxJpaU4eCvW7NOHWFPAhzvgLaZiSB5X555=>false\n" +
                "LRHO7zulFWjahyQReCgZSUH6ybvokO2tdBltzwWBVBC29=>false\n" +
                "a0sgCHriukJ5lv2TlEQeZWS0GsNkzcKTMBz7Leo1VQ9o=>false"
                ;
    }
}