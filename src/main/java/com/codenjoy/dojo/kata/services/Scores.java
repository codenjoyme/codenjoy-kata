package com.codenjoy.dojo.kata.services;

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

import com.codenjoy.dojo.services.event.ScoresMap;
import com.codenjoy.dojo.services.questionanswer.event.NextAlgorithmEvent;
import com.codenjoy.dojo.services.questionanswer.event.PassTestEvent;
import com.codenjoy.dojo.services.settings.SettingsReader;

import static com.codenjoy.dojo.kata.services.GameSettings.Keys.*;

public class Scores extends ScoresMap<Object> {

    public Scores(SettingsReader settings) {
        super(settings);

        putAs(PassTestEvent.class,
                event -> passTestScore(
                        event.complexity(),
                        event.testCount(),
                        settings.integer(A_CONSTANT),
                        settings.integer(D_CONSTANT)));

        putAs(NextAlgorithmEvent.class,
                event -> nextAlgorithmScore(
                        event.complexity(),
                        event.time(),
                        settings.integer(A_CONSTANT),
                        settings.integer(B_CONSTANT),
                        settings.integer(C_CONSTANT)));
    }

    public static int nextAlgorithmScore(double complexity, double time, double a, double b, double c) {
        c = c / 100D;
        if (time > b * complexity) {
            time = b * complexity;
        }
        return (int) (a * (((c - 1) * time + (b - c) * complexity) / (b - 1)));
    }

    public static int passTestScore(double complexity, double testCount, double a, double d) {
        double perTest = complexity * a * d / (100 * testCount);
        if (perTest < 1) {
            return 1;
        }
        return (int)(perTest);
    }
}