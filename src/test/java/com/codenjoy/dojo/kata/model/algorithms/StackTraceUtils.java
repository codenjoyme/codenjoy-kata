package com.codenjoy.dojo.kata.model.algorithms;

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


import org.junit.ComparisonFailure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StackTraceUtils {

    private static int getLineNumber(String methodName, Class<?> clazz) {
        Path sourceFile = Path.of("src/test/java",
                clazz.getName()
                        .replace(".", "/")
                        + ".java");
        try (Stream<String> stream = Files.lines(sourceFile)) {
            List<String> lines = stream.collect(toList());
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains(" " + methodName)) {
                    return i + 1;
                }
            }
        } catch (IOException e) {
            // do nothing
        }
        return 35;
    }


    public static ComparisonFailure clarify(ComparisonFailure exception, String methodName, Class<?> clazz) {
        int lineNumber = getLineNumber(methodName, clazz);
        List<StackTraceElement> trace = new LinkedList<>(Arrays.asList(exception.getStackTrace()));
        trace.add(0, new StackTraceElement(clazz.toString(), methodName, clazz.getSimpleName() + ".java", lineNumber));
        exception.setStackTrace(trace.toArray(new StackTraceElement[0]));
        return exception;
    }
}
