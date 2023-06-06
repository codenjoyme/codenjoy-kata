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

public class NameIntoInitialsAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new NameIntoInitialsAlgorithm();
    }

    @Override
    public String answers() {
        return "Tom Harris=>T.H\n" +
                "garlick looney=>G.L\n" +
                "Ethan parker=>E.P\n" +
                "olivia Campbell=>O.C\n" +
                "Liam Jenkins=>L.J\n" +
                "Emma Bryant=>E.B\n" +
                "Noah Reed=>N.R\n" +
                "Ava Coleman=>A.C\n" +
                "William Barnes=>W.B\n" +
                "Sophia Mitchell=>S.M\n" +
                "James Hughes=>J.H\n" +
                "Isabella Foster=>I.F\n" +
                "Benjamin Evans=>B.E\n" +
                "Mia Murphy=>M.M\n" +
                "Mason Richardson=>M.R\n" +
                "Charlotte Peterson=>C.P\n" +
                "Elijah Cooper=>E.C\n" +
                "Amelia Cox=>A.C\n" +
                "Alexander Griffin=>A.G\n" +
                "Harper Brooks=>H.B\n" +
                "Daniel Turner=>D.T\n" +
                "Abigail Kelly=>A.K\n" +
                "Henry Price=>H.P\n" +
                "Emily Ross=>E.R\n" +
                "Samuel Ward=>S.W\n" +
                "Elizabeth Morgan=>E.M\n" +
                "Joseph Watson=>J.W\n" +
                "Ella Bennett=>E.B\n" +
                "David Bailey=>D.B\n" +
                "Avery Howard=>A.H\n" +
                "Michael Nelson=>M.N\n" +
                "Lily Anderson=>L.A";
    }
}