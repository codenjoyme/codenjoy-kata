package com.codenjoy.dojo.kata.model;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2012 - 2022 Codenjoy
 * %%
 * This program is free software:you can redistribute it and/or modify
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


import com.codenjoy.dojo.kata.TestGameSettings;
import com.codenjoy.dojo.kata.services.GameRunner;
import com.codenjoy.dojo.kata.services.GameSettings;
import com.codenjoy.dojo.services.EventListener;
import com.codenjoy.dojo.services.Game;
import com.codenjoy.dojo.services.dice.MockDice;
import com.codenjoy.dojo.services.multiplayer.Single;
import com.codenjoy.dojo.services.printer.PrinterFactory;
import com.codenjoy.dojo.services.questionanswer.event.FailTestEvent;
import com.codenjoy.dojo.services.questionanswer.event.NextAlgorithmEvent;
import com.codenjoy.dojo.services.questionanswer.event.PassTestEvent;
import com.codenjoy.dojo.services.questionanswer.levels.Level;
import com.codenjoy.dojo.utils.JsonUtils;
import com.codenjoy.dojo.utils.smart.SmartAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static com.codenjoy.dojo.client.Command.START_NEXT_LEVEL;
import static com.codenjoy.dojo.kata.services.GameSettings.Keys.*;
import static com.codenjoy.dojo.utils.smart.SmartAssert.assertEquals;
import static org.mockito.Mockito.*;

// TODO А точно Kata это мультиплеерная игра?
public class MultiplayerTest {

    private EventListener listener1;
    private EventListener listener2;
    private EventListener listener3;
    private Game game1;
    private Game game2;
    private Game game3;
    private MockDice dice;
    private Kata field;
    private TestGameSettings settings;
    private boolean screenOrClient;

    // появляется другие игроки, игра становится мультипользовательской
    @Before
    public void setup() {
        Level level = new SimpleQATestLevel(
                "question1=answer1",
                "question2=answer2",
                "question3=answer3");

        printForClient();
        dice = new MockDice();
        settings = new TestGameSettings(){
            @Override
            public List<Level> levels() {
                return Arrays.asList(level);
            }
        };
        field = new Kata(dice, 0, settings);
        GameRunner gameRunner = new GameRunner(){
            @Override
            public GameSettings getSettings() {
                return settings;
            }
        };
        PrinterFactory factory = gameRunner.getPrinterFactory();

        listener1 = mock(EventListener.class);
        Player player1 = new Player(listener1, settings);
        game1 = new Single(player1, factory);
        game1.on(field);

        listener2 = mock(EventListener.class);
        Player player2 = new Player(listener2, settings);
        game2 = new Single(player2, factory);
        game2.on(field);

        listener3 = mock(EventListener.class);
        Player player3 = new Player(listener3, settings);
        game3 = new Single(player3, factory);
        game3.on(field);

        dice(1, 4);
        game1.newGame();

        dice(2, 2);
        game2.newGame();

        dice(3, 4);
        game3.newGame();
    }

    @After
    public void after() {
        SmartAssert.checkResult();
    }

    private void dice(Integer... next) {
        dice.then(next);
    }

    private void asrtFl1(String expected) {
        assertField(expected, game1);
    }

    private void assertField(String expected, Game game1) {
        assertEquals(expected, JsonUtils.prettyPrint(game1.getBoardAsString(screenOrClient).toString()).replace('\"', '\'').replaceAll("\\r", ""));
    }

    private void asrtFl2(String expected) {
        assertField(expected, game2);
    }

    private void asrtFl3(String expected) {
        assertField(expected, game3);
    }

