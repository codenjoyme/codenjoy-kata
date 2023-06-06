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

public class RemoveVowelsAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new RemoveVowelsAlgorithm();
    }

    @Override
    public String answers() {
        return "Hello World!!=>Hll Wrld!!\n" +
                "The quick brown fox jumps over the lazy dog.=>Th qck brwn fx jmps vr th lzy dg.\n" +
                "To be or not to be, that is the question.=>T b r nt t b, tht s th qstn.\n" +
                "The world is a book, and those who do not travel read only a page.=>Th wrld s  bk, nd ths wh d nt trvl rd nly  pg.\n" +
                "The five boxing wizards jump quickly.=>Th fv bxng wzrds jmp qckly.\n" +
                "Why did the tomato turn red? Because it saw the salad dressing!=>Why dd th tmt trn rd? Bcs t sw th sld drssng!\n" +
                "She sells seashells by the seashore.=>Sh slls sshlls by th sshr.\n" +
                "How much wood would a woodchuck chuck if a woodchuck could chuck wood?=>Hw mch wd wld  wdchck chck f  wdchck cld chck wd?\n" +
                "All work and no play makes Jack a dull boy.=>ll wrk nd n ply mks Jck  dll by.\n" +
                "The cat in the hat had a bat and a hat.=>Th ct n th ht hd  bt nd  ht.\n" +
                "I before E except after C.=> bfr  xcpt ftr C.\n" +
                "The rain in Spain stays mainly in the plain.=>Th rn n Spn stys mnly n th pln.\n" +
                "Supercalifragilisticexpialidocious.=>Sprclfrglstcxpldcs."
                ;
    }
}