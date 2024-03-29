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

public class LongDivisionAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new LongDivisionAlgorithm();
    }

    @Override
    public String answers() {
        return "1, 2=>0.5\n" +
                "1, 1=>1\n" +
                "5, 5=>1\n" +
                "55, 5=>11\n" +
                "55, 44=>1.25\n" +
                "0, 56=>0\n" +
                "56, 1=>56\n" +
                "1, -2=>-0.5\n" +
                "-1, 2=>-0.5\n" +
                "-1, -2=>0.5\n" +
                "1, 1000=>0.001\n" +
                "56, 45=>1.2(4)\n" +
                "111, 110=>1.00(90)\n" +
                "111, 11=>10.0(90)\n" +
                "11111, 11=>1010.0(90)\n" +
                "-11, -222=>0.0(495)\n" +
                "111, -22=>-5.0(45)\n" +
                "1, 3000=>0.000(3)\n" +
                "87, 78=>1.1(153846)\n" +
                "45, 56=>0.803(571428)\n" +
                "212, 133=>1.(593984962406015037)\n" +
                "11111, 115=>96.6(1739130434782608695652)\n" +
                "123, 345=>0.3(5652173913043478260869)\n" +
                "66666666, 77727777=>0.8576942320118070532237143486041032667124906968586017840186012266888836921194851616559161340739231484\n" +
                "666666660, 77727777=>8.5769423201180705322371434860410326671249069685860178401860122668888369211948516165591613407392314847\n" +
                "666666660, 7772777=>85.7694309253951322673994120762759564567464112247141529983428059238030371899258141588263756955847311713\n" +
                "100, 97=>1.0(309278350515463917525773195876288659793814432989690721649484536082474226804123711340206185567010)\n" +
                "999, 0=>Div by zero error!";
    }

    @Override
    public String cornerCases() {
        return "FILE:LongDivisionAlgorithmTest.cornerCases.txt";
    }
}
