package com.codenjoy.dojo.kata;

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


import com.codenjoy.dojo.client.QuestionsJsonParser;
import com.codenjoy.dojo.client.Utils;
import com.codenjoy.dojo.games.kata.Board;
import com.codenjoy.dojo.kata.services.GameRunner;
import com.codenjoy.dojo.kata.services.GameSettings;
import com.codenjoy.dojo.kata.services.ai.AISolver;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.printer.PrinterFactory;
import com.codenjoy.dojo.utils.Smoke;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.codenjoy.dojo.kata.services.GameSettings.Keys.SHOW_EXPECTED_ANSWER;
import static com.codenjoy.dojo.kata.services.GameSettings.Keys.SHOW_VALID_IN_HISTORY;
import static java.util.stream.Collectors.toList;

public class SmokeTest {

    private Smoke smoke;
    private Dice dice;

    @Before
    public void setup() {
        smoke = new Smoke();
        dice = smoke.dice();
    }

    @Test
    public void testPrintForClient() {
        // about 5.0 sec
        int ticks = 1000;

        smoke.settings().removeWhenWin(true);
        smoke.settings().removeWhenGameOver(true);
        smoke.settings().reloadPlayersWhenGameOverAll(true);
        smoke.settings().increaseLevelAfterReload(true);

        smoke.play(ticks, "SmokeTest_forClient.data",
                new GameRunner() {
                    @Override
                    public Dice getDice() {
                        return dice;
                    }

                    @Override
                    public GameSettings getSettings() {
                        return new TestGameSettings()
                                .bool(SHOW_EXPECTED_ANSWER, true)
                                .bool(SHOW_VALID_IN_HISTORY, true);
                    }
                },
                Arrays.asList(new AISolver(dice)),
                Arrays.asList(new Board()));
    }

    @Test
    public void testPrintForScreen() {
        // about 5.0 sec
        int ticks = 1000;

        smoke.settings().removeWhenWin(true);
        smoke.settings().removeWhenGameOver(true);
        smoke.settings().reloadPlayersWhenGameOverAll(true);
        smoke.settings().increaseLevelAfterReload(true);

        smoke.play(ticks, "SmokeTest_forScreen.data",
                new GameRunner() {
                    @Override
                    public Dice getDice() {
                        return dice;
                    }

                    @Override
                    public GameSettings getSettings() {
                        return new TestGameSettings()
                                .bool(SHOW_EXPECTED_ANSWER, true)
                                .bool(SHOW_VALID_IN_HISTORY, true);
                    }

                    @Override
                    public PrinterFactory getPrinterFactory() {
                        return (reader, player)
                                -> parameters
                                -> super.getPrinterFactory()
                                    .getPrinter(reader, player)
                                    .print(true); // print only for screen
                    }
                },
                Arrays.asList(new AISolver(dice){{
                    parser = new QuestionsJsonParser() {
                        @Override
                        public int level(JSONObject data) {
                            return data.getInt("level");
                        }

                        @Override
                        public List<String> questions(JSONObject data) {
                            List<String> info = Utils.getStrings(data.getJSONArray("info"));
                            info = info.stream()
                                    .map(it -> it.substring(it.indexOf("f(") + 2, it.indexOf(") ")))
                                    .collect(toList());
                            return info;
                        }
                    };
                }}),
                Arrays.asList(new Board()));
    }
}
