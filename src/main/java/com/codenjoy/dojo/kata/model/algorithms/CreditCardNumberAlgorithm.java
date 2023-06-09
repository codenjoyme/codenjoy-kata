package com.codenjoy.dojo.kata.model.algorithms;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2012 - 2023 Codenjoy
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

import java.util.Arrays;
import java.util.List;

public class CreditCardNumberAlgorithm extends AlgorithmLevelImpl {
    @Override
    public String get(String input) {
        String digits = extractDigits(input);
        int sum = 0;
        for (int i = 0; i < digits.length(); i++) {
            int number = Character.getNumericValue(digits.charAt(i));
            sum += i % 2 == 0 ? calcLuhnNumber(number) : number;
        }
        return Integer.toString(sum % 10 == 0 ? 0 : 10 - (sum % 10));
    }

    private int calcLuhnNumber(int number) {
        int result = number * 2;
        return result > 9 ? result - 9 : result;
    }

    private String extractDigits(String input) {
        return input.replaceAll("\\D", "");
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "  let sum = 0;\n" +
                "  for (let i = 0; i < input.length; i++) {\n" +
                "    const number = parseInt(input.charAt(i));\n" +
                "    sum += i % 2 == 0 ? calcLuhnNumber(number) : number;\n" +
                "  }\n" +
                "  return (sum % 10 == 0 ? 0 : 10 - (sum % 10)).toString();\n" +
                "}\n" +
                "\n" +
                "function calcLuhnNumber(number) {\n" +
                "  const result = number * 2;\n" +
                "  return result > 9 ? result - 9 : result;\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList("Credit Card Number...\n " +
                "I will give you the first 15 digits of the credit card number. \n" +
                "You need to generate the last, 16th digit.\n" +
                "Please provide only the last digit as the answer.\n" +
                "Correct credit card number example: 4561261212345467" +
                "Answer example: 456126121234546=>7");
    }

    @Override
    public List<String> getQuestions() {
        return List.of("456126121234546",
                "123456781234567",
                "183168009579826",
                "964720036906339",
                "613951967276640",
                "825813064400100",
                "239698713103140",
                "771412693933286",
                "254262384108564",
                "959681833483055",
                "210087745295982",
                "367683885386271",
                "894632429803471",
                "471260044736237",
                "916471602234329",
                "961073953339054",
                "917408439816341",
                "498078140932499",
                "686244896142849",
                "772287416460433",
                "207725984977363",
                "199776984753064",
                "498874493103145",
                "662571495734934",
                "287442129303575",
                "358353262548397",
                "576080532156469"
        );
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
