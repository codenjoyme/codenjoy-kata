package com.codenjoy.dojo.kata.services;

/*-
 * #%L
 * expansion - it's a dojo-like platform from developers to developers.
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


import com.codenjoy.dojo.services.event.Calculator;
import com.codenjoy.dojo.services.questionanswer.levels.Level;
import com.codenjoy.dojo.services.questionanswer.levels.LevelsLoader;
import com.codenjoy.dojo.services.settings.PropertiesKey;
import com.codenjoy.dojo.services.settings.SettingsImpl;
import com.codenjoy.dojo.services.settings.SettingsReader;

import java.util.Arrays;
import java.util.List;

import static com.codenjoy.dojo.kata.services.GameRunner.GAME_NAME;
import static com.codenjoy.dojo.kata.services.GameSettings.Keys.*;

public class GameSettings extends SettingsImpl implements SettingsReader<GameSettings> {

    public enum Keys implements PropertiesKey {

        WIN_SCORE,
        LOSE_PENALTY,
        A_CONSTANT,
        B_CONSTANT,
        C_CONSTANT,
        D_CONSTANT,
        SHOW_DESCRIPTION,
        SHOW_EXPECTED_ANSWER,
        LEVELS_COUNT;

        private String key;

        Keys() {
            this.key = key(GAME_NAME);
        }

        @Override
        public String key() {
            return key;
        }
    }

    @Override
    public List<Key> allKeys() {
        return Arrays.asList(Keys.values());
    }

    public GameSettings() {
        integer(WIN_SCORE, 30);
        integer(LOSE_PENALTY, -100);

        integer(A_CONSTANT, 100);
        integer(B_CONSTANT, 3);
        integer(C_CONSTANT, 30);
        integer(D_CONSTANT, 10);

        bool(SHOW_DESCRIPTION, true);
        bool(SHOW_EXPECTED_ANSWER, true);

        Levels.setup(this);
    }

    public List<Level> levels() {
        return Levels.sorted(this);
    }

    public int levelsCount() {
        return integer(LEVELS_COUNT);
    }

    public String levelName(int index) {
        return string(nameKey(index));
    }

    public GameSettings addLevel(int index, Level level) {
        integer(LEVELS_COUNT, index);

        string(nameKey(index), level.name());
//        string(helpKey(index), level.description());
//        string(defaultCodeKey(index), level.defaultCode());
//        string(winCodeKey(index), level.winCode());
        return this;
    }

    private String levelPrefix(int index) {
        return "Level" + index + " ";
    }

    private Key nameKey(int index) {
        return () -> levelPrefix(index) + "name";
    }

    public Calculator<Object> calculator() {
        return new Calculator<>(new Scores(this));
    }
}