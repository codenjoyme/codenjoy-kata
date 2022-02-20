package com.codenjoy.dojo.kata.model;

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


import com.codenjoy.dojo.kata.services.GameSettings;
import com.codenjoy.dojo.kata.services.events.NextAlgorithmEvent;
import com.codenjoy.dojo.kata.services.events.PassTestEvent;
import com.codenjoy.dojo.services.EventListener;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.multiplayer.GamePlayer;
import com.codenjoy.dojo.services.questionanswer.Processor;
import com.codenjoy.dojo.services.questionanswer.levels.LevelsPool;
import com.codenjoy.dojo.services.time.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Player extends GamePlayer<Hero, Field> {

    private static Logger logger = LoggerFactory.getLogger(Player.class);

    private LevelsPool level;
    private Processor processor;
    private Timer timer = new Timer();

    public Player(EventListener listener, LevelsPool level, GameSettings settings) {
        super(listener, settings);
        processor = new Processor();
        this.level = level;
        level.firstLevel();
    }

    @Override
    public String toString() {
        return "{" + Integer.toHexString(this.hashCode()) + "}";
    }

    public void event(Object event) {
        if (logger.isDebugEnabled()) {
            logger.debug("Player '{}' on Level '{}:{}' fired event '{}'",
                    this,
                    level.getLevelIndex(), level.getQuestionIndex(),
                    event);
        }

        super.event(event);
    }

    public void clearScore() {
        if (processor != null) {
            processor.clear();
            level.firstLevel();
        }
    }

    public Hero createHero(Point pt) {
        return new Hero();
    }

    public void checkAnswer() {
        hero.tick();

        if (hero.wantsSkipLevel()) {
            hero.clearFlags();
            level.waitNext();
            return;
        }

        if (hero.wantsNextLevel()) {
            hero.clearFlags();
            if (level.isWaitNext()) {
                timer.start();
                level.nextLevel();
                processor.logNextAttempt();
            }
            return;
        }

        String answersString = hero.popAnswers();
        if (answersString == null) {
            return;
        }

        List<String> actualAnswers = processor.nextAnswer(answersString);

        if (level.isLastQuestion()) {
            return;
        }

        List<String> questions = level.getQuestions();
        List<String> expectedAnswers = level.getAnswers();

        boolean isWin = processor.checkAnswers(questions, expectedAnswers, actualAnswers);

        if (isWin) {
            event(new PassTestEvent(level.getComplexity(), level.getTotalQuestions()));
            boolean levelFinished = level.isLevelFinished();
            if (levelFinished) {
                event(new NextAlgorithmEvent(level.getComplexity(), timer.end()));
                level.waitNext();
            } else {
                level.nextQuestion();
            }
        } else {
            // do nothing, gamification is a positive thing
        }
    }

    public LevelsPool level() {
        return level;
    }

    public Processor processor() {
        return processor;
    }
}
