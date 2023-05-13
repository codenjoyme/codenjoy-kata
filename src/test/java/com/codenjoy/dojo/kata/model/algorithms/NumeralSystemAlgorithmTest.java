package com.codenjoy.dojo.kata.model.algorithms;

import com.codenjoy.dojo.services.questionanswer.levels.Algorithm;

public class NumeralSystemAlgorithmTest extends AlgorithmTest {

    @Override
    public Algorithm algorithm() {
        return new NumeralSystemAlgorithm();
    }

    @Override
    public String answers() {
        return "10, 10, 10=>10\n" +
                "10, 10, 2=>1010\n" +
                "10, 2, 10=>2\n" +
                "1000, 10, 16=>3e8\n" +
                "1000, 16, 10=>4096\n" +
                "1000, 16, 2=>1000000000000\n" +
                "1ACD, 16, 2=>1101011001101\n" +
                "ABCD, 16, 2=>1010101111001101\n" +
                "34BE, 16, 10=>13502\n" +
                "1000, 2, 16=>8\n" +
                "1010, 2, 16=>a\n" +
                "1010101, 2, 4=>1111\n" +
                "1010101, 2, 6=>221\n" +
                "1010101, 2, 8=>125\n" +
                "1010101, 2, 10=>85\n" +
                "1010101, 2, 12=>71\n" +
                "1010101, 2, 14=>61\n" +
                "1010101, 2, 16=>55\n" +
                "0, 2, 16=>0\n" +
                "360, 10, 60=>360\n" +
                "360, 10, 12=>260";
    }
}