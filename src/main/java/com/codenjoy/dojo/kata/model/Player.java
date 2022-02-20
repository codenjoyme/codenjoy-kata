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
import com.codenjoy.dojo.services.EventListener;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.multiplayer.GamePlayer;
import com.codenjoy.dojo.services.questionanswer.Examiner;
import com.codenjoy.dojo.services.questionanswer.levels.LevelsPool;
import com.codenjoy.dojo.services.questionanswer.levels.LevelsPoolImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player extends GamePlayer<Hero, Field> {

    private static Logger logger = LoggerFactory.getLogger(Player.class);

    private LevelsPool level;
    private Examiner examiner;

    public Player(EventListener listener, GameSettings settings) {
        super(listener, settings);
        this.level = new LevelsPoolImpl(settings.levels());
        examiner = new Examiner(level);
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
        if (examiner != null) {
            examiner.clear();
        }
    }

    public Hero createHero(Point pt) {
        return new Hero();
    }

    public void checkAnswer() {
        hero.tick();

        for (Object event : examiner.ask(hero)) {
            event(event);
        }
    }

    public LevelsPool levels() {
        return level;
    }

    public Examiner examiner() {
        return examiner;
    }
}
