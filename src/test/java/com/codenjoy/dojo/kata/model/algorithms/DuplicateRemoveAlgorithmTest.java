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

public class DuplicateRemoveAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new DuplicateRemoveAlgorithm();
    }

    @Override
    public String answers() {
        return "a=>a\n" +
                "abc=>abc\n" +
                "abcba=>abcba\n" +
                "aa=>\n" +
                "aaaa=>\n" +
                "aaabaa=>b\n" +
                "aabaaa=>b\n" +
                "abaa=>ab\n" +
                "abba=>\n" +
                "abbaaa=>\n" +
                "abcdeedcba=>\n" +
                "bcdeeedcbabcde=>abcde\n" +
                "fffkkhhffzzhhkkkzzrrrrryyy=>\n" +
                "beellllgrhhoyy=>bgro\n" +
                "abbcccbad=>abad\n" +
                "abccbbad=>d\n" +
                "abcdeffedcbar=>r\n" +
                "abcdeffedcba=>\n" +
                "abcdefaaabbbvvvfedcba=>\n" +
                "ddllppppccffmmkkkkjjggggffvvvuaaoooxtttnyyrffbbbbiqqdddd=>uxnri\n" +
                "tnnnnnnnddddccccccckcmkkvvvbbbqqqqddannnnmbbbbsssww=>tkcmam\n" +
                "paoooovvviiggggyyyynnnnhhhrjxbbbbbbfjjjjyaaaddqqbbbccueebbbbbbgwoii=>parjxfyugwo\n" +
                "ssssiiiijjjwrbbbvvvlllkkkkesssddcnoarrrbbooyyyydssszzzeeewwy=>wrecnoady\n" +
                "aahhhhvvvviiiiaaabbbbmmmwwwwwzzkkkkyyhhzzzzkkkkcee=>c";
    }
}