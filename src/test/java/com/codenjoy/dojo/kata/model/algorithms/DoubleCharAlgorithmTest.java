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

public class DoubleCharAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new DoubleCharAlgorithm();
    }

    @Override
    public String answers() {
        return "String=>SSttrriinngg\n" +
                "Hello World=>HHeelllloo  WWoorrlldd\n" +
                "1234!_ =>11223344!!__  \n" +
                "____ _ _ __ ___ _ ____ =>________  __  __  ____  ______  __  ________  \n" +
                "(-_-)=>((--__--))\n" +
                "123456=>112233445566\n" +
                "Scrub Lords=>SSccrruubb  LLoorrddss\n" +
                "bruh=>bbrruuhh\n" +
                "illuminati=>iilllluummiinnaattii\n" +
                "Adidas=>AAddiiddaass\n" +
                "!#%G#DGY^RC=>!!##%%GG##DDGGYY^^RRCC\n" +
                "Donald Duck=>DDoonnaalldd  DDuucckk\n" +
                "Kanye 2020=>KKaannyyee  22002200\n" +
                "Bernie Sanders is Bae=>BBeerrnniiee  SSaannddeerrss  iiss  BBaaee\n" +
                "Peanut Butter=>PPeeaannuutt  BBuutttteerr\n" +
                "1337=>11333377\n" +
                "h*o@D7an& a=>hh**oo@@DD77aann&&  aa\n" +
                "Y!S47Y @=>YY!!SS4477YY  @@\n" +
                ".-&dFI8=>..--&&ddFFII88\n" +
                "!Zq+=>!!ZZqq++\n" +
                "g%;U*!a'/[pZ4V3/&=>gg%%;;UU**!!aa''//[[ppZZ44VV33//&&\n" +
                "7f5nF=:b8eo&+7=>77ff55nnFF==::bb88eeoo&&++77\n" +
                "*2SNm#Lo&Y=>**22SSNNmm##LLoo&&YY\n" +
                "3ZVm=>33ZZVVmm\n" +
                "]C06*Ec$62o!7][/9=>]]CC0066**EEcc$$6622oo!!77]][[//99\n" +
                "^'q%]VoKhh9j5-=>^^''qq%%]]VVooKKhhhh99jj55--\n" +
                "$2EZGQ=>$$22EEZZGGQQ\n" +
                "`U9@h=>``UU99@@hh\n" +
                "k^F [=>kk^^FF  [[\n" +
                "@Y(-SAZa<S2OS**i=>@@YY((--SSAAZZaa<<SS22OOSS****ii\n" +
                "h*?RW_i+<=>hh**??RRWW__ii++<<\n" +
                "FACBT+3YC9m3'+a0Q=>FFAACCBBTT++33YYCC99mm33''++aa00QQ\n" +
                "KS):jY?+S9=>KKSS))::jjYY??++SS99\n" +
                "JBWh=>JJBBWWhh\n" +
                "ONm3l))H@Gf(=>OONNmm33ll))))HH@@GGff((\n" +
                "fk6Kg 7&=>ffkk66KKgg  77&&\n" +
                "*A&2SJUb#(Vc(OjC`W1=>**AA&&22SSJJUUbb##((VVcc((OOjjCC``WW11\n" +
                "`S9ONu001E83+!=>``SS99OONNuu000011EE8833++!!\n" +
                "('YQ^/2]7c$8L*,]:+=>((''YYQQ^^//22]]77cc$$88LL**,,]]::++\n" +
                "7Pla G3*C[=%`d=l$=>77PPllaa  GG33**CC[[==%%``dd==ll$$\n" +
                "12mq,<[:FdF&^2P=>1122mmqq,,<<[[::FFddFF&&^^22PP\n" +
                "l#NRT7nn+p&=>ll##NNRRTT77nnnn++pp&&\n" +
                "9.d(Q;D(L.*=>99..dd((QQ;;DD((LL..**\n" +
                "nq0CMEg`)?nJ$M$GG;,;>=>nnqq00CCMMEEgg``))??nnJJ$$MM$$GGGG;;,,;;>>";
    }
}