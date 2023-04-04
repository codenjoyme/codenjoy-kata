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


import com.codenjoy.dojo.services.multiplayer.LevelProgress;
import com.codenjoy.dojo.services.questionanswer.levels.Level;
import com.codenjoy.dojo.services.questionanswer.levels.LevelsLoader;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public final class Levels {

    private Levels() {
        throw new IllegalAccessError("Utility class");
    }

    public static List<Level> all() {
        return LevelsLoader.getAlgorithms();
    }

    public static void setup(GameSettings settings) {
        AtomicInteger index = new AtomicInteger();
        all().forEach(level -> settings.addLevel(index.incrementAndGet(), level));
    }

    public static List<Level> sorted(GameSettings settings) {
        List<String> sorted = IntStream.range(0, settings.levelsCount())
                .map(index -> index + LevelProgress.levelsStartsFrom1)
                .mapToObj(settings::levelName)
                .collect(toList());

        return all().stream()
                .sorted(comparingInt(level -> sorted.indexOf(level.name())))
                .filter(level -> sorted.contains(level.name()))
                .collect(toList());
    }
}