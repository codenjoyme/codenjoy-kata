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


import com.codenjoy.dojo.client.ClientBoard;
import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.games.kata.Board;
import com.codenjoy.dojo.kata.model.Kata;
import com.codenjoy.dojo.kata.model.Player;
import com.codenjoy.dojo.kata.services.ai.AISolver;
import com.codenjoy.dojo.services.AbstractGameType;
import com.codenjoy.dojo.services.EventListener;
import com.codenjoy.dojo.services.PlayerScores;
import com.codenjoy.dojo.services.event.ScoresImpl;
import com.codenjoy.dojo.services.multiplayer.GameField;
import com.codenjoy.dojo.services.multiplayer.GamePlayer;
import com.codenjoy.dojo.services.multiplayer.LevelProgress;
import com.codenjoy.dojo.services.multiplayer.MultiplayerType;
import com.codenjoy.dojo.services.printer.BoardReader;
import com.codenjoy.dojo.services.printer.CharElement;
import com.codenjoy.dojo.services.printer.Printer;
import com.codenjoy.dojo.services.printer.PrinterFactory;
import com.codenjoy.dojo.services.questionanswer.QuestionAnswer;
import com.codenjoy.dojo.services.settings.Parameter;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static com.codenjoy.dojo.kata.services.GameSettings.Keys.*;
import static com.codenjoy.dojo.services.questionanswer.Examiner.UNANSWERED;
import static com.codenjoy.dojo.services.settings.SimpleParameter.v;
import static java.util.stream.Collectors.toList;

public class GameRunner extends AbstractGameType<GameSettings> {

    public static final String GAME_NAME = "kata";

    public static final String KEY_HISTORY = "history";
    public static final String KEY_LEVEL = "level";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_EXPECTED_ANSWER = "expectedAnswer";
    public static final String KEY_QUESTIONS = "questions";
    public static final String KEY_NEXT_QUESTION = "nextQuestion";

    @Override
    public GameSettings getSettings() {
        return new GameSettings();
    }

    @Override
    public PlayerScores getPlayerScores(Object score, GameSettings settings) {
        return new ScoresImpl<>(Integer.parseInt(score.toString()), settings.calculator());
    }

    @Override
    public GameField createGame(int levelNumber, GameSettings settings) {
        int levelIndex = levelNumber - LevelProgress.levelsStartsFrom1;
        return new Kata(getDice(), levelIndex, settings);
    }

    @Override
    public Parameter<Integer> getBoardSize(GameSettings settings) {
        return v(0);
    }

    @Override
    public String name() {
        return GAME_NAME;
    }

    @Override
    public CharElement[] getPlots() {
        return new CharElement[0];
    }


    @Override
    public Class<? extends Solver> getAI() {
        return AISolver.class;
    }

    @Override
    public Class<? extends ClientBoard> getBoard() {
        return Board.class;
    }

    @Override
    public MultiplayerType getMultiplayerType(GameSettings settings) {
        return MultiplayerType.ALL_SINGLE.apply(settings.getLevelsCount());
    }

    @Override
    public GamePlayer createPlayer(EventListener listener, int teamId, String playerId, GameSettings settings) {
        return new Player(listener, settings).inTeam(teamId);
    }

    @Override
    public PrinterFactory getPrinterFactory() {
        return PrinterFactory.get((BoardReader boardReader, Player player, Object... parameters) -> {
            boolean screenOrClient = Printer.isScreenOrClient(parameters);
            JSONObject result = new JSONObject();
            GameSettings settings = player.settings();

            result.put(KEY_LEVEL, player.levels().getLevelIndex());

            String next = player.levels().getNextQuestion();

            if (screenOrClient) {
                QuestionAnswer last = new QuestionAnswer(next, null);
                last.setExpectedAnswer(player.levels().getExpectedAnswer());

                List<QuestionAnswer> lastHistory = player.examiner().getLastHistory();
                if (lastHistory == null) {
                    lastHistory = new LinkedList<>();
                }
                Deque<QuestionAnswer> history = new LinkedList<>(lastHistory);
                if (next != null && (history.isEmpty() || !StringUtils.equals(next, history.getLast().getQuestion()))) {
                    history.add(last);
                }
                result.put(KEY_HISTORY, history.stream()
                        .map(qa -> format(settings, qa, next))
                        .collect(toList()));
            } else {
                if (settings.bool(SHOW_DESCRIPTION)) {
                    result.put(KEY_DESCRIPTION,
                            player.levels().getDescription().stream()
                                    .map(StringEscapeUtils::escapeJava)
                                    .collect(toList()));
                }

                if (settings.bool(SHOW_EXPECTED_ANSWER)) {
                    result.put(KEY_EXPECTED_ANSWER, player.levels().getExpectedAnswer());
                }

                result.put(KEY_QUESTIONS, player.levels().getQuestions());

                result.put(KEY_NEXT_QUESTION, next);

                List<QuestionAnswer> history = player.examiner().getLastHistory();
                if (!settings.bool(SHOW_VALID_IN_HISTORY)) {
                    if (history != null) {
                        history.forEach(it -> it.setExpectedAnswer(null));
                    }
                }
                result.put(KEY_HISTORY, history);

            }
            return result;
        });
    }

    private String format(GameSettings settings, QuestionAnswer qa, String nextQuestion) {
        boolean last = StringUtils.equals(qa.getQuestion(), nextQuestion);
        String answer = qa.getAnswer();
        if (answer == null) {
            answer = UNANSWERED;
        }
        if (qa.isValid()) {
            return String.format("✅f(%s) = %s", qa.getQuestion(), answer);
        }
        boolean showExpected =
                (last && settings.bool(SHOW_EXPECTED_ANSWER))
                || (!last && settings.bool(SHOW_VALID_IN_HISTORY));
        if (showExpected){
            return String.format("❌f(%s) = %s != %s", qa.getQuestion(), answer, qa.getExpected());
        } else {
            return String.format("❌f(%s) != %s", qa.getQuestion(), answer);
        }
    }
}