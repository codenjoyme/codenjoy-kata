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

public class ExesAndOhsAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        String lowerCaseInput = input.toLowerCase();
        return Boolean.toString(
                lowerCaseInput.replaceAll("[^o]", "").length()
                        ==
                        lowerCaseInput.replaceAll("[^x]", "").length()
        );
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "    const lowerCaseInput = input.toLowerCase();\n" +
                "    return (\n" +
                "        String(lowerCaseInput.replaceAll(\"[^o]\", \"\").length) ===\n" +
                "        String(lowerCaseInput.replaceAll(\"[^x]\", \"\").length)\n" +
                "    );\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "Check to see if a string has the same amount of 'x's and 'o's.\n" +
                        "The method must return a boolean and be case insensitive. The string can contain any char.\n" +
                        "Examples input/output:\n" +
                        "ooxx=>true\n" +
                        "xooxx=>false\n" +
                        "ooxXm=>true\n" +
                        "zpzpzpp=>true // when no 'x' and 'o' is present should return true\n" +
                        "zzoo=>false",
                        
                        "Rewrite this function in JavaScript.",
                        
                        "Use a regexp for this task.",
                        
                        "Rewrite this function using let keyword.",
                        
                        "Store input string in the separate variable.",
                        
                        "Remove comments.",
                        
                        "Remove everything from the script except for the function.");
    }

    @Override
    public List<String> getQuestions() {
        return List.of("ooxx",
                "xooxx",
                "ooxXm",
                "zpzpzpp",
                "zzoo",
                "xxxooo",
                "xxxXooOo",
                "xxx23424esdsfvxXXOOooo",
                "xXxxoewrcoOoo",
                "XxxxooO",
                "zssddd",
                "Xxxxertr34",
                "xXoXOFo",
                "ooXXoOO",
                "RXT0oo",
                "XXOAB0oxXx",
                "JxXAO",
                "PXXWXoO",
                "XO7XxX",
                "FGoXBOFO",
                "oO",
                "XCOXXXO",
                "WXXxXOXXT",
                "RXXoX",
                "oXOoxXW",
                "x",
                "Z7pfb0k598EWG2mK5FaJFQSVJWeROCs9X1qSJO6Kdb72",
                "5CAr7zsRke6Lb0Bi",
                "XsYSeqWBD1",
                "Dd6MxC0RceIFemDrmxbL7JegLx81pqszX5EQG04eA9yYhZnX",
                "tqM31hdjxhaPYLdght9ZZfWt0Tvy",
                "EMfqgqHIJAvjjdKhqS8uoa",
                "xQRJIiTxtmSEQX60PJvcVXA4X2YviIrMpCSb3BwAHB",
                "rYAducZzKNaZkfp3QNkTA7kaHdxu9KfFApJF",
                "i0XLMlDgITKfdEy",
                "pHMVG2TrpYC1VtmUgIV6V6Briic2q2bfvrKIvZmw",
                "cv6AvJpr1oTuEOJ5ox0jOb0dRQ4ClXk7asSX8QEPXn95nIm",
                "VZkOMeV8mcoie1vUroksxHKLfIxmj7mwZ",
                "TuxJpaU4eCvW7NOHWFPAhzvgLaZiSB5X555",
                "LRHO7zulFWjahyQReCgZSUH6ybvokO2tdBltzwWBVBC29",
                "a0sgCHriukJ5lv2TlEQeZWS0GsNkzcKTMBz7Leo1VQ9o"
        );
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
