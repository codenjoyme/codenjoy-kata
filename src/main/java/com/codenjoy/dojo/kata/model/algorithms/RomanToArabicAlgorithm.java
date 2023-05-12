package com.codenjoy.dojo.kata.model.algorithms;

import com.codenjoy.dojo.services.questionanswer.levels.AlgorithmLevelImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RomanToArabicAlgorithm extends AlgorithmLevelImpl {

    /**
     * Converts a Roman number to Arabic.
     * @param input string with Roman number.
     * @return Arabic number.
     */
    @Override
    public String get(String input) {
        Map<Character, Integer> numbers = Map.ofEntries(
                Map.entry('M', 1000),
                Map.entry('D', 500),
                Map.entry('C', 100),
                Map.entry('L', 50),
                Map.entry('X', 10),
                Map.entry('V', 5),
                Map.entry('I', 1)
        );

        int result = 0;
        int previousValue = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            char current = input.charAt(i);
            int value = numbers.get(current);

            if (value < previousValue) {
                result -= value;
            } else {
                result += value;
            }

            previousValue = value;
        }

        return Integer.toString(result);
    }

    @Override
    public String winCode() {
        return "function get(input) {\n" +
                "    const numbers = {\n" +
                "        'M':1000,\n" +
                "        'D':500,\n" +
                "        'C':100,\n" +
                "        'L':50,\n" +
                "        'X':10,\n" +
                "        'V':5,\n" +
                "        'I':1\n" +
                "    };\n" +
                "    let result = 0;\n" +
                "    let previous = 0;\n" +
                "\n" +
                "    for (let i = input.length - 1; i >= 0; i--) {\n" +
                "        const current = numbers[input.charAt(i)];\n" +
                "\n" +
                "        if (current < previous) {\n" +
                "            result -= current;\n" +
                "        } else {\n" +
                "            result += current;\n" +
                "        }\n" +
                "\n" +
                "        previous = current;\n" +
                "    }\n" +
                "\n" +
                "    return result.toString();\n" +
                "}";
    }

    @Override
    public List<String> getQuestions() {
        return Arrays.asList(
                "I",
                "II",
                "III",
                "IV",
                "V",
                "VI",
                "VII",
                "VIII",
                "IX",
                "X",
                "XI",
                "XII",
                "XIII",
                "XIV",
                "XV",
                "XVI",
                "XVII",
                "XVIII",
                "XIX",
                "XX",
                "XXX",
                "XXXV",
                "XXXVI",
                "XLVI",
                "LVII",
                "LXVII",
                "LXXXIX",
                "CXXIII",
                "CCXXXIV",
                "CCCXLV",
                "CDLVI",
                "DLXVII",
                "DCLXXVIII",
                "DCCCXC",
                "MCCXXXIV",
                "MMCCCXLV",
                "MMMCDLVI");
    }

    @Override
    public int complexity() {
        return 38;
    }

    @Override
    public List<String> description() {
        return Arrays.asList(
                "Write a function that converts a Roman number to Arabic");
    }

    @Override
    public String author() {
        return "Oleksandr Baglai";
    }
}
