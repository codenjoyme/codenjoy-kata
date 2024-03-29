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
import com.codenjoy.dojo.kata.services.GameSettings;
import com.codenjoy.dojo.services.EventListener;
import com.codenjoy.dojo.services.dice.MockDice;
import com.codenjoy.dojo.services.questionanswer.levels.Level;
import com.codenjoy.dojo.services.questionanswer.levels.LevelsPool;
import com.codenjoy.dojo.services.questionanswer.levels.QuestionAnswerLevelImpl;
import com.codenjoy.dojo.utils.JsonUtils;
import com.codenjoy.dojo.utils.smart.SmartAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.codenjoy.dojo.client.Command.SKIP_THIS_LEVEL;
import static com.codenjoy.dojo.client.Command.START_NEXT_LEVEL;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class GameTest {

    private Kata game;
    private Hero hero;
    private MockDice dice;
    private EventListener listener;
    private Player player;
    private LevelsPool pool;
    private GameSettings settings;

    private List<Level> levels;
    private int levelIndex;

    @Before
    public void setup() {
        dice = new MockDice();
    }

    @Test
    public void after() {
        SmartAssert.checkResult();
    }

    private void dice(Integer... next) {
        dice.then(next);
    }

    private void givenQA(String... questionAnswers) {
        withLevels(qa(questionAnswers));
        givenGame();
    }

    private Level qa(String... questionAnswers) {
        return new QuestionAnswerLevelImpl(questionAnswers){
            @Override
            public int complexity() {
                return 0;
            }

            @Override
            public void setComplexity(int value) {
            }

            @Override
            public List<String> description() {
                return Arrays.asList("description");
            }
        };
    }

    private void givenGame() {
        listener = mock(EventListener.class);
        settings = new TestGameSettings(){
            @Override
            public List<Level> levels() {
                return levels;
            }
        };
        game = new Kata(dice, levelIndex, settings);
        player = new Player(listener, settings);
        game.newGame(player);
        hero = player.getHero();
        pool = player.levels();
    }

    private void thenHistory(String expected) {
        assertEquals(expected, JsonUtils.prettyPrint(player.examiner().getHistory()));
    }

    private void thenQuestions(String expected) {
        assertEquals(expected, JsonUtils.prettyPrint(player.levels().getQuestions()));
    }

    @Test
    public void shouldNoAnswersAtStart() {
        // given
        givenQA("question1=answer1",
                "question2=answer2",
                "question3=answer3");

        // then
        thenHistory("[]");

        thenQuestions("[\n" +
                "  'question1'\n" +
                "]");
    }

    @Test
    public void shouldNoAnswersAtStartAfterTick() {
        // given
        givenQA("question1=answer1",
                "question2=answer2",
                "question3=answer3");

        // when
        game.tick();

        // then
        thenHistory("[]");

        thenQuestions("[\n" +
                "  'question1'\n" +
                "]");
    }

    @Test
    public void should_invalid() {
        // given
        givenQA("question1=answer1",
                "question2=answer2",
                "question3=answer3");

        // when
        hero.message("['wrong-answer']");
        game.tick();

        // then
        thenHistory(
                "[\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'wrong-answer',\n" +
                "        'expected':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':false\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");

        thenQuestions("[\n" +
                "  'question1'\n" +
                "]");
    }

    @Test
    public void should_invalid_invalid() {
        // given
        givenQA("question1=answer1",
                "question2=answer2",
                "question3=answer3");

        // when
        hero.message("['wrong-answer1']");
        game.tick();

        hero.message("['wrong-answer2']");
        game.tick();

        // then
        thenHistory(
                "[\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'wrong-answer1',\n" +
                "        'expected':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':false\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'wrong-answer2',\n" +
                "        'expected':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':false\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");

        thenQuestions("[\n" +
                "  'question1'\n" +
                "]");
    }

    @Test
    public void should_invalid_valid() {
        // given
        givenQA("question1=answer1",
                "question2=answer2",
                "question3=answer3");

        // when
        hero.message("['wrong-answer']");
        game.tick();

        hero.message("['answer1']");
        game.tick();

        // then
        thenHistory(
            "[\n" +
            "  {\n" +
            "    'questionAnswers':[\n" +
            "      {\n" +
            "        'answer':'wrong-answer',\n" +
            "        'expected':'answer1',\n" +
            "        'question':'question1',\n" +
            "        'valid':false\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    'questionAnswers':[\n" +
            "      {\n" +
            "        'answer':'answer1',\n" +
            "        'question':'question1',\n" +
            "        'valid':true\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]");

        thenQuestions("[\n" +
                "  'question1',\n" +
                "  'question2'\n" +
                "]");
    }

    @Test
    public void should_invalid_valid_tick() {
        // given
        givenQA("question1=answer1",
                "question2=answer2",
                "question3=answer3");

        // when
        hero.message("['wrong-answer']");
        game.tick();

        hero.message("['answer1']");
        game.tick();

        game.tick();

        // then
        thenHistory(
            "[\n" +
            "  {\n" +
            "    'questionAnswers':[\n" +
            "      {\n" +
            "        'answer':'wrong-answer',\n" +
            "        'expected':'answer1',\n" +
            "        'question':'question1',\n" +
            "        'valid':false\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    'questionAnswers':[\n" +
            "      {\n" +
            "        'answer':'answer1',\n" +
            "        'question':'question1',\n" +
            "        'valid':true\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]");

        thenQuestions("[\n" +
                "  'question1',\n" +
                "  'question2'\n" +
                "]");
    }

    @Test
    public void should_invalid_valid_valid() {
        // given
        givenQA("question1=answer1",
                "question2=answer2",
                "question3=answer3");

        // when
        hero.message("['wrong-answer']");
        game.tick();

        hero.message("['answer1']");
        game.tick();

        hero.message("['answer1','answer2']");
        game.tick();

        // then
        thenHistory(
                "[\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'wrong-answer',\n" +
                "        'expected':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':false\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      },\n" +
                "      {\n" +
                "        'answer':'answer2',\n" +
                "        'question':'question2',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");

        thenQuestions("[\n" +
                "  'question1',\n" +
                "  'question2',\n" +
                "  'question3'\n" +
                "]");
    }

    @Test
    public void should_invalid_valid_tick_valid_tick() {
        // given
        givenQA("question1=answer1",
                "question2=answer2",
                "question3=answer3");

        // when
        hero.message("['wrong-answer']");
        game.tick();

        hero.message("['answer1']");
        game.tick();

        game.tick();

        hero.message("['answer1','answer2']");
        game.tick();

        game.tick();

        // then
        thenHistory(
                "[\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'wrong-answer',\n" +
                "        'expected':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':false\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      },\n" +
                "      {\n" +
                "        'answer':'answer2',\n" +
                "        'question':'question2',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");

        thenQuestions("[\n" +
                "  'question1',\n" +
                "  'question2',\n" +
                "  'question3'\n" +
                "]");
    }

    @Test
    public void shouldAfterLastQuestion() {
        // given
        givenQA("question1=answer1",
                "question2=answer2",
                "question3=answer3");

        // when
        hero.message("['answer1']");
        game.tick();

        hero.message("['answer1','answer2']");
        game.tick();

        hero.message("['answer1','answer2','answer3']");
        game.tick();

        hero.message("['answer1','answer2','answer3','answer4']");
        game.tick();

        // then
        thenHistory(
                "[\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      },\n" +
                "      {\n" +
                "        'answer':'answer2',\n" +
                "        'question':'question2',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      },\n" +
                "      {\n" +
                "        'answer':'answer2',\n" +
                "        'question':'question2',\n" +
                "        'valid':true\n" +
                "      },\n" +
                "      {\n" +
                "        'answer':'answer3',\n" +
                "        'question':'question3',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    'questionAnswers':[]\n" +
                "  }\n" +
                "]");

        thenQuestions("[]");
    }

    @Test
    public void should_stringAnswers() {
        // given
        givenQA("question1=answer1",
                "question2=answer2");

        // when
        hero.message("['answer1']");
        game.tick();

        // then
        thenHistory(
                "[\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");

        thenQuestions("[\n" +
                "  'question1',\n" +
                "  'question2'\n" +
                "]");

        // when
        hero.message("['answer1', 'answer2']");
        game.tick();

        thenHistory(
                "[\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      },\n" +
                "      {\n" +
                "        'answer':'answer2',\n" +
                "        'question':'question2',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");

        thenQuestions("[]");
    }

    @Test
    public void should_integerAnswers() {
        // given
        givenQA("question1=1",
                "question2=2");

        // when
        hero.message("['1']");
        game.tick();

        // then
        thenHistory(
                "[\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");

        thenQuestions("[\n" +
                "  'question1',\n" +
                "  'question2'\n" +
                "]");

        // when
        hero.message("['1', '2']");
        game.tick();

        thenHistory(
                "[\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      },\n" +
                "      {\n" +
                "        'answer':'2',\n" +
                "        'question':'question2',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");

        thenQuestions("[]");
    }

    @Test
    public void should_integersAnswers() {
        // given
        givenQA("question1=1, 2",
                "question2=3, 4");

        // when
        hero.message("['1, 2']");
        game.tick();

        thenHistory(
                "[\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'1, 2',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");

        thenQuestions("[\n" +
                "  'question1',\n" +
                "  'question2'\n" +
                "]");

        // when
        hero.message("['1, 2', '3, 4']");
        game.tick();

        // then
        thenHistory(
                "[\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'1, 2',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'1, 2',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      },\n" +
                "      {\n" +
                "        'answer':'3, 4',\n" +
                "        'question':'question2',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");

        thenQuestions("[]");
    }

    @Test
    public void shouldCleanHistoryWhenLastLevel() {
        // given
        givenQA("question1=answer1");

        // when
        hero.message("['answer1']");
        game.tick();

        thenHistory(
                "[\n" +
                    "  {\n" +
                    "    'questionAnswers':[\n" +
                    "      {\n" +
                    "        'answer':'answer1',\n" +
                    "        'question':'question1',\n" +
                    "        'valid':true\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  }\n" +
                    "]");

        thenQuestions("[]");

        // when
        hero.message("['blabla']");
        game.tick();

        // then
        thenHistory(
                "[\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    'questionAnswers':[]\n" +
                "  }\n" +
                "]");

        thenQuestions("[]");
    }

    @Test
    public void should_unansweredQuestion() {
        // given
        givenQA("question1=answer1",
                "question2=answer2",
                "question3=answer3");

        hero.message("['answer1']");
        game.tick();

        hero.message("['answer1','answer2']");
        game.tick();

        // when
        hero.message("['answer1','answer2']");
        game.tick();

        // then
        thenHistory(
                "[\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      },\n" +
                "      {\n" +
                "        'answer':'answer2',\n" +
                "        'question':'question2',\n" +
                "        'valid':true\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    'questionAnswers':[\n" +
                "      {\n" +
                "        'answer':'answer1',\n" +
                "        'question':'question1',\n" +
                "        'valid':true\n" +
                "      },\n" +
                "      {\n" +
                "        'answer':'answer2',\n" +
                "        'question':'question2',\n" +
                "        'valid':true\n" +
                "      },\n" +
                "      {\n" +
                "        'answer':'???',\n" +
                "        'expected':'answer3',\n" +
                "        'question':'question3',\n" +
                "        'valid':false\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");

        thenQuestions("[\n" +
                "  'question1',\n" +
                "  'question2',\n" +
                "  'question3'\n" +
                "]");
    }

    @Test
    public void shouldPlayerHasLevels() {
        // given
        withLevels(qa("question1=answer1"),
                qa("question2=answer2",
                        "question3=answer3"),
                qa("question4=answer4",
                        "question5=answer5"));
        givenGame();

        // then
        assertStillOnLevel(0);

        // when
        hero.message("['answer1']");
        game.tick();

        // then
        assertGoToNextLevel(1);

        // when
        hero.message("['answer2']");
        game.tick();

        // then
        assertStillOnLevel(1);

        hero.message("['answer2','answer3']");
        game.tick();

        // then
        assertGoToNextLevel(2);

        hero.message("['answer4']");
        game.tick();

        // then
        assertStillOnLevel(2);

        hero.message("['answer4','answer5']");
        game.tick();

        // then
        assertGoToNextLevel(3);
    }

    private void withLevels(Level... levels) {
        this.levels = Arrays.asList(levels);
        levelIndex = 0;
    }

    private void assertStillOnLevel(int expected) {
        assertEquals(expected, player.levels().getLevelIndex());
        assertEquals(false, pool.isWaitNext());
    }

    private void assertGoToNextLevel(int level) {
        // then
        assertWaitAfter(level - 1);

        // when
        hero.message(START_NEXT_LEVEL);
        game.tick();

        // then
        assertStillOnLevel(level);

        // given
        levelIndex = level;
        givenGame();
    }

    @Test
    public void shouldPlayerAskNextLevelOnlyIfNowWeAreWaiting() {
        // given
        withLevels(qa("question1=answer1"),
                qa("question2=answer2",
                        "question3=answer3"),
                qa("question4=answer4",
                        "question5=answer5"));
        givenGame();

        // then
        int sameLevel = 0;
        assertStillOnLevel(sameLevel);

        // when
        // try to NextLevel
        hero.message(START_NEXT_LEVEL);
        game.tick();

        // then
        // unsuccessful
        assertStillOnLevel(sameLevel);

        // when
        hero.message("['answer1']");
        game.tick();
        
        // then
        assertGoToNextLevel(1);
    }

    @Test
    public void shouldPlayerSkipLevel_onlyIfNowWeArePlaying() {
        // given
        withLevels(qa("question1=answer1"),
                qa("question2=answer2",
                        "question3=answer3"),
                qa("question4=answer4",
                        "question5=answer5"));
        givenGame();

        // then
        assertStillOnLevel(0);

        // when
        hero.message("['answer1']");
        game.tick();

        // then
        // WaitLevel
        int sameLevel = 0;
        assertWaitAfter(sameLevel);

        // when
        // try to skip
        hero.message(SKIP_THIS_LEVEL);
        game.tick();

        // then
        // unsuccessful
        assertWaitAfter(sameLevel);

        // when
        // start next
        hero.message(START_NEXT_LEVEL);
        game.tick();

        // then
        assertStillOnLevel(1);

        // when
        // try to skip
        hero.message(SKIP_THIS_LEVEL);
        game.tick();

        // then
        assertWaitAfter(1);
    }

    private void assertWaitAfter(int level) {
        assertEquals(level, player.levels().getLevelIndex());
        assertEquals(true, pool.isWaitNext());
    }

    @Test
    public void shouldPlayerSkipFirstTwoLevels_thenAnswer_case2() {
        // given
        withLevels(qa("question1=answer1"),
                qa("question2=answer2",
                        "question3=answer3"),
                qa("question4=answer4",
                        "question5=answer5"));
        givenGame();

        // then
        assertStillOnLevel(0);

        // when
        hero.message(SKIP_THIS_LEVEL);
        game.tick();

        // then
        assertGoToNextLevel(1);

        // when
        hero.message(SKIP_THIS_LEVEL);
        game.tick();

        // then
        assertGoToNextLevel(2);

        // when
        hero.message("['answer4']");
        game.tick();

        // then
        assertStillOnLevel(2);

        hero.message("['answer4','answer5']");
        game.tick();

        // then
        assertGoToNextLevel(3);
    }

    @Test
    public void should_ignoreBadCommand_caseTwoParameters() {
        // given
        givenQA("question1=answer1",
                "question2=answer2",
                "question3=answer3");

        // when
        hero.message("['StartNextLevel']");
        game.tick();

        // then
        assertStillOnLevel(0);
    }

    @Test
    public void shouldHeroWin_whenSkipThisLevel_whenWaiting() {
        // given
        withLevels(qa("question1=answer1"),
                qa("question2=answer2",
                        "question3=answer3"),
                qa("question4=answer4",
                        "question5=answer5"));
        givenGame();

        // then
        assertStillOnLevel(0);
        assertRequestedNextLevel(false);

        // when
        hero.message("['answer1']");
        game.tick();

        // then
        // WaitLevel
        int sameLevel = 0;
        assertWaitAfter(sameLevel);
        assertRequestedNextLevel(false);

        // when
        // try to skip
        hero.message(SKIP_THIS_LEVEL);

        // then
        // we are waiting and skip this level
        assertRequestedNextLevel(true);
    }

    @Test
    public void shouldHeroWin_whenStartNextLevel_whenWaiting() {
        // given
        withLevels(qa("question1=answer1"),
                qa("question2=answer2",
                        "question3=answer3"),
                qa("question4=answer4",
                        "question5=answer5"));
        givenGame();

        // then
        assertStillOnLevel(0);
        assertRequestedNextLevel(false);

        // when
        hero.message("['answer1']");
        game.tick();

        // then
        // WaitLevel
        int sameLevel = 0;
        assertWaitAfter(sameLevel);
        assertRequestedNextLevel(false);

        // when
        // try to skip
        hero.message(START_NEXT_LEVEL);

        // then
        // we are waiting and start next level
        assertRequestedNextLevel(true);
    }

    @Test
    public void shouldHeroWin_whenSkipThisLevel_whenPlaying() {
        // given
        withLevels(qa("question1=answer1"),
                qa("question2=answer2",
                        "question3=answer3"),
                qa("question4=answer4",
                        "question5=answer5"));
        givenGame();

        // then
        assertStillOnLevel(0);
        assertRequestedNextLevel(false);

        // when
        // try to skip
        hero.message(SKIP_THIS_LEVEL);

        // then
        // we are playing and skip this level
        assertRequestedNextLevel(true);
    }

    @Test
    public void shouldHeroNotWin_whenStartNextLevel_whenPlaying() {
        // given
        withLevels(qa("question1=answer1"),
                qa("question2=answer2",
                        "question3=answer3"),
                qa("question4=answer4",
                        "question5=answer5"));
        givenGame();

        // then
        assertStillOnLevel(0);
        assertRequestedNextLevel(false);

        // when
        // try to skip
        hero.message(START_NEXT_LEVEL);

        // then
        // we are playing and trying to start next level
        // but unsuccessful
        assertRequestedNextLevel(false);
    }

    private void assertRequestedNextLevel(boolean requested) {
        assertEquals(!requested, player.isAlive());
        assertEquals(requested, player.isWin());
    }
}
