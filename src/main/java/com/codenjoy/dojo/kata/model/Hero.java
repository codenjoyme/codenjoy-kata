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


import com.codenjoy.dojo.services.joystick.MessageJoystick;
import com.codenjoy.dojo.services.multiplayer.PlayerHero;
import com.codenjoy.dojo.services.questionanswer.Respondent;

import static com.codenjoy.dojo.games.kata.Command.SKIP_THIS_LEVEL;
import static com.codenjoy.dojo.games.kata.Command.START_NEXT_LEVEL;

public class Hero extends PlayerHero<Field> implements MessageJoystick, Respondent {

    private boolean alive;
    private String answers;
    
    private boolean skipLevel;
    private boolean nextLevel;

    public Hero() {
        alive = true;
        clearFlags();
    }

    @Override
    public void message(String answers) {
        if (START_NEXT_LEVEL.equals(answers)) {
            nextLevel = true;
            return;
        }

        if (SKIP_THIS_LEVEL.equals(answers)) {
            skipLevel = true;
            return;
        }

        this.answers = answers;
    }

    @Override
    public void tick() {
        if (!alive) return;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public String popAnswers() {
        String answers = this.answers;
        this.answers = null;
        return answers;
    }

    @Override
    public boolean wantsSkipLevel() {
        return skipLevel;
    }

    @Override
    public boolean wantsNextLevel() {
        return nextLevel;
    }

    @Override
    public void clearFlags() {
        skipLevel = false;
        nextLevel = false;        
    }
}