    @Test
    public void shouldPrint_whenInitialStep_forClient() {
        // when then
        asrtFl1("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl2("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl3("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");
    }

    @Test
    public void shouldPrint_whenInitialStep_forScreen() {
        // given
        printForScreen();

        // when then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");
    }

    private void printForScreen() {
        screenOrClient = true;
    }

    private void printForClient() {
        screenOrClient = false;
    }

    @Test
    public void shouldPrint_whenDescriptionIsDisabled_forClient() {
        // given
        settings.bool(SHOW_DESCRIPTION, false)
                .bool(SHOW_EXPECTED_ANSWER, true);

        // when then
        asrtFl1("{\n" +
                "  'expectedAnswer':'answer1',\n" + // instead of description
                "  'history':[],\n" +
                "  'info':[\n" +
                "    '❌f(question1) = ??? != answer1'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl2("{\n" +
                "  'expectedAnswer':'answer1',\n" +
                "  'history':[],\n" +
                "  'info':[\n" +
                "    '❌f(question1) = ??? != answer1'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl3("{\n" +
                "  'expectedAnswer':'answer1',\n" +
                "  'history':[],\n" +
                "  'info':[\n" +
                "    '❌f(question1) = ??? != answer1'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");
    }

    @Test
    public void shouldPrint_whenDescriptionIsDisabled_forScreen() {
        // given
        printForScreen();

        settings.bool(SHOW_DESCRIPTION, false)
                .bool(SHOW_EXPECTED_ANSWER, true);

        // when then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) = ??? != answer1'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) = ??? != answer1'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) = ??? != answer1'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");
    }

    // Каждый игрок может управляться за тик игры независимо,
    // все их последние ходы применяются после тика любой борды
    @Test
    public void shouldJoystick_forClient() {
        // when
        game1.getJoystick().message("['wrong-message']");
        game1.getJoystick().message("['answer1']");

        game2.getJoystick().message("['answer2']");

        game3.getJoystick().message("['answer3']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':true\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question2',\n" +
                "  'questions':[\n" +
                "    'question1',\n" +
                "    'question2'\n" +
                "  ]\n" +
                "}");

        asrtFl2("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'answer2',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != answer2'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl3("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'answer3',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != answer3'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");
    }

    @Test
    public void shouldPrintHistory_withDescription_withExpectedAnswer_withValid_forScreen() {
        // given
        printForScreen();

        settings.bool(SHOW_DESCRIPTION, true)
                .bool(SHOW_EXPECTED_ANSWER, true)
                .bool(SHOW_VALID_IN_HISTORY, true);

        // when
        game1.getJoystick().message("['wrong-answer1']");
        game2.getJoystick().message("['answer1']");
        game3.getJoystick().message("['answer1']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) = wrong-answer1 != answer1'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) = ??? != answer2'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) = ??? != answer2'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['answer1']");
        game2.getJoystick().message("['answer1', 'wrong-answer2']");
        game3.getJoystick().message("['answer1', 'answer2']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) = ??? != answer2'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) = wrong-answer2 != answer2'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['answer1', 'answer2']");
        game2.getJoystick().message("['answer1', 'wrong-answer22']");
        game3.getJoystick().message("['answer1', 'answer2', 'wrong-answer3']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) = wrong-answer22 != answer2'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) = wrong-answer3 != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['wrong-answer1', 'answer2', 'answer3']");
        game2.getJoystick().message("['answer1', 'answer2']");
        game3.getJoystick().message("['answer1', 'answer2']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) = wrong-answer1 != answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '✅f(question3) = answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['wrong-answer1', 'wrong-answer2', 'wrong-answer3']");
        game2.getJoystick().message("['wrong-answer1', 'wrong-answer2']");
        game3.getJoystick().message("['wrong-answer1']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) = wrong-answer1 != answer1',\n" +
                "    '❌f(question2) = wrong-answer2 != answer2',\n" +
                "    '❌f(question3) = wrong-answer3 != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) = wrong-answer1 != answer1',\n" +
                "    '❌f(question2) = wrong-answer2 != answer2',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) = wrong-answer1 != answer1',\n" +
                "    '❌f(question2) = ??? != answer2',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['answer1', 'answer2', 'answer3']");
        game2.getJoystick().message("['answer1', 'answer2']");
        game3.getJoystick().message("['answer1']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '✅f(question3) = answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) = ??? != answer2',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");
    }

    @Test
    public void shouldPrintHistory_withDescription_withExpectedAnswer_withoutValid_forScreen() {
        // given
        printForScreen();

        settings.bool(SHOW_DESCRIPTION, true)
                .bool(SHOW_EXPECTED_ANSWER, true)
                .bool(SHOW_VALID_IN_HISTORY, false);

        // when
        game1.getJoystick().message("['wrong-answer1']");
        game2.getJoystick().message("['answer1']");
        game3.getJoystick().message("['answer1']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) = wrong-answer1 != answer1'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) = ??? != answer2'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) = ??? != answer2'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['answer1']");
        game2.getJoystick().message("['answer1', 'wrong-answer2']");
        game3.getJoystick().message("['answer1', 'answer2']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) = ??? != answer2'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) = wrong-answer2 != answer2'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['answer1', 'answer2']");
        game2.getJoystick().message("['answer1', 'wrong-answer22']");
        game3.getJoystick().message("['answer1', 'answer2', 'wrong-answer3']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) = wrong-answer22 != answer2'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) = wrong-answer3 != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['wrong-answer1', 'answer2', 'answer3']");
        game2.getJoystick().message("['answer1', 'answer2']");
        game3.getJoystick().message("['answer1', 'answer2']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) != wrong-answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '✅f(question3) = answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['wrong-answer1', 'wrong-answer2', 'wrong-answer3']");
        game2.getJoystick().message("['wrong-answer1', 'wrong-answer2']");
        game3.getJoystick().message("['wrong-answer1']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) != wrong-answer1',\n" +
                "    '❌f(question2) != wrong-answer2',\n" +
                "    '❌f(question3) = wrong-answer3 != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) != wrong-answer1',\n" +
                "    '❌f(question2) != wrong-answer2',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) != wrong-answer1',\n" +
                "    '❌f(question2) != ???',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['answer1', 'answer2', 'answer3']");
        game2.getJoystick().message("['answer1', 'answer2']");
        game3.getJoystick().message("['answer1']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '✅f(question3) = answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???',\n" +
                "    '❌f(question3) = ??? != answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");
    }

    @Test
    public void shouldPrintHistory_withDescription_withoutExpectedAnswer_withValid_forScreen() {
        // given
        printForScreen();

        settings.bool(SHOW_DESCRIPTION, true)
                .bool(SHOW_EXPECTED_ANSWER, false)
                .bool(SHOW_VALID_IN_HISTORY, true);

        // when
        game1.getJoystick().message("['wrong-answer1']");
        game2.getJoystick().message("['answer1']");
        game3.getJoystick().message("['answer1']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) != wrong-answer1'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['answer1']");
        game2.getJoystick().message("['answer1', 'wrong-answer2']");
        game3.getJoystick().message("['answer1', 'answer2']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != wrong-answer2'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['answer1', 'answer2']");
        game2.getJoystick().message("['answer1', 'wrong-answer22']");
        game3.getJoystick().message("['answer1', 'answer2', 'wrong-answer3']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != wrong-answer22'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) != wrong-answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['wrong-answer1', 'answer2', 'answer3']");
        game2.getJoystick().message("['answer1', 'answer2']");
        game3.getJoystick().message("['answer1', 'answer2']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) = wrong-answer1 != answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '✅f(question3) = answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['wrong-answer1', 'wrong-answer2', 'wrong-answer3']");
        game2.getJoystick().message("['wrong-answer1', 'wrong-answer2']");
        game3.getJoystick().message("['wrong-answer1']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) = wrong-answer1 != answer1',\n" +
                "    '❌f(question2) = wrong-answer2 != answer2',\n" +
                "    '❌f(question3) != wrong-answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) = wrong-answer1 != answer1',\n" +
                "    '❌f(question2) = wrong-answer2 != answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) = wrong-answer1 != answer1',\n" +
                "    '❌f(question2) = ??? != answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['answer1', 'answer2', 'answer3']");
        game2.getJoystick().message("['answer1', 'answer2']");
        game3.getJoystick().message("['answer1']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '✅f(question3) = answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) = ??? != answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");
    }

    @Test
    public void shouldPrintHistory_withDescription_withoutExpectedAnswer_withoutValid_forScreen() {
        // given
        printForScreen();

        settings.bool(SHOW_DESCRIPTION, true)
                .bool(SHOW_EXPECTED_ANSWER, false)
                .bool(SHOW_VALID_IN_HISTORY, false);

        // when
        game1.getJoystick().message("['wrong-answer1']");
        game2.getJoystick().message("['answer1']");
        game3.getJoystick().message("['answer1']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) != wrong-answer1'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['answer1']");
        game2.getJoystick().message("['answer1', 'wrong-answer2']");
        game3.getJoystick().message("['answer1', 'answer2']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != wrong-answer2'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['answer1', 'answer2']");
        game2.getJoystick().message("['answer1', 'wrong-answer22']");
        game3.getJoystick().message("['answer1', 'answer2', 'wrong-answer3']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != wrong-answer22'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) != wrong-answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['wrong-answer1', 'answer2', 'answer3']");
        game2.getJoystick().message("['answer1', 'answer2']");
        game3.getJoystick().message("['answer1', 'answer2']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) != wrong-answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '✅f(question3) = answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['wrong-answer1', 'wrong-answer2', 'wrong-answer3']");
        game2.getJoystick().message("['wrong-answer1', 'wrong-answer2']");
        game3.getJoystick().message("['wrong-answer1']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) != wrong-answer1',\n" +
                "    '❌f(question2) != wrong-answer2',\n" +
                "    '❌f(question3) != wrong-answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) != wrong-answer1',\n" +
                "    '❌f(question2) != wrong-answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '❌f(question1) != wrong-answer1',\n" +
                "    '❌f(question2) != ???',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        // when
        game1.getJoystick().message("['answer1', 'answer2', 'answer3']");
        game2.getJoystick().message("['answer1', 'answer2']");
        game3.getJoystick().message("['answer1']");

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '✅f(question3) = answer3'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl2("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");

        asrtFl3("{\n" +
                "  'history':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0\n" +
                "}");
    }

    // игроков можно удалять из игры
    @Test
    public void shouldRemove() {
        // when
        game3.close();

        field.tick();

        // then
        asrtFl1("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl2("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        try {
            asrtFl3("{\n" +
                    "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                    "  'history':[],\n" +
                    "  'level':0,\n" +
                    "  'nextQuestion':'question1',\n" +
                    "  'questions':[\n" +
                    "    'question1'\n" +
                    "  ]\n" +
                    "}");
        } catch (IllegalStateException e) {
            assertEquals("No board for this player", e.getMessage());
        }
    }

    // игрока можно ресетнуть
    @Test
    public void shouldKill() {
        // given
        game1.getJoystick().message("['answer1']");
        game2.getJoystick().message("['answer1']");
        game3.getJoystick().message("['answer1']");

        field.tick();

        asrtFl1("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':true\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question2',\n" +
                "  'questions':[\n" +
                "    'question1',\n" +
                "    'question2'\n" +
                "  ]\n" +
                "}");

        asrtFl2("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':true\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question2',\n" +
                "  'questions':[\n" +
                "    'question1',\n" +
                "    'question2'\n" +
                "  ]\n" +
                "}");

        asrtFl3("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':true\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question2',\n" +
                "  'questions':[\n" +
                "    'question1',\n" +
                "    'question2'\n" +
                "  ]\n" +
                "}");

        // when
        game1.newGame();
        field.tick();

        asrtFl1("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl2("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':true\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question2',\n" +
                "  'questions':[\n" +
                "    'question1',\n" +
                "    'question2'\n" +
                "  ]\n" +
                "}");

        asrtFl3("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':true\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question2',\n" +
                "  'questions':[\n" +
                "    'question1',\n" +
                "    'question2'\n" +
                "  ]\n" +
                "}");
    }

    // игрок может ответить правильно и неправильно
    @Test
    public void shouldEvents() {
        // when
        game1.getJoystick().message("['answer1']");
        game2.getJoystick().message("['wrong2']");
        game3.getJoystick().message("['wrong3']");

        field.tick();

        asrtFl1("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':true\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question2',\n" +
                "  'questions':[\n" +
                "    'question1',\n" +
                "    'question2'\n" +
                "  ]\n" +
                "}");

        asrtFl2("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong2',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong2'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl3("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong3',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong3'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        // then
        assertPassTestEvent(listener1, "PassTest{complexity=30, testCount=3}");
        assertFailTestEvent(listener2, "FailTest{complexity=30, testCount=3}");
        assertFailTestEvent(listener3, "FailTest{complexity=30, testCount=3}");

        // when
        field.tick();

        // then
        verifyNoMoreInteractions(listener1);
        verifyNoMoreInteractions(listener2);
        verifyNoMoreInteractions(listener3);
    }

    private void assertPassTestEvent(EventListener listener, String expected) {
        ArgumentCaptor<PassTestEvent> captor = ArgumentCaptor.forClass(PassTestEvent.class);
        verify(listener).event(captor.capture());
        PassTestEvent value = captor.getValue();
        assertEquals(expected, value.toString());
    }

    private void assertFailTestEvent(EventListener listener, String expected) {
        ArgumentCaptor<FailTestEvent> captor = ArgumentCaptor.forClass(FailTestEvent.class);
        verify(listener).event(captor.capture());
        PassTestEvent value = captor.getValue();
        assertEquals(expected, value.toString());
    }

    private void assertNextAlgorithmEvent(EventListener listener, String expected) {
        ArgumentCaptor<NextAlgorithmEvent> captor = ArgumentCaptor.forClass(NextAlgorithmEvent.class);
        verify(listener, times(4)).event(captor.capture());
        NextAlgorithmEvent value = captor.getValue();
        assertEquals(expected, value.toString());
    }

    @Test
    public void shouldGetHeroes() {
        assertEquals(
                Arrays.asList(
                    game1.getJoystick(),
                    game2.getJoystick(),
                    game3.getJoystick()),
                field.getHeroes());
    }

    private void givenUser1GoesToEnd() {
        // given
        game1.getJoystick().message("['answer1']");
        game2.getJoystick().message("['wrong']");
        game3.getJoystick().message("['wrong']");

        field.tick();

        asrtFl1("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':true\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question2',\n" +
                "  'questions':[\n" +
                "    'question1',\n" +
                "    'question2'\n" +
                "  ]\n" +
                "}");

        asrtFl2("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl3("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        // when
        game1.getJoystick().message("['answer1', 'answer2']");
        field.tick();

        // then
        asrtFl1("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':true\n" +
                "    },\n" +
                "    {\n" +
                "      'answer':'answer2',\n" +
                "      'question':'question2',\n" +
                "      'valid':true\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '❌f(question3) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question3',\n" +
                "  'questions':[\n" +
                "    'question1',\n" +
                "    'question2',\n" +
                "    'question3'\n" +
                "  ]\n" +
                "}");

        asrtFl2("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl3("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        // when
        game1.getJoystick().message("['answer1', 'answer2', 'answer3']");
        field.tick();

        // then
        // wait level
        asrtFl1("{\n" +
                "  'description':[\n" +
                "    'Wait for next level. Please send 'message('StartNextLevel')' command.'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':true\n" +
                "    },\n" +
                "    {\n" +
                "      'answer':'answer2',\n" +
                "      'question':'question2',\n" +
                "      'valid':true\n" +
                "    },\n" +
                "    {\n" +
                "      'answer':'answer3',\n" +
                "      'question':'question3',\n" +
                "      'valid':true\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '✅f(question2) = answer2',\n" +
                "    '✅f(question3) = answer3'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'questions':[]\n" +
                "}");

        asrtFl2("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl3("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");
        
        // when
        game1.getJoystick().message(START_NEXT_LEVEL);
        field.tick();

        // then
        // win level with clean history
        asrtFl1("{\n" +
                "  'description':[\n" +
                "    'No more Levels. You win!'\n" +
                "  ],\n" +
                "  'history':[],\n" +
                "  'info':[],\n" +
                "  'level':1,\n" +
                "  'questions':[]\n" +
                "}");

        asrtFl2("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl3("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        // when
        field.tick();

        // then 
        // still clear history
        asrtFl1("{\n" +
                "  'description':[\n" +
                "    'No more Levels. You win!'\n" +
                "  ],\n" +
                "  'history':[],\n" +
                "  'info':[],\n" +
                "  'level':1,\n" +
                "  'questions':[]\n" +
                "}");

        asrtFl2("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl3("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

    }

    // игрок дошел до конца и хистори не сохраняется больше
    @Test
    public void shouldNoHistory_whenEndGame() {
        givenUser1GoesToEnd();

        // when
        game1.getJoystick().message("['blablabla']");
        field.tick();

        // then
        asrtFl1("{\n" +
                "  'description':[\n" +
                "    'No more Levels. You win!'\n" +
                "  ],\n" +
                "  'history':[],\n" +
                "  'info':[],\n" +
                "  'level':1,\n" +
                "  'questions':[]\n" +
                "}");

        asrtFl2("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl3("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        // when
        game1.getJoystick().message("['qweasadzxc']");
        field.tick();

        // then
        asrtFl1("{\n" +
                "  'description':[\n" +
                "    'No more Levels. You win!'\n" +
                "  ],\n" +
                "  'history':[],\n" +
                "  'info':[],\n" +
                "  'level':1,\n" +
                "  'questions':[]\n" +
                "}");

        asrtFl2("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl3("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");
    }

    // игрок дошел до конца и там файрится определенный ивент
    @Test
    public void shouldEvent_whenUserGoesToEnd() {
        givenUser1GoesToEnd();

        // then
        assertNextAlgorithmEvent(listener1, "NextAlgorithm{complexity=30, time=0}");
    }

    @Test
    public void bug() {
        // given
        game1.getJoystick().message("['answer1']");
        game2.getJoystick().message("['wrong']");
        game3.getJoystick().message("['wrong']");

        // when
        field.tick();

        // then
        asrtFl1("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':true\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '✅f(question1) = answer1',\n" +
                "    '❌f(question2) != ???'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question2',\n" +
                "  'questions':[\n" +
                "    'question1',\n" +
                "    'question2'\n" +
                "  ]\n" +
                "}");

        asrtFl2("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");

        asrtFl3("{\n" +
                "  'description':[\n" +
                "    'description'\n" +
                "  ],\n" +
                "  'history':[\n" +
                "    {\n" +
                "      'answer':'wrong',\n" +
                "      'expected':'answer1',\n" +
                "      'question':'question1',\n" +
                "      'valid':false\n" +
                "    }\n" +
                "  ],\n" +
                "  'info':[\n" +
                "    '❌f(question1) != wrong'\n" +
                "  ],\n" +
                "  'level':0,\n" +
                "  'nextQuestion':'question1',\n" +
                "  'questions':[\n" +
                "    'question1'\n" +
                "  ]\n" +
                "}");
    }
}
