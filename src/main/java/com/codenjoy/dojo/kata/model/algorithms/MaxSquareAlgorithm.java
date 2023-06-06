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

import com.codenjoy.dojo.services.questionanswer.levels.AlgorithmLevelImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class MaxSquareAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(int... input) {
        int[] lines = Arrays.stream(input).toArray();

        int left = 0;
        int right = lines.length - 1;
        int maxArea = 0;
        String result = StringUtils.EMPTY;
        while (left < right) {
            int width = right - left;
            int height = Math.min(lines[left], lines[right]);
            int area = height * width;
            if (area >= maxArea) {
                result = String.format("%d,%d", left, right);
                maxArea = area;
            }
            if (lines[left] < lines[right]) {
                left++;
            } else {
                right--;
            }
        }
        return String.format("%d:%s", maxArea, result);
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "  const lines = input.split(', ').map(number => parseInt(number));\n" +
                "  let left = 0;\n" +
                "  let right = lines.length - 1;\n" +
                "  let maxArea = 0;\n" +
                "  let result = '';\n" +
                "  \n" +
                "  while (left < right) {\n" +
                "    const width = right - left;\n" +
                "    const height = Math.min(lines[left], lines[right]);\n" +
                "    const area = width * height;\n" +
                "    if (area >= maxArea) {\n" +
                "      maxArea = area;\n" +
                "      result = `${maxArea}:${left},${right}`;\n" +
                "    }\n" +
                "    if (lines[left] < lines[right]) {\n" +
                "      left++;\n" +
                "    } else {\n" +
                "      right--;\n" +
                "    }\n" +
                "  }\n" +
                "  \n" +
                "  return result;\n" +
                "}";
    }


    @Override
    public List<String> description() {
        return List.of("You are given an array of vertical lines height," +
                " so that Y-axis is the line height and X-axis is line index from an array." +
                " Write a Javascript function that finds two lines that together forms the largest square" +
                " and returns the maximum square number.",
                "Try to solve this task with O(n) complexity.");
    }

    @Override
    public List<String> getQuestions() {
        return List.of(
                "3, 6, 2, 5, 4, 8, 3",
                "1, 1, 1, 1, 1",
                "1, 2, 1, 2, 1",
                "1, 1, 10, 1, 1",
                "1, 5, 10, 5, 1",
                "5, 1, 10, 1, 5",
                "100, 5, 1, 5, 100",
                "100, 1, 5, 1, 100",
                "1, 100, 1, 100, 1"
        );
    }

    @Override
    public String author() {
        return "Inspired by LeetCode algorithm:" +
                "https://leetcode.com/problems/container-with-most-water/description/";
    }

    @Override
    public int complexity() {
        return 51;
    }
}
