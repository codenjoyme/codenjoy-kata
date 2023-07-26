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

import com.codenjoy.dojo.utils.JsonUtils;
import com.codenjoy.dojo.utils.TestUtils;
import com.codenjoy.dojo.utils.smart.SmartAssert;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Test;

import static com.codenjoy.dojo.utils.smart.SmartAssert.assertEquals;
import static java.util.stream.Collectors.toList;

public class GameSettingsTest {

    @After
    public void after() {
        SmartAssert.checkResult();
    }

    @Test
    public void shouldGetAllParameters_withKeys() {
        assertEquals("WIN_SCORE             =[Score] Win score\n" +
                        "LOSE_PENALTY          =[Score] Lose penalty\n" +
                        "A_CONSTANT            =[Score] A constant\n" +
                        "B_CONSTANT            =[Score] B constant\n" +
                        "C_CONSTANT            =[Score] C constant\n" +
                        "D_CONSTANT            =[Score] D constant\n" +
                        "SHOW_DESCRIPTION      =[Game] Show algorithm description in the request\n" +
                        "SHOW_EXPECTED_ANSWER  =[Game] Show expected answer for last question\n" +
                        "SHOW_VALID_IN_HISTORY =[Game] Show expected answer for all history questions",
                TestUtils.toString(new GameSettings().allKeys()));
    }

    @Test
    public void shouldGetAllParameters_alsoWithoutKeys() {
        assertEquals("{\n" +
                        "  '[Game] Show algorithm description in the request':true,\n" +
                        "  '[Game] Show expected answer for all history questions':true,\n" +
                        "  '[Game] Show expected answer for last question':true,\n" +
                        "  '[Level] Map[10]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Oh my, it seems that trolls have taken over your comment section!\\\\nHowever, fear not, for there is a simple solution to deal with these troublesome creatures.\\\\nYou may remove all vowels from their comments, rendering them powerless.\\\\nI implore you to create a function that can execute this task, for instance,\\\\ntransforming \\\\\\'This website is for losers LOL!\\\\\\' into \\\\\\'Ths wbst s fr lsrs LL!\\\\\\'. \\\\nPlease take note that for this exercise, the letter \\\\\\\\'y\\\\\\\\' is not considered a vowel.\\'\\n  ],\\n  \\'name\\':\\'RemoveVowelsAlgorithm\\',\\n  \\'winCode\\':\\'function get(input) {\\\\n    return input.replace(/(?i)[aeiou]/g, \\\\\\'\\\\\\');\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[11]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Check to see if a string has the same amount of \\\\\\\\'x\\\\\\\\'s and \\\\\\\\'o\\\\\\\\'s.\\\\nThe method must return a boolean and be case insensitive. The string can contain any char.\\\\nExamples input/output:\\\\nooxx=>true\\\\nxooxx=>false\\\\nooxXm=>true\\\\nzpzpzpp=>true // when no \\\\\\\\'x\\\\\\\\' and \\\\\\\\'o\\\\\\\\' is present should return true\\\\nzzoo=>false\\'\\n  ],\\n  \\'name\\':\\'ExesAndOhsAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n    const lowerCaseInput = input.toLowerCase();\\\\n    return (\\\\n        String(lowerCaseInput.replaceAll(\\\\\\'[^o]\\\\\\', \\\\\\'\\\\\\').length) ===\\\\n        String(lowerCaseInput.replaceAll(\\\\\\'[^x]\\\\\\', \\\\\\'\\\\\\').length)\\\\n    );\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[12]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'The order matters...\\\\n Everything is quite simple. \\\\nIn a string of three characters, the last character becomes the first one,\\\\n and the first two characters shift one position to the right. \\\\nFor example: abc=>cab...\\'\\n  ],\\n  \\'name\\':\\'CharOrderAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n    return input.substring(2)\\\\n        + input.substring(0, 2);\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[13]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'An isogram is a word that has no repeating letters, consecutive or non-consecutive.\\\\nImplement a function that determines whether a string that contains only letters is an isogram.\\\\nAssume the empty string is an isogram. Ignore letter case.\\\\nConjugated=>true\\\\ncappa=>false\\\\nmoOn=>false\\'\\n  ],\\n  \\'name\\':\\'IsogramWordsAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n   return (new Set(input.toLowerCase())).size === input.length;}\\'\\n}',\n" +
                        "  '[Level] Map[14]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Rent car cost calculator\\\\n Every day you rent the car costs $40. If you rent the car for 7 or more days, you get $50 off your total. \\\\nAlternatively, if you rent the car for 3 or more days, you get $20 off your total.\\\\nWrite a code that gives out the total amount for different days(d).Example: 1=>40, 2=>80, 3=>100, 4=>140, 6=>220, 7=>230, 15=>550\\'\\n  ],\\n  \\'name\\':\\'RentCarCostCalculatorAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n  return (input * 40) - (input >= 7 ? 50 : (input >= 3 ? 20 : 0));\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[15]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Remove all adjacent duplicate characters from a string, as soon as you encounter them walking left to right, and ensuring that at the end NO two adjacent characters remain.\\\\nExample: abc=>abc\\\\nabbc=>ac\\\\nabbbc=>ac\\\\nabbcccbad=>abad\\'\\n  ],\\n  \\'name\\':\\'DuplicateRemoveAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\nconst stack = [];\\\\nlet deleted = \\\\\\'\\\\\\';\\\\n\\\\nfor (let i = 0; i < input.length; i++) {\\\\n    const c = input.charAt(i);\\\\n\\\\n    if (stack.length === 0 && !c===deleted) {\\\\n        stack.push(c);\\\\n        deleted = \\\\\\'\\\\\\';\\\\n    } else if (deleted === c) {\\\\n        //skip\\\\n    } else if (stack[stack.length - 1] === c) {\\\\n        deleted = stack.pop();\\\\n    } else {\\\\n        stack.push(c);\\\\n        deleted = \\\\\\'\\\\\\';\\\\n    }\\\\n}\\\\nreturn stack.join(\\\\\\'\\\\\\');\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[16]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Think like a child...\\\\n Implement an algorithm that can solve the following tasks:For example: \\\\n8809 = 6\\\\n7111 = 0\\\\n2172 = 0\\\\n6666 = 4\\\\n1111 = 0\\\\n3213 = 0\\\\n7662 = 2\\\\n9312 = 1\\\\n0000 = 4\\\\n2222 = 0\\\\n3333 = 0\\\\n5555 = 0\\\\n8193 = 3\\\\n8096 = 5\\\\n7777 = 0\\\\n9999 = 4\\'\\n  ],\\n  \\'name\\':\\'ThinkLikeAChildAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\nreturn input.chars().map(this::getCircleCount).sum() + \\\\\\'\\\\\\';\\\\n    }\\\\n\\\\n    private int getCircleCount(int c) {\\\\n        switch (c) {\\\\n            case \\\\\\\\'0\\\\\\\\':\\\\n            case \\\\\\\\'6\\\\\\\\':\\\\n            case \\\\\\\\'9\\\\\\\\':\\\\n                return 1;\\\\n            case \\\\\\\\'8\\\\\\\\':\\\\n                return 2;\\\\n\\\\n            default:\\\\n                return 0;\\\\n        }\\\\n    }\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[17]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.\\\\nThe sum of these multiples is 23.\\\\nFinish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.\\\\nAdditionally, if the number is negative, return 0 (for languages that do have them).\\\\nNote: If the number is a multiple of both 3 and 5, only count it once.\\'\\n  ],\\n  \\'name\\':\\'MultiplesThreeOrFiveAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\nreturn String(\\\\n    [...Array(parseInt(input)).keys()]\\\\n      .filter(n => n % 3 === 0 || n % 5 === 0)\\\\n      .reduce((acc, n) => acc + n, 0)\\\\n  );\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[18]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Credit Card Number...\\\\n I will give you the first 15 digits of the credit card number. \\\\nYou need to generate the last, 16th digit.\\\\nPlease provide only the last digit as the answer.\\\\nCorrect credit card number example: 4561261212345467Answer example: 456126121234546=>7\\'\\n  ],\\n  \\'name\\':\\'CreditCardNumberAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n  let sum = 0;\\\\n  for (let i = 0; i < input.length; i++) {\\\\n    const number = parseInt(input.charAt(i));\\\\n    sum += i % 2 == 0 ? calcLuhnNumber(number) : number;\\\\n  }\\\\n  return (sum % 10 == 0 ? 0 : 10 - (sum % 10)).toString();\\\\n}\\\\n\\\\nfunction calcLuhnNumber(number) {\\\\n  const result = number * 2;\\\\n  return result > 9 ? result - 9 : result;\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[19]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'The structure of the DNA double helix (type B-DNA).\\\\nIf you want to know more: http://en.wikipedia.org/wiki/DNA\\\\n\\\\nIn DNA strings, symbols \\\\\\\\'A\\\\\\\\' and \\\\\\\\'T\\\\\\\\' are complements of each other, as \\\\\\\\'C\\\\\\\\' and \\\\\\\\'G\\\\\\\\'. \\\\nYour function receives one side of the DNA (string). \\\\nYou need to return the other complementary side. \\\\nDNA strand is never empty or there is no DNA at all (again, except for Haskell).\\\\nExample: TTTT=>AAAA, TAACG=>ATTGC etc.\\'\\n  ],\\n  \\'name\\':\\'DNASequenceAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n    return Array.from(input.toUpperCase()).map(c => {\\\\n        switch (c) {\\\\n            case \\\\\\\\'T\\\\\\\\':\\\\n                return \\\\\\\\'A\\\\\\\\';\\\\n            case \\\\\\\\'A\\\\\\\\':\\\\n                return \\\\\\\\'T\\\\\\\\';\\\\n            case \\\\\\\\'C\\\\\\\\':\\\\n                return \\\\\\\\'G\\\\\\\\';\\\\n            case \\\\\\\\'G\\\\\\\\':\\\\n                return \\\\\\\\'C\\\\\\\\';\\\\n            default:\\\\n                return c;\\\\n        }\\\\n    }).join(\\\\\\\\'\\\\\\\\');\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[1]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Write a method that takes a single string argument and return the string \\\\\\\\'world\\\\\\\\' if \\\\\\\\'hello\\\\\\\\' came in.\\',\\n    \\'Please write js method.\\',\\n    \\'Now please improve the algorithm so that it returns\\\\\\\\'hello\\\\\\\\' if \\\\\\\\'world\\\\\\\\' came in. Previous logic should work also\\',\\n    \\'One more improvement: in other cases the algorithm should return the same string that came in.\\'\\n  ],\\n  \\'name\\':\\'HelloWorldAlgorithm\\',\\n  \\'winCode\\':\\'function program(question) {\\\\n    if (question == \\\\\\\\'hello\\\\\\\\'){\\\\n        return \\\\\\\\'world\\\\\\\\';\\\\n    }\\\\n    if (question == \\\\\\\\'world\\\\\\\\'){\\\\n        return \\\\\\\\'hello\\\\\\\\';\\\\n    }\\\\n    return question;\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[20]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'You are going to be given a word. \\\\nYour job is to return the middle character of the word. \\\\nIf the word\\\\\\\\'s length is odd, return the middle character. \\\\nIf the word\\\\\\\\'s length is even, return the middle 2 characters.\\\\n#Examples:test=>es, testing=>t, middle=>dd, A=>A\\'\\n  ],\\n  \\'name\\':\\'MiddleCharacterAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n  let length = input.length;\\\\n  let middle = Math.floor(length / 2);\\\\n\\\\n  if (length % 2 === 0) {\\\\n    return input.substring(middle - 1, middle + 1);\\\\n  } else {\\\\n    return input.substring(middle, middle + 1);\\\\n  }}\\'\\n}',\n" +
                        "  '[Level] Map[21]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Order matters...\\\\nYou need to work with three-digit numbers. \\\\nSolve the algorithm for changing the number according to the given examples: \\\\nExamples: 111=>222, 123=>423, 679=>078, 999=>000, 012=>312, 090=>110, 444=>555, 090=>110, 916=>702\\'\\n  ],\\n  \\'name\\':\\'NumberOrderAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n    return \\\\\\\\'\\\\\\\\' + getNextNumber(input.charAt(2))\\\\n        + getNextNumber(input.charAt(0))\\\\n        + getNextNumber(input.charAt(1));\\\\n}\\\\n\\\\nfunction getNextNumber(number) {\\\\n    return (parseInt(number) + 1) % 10;\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[22]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Continue the sequence 101, 112, 131, 415, 161, 718... \\\\ni.e f(1) = 101, f(2) = 112, ...\\\\nHint: Look at the whole picture\\'\\n  ],\\n  \\'name\\':\\'Sequence1Algorithm\\',\\n  \\'winCode\\':\\'function program(number) {\\\\n    const START_WITH = 10;\\\\n    const GROUP = 3;\\\\n    const MAX = number * GROUP;\\\\n    let i = 0;\\\\n    let buffer = \\\\\\'\\\\\\';\\\\n    while (buffer.length < MAX) {\\\\n        buffer += START_WITH + i;\\\\n        i++;\\\\n    }\\\\n    return buffer.substring(MAX - GROUP, MAX);\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[23]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Please implement algorithm that converts number from one numeral system to another. Method should accept number, source numeral system and target numeral system.\\'\\n  ],\\n  \\'name\\':\\'NumeralSystemAlgorithm\\',\\n  \\'winCode\\':\\'function get(...input) {\\\\n    const number = input[0];\\\\n    const source = parseInt(input[1]);\\\\n    const target = parseInt(input[2]);\\\\n    \\\\n    return parseInt(number, source).toString(target);\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[24]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Make a method that returns a Fibonacci number from the series by its number:\\\\nf(0) = 0\\\\nf(1) = 1\\\\nf(2) = 0 + 1 = 1\\\\nf(3) = 1 + 1 = 2\\\\nf(4) = 1 + 2 = 3\\\\nf(5) = 2 + 3 = 5\\\\nf(6) = 3 + 5 = 8\\\\nf(7) = 5 + 8 = 13\\\\nf(8) = 8 + 13 = 21\\\\nf(9) = 13 + 21 = 34\\\\netc...\\'\\n  ],\\n  \\'name\\':\\'FibonacciNumbersAlgorithm\\',\\n  \\'winCode\\':\\'function program(number) {\\\\n    let previous = 0, current = 1;\\\\n    for (let i = 0; i < number; i++) {\\\\n         [previous, current] = [current, previous + current];\\\\n    }\\\\n    return String(previous);\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[25]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Divide an integer into multiples of prime numbers:\\\\n1 -> [1]\\\\n2 -> [2]\\\\n3 -> [3]\\\\n4 -> [2,2]\\\\n6 -> [2,3]\\\\n9 -> [3,3]\\\\n12 -> [2,2,3]\\\\n15 -> [3,5]\\\\netc...\\'\\n  ],\\n  \\'name\\':\\'PrimeFactoryAlgorithm\\',\\n  \\'winCode\\':\\'function program(number) {\\\\n    if (number == 1) {\\\\n        return \\\\\\\\'[1]\\\\\\\\';\\\\n    }\\\\n    const result = [];\\\\n    for (let i = 2; i <= Math.sqrt(number); i++) {\\\\n        while (number % i === 0) {\\\\n             result.push(i);\\\\n             number /= i;\\\\n        }\\\\n    }\\\\n    if (number > 1) {\\\\n        result.push(number);\\\\n    }\\\\n    return \\\\\\\\'[\\\\\\\\' + result.join(\\\\\\\\',\\\\\\\\') + \\\\\\\\']\\\\\\\\';\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[26]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'2 to the power of 15 = 32768, the sum of digits of the result 3 + 2 + 7 + 6 + 8 = 26. What is the sum of the digits of 2 to the power of i?\\\\nWrite a method for calculation that takes int and returns the result as a String\\'\\n  ],\\n  \\'name\\':\\'PowerDigitSumAlgorithm\\',\\n  \\'winCode\\':\\'function program(power) {\\\\n    const temp = (BigInt(1) << BigInt(power)).toString();\\\\n    let sum = 0;\\\\n    for (let i = 0; i < temp.length; i++) {\\\\n        sum += parseInt(temp[i]);\\\\n    }\\\\n    return sum.toString();\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[27]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'You have bricks of size 5 (bigCount) and 1 (smallCount). Write a method that can determine if a given set of bricks can be used to build a wall of a given length. a given set of bricks to build a wall of a given length (length). For example: \\\\nmethod(3, 1, 8) → true\\\\nmethod(3, 1, 9) → false\\\\nmethod(3, 2, 10) → true\\'\\n  ],\\n  \\'name\\':\\'MakeBricksAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n    const [small, big, goal] = input.split(\\\\\\\\', \\\\\\\\').map(number => parseInt(number));\\\\n    const result = (small >= (goal % 5) && small >= goal - big * 5);\\\\n    return String(result);\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[28]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Roman number algorithm. Convert arabic number to roman number.\\'\\n  ],\\n  \\'name\\':\\'ArabicToRomanAlgorithm\\',\\n  \\'winCode\\':\\'function get(input) {\\\\n  const numerals = [\\\\n    [1000, \\\\\\\\'M\\\\\\\\'],\\\\n    [900, \\\\\\\\'CM\\\\\\\\'],\\\\n    [500, \\\\\\\\'D\\\\\\\\'],\\\\n    [400, \\\\\\\\'CD\\\\\\\\'],\\\\n    [100, \\\\\\\\'C\\\\\\\\'],\\\\n    [90, \\\\\\\\'XC\\\\\\\\'],\\\\n    [50, \\\\\\\\'L\\\\\\\\'],\\\\n    [40, \\\\\\\\'XL\\\\\\\\'],\\\\n    [10, \\\\\\\\'X\\\\\\\\'],\\\\n    [9, \\\\\\\\'IX\\\\\\\\'],\\\\n    [5, \\\\\\\\'V\\\\\\\\'],\\\\n    [4, \\\\\\\\'IV\\\\\\\\'],\\\\n    [1, \\\\\\\\'I\\\\\\\\'],\\\\n  ];\\\\n\\\\n  if (input < 1 || input > 3999) {\\\\n    return \\\\\\\\'Input must be between 1 and 3999\\\\\\\\';\\\\n  }\\\\n\\\\n  let result = \\\\\\\\'\\\\\\\\';\\\\n  numerals.forEach(([value, numeral]) => {\\\\n    while (input >= value) {\\\\n      result += numeral;\\\\n      input -= value;\\\\n    }\\\\n  });\\\\n\\\\n  return result;\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[29]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Write a function that converts a Roman number to Arabic\\'\\n  ],\\n  \\'name\\':\\'RomanToArabicAlgorithm\\',\\n  \\'winCode\\':\\'function get(input) {\\\\n    const numbers = {\\\\n        \\\\\\\\'M\\\\\\\\':1000,\\\\n        \\\\\\\\'D\\\\\\\\':500,\\\\n        \\\\\\\\'C\\\\\\\\':100,\\\\n        \\\\\\\\'L\\\\\\\\':50,\\\\n        \\\\\\\\'X\\\\\\\\':10,\\\\n        \\\\\\\\'V\\\\\\\\':5,\\\\n        \\\\\\\\'I\\\\\\\\':1\\\\n    };\\\\n    let result = 0;\\\\n    let previous = 0;\\\\n\\\\n    for (let i = input.length - 1; i >= 0; i--) {\\\\n        const current = numbers[input.charAt(i)];\\\\n\\\\n        if (current < previous) {\\\\n            result -= current;\\\\n        } else {\\\\n            result += current;\\\\n        }\\\\n\\\\n        previous = current;\\\\n    }\\\\n\\\\n    return result.toString();\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[2]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Write a javascript method that takes one int argument and returns a string containing the number itself.\\',\\n    \\'For those numbers that are divisible by 3, the method should return \\\\\\\\'Fizz\\\\\\\\'\\',\\n    \\'For those numbers divisible by 5 it should return \\\\\\\\'Buzz\\\\\\\\'.\\',\\n    \\'For those numbers divisible by both 3 and 5 - \\\\\\\\'FizzBuzz\\\\\\\\'.\\',\\n    \\'Proceed in the same way if there is a number with a divisor of 7. The word \\\\\\\\'Muzz\\\\\\\\' is used for it. .\\',\\n    \\'Please write optimized code without any duplication.\\',\\n    \\'For divider 11 - the word must be \\\\\\\\'Duzz\\\\\\\\'.\\',\\n    \\'For divider 13 - the word must be \\\\\\\\'Cazz\\\\\\\\'.\\',\\n    \\'Please use a map with constants and dividers to avoid multiple ifs.\\'\\n  ],\\n  \\'name\\':\\'FizzBuzzAlgorithm\\',\\n  \\'winCode\\':\\'function getWord(number) {\\\\n  const map = new Map([\\\\n    [3, \\\\\\\\'Fizz\\\\\\\\'],\\\\n    [5, \\\\\\\\'Buzz\\\\\\\\'],\\\\n    [7, \\\\\\\\'Muzz\\\\\\\\'],\\\\n    [11, \\\\\\\\'Duzz\\\\\\\\'],\\\\n    [13, \\\\\\\\'Cazz\\\\\\\\']\\\\n  ]);\\\\n\\\\n  let result = \\\\\\\\'\\\\\\\\';\\\\n  map.forEach((word, divisor) => {\\\\n    if (number % divisor === 0) {\\\\n      result += word;\\\\n    }\\\\n  });\\\\n\\\\n  return result || number.toString();\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[30]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Write a method that takes one int argument and that returns the factorial of that number as a String.\\\\nWarning: Int/long overflow is possible.\\'\\n  ],\\n  \\'name\\':\\'FactorialAlgorithm\\',\\n  \\'winCode\\':\\'function program(number) {\\\\n    const cache = {};\\\\n\\\\n    function calculate(number) {\\\\n        if (number == 0) {\\\\n            return 1n;\\\\n        }\\\\n\\\\n        if (number in cache) {\\\\n            return cache[number];\\\\n        }\\\\n\\\\n        const result = BigInt(number) * calculate(number - 1);\\\\n        cache[number] = result;\\\\n\\\\n        return result;\\\\n    }\\\\n\\\\n    return calculate(number).toString();\\\\n}\\\\n\\'\\n}',\n" +
                        "  '[Level] Map[31]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'For the most of numbers iterative \\\\\\\\'reverse and add\\\\\\\\' actions lead to palindrome number. For example: \\\\nNumber 23: 23 + 32 = 55; \\\\nNumber 254: 254 + 452 = 706; 706 + 607 = 1313; 1313 + 3131 = 4444;\\\\nWrite a method which calculates \\\\\\\\'ReverseAndAdd\\\\\\\\' palindrome for a number. i.e f(23) = 55; f(254) = 4444\\'\\n  ],\\n  \\'name\\':\\'ReverseAddPalindromeAlgorithm\\',\\n  \\'winCode\\':\\'function program(number) {\\\\n    let result = BigInt(number);\\\\n    do {\\\\n        result += BigInt(reverse(String(result))); \\\\n    } while (!isPalindrome(result));\\\\n    return String(result);\\\\n}\\\\n\\\\nfunction isPalindrome(input) {\\\\n    let number = String(input);\\\\n    return number === reverse(number);\\\\n}\\\\n\\\\nfunction reverse(string) {\\\\n    return string.split(\\\\\\\\'\\\\\\\\').reverse().join(\\\\\\\\'\\\\\\\\');\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[32]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Continue the sequence 971, 874, 787, 709, 639...\\\\ni.e f(1) = 971, f(2) = 874, ...\\\\nHint: Use subtraction\\'\\n  ],\\n  \\'name\\':\\'Sequence2Algorithm\\',\\n  \\'winCode\\':\\'function program(number) {\\\\n    let result = 971;\\\\n\\\\n    for (let i = 1; i < number; i++) {\\\\n        let string = result.toString().padStart(3, \\\\\\\\'0\\\\\\\\');\\\\n        result -= parseInt(string.substring(0, 2));\\\\n    }\\\\n\\\\n    return result.toString();\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[33]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'You are given an array of vertical lines height, so that Y-axis is the line height and X-axis is line index from an array. Write a Javascript function that finds two lines that together forms the rectangle with largest area. Return the maximum area number and line coordinates in format {area}:{x1},{x2}. For example:\\\\n 1, 6, 3, 2, 8 => 18:1,4\\\\n 5, 2, 8, 1, 4 => 16:0,4\\\\n 7, 10, 2, 3, 1 => 9:0,3\\',\\n    \\'Solve this task with O(n) complexity.\\',\\n    \\'Return line coordinates of last found rectangle.\\'\\n  ],\\n  \\'name\\':\\'MaxSquareAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n  const lines = input.split(\\\\\\\\', \\\\\\\\').map(number => parseInt(number));\\\\n  let left = 0;\\\\n  let right = lines.length - 1;\\\\n  let maxArea = 0;\\\\n  let result = \\\\\\\\'\\\\\\\\';\\\\n  \\\\n  while (left < right) {\\\\n    const width = right - left;\\\\n    const height = Math.min(lines[left], lines[right]);\\\\n    const area = width * height;\\\\n    if (area >= maxArea) {\\\\n      maxArea = area;\\\\n      result = `${maxArea}:${left},${right}`;\\\\n    }\\\\n    if (lines[left] < lines[right]) {\\\\n      left++;\\\\n    } else {\\\\n      right--;\\\\n    }\\\\n  }\\\\n  \\\\n  return result;\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[34]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'The first 10 prime numbers are 2, 3, 5, 7, 11, 13, 17, 19, 23, 29. Write a method that returns the i-th prime number.\\'\\n  ],\\n  \\'name\\':\\'XthPrimeAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n    let index = parseInt(input);\\\\n    let count = 0;\\\\n    let result = 2;\\\\n\\\\n    while (count < index) {\\\\n        let isPrime = true;\\\\n        for (let j = 2; j <= Math.sqrt(result); j++) {\\\\n            if (result % j === 0) {\\\\n                isPrime = false;\\\\n                break;\\\\n            }\\\\n        }\\\\n        if (isPrime) {\\\\n            count++;\\\\n            if (count === index) {\\\\n                return result;\\\\n            }\\\\n        }\\\\n        result++;\\\\n    }\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[35]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Write a js function that takes an integer index as input and returns a string in the format \\\\\\\\'number:divisors:fizzBuzz\\\\\\\\', where \\\\\\\\'number\\\\\\\\' is the nth positive integer that has at least two distinct dividers [3, 5, 7, 9, 13] and is divisible by them without a rest, \\\\\\\\'divisors\\\\\\\\' is a separated by \\\\\\\\'*\\\\\\\\' list of the distinct prime factors of \\\\\\\\'number\\\\\\\\', and \\\\\\\\'fizzBuzz\\\\\\\\' is the result of calling a function \\\\\\\\'fizzBuzz(number)\\\\\\\\'. If the input index is less than or equal to 0 or greater than or equal to 25, return \\\\\\\\'none\\\\\\\\'.\\',\\n    \\'JavaScript program:\\\\nfunction fizzBuzz(number) {\\\\n    const divisors = [3, 5, 7, 11, 13];\\\\n    const strings = [\\\\\\\\'Fizz\\\\\\\\', \\\\\\\\'Buzz\\\\\\\\', \\\\\\\\'Muzz\\\\\\\\', \\\\\\\\'Duzz\\\\\\\\', \\\\\\\\'Cazz\\\\\\\\'];\\\\n    let str = \\\\\\\\'\\\\\\\\';\\\\n    for (let i = 0; i < divisors.length; i++) {\\\\n        if (number % divisors[i] === 0) {\\\\n            str += strings[i];\\\\n        }\\\\n    }\\\\n    return str || number.toString();\\\\n}\\',\\n    \\'For example:\\\\n1=>15:3*5:FizzBuzz\\\\n2=>21:3*7:FizzMuzz\\\\n3=>33:3*11:FizzDuzz\\\\n10=>105:3*5*7:FizzBuzzMuzz\\\\n12=>165:3*5*11:FizzBuzzDuzz\\\\n13=>195:3*5*13:FizzBuzzCazz\\\\n21=>1155:3*5*7*11:FizzBuzzMuzzDuzz\\\\n23=>2145:3*5*11*13:FizzBuzzDuzzCazz\\\\n24=>3003:3*7*11*13:FizzMuzzDuzzCazz\\\\n26=>15015:3*5*7*11*13:FizzBuzzMuzzDuzzCazz\\'\\n  ],\\n  \\'name\\':\\'FizzBuzzMultiplierAlgorithm\\',\\n  \\'winCode\\':\\'function program(index) {\\\\n    if (index < 1 || index > 26) {\\\\n        return \\\\\\\\'none\\\\\\\\';\\\\n    }\\\\n    \\\\n    const PRIMES = [3, 5, 7, 11, 13];\\\\n    \\\\n    let number = 0;\\\\n    let found = 0;\\\\n    \\\\n    const divisors = [];\\\\n    \\\\n    while (found != index) {\\\\n        number++;\\\\n        let rest = number;\\\\n        divisors.length = 0;\\\\n        \\\\n        for (let i = 0; i < PRIMES.length && rest > 1; i++) {\\\\n            if (rest <= PRIMES[i]) {\\\\n                break;\\\\n            }\\\\n            if (number % PRIMES[i] === 0) {\\\\n                divisors.push(PRIMES[i]);\\\\n                rest /= PRIMES[i];\\\\n            }\\\\n        }\\\\n        \\\\n        if (divisors.length > 1 && rest === 1) {\\\\n            found++;\\\\n        }\\\\n    }\\\\n    \\\\n    const divisorsStr = divisors.join(\\\\\\'*\\\\\\');\\\\n    return `${number}:${divisorsStr}:${fizzBuzz(number)}`;\\\\n}\\\\nfunction fizzBuzz(number) {\\\\n    const divisors = [3, 5, 7, 11, 13];\\\\n    const strings = [\\\\\\\\'Fizz\\\\\\\\', \\\\\\\\'Buzz\\\\\\\\', \\\\\\\\'Muzz\\\\\\\\', \\\\\\\\'Duzz\\\\\\\\', \\\\\\\\'Cazz\\\\\\\\'];\\\\n    let str = \\\\\\\\'\\\\\\\\';\\\\n    for (let i = 0; i < divisors.length; i++) {\\\\n        if (number % divisors[i] === 0) {\\\\n            str += strings[i];\\\\n        }\\\\n    }\\\\n    return str || number.toString();\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[36]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Write a method that divides two numbers in a column to within 100 digits. If there is a period in the result, it should be written as follows:\\\\n212/133 = 1.(593984962406015037)\\\\n87/78 = 1.1(153846)\\'\\n  ],\\n  \\'name\\':\\'LongDivisionAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n    let a = Number(input.split(\\\\\\\\',\\\\\\\\')[0]);\\\\n    let b = Number(input.split(\\\\\\\\',\\\\\\\\')[1]);\\\\n\\\\n    if (b === 0) {\\\\n        return \\\\\\\\'Div by zero error!\\\\\\\\';\\\\n    }\\\\n    if (a === 0) {\\\\n        return \\\\\\\\'0\\\\\\\\';\\\\n    }\\\\n    const isMinus = (a < 0 && b > 0 || a > 0 && b < 0);\\\\n    a = Math.abs(a);\\\\n    b = Math.abs(b);\\\\n\\\\n    const length = 100;\\\\n    const DOT = -1;\\\\n    const TEN = 10;\\\\n    const NOT_FOUND = -1;\\\\n\\\\n    const result = [];\\\\n\\\\n    const aa = new Array(length * 2).fill(0);\\\\n    let ia = 0;\\\\n    let ceilpos = 0;\\\\n\\\\n    let isCalcCeil = a >= b;\\\\n    if (!isCalcCeil) {\\\\n        result.push(\\\\\\\\'0\\\\\\\\', \\\\\\\\'.\\\\\\\\');\\\\n        aa[ia++] = 0;\\\\n        aa[ia++] = DOT;\\\\n        ceilpos = ia - 1;\\\\n    }\\\\n\\\\n    while (a != 0 && (result.length - ceilpos) <= length) {\\\\n        if (a < b) {\\\\n            if (isCalcCeil) {\\\\n                result.push(\\\\\\\\'.\\\\\\\\');\\\\n                aa[ia++] = DOT;\\\\n                ceilpos = ia - 1;\\\\n                isCalcCeil = false;\\\\n            }\\\\n            a *= TEN;\\\\n        }\\\\n        while (a < b) {\\\\n            result.push(\\\\\\\\'0\\\\\\\\');\\\\n            aa[ia++] = 0;\\\\n            a *= TEN;\\\\n        }\\\\n\\\\n        let found = NOT_FOUND;\\\\n        for (let ja = 0; ja < ia; ja++) {\\\\n            if (aa[ja] === a) {\\\\n                found = ja;\\\\n                break;\\\\n            }\\\\n        }\\\\n        if (found !== NOT_FOUND) {\\\\n            result.splice(found, 0, \\\\\\\\'(\\\\\\\\');\\\\n            result.push(\\\\\\\\')\\\\\\\\');\\\\n            break;\\\\n        }\\\\n\\\\n        const c = Math.floor(a / b);\\\\n        if (isCalcCeil) {\\\\n            let c1 = c;\\\\n            while (c1 / TEN > 10000000) {\\\\n                aa[ia++] = c1 % TEN;\\\\n                c1 = Math.floor(c1 / TEN);\\\\n            }\\\\n            aa[ia++] = c1;\\\\n        } else {\\\\n            aa[ia++] = a;\\\\n        }\\\\n        const d = a % b;\\\\n        result.push(c);\\\\n        a = d;\\\\n\\\\n    }\\\\n\\\\n    return ((isMinus) ? \\\\\\\\'-\\\\\\\\' : \\\\\\\\'\\\\\\\\') + result.join(\\\\\\\\'\\\\\\\\');\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[37]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'No more Levels. You win!\\'\\n  ],\\n  \\'name\\':\\'NullLevel\\',\\n  \\'winCode\\':\\'function program(question) {\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[3]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Given a list of integers, determine whether the sum of its elements is Odd or Even.\\',\\n    \\'Write a javascript method.\\',\\n    \\'You are given a string of space separated numbers.\\',\\n    \\'All numbers are valid Int32, no need to validate them.\\',\\n    \\'Give your answer as a string matching \\\\\\\\'odd\\\\\\\\' or \\\\\\\\'even\\\\\\\\'.\\',\\n    \\'Example:\\\\n0=>even\\\\n0 1 4=>odd\\\\n0 -1 -5=>even\\',\\n    \\'Don\\\\\\\\'t use comments for clarification.\\',\\n    \\'Make the code as readable and concise as possible.\\'\\n  ],\\n  \\'name\\':\\'OddOrEvenAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n  const result = input.split(\\\\\\' \\\\\\')\\\\n    .map(Number)\\\\n    .reduce((sum, num) => sum + num, 0);\\\\n  return result % 2 === 0 ? \\\\\\'even\\\\\\' : \\\\\\'odd\\\\\\';\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[4]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Double char?\\\\nGiven a string, you have to return a string in which each character (case-sensitive) is repeated once.\\\\nExamples (Input=>Output):\\\\nString=>SSttrriinngg\\\\nHello World=>HHeelllloo  WWoorrlldd\\\\n1234!_ =>11223344!!__  \\'\\n  ],\\n  \\'name\\':\\'DoubleCharAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n  return input.replace(/./g, \\\\\\\\'$&$&\\\\\\\\');\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[5]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Given the sequence: 1, 0, 3, 2, 5, 4, 7, 6, 9, 8, 11, 10, 13, 12, 15, 14...\\\\nThe sequence starts with element number 0: f(0)=1.\\\\nYour task is to write a function that returns the element at index n: f(n)=?\\'\\n  ],\\n  \\'name\\':\\'SimpleMathAlgorithm\\',\\n  \\'winCode\\':\\'function get(input) {\\\\n    let number = parseInt(input);\\\\n    return (number % 2 == 0)\\\\n        ? number + 1\\\\n        : number - 1;\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[6]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Write a function to convert a name into initials. \\\\nThis kata strictly takes two words with one space in between them.\\\\nThe output should be two capital letters with a dot separating them.\\\\nExample:\\\\nTom Harris=>T.H\\\\ngarlick looney=>G.L\\'\\n  ],\\n  \\'name\\':\\'NameIntoInitialsAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\nreturn input.split(\\\\\\' \\\\\\').map(w => w.substring(0, 1)).join(\\\\\\'.\\\\\\').toUpperCase();\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[7]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Hello there\\\\nYou are asked to square every digit of a number and concatenate them.\\\\nFor example, if we run 123 through the function, 149 will come out\\\\n because 1^2 is 1 and 2^2 is 4, 3^3=9. (1-4-9)\\\\nExample #2: An input of 465 will/should return 163625\\\\nbecause 4^2 is 16, 6^2 is 36, and 5^2 is 25. (16-36-25)\\\\n\\'\\n  ],\\n  \\'name\\':\\'ConcatenatedSquaresAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\nreturn Array.from(input)\\\\n    .map(Number)\\\\n    .map(d => d * d)\\\\n    .join(\\\\\\\\'\\\\\\\\');}\\'\\n}',\n" +
                        "  '[Level] Map[8]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'The sum of the squares of the first ten positive integers \\\\n1^2 + 2^2 + ... + 10^2 = 385. \\\\nAnd the square of the sum is \\\\n(1 + 2 + ... + 10)^2 = 55^2 = 3025. \\\\nTherefore, the difference between the sum of the squares and the square of the sum of the first ten natural numbers is equal to 3025 - 385 = 2640. \\\\nCreate a method that calculates the difference between the sum squares and the square of the sum for the natural number i.\\'\\n  ],\\n  \\'name\\':\\'SumSquareDifferenceAlgorithm\\',\\n  \\'winCode\\':\\'function program(question) {\\\\n    let number = parseInt(question);\\\\n    let sumOfSquares = (number * (number + 1) * (2 * number + 1)) / 6;\\\\n    let squareOfSum = Math.pow((number * (number + 1)) / 2, 2);\\\\n    return squareOfSum - sumOfSquares;\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[9]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.\\\\nAll numbers are valid Int32, no need to validate them.\\\\nThere will always be at least one number in the input string.\\\\nOutput string must be two numbers separated by a single space, and highest number is first.Example: 1 2 3 4 5=>5 1\\\\n1 2 -3 4 5=>5 -3\\\\n1 9 3 4 -5=>9 -5\\'\\n  ],\\n  \\'name\\':\\'HighestAndLowestAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n  const result = input\\\\n    .split(\\\\\\' \\\\\\')\\\\n    .map(Number)\\\\n    .reduce(\\\\n      (stats, num) => {\\\\n        stats.max = Math.max(stats.max, num);\\\\n        stats.min = Math.min(stats.min, num);\\\\n        return stats;\\\\n      },\\\\n      { max: -Infinity, min: Infinity }\\\\n    );\\\\n\\\\n  return `${result.max} ${result.min}`;\\'\\n}',\n" +
                        "  '[Score] A constant':100,\n" +
                        "  '[Score] B constant':3,\n" +
                        "  '[Score] C constant':30,\n" +
                        "  '[Score] D constant':10,\n" +
                        "  '[Score] Lose penalty':-100,\n" +
                        "  '[Score] Win score':30\n" +
                        "}",
                JsonUtils.prettyPrint(new GameSettings().asNameValueJson()));
    }

    @Test
    public void shouldGetAllSortedLevels() {
        assertEquals("[\n" +
                        "  {\n" +
                        "    'complexity':0,\n" +
                        "    'description':[\n" +
                        "      'Write a method that takes a single string argument and return the string 'world' if 'hello' came in.',\n" +
                        "      'Please write js method.',\n" +
                        "      'Now please improve the algorithm so that it returns'hello' if 'world' came in. Previous logic should work also',\n" +
                        "      'One more improvement: in other cases the algorithm should return the same string that came in.'\n" +
                        "    ],\n" +
                        "    'name':'HelloWorldAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      'hello=world',\n" +
                        "      'world=hello',\n" +
                        "      'qwe=qwe',\n" +
                        "      'asd=asd',\n" +
                        "      'zxc=zxc'\n" +
                        "    ],\n" +
                        "    'size':5\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':5,\n" +
                        "    'description':[\n" +
                        "      'Write a javascript method that takes one int argument and returns a string containing the number itself.',\n" +
                        "      'For those numbers that are divisible by 3, the method should return 'Fizz'',\n" +
                        "      'For those numbers divisible by 5 it should return 'Buzz'.',\n" +
                        "      'For those numbers divisible by both 3 and 5 - 'FizzBuzz'.',\n" +
                        "      'Proceed in the same way if there is a number with a divisor of 7. The word 'Muzz' is used for it. .',\n" +
                        "      'Please write optimized code without any duplication.',\n" +
                        "      'For divider 11 - the word must be 'Duzz'.',\n" +
                        "      'For divider 13 - the word must be 'Cazz'.',\n" +
                        "      'Please use a map with constants and dividers to avoid multiple ifs.'\n" +
                        "    ],\n" +
                        "    'name':'FizzBuzzAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '1=1',\n" +
                        "      '2=2',\n" +
                        "      '3=Fizz',\n" +
                        "      '4=4',\n" +
                        "      '5=Buzz',\n" +
                        "      '3=Fizz',\n" +
                        "      '7=Muzz',\n" +
                        "      '8=8',\n" +
                        "      '3=Fizz',\n" +
                        "      '5=Buzz',\n" +
                        "      '11=Duzz',\n" +
                        "      '3=Fizz',\n" +
                        "      '13=Cazz',\n" +
                        "      '7=Muzz',\n" +
                        "      '15=FizzBuzz',\n" +
                        "      '16=16',\n" +
                        "      '17=17',\n" +
                        "      '21=FizzMuzz',\n" +
                        "      '33=FizzDuzz',\n" +
                        "      '35=BuzzMuzz',\n" +
                        "      '39=FizzCazz',\n" +
                        "      '7=Muzz',\n" +
                        "      '55=BuzzDuzz',\n" +
                        "      '65=BuzzCazz',\n" +
                        "      '77=MuzzDuzz',\n" +
                        "      '91=MuzzCazz',\n" +
                        "      '105=FizzBuzzMuzz',\n" +
                        "      '165=FizzBuzzDuzz',\n" +
                        "      '195=FizzBuzzCazz',\n" +
                        "      '231=FizzMuzzDuzz',\n" +
                        "      '273=FizzMuzzCazz',\n" +
                        "      '385=BuzzMuzzDuzz',\n" +
                        "      '455=BuzzMuzzCazz',\n" +
                        "      '715=BuzzDuzzCazz',\n" +
                        "      '1001=MuzzDuzzCazz',\n" +
                        "      '1155=FizzBuzzMuzzDuzz',\n" +
                        "      '1365=FizzBuzzMuzzCazz',\n" +
                        "      '2145=FizzBuzzDuzzCazz',\n" +
                        "      '3003=FizzMuzzDuzzCazz',\n" +
                        "      '5005=BuzzMuzzDuzzCazz',\n" +
                        "      '15015=FizzBuzzMuzzDuzzCazz'\n" +
                        "    ],\n" +
                        "    'size':41\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':6,\n" +
                        "    'description':[\n" +
                        "      'Given a list of integers, determine whether the sum of its elements is Odd or Even.',\n" +
                        "      'Write a javascript method.',\n" +
                        "      'You are given a string of space separated numbers.',\n" +
                        "      'All numbers are valid Int32, no need to validate them.',\n" +
                        "      'Give your answer as a string matching 'odd' or 'even'.',\n" +
                        "      'Example:\\n0=>even\\n0 1 4=>odd\\n0 -1 -5=>even',\n" +
                        "      'Don't use comments for clarification.',\n" +
                        "      'Make the code as readable and concise as possible.'\n" +
                        "    ],\n" +
                        "    'name':'OddOrEvenAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '0=even',\n" +
                        "      '0 1 4=odd',\n" +
                        "      '0=even',\n" +
                        "      '0 1 4=odd',\n" +
                        "      '0 1 4=odd',\n" +
                        "      '0=even',\n" +
                        "      '0 1 4=odd',\n" +
                        "      '0=even',\n" +
                        "      '0 1 4=odd',\n" +
                        "      '0 1 4=odd',\n" +
                        "      '0=even',\n" +
                        "      '0=even',\n" +
                        "      '0=even',\n" +
                        "      '0=even',\n" +
                        "      '0 1 4=odd',\n" +
                        "      '0 1 4=odd',\n" +
                        "      '0=even',\n" +
                        "      '0=even',\n" +
                        "      '0 1 4=odd',\n" +
                        "      '0=even',\n" +
                        "      '0=even',\n" +
                        "      '0=even',\n" +
                        "      '0=even',\n" +
                        "      '0 1 4=odd',\n" +
                        "      '0=even',\n" +
                        "      '0=even'\n" +
                        "    ],\n" +
                        "    'size':26\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':7,\n" +
                        "    'description':[\n" +
                        "      'Double char?\\nGiven a string, you have to return a string in which each character (case-sensitive) is repeated once.\\nExamples (Input=>Output):\\nString=>SSttrriinngg\\nHello World=>HHeelllloo  WWoorrlldd\\n1234!_ =>11223344!!__  '\n" +
                        "    ],\n" +
                        "    'name':'DoubleCharAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      'String=SSttrriinngg',\n" +
                        "      'Hello World=HHeelllloo  WWoorrlldd',\n" +
                        "      '1234!_ =11223344!!__  ',\n" +
                        "      '____ _ _ __ ___ _ ____ =________  __  __  ____  ______  __  ________  ',\n" +
                        "      '(-_-)=((--__--))',\n" +
                        "      '123456=112233445566',\n" +
                        "      'Scrub Lords=SSccrruubb  LLoorrddss',\n" +
                        "      'bruh=bbrruuhh',\n" +
                        "      'illuminati=iilllluummiinnaattii',\n" +
                        "      'Adidas=AAddiiddaass',\n" +
                        "      '!#%G#DGY^RC=!!##%%GG##DDGGYY^^RRCC',\n" +
                        "      'Donald Duck=DDoonnaalldd  DDuucckk',\n" +
                        "      'Kanye 2020=KKaannyyee  22002200',\n" +
                        "      'Bernie Sanders is Bae=BBeerrnniiee  SSaannddeerrss  iiss  BBaaee',\n" +
                        "      'Peanut Butter=PPeeaannuutt  BBuutttteerr',\n" +
                        "      '1337=11333377',\n" +
                        "      'h*o@D7an& a=hh**oo@@DD77aann&&  aa',\n" +
                        "      'Y!S47Y @=YY!!SS4477YY  @@',\n" +
                        "      '.-&dFI8=..--&&ddFFII88',\n" +
                        "      '!Zq+=!!ZZqq++',\n" +
                        "      'g%;U*!a/[pZ4V3/&=gg%%;;UU**!!aa//[[ppZZ44VV33//&&',\n" +
                        "      '7f5nF=:b8eo&+7=77ff55nnFF==::bb88eeoo&&++77',\n" +
                        "      '*2SNm#Lo&Y=**22SSNNmm##LLoo&&YY',\n" +
                        "      '3ZVm=33ZZVVmm',\n" +
                        "      ']C06*Ec$62o!7][/9=]]CC0066**EEcc$$6622oo!!77]][[//99',\n" +
                        "      '^q%]VoKhh9j5-=^^qq%%]]VVooKKhhhh99jj55--',\n" +
                        "      '$2EZGQ=$$22EEZZGGQQ',\n" +
                        "      '`U9@h=``UU99@@hh',\n" +
                        "      'k^F [=kk^^FF  [[',\n" +
                        "      '@Y(-SAZa<S2OS**i=@@YY((--SSAAZZaa<<SS22OOSS****ii',\n" +
                        "      'h*?RW_i+<=hh**??RRWW__ii++<<',\n" +
                        "      'FACBT+3YC9m3+a0Q=FFAACCBBTT++33YYCC99mm33++aa00QQ',\n" +
                        "      'KS):jY?+S9=KKSS))::jjYY??++SS99',\n" +
                        "      'JBWh=JJBBWWhh',\n" +
                        "      'ONm3l))H@Gf(=OONNmm33ll))))HH@@GGff((',\n" +
                        "      'fk6Kg 7&=ffkk66KKgg  77&&',\n" +
                        "      '*A&2SJUb#(Vc(OjC`W1=**AA&&22SSJJUUbb##((VVcc((OOjjCC``WW11',\n" +
                        "      '`S9ONu001E83+!=``SS99OONNuu000011EE8833++!!',\n" +
                        "      '(YQ^/2]7c$8L*,]:+=((YYQQ^^//22]]77cc$$88LL**,,]]::++',\n" +
                        "      '7Pla G3*C[=%`d=l$=77PPllaa  GG33**CC[[==%%``dd==ll$$',\n" +
                        "      '12mq,<[:FdF&^2P=1122mmqq,,<<[[::FFddFF&&^^22PP',\n" +
                        "      'l#NRT7nn+p&=ll##NNRRTT77nnnn++pp&&',\n" +
                        "      '9.d(Q;D(L.*=99..dd((QQ;;DD((LL..**',\n" +
                        "      'nq0CMEg`)?nJ$M$GG;,;>=nnqq00CCMMEEgg``))??nnJJ$$MM$$GGGG;;,,;;>>'\n" +
                        "    ],\n" +
                        "    'size':44\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':8,\n" +
                        "    'description':[\n" +
                        "      'Given the sequence: 1, 0, 3, 2, 5, 4, 7, 6, 9, 8, 11, 10, 13, 12, 15, 14...\\nThe sequence starts with element number 0: f(0)=1.\\nYour task is to write a function that returns the element at index n: f(n)=?'\n" +
                        "    ],\n" +
                        "    'name':'SimpleMathAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '0=1',\n" +
                        "      '1=0',\n" +
                        "      '2=3',\n" +
                        "      '3=2',\n" +
                        "      '5=4',\n" +
                        "      '7=6',\n" +
                        "      '9=8',\n" +
                        "      '11=10',\n" +
                        "      '14=15',\n" +
                        "      '17=16',\n" +
                        "      '20=21',\n" +
                        "      '23=22',\n" +
                        "      '26=27',\n" +
                        "      '29=28',\n" +
                        "      '33=32',\n" +
                        "      '37=36',\n" +
                        "      '41=40',\n" +
                        "      '45=44',\n" +
                        "      '50=51',\n" +
                        "      '55=54',\n" +
                        "      '60=61',\n" +
                        "      '65=64',\n" +
                        "      '70=71',\n" +
                        "      '75=74',\n" +
                        "      '81=80',\n" +
                        "      '87=86'\n" +
                        "    ],\n" +
                        "    'size':26\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':9,\n" +
                        "    'description':[\n" +
                        "      'Write a function to convert a name into initials. \\nThis kata strictly takes two words with one space in between them.\\nThe output should be two capital letters with a dot separating them.\\nExample:\\nTom Harris=>T.H\\ngarlick looney=>G.L'\n" +
                        "    ],\n" +
                        "    'name':'NameIntoInitialsAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      'Tom Harris=T.H',\n" +
                        "      'garlick looney=G.L',\n" +
                        "      'Ethan parker=E.P',\n" +
                        "      'olivia Campbell=O.C',\n" +
                        "      'Liam Jenkins=L.J',\n" +
                        "      'Emma Bryant=E.B',\n" +
                        "      'Noah Reed=N.R',\n" +
                        "      'Ava Coleman=A.C',\n" +
                        "      'William Barnes=W.B',\n" +
                        "      'Sophia Mitchell=S.M',\n" +
                        "      'James Hughes=J.H',\n" +
                        "      'Isabella Foster=I.F',\n" +
                        "      'Benjamin Evans=B.E',\n" +
                        "      'Mia Murphy=M.M',\n" +
                        "      'Mason Richardson=M.R',\n" +
                        "      'Charlotte Peterson=C.P',\n" +
                        "      'Elijah Cooper=E.C',\n" +
                        "      'Ava Coleman=A.C',\n" +
                        "      'Alexander Griffin=A.G',\n" +
                        "      'Harper Brooks=H.B',\n" +
                        "      'Daniel Turner=D.T',\n" +
                        "      'Abigail Kelly=A.K',\n" +
                        "      'Henry Price=H.P',\n" +
                        "      'Emily Ross=E.R',\n" +
                        "      'Samuel Ward=S.W',\n" +
                        "      'Elizabeth Morgan=E.M',\n" +
                        "      'Joseph Watson=J.W',\n" +
                        "      'Emma Bryant=E.B',\n" +
                        "      'David Bailey=D.B',\n" +
                        "      'Avery Howard=A.H',\n" +
                        "      'Michael Nelson=M.N',\n" +
                        "      'Lily Anderson=L.A'\n" +
                        "    ],\n" +
                        "    'size':32\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':10,\n" +
                        "    'description':[\n" +
                        "      'Hello there\\nYou are asked to square every digit of a number and concatenate them.\\nFor example, if we run 123 through the function, 149 will come out\\n because 1^2 is 1 and 2^2 is 4, 3^3=9. (1-4-9)\\nExample #2: An input of 465 will/should return 163625\\nbecause 4^2 is 16, 6^2 is 36, and 5^2 is 25. (16-36-25)\\n'\n" +
                        "    ],\n" +
                        "    'name':'ConcatenatedSquaresAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '123=149',\n" +
                        "      '465=163625',\n" +
                        "      '0=0',\n" +
                        "      '5813=256419',\n" +
                        "      '7264=4943616',\n" +
                        "      '1369=193681',\n" +
                        "      '7952=4981254',\n" +
                        "      '9425=8116425',\n" +
                        "      '4759=16492581',\n" +
                        "      '4777=16494949',\n" +
                        "      '2040=40160',\n" +
                        "      '6176=3614936',\n" +
                        "      '1308=19064',\n" +
                        "      '2784=4496416',\n" +
                        "      '1868=1643664',\n" +
                        "      '4289=1646481',\n" +
                        "      '8703=644909',\n" +
                        "      '1690=136810',\n" +
                        "      '2722=44944',\n" +
                        "      '2332=4994',\n" +
                        "      '5152=251254',\n" +
                        "      '1399=198181',\n" +
                        "      '794=498116',\n" +
                        "      '9906=8181036',\n" +
                        "      '2157=412549',\n" +
                        "      '586=256436',\n" +
                        "      '720=4940',\n" +
                        "      '8626=6436436'\n" +
                        "    ],\n" +
                        "    'size':28\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':11,\n" +
                        "    'description':[\n" +
                        "      'The sum of the squares of the first ten positive integers \\n1^2 + 2^2 + ... + 10^2 = 385. \\nAnd the square of the sum is \\n(1 + 2 + ... + 10)^2 = 55^2 = 3025. \\nTherefore, the difference between the sum of the squares and the square of the sum of the first ten natural numbers is equal to 3025 - 385 = 2640. \\nCreate a method that calculates the difference between the sum squares and the square of the sum for the natural number i.'\n" +
                        "    ],\n" +
                        "    'name':'SumSquareDifferenceAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '1=0',\n" +
                        "      '2=4',\n" +
                        "      '3=22',\n" +
                        "      '4=70',\n" +
                        "      '5=170',\n" +
                        "      '6=350',\n" +
                        "      '7=644',\n" +
                        "      '8=1092',\n" +
                        "      '9=1740',\n" +
                        "      '10=2640',\n" +
                        "      '11=3850',\n" +
                        "      '12=5434',\n" +
                        "      '13=7462',\n" +
                        "      '14=10010',\n" +
                        "      '15=13160',\n" +
                        "      '16=17000',\n" +
                        "      '17=21624',\n" +
                        "      '18=27132',\n" +
                        "      '19=33630',\n" +
                        "      '20=41230',\n" +
                        "      '21=50050',\n" +
                        "      '22=60214',\n" +
                        "      '23=71852',\n" +
                        "      '24=85100',\n" +
                        "      '25=100100'\n" +
                        "    ],\n" +
                        "    'size':25\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':12,\n" +
                        "    'description':[\n" +
                        "      'In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.\\nAll numbers are valid Int32, no need to validate them.\\nThere will always be at least one number in the input string.\\nOutput string must be two numbers separated by a single space, and highest number is first.Example: 1 2 3 4 5=>5 1\\n1 2 -3 4 5=>5 -3\\n1 9 3 4 -5=>9 -5'\n" +
                        "    ],\n" +
                        "    'name':'HighestAndLowestAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '1 2 3 4 5=5 1',\n" +
                        "      '1 2 -3 4 5=5 -3',\n" +
                        "      '1 9 3 4 -5=9 -5',\n" +
                        "      '8 3 -5 42 -1 0 0 -9 4 7 4 -4=42 -9',\n" +
                        "      '1 2 3=3 1',\n" +
                        "      '1=1 1',\n" +
                        "      '-1=-1 -1',\n" +
                        "      '-1 -1 0=0 -1',\n" +
                        "      '1 1 0=1 0',\n" +
                        "      '-1=-1 -1',\n" +
                        "      '1 -1 0=1 -1',\n" +
                        "      '10 2 -1 -20=10 -20',\n" +
                        "      '452 561 -686 679 476 -515 805 -739 571 791=805 -739',\n" +
                        "      '-983 -111 -332 -973 47 728=728 -983',\n" +
                        "      '268 -359 -513 -9 -86 -142 -779=268 -779',\n" +
                        "      '556 32 866 -730 -367 -937 367 888 43 -510 773=888 -937',\n" +
                        "      '646 261 609 -82 949 526 -449 -594 894=949 -594',\n" +
                        "      '-950 909 424 834 -579 -275 -901 444=909 -950',\n" +
                        "      '-857 43 444 158 510 -879 -350 705=705 -879',\n" +
                        "      '-961 908 -769 980 407 -651 550 671 -996 215=980 -996',\n" +
                        "      '483 -83 -229 -373 -812 335 -802=483 -812',\n" +
                        "      '-968 -692 -566 -31 333 831 81 -476 828 -232=831 -968',\n" +
                        "      '4 5 29 54 4 0 -214 542 -64 1 -3 6 -6=542 -214'\n" +
                        "    ],\n" +
                        "    'size':23\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':13,\n" +
                        "    'description':[\n" +
                        "      'Oh my, it seems that trolls have taken over your comment section!\\nHowever, fear not, for there is a simple solution to deal with these troublesome creatures.\\nYou may remove all vowels from their comments, rendering them powerless.\\nI implore you to create a function that can execute this task, for instance,\\ntransforming \\'This website is for losers LOL!\\' into \\'Ths wbst s fr lsrs LL!\\'. \\nPlease take note that for this exercise, the letter 'y' is not considered a vowel.'\n" +
                        "    ],\n" +
                        "    'name':'RemoveVowelsAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      'Hello World!!=Hll Wrld!!',\n" +
                        "      'The quick brown fox jumps over the lazy dog.=Th qck brwn fx jmps vr th lzy dg.',\n" +
                        "      'To be or not to be, that is the question.=T b r nt t b, tht s th qstn.',\n" +
                        "      'The world is a book, and those who do not travel read only a page.=Th wrld s  bk, nd ths wh d nt trvl rd nly  pg.',\n" +
                        "      'The five boxing wizards jump quickly.=Th fv bxng wzrds jmp qckly.',\n" +
                        "      'Why did the tomato turn red? Because it saw the salad dressing!=Why dd th tmt trn rd? Bcs t sw th sld drssng!',\n" +
                        "      'She sells seashells by the seashore.=Sh slls sshlls by th sshr.',\n" +
                        "      'How much wood would a woodchuck chuck if a woodchuck could chuck wood?=Hw mch wd wld  wdchck chck f  wdchck cld chck wd?',\n" +
                        "      'All work and no play makes Jack a dull boy.=ll wrk nd n ply mks Jck  dll by.',\n" +
                        "      'The cat in the hat had a bat and a hat.=Th ct n th ht hd  bt nd  ht.',\n" +
                        "      'I before E except after C.= bfr  xcpt ftr C.',\n" +
                        "      'The rain in Spain stays mainly in the plain.=Th rn n Spn stys mnly n th pln.',\n" +
                        "      'Supercalifragilisticexpialidocious.=Sprclfrglstcxpldcs.'\n" +
                        "    ],\n" +
                        "    'size':13\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':14,\n" +
                        "    'description':[\n" +
                        "      'Check to see if a string has the same amount of 'x's and 'o's.\\nThe method must return a boolean and be case insensitive. The string can contain any char.\\nExamples input/output:\\nooxx=>true\\nxooxx=>false\\nooxXm=>true\\nzpzpzpp=>true // when no 'x' and 'o' is present should return true\\nzzoo=>false'\n" +
                        "    ],\n" +
                        "    'name':'ExesAndOhsAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      'ooxx=true',\n" +
                        "      'xooxx=false',\n" +
                        "      'ooxx=true',\n" +
                        "      'ooxx=true',\n" +
                        "      'xooxx=false',\n" +
                        "      'ooxx=true',\n" +
                        "      'ooxx=true',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'ooxx=true',\n" +
                        "      'xooxx=false',\n" +
                        "      'ooxx=true',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'ooxx=true',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'ooxx=true',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'ooxx=true',\n" +
                        "      'ooxx=true',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false',\n" +
                        "      'xooxx=false'\n" +
                        "    ],\n" +
                        "    'size':41\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':15,\n" +
                        "    'description':[\n" +
                        "      'The order matters...\\n Everything is quite simple. \\nIn a string of three characters, the last character becomes the first one,\\n and the first two characters shift one position to the right. \\nFor example: abc=>cab...'\n" +
                        "    ],\n" +
                        "    'name':'CharOrderAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      'abc=cab',\n" +
                        "      'cad=dca',\n" +
                        "      'asd=das',\n" +
                        "      'xyz=zxy',\n" +
                        "      'aaa=aaa',\n" +
                        "      '123=312',\n" +
                        "      'dEf=fdE',\n" +
                        "      'zxc=czx',\n" +
                        "      'qwe=eqw',\n" +
                        "      'rty=yrt',\n" +
                        "      'mnb=bmn',\n" +
                        "      'vbn=nvb',\n" +
                        "      'fgh=hfg',\n" +
                        "      'ijk=kij',\n" +
                        "      'lmn=nlm',\n" +
                        "      'pqr=rpq',\n" +
                        "      'stu=ust',\n" +
                        "      'wxy=ywx',\n" +
                        "      '222=222',\n" +
                        "      '789=978',\n" +
                        "      '090=009'\n" +
                        "    ],\n" +
                        "    'size':21\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':16,\n" +
                        "    'description':[\n" +
                        "      'An isogram is a word that has no repeating letters, consecutive or non-consecutive.\\nImplement a function that determines whether a string that contains only letters is an isogram.\\nAssume the empty string is an isogram. Ignore letter case.\\nConjugated=>true\\ncappa=>false\\nmoOn=>false'\n" +
                        "    ],\n" +
                        "    'name':'IsogramWordsAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      'Dermatoglyphics=true',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'Dermatoglyphics=true',\n" +
                        "      'Dermatoglyphics=true',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'Dermatoglyphics=true',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'Dermatoglyphics=true',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'Dermatoglyphics=true',\n" +
                        "      'Dermatoglyphics=true',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'cappa=false',\n" +
                        "      'Dermatoglyphics=true',\n" +
                        "      'Dermatoglyphics=true'\n" +
                        "    ],\n" +
                        "    'size':34\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':17,\n" +
                        "    'description':[\n" +
                        "      'Rent car cost calculator\\n Every day you rent the car costs $40. If you rent the car for 7 or more days, you get $50 off your total. \\nAlternatively, if you rent the car for 3 or more days, you get $20 off your total.\\nWrite a code that gives out the total amount for different days(d).Example: 1=>40, 2=>80, 3=>100, 4=>140, 6=>220, 7=>230, 15=>550'\n" +
                        "    ],\n" +
                        "    'name':'RentCarCostCalculatorAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '1=40',\n" +
                        "      '2=80',\n" +
                        "      '3=100',\n" +
                        "      '4=140',\n" +
                        "      '5=180',\n" +
                        "      '6=220',\n" +
                        "      '7=230',\n" +
                        "      '8=270',\n" +
                        "      '9=310',\n" +
                        "      '10=350',\n" +
                        "      '22=830',\n" +
                        "      '33=1270',\n" +
                        "      '44=1710',\n" +
                        "      '55=2150',\n" +
                        "      '66=2590',\n" +
                        "      '77=3030',\n" +
                        "      '88=3470',\n" +
                        "      '99=3910',\n" +
                        "      '100=3950'\n" +
                        "    ],\n" +
                        "    'size':19\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':20,\n" +
                        "    'description':[\n" +
                        "      'Remove all adjacent duplicate characters from a string, as soon as you encounter them walking left to right, and ensuring that at the end NO two adjacent characters remain.\\nExample: abc=>abc\\nabbc=>ac\\nabbbc=>ac\\nabbcccbad=>abad'\n" +
                        "    ],\n" +
                        "    'name':'DuplicateRemoveAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      'a=a',\n" +
                        "      'abc=abc',\n" +
                        "      'abcba=abcba',\n" +
                        "      'aa=',\n" +
                        "      'aa=',\n" +
                        "      'aaabaa=b',\n" +
                        "      'aaabaa=b',\n" +
                        "      'abaa=ab',\n" +
                        "      'aa=',\n" +
                        "      'aa=',\n" +
                        "      'aa=',\n" +
                        "      'bcdeeedcbabcde=abcde',\n" +
                        "      'aa=',\n" +
                        "      'beellllgrhhoyy=bgro',\n" +
                        "      'abbcccbad=abad',\n" +
                        "      'abccbbad=d',\n" +
                        "      'abcdeffedcbar=r',\n" +
                        "      'aa=',\n" +
                        "      'aa=',\n" +
                        "      'ddllppppccffmmkkkkjjggggffvvvuaaoooxtttnyyrffbbbbiqqdddd=uxnri',\n" +
                        "      'tnnnnnnnddddccccccckcmkkvvvbbbqqqqddannnnmbbbbsssww=tkcmam',\n" +
                        "      'paoooovvviiggggyyyynnnnhhhrjxbbbbbbfjjjjyaaaddqqbbbccueebbbbbbgwoii=parjxfyugwo',\n" +
                        "      'ssssiiiijjjwrbbbvvvlllkkkkesssddcnoarrrbbooyyyydssszzzeeewwy=wrecnoady',\n" +
                        "      'aahhhhvvvviiiiaaabbbbmmmwwwwwzzkkkkyyhhzzzzkkkkcee=c'\n" +
                        "    ],\n" +
                        "    'size':24\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':21,\n" +
                        "    'description':[\n" +
                        "      'Think like a child...\\n Implement an algorithm that can solve the following tasks:For example: \\n8809 = 6\\n7111 = 0\\n2172 = 0\\n6666 = 4\\n1111 = 0\\n3213 = 0\\n7662 = 2\\n9312 = 1\\n0000 = 4\\n2222 = 0\\n3333 = 0\\n5555 = 0\\n8193 = 3\\n8096 = 5\\n7777 = 0\\n9999 = 4'\n" +
                        "    ],\n" +
                        "    'name':'ThinkLikeAChildAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '0000=4',\n" +
                        "      '0123=1',\n" +
                        "      '0123=1',\n" +
                        "      '0000=4',\n" +
                        "      '1111=0',\n" +
                        "      '3366=2',\n" +
                        "      '8899=6',\n" +
                        "      '0896=5',\n" +
                        "      '1111=0',\n" +
                        "      '1111=0',\n" +
                        "      '3366=2',\n" +
                        "      '8899=6',\n" +
                        "      '1111=0',\n" +
                        "      '1111=0',\n" +
                        "      '0000=4',\n" +
                        "      '1111=0',\n" +
                        "      '3366=2',\n" +
                        "      '0123=1',\n" +
                        "      '1111=0',\n" +
                        "      '1111=0',\n" +
                        "      '8193=3',\n" +
                        "      '0896=5',\n" +
                        "      '1111=0',\n" +
                        "      '0000=4',\n" +
                        "      '0123=1',\n" +
                        "      '8193=3',\n" +
                        "      '0896=5',\n" +
                        "      '1111=0',\n" +
                        "      '0896=5',\n" +
                        "      '0896=5',\n" +
                        "      '0896=5',\n" +
                        "      '0896=5',\n" +
                        "      '9298089492=9',\n" +
                        "      '0000=4',\n" +
                        "      '8899=6',\n" +
                        "      '0000000000=10'\n" +
                        "    ],\n" +
                        "    'size':36\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':22,\n" +
                        "    'description':[\n" +
                        "      'If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.\\nThe sum of these multiples is 23.\\nFinish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.\\nAdditionally, if the number is negative, return 0 (for languages that do have them).\\nNote: If the number is a multiple of both 3 and 5, only count it once.'\n" +
                        "    ],\n" +
                        "    'name':'MultiplesThreeOrFiveAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '10=23',\n" +
                        "      '20=78',\n" +
                        "      '30=195',\n" +
                        "      '100=2318',\n" +
                        "      '200=9168',\n" +
                        "      '300=20850',\n" +
                        "      '500=57918',\n" +
                        "      '1000=233168',\n" +
                        "      '2000=931668',\n" +
                        "      '3000=2098500',\n" +
                        "      '5000=5829168',\n" +
                        "      '10000=23331668',\n" +
                        "      '22222=115229219',\n" +
                        "      '66666=1036996298',\n" +
                        "      '99999=2333216669',\n" +
                        "      '1234567=355636612814',\n" +
                        "      '7654321=13670680581720'\n" +
                        "    ],\n" +
                        "    'size':17\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':23,\n" +
                        "    'description':[\n" +
                        "      'Credit Card Number...\\n I will give you the first 15 digits of the credit card number. \\nYou need to generate the last, 16th digit.\\nPlease provide only the last digit as the answer.\\nCorrect credit card number example: 4561261212345467Answer example: 456126121234546=>7'\n" +
                        "    ],\n" +
                        "    'name':'CreditCardNumberAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '456126121234546=7',\n" +
                        "      '123456781234567=0',\n" +
                        "      '183168009579826=2',\n" +
                        "      '456126121234546=7',\n" +
                        "      '613951967276640=9',\n" +
                        "      '456126121234546=7',\n" +
                        "      '613951967276640=9',\n" +
                        "      '456126121234546=7',\n" +
                        "      '123456781234567=0',\n" +
                        "      '456126121234546=7',\n" +
                        "      '210087745295982=4',\n" +
                        "      '183168009579826=2',\n" +
                        "      '894632429803471=5',\n" +
                        "      '894632429803471=5',\n" +
                        "      '916471602234329=1',\n" +
                        "      '210087745295982=4',\n" +
                        "      '894632429803471=5',\n" +
                        "      '210087745295982=4',\n" +
                        "      '183168009579826=2',\n" +
                        "      '183168009579826=2',\n" +
                        "      '916471602234329=1',\n" +
                        "      '183168009579826=2',\n" +
                        "      '894632429803471=5',\n" +
                        "      '916471602234329=1',\n" +
                        "      '916471602234329=1',\n" +
                        "      '123456781234567=0',\n" +
                        "      '576080532156469=3'\n" +
                        "    ],\n" +
                        "    'size':27\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':24,\n" +
                        "    'description':[\n" +
                        "      'The structure of the DNA double helix (type B-DNA).\\nIf you want to know more: http://en.wikipedia.org/wiki/DNA\\n\\nIn DNA strings, symbols 'A' and 'T' are complements of each other, as 'C' and 'G'. \\nYour function receives one side of the DNA (string). \\nYou need to return the other complementary side. \\nDNA strand is never empty or there is no DNA at all (again, except for Haskell).\\nExample: TTTT=>AAAA, TAACG=>ATTGC etc.'\n" +
                        "    ],\n" +
                        "    'name':'DNASequenceAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      'TTTT=AAAA',\n" +
                        "      'AAAA=TTTT',\n" +
                        "      'TAACG=ATTGC',\n" +
                        "      'ATTGC=TAACG',\n" +
                        "      'CATA=GTAT',\n" +
                        "      'GTAT=CATA',\n" +
                        "      'TAGCCTAGCT=ATCGGATCGA',\n" +
                        "      'GATCGATCGA=CTAGCTAGCT',\n" +
                        "      'CTAGCTAGCTAGCTAGCT=GATCGATCGATCGATCGA',\n" +
                        "      'ACGTAGCTAGCTAGCTA=TGCATCGATCGATCGAT',\n" +
                        "      'CTAGCTAGCTAGCTAGCTAGCTAGCT=GATCGATCGATCGATCGATCGATCGA',\n" +
                        "      'GCTAGCTAGCTAGCTAGCTAGCTAGC=CGATCGATCGATCGATCGATCGATCG',\n" +
                        "      'CTAGCTAGCTAGCTAGCTAGCTAGCTAGC=GATCGATCGATCGATCGATCGATCGATCG',\n" +
                        "      'AGCTAGCTAGCTAGCTAGCTAGCTAGCTA=TCGATCGATCGATCGATCGATCGATCGAT',\n" +
                        "      'GCTAGCTAGCTAGCTAGCTAGCTAGCTAGC=CGATCGATCGATCGATCGATCGATCGATCG',\n" +
                        "      'CTAGCTAGCTAGCTAGCTAGCTAGCTAGCT=GATCGATCGATCGATCGATCGATCGATCGA',\n" +
                        "      'ATCGATCGATCGATCGATC=TAGCTAGCTAGCTAGCTAG',\n" +
                        "      'CATCGATCGATCGATCGA=GTAGCTAGCTAGCTAGCT',\n" +
                        "      'GATCGATCGATCGATCGATCGAT=CTAGCTAGCTAGCTAGCTAGCTA',\n" +
                        "      'TCGATCGATCGATCGATCGA=AGCTAGCTAGCTAGCTAGCT',\n" +
                        "      'GATCGATCGATCGATCGATCGATC=CTAGCTAGCTAGCTAGCTAGCTAG',\n" +
                        "      'CTAGCTAGCTAGCTAGCTAG=GATCGATCGATCGATCGATC',\n" +
                        "      'ACGTACGTACGTACGTAC=TGCATGCATGCATGCATG',\n" +
                        "      'CACGACGACGACGACGA=GTGCTGCTGCTGCTGCT',\n" +
                        "      'GTCAGTCAGTCAGTCA=CAGTCAGTCAGTCAGT',\n" +
                        "      'CTAGCTAGCTAGCTAGC=GATCGATCGATCGATCG',\n" +
                        "      'GTATCGATCGATCGATCGATTATATTTTCGACGAGATTTAAATATATATATATACGAGAGAATACAGATAGACAGATTA=CATAGCTAGCTAGCTAGCTAATATAAAAGCTGCTCTAAATTTATATATATATATGCTCTCTTATGTCTATCTGTCTAAT'\n" +
                        "    ],\n" +
                        "    'size':27\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':25,\n" +
                        "    'description':[\n" +
                        "      'You are going to be given a word. \\nYour job is to return the middle character of the word. \\nIf the word's length is odd, return the middle character. \\nIf the word's length is even, return the middle 2 characters.\\n#Examples:test=>es, testing=>t, middle=>dd, A=>A'\n" +
                        "    ],\n" +
                        "    'name':'MiddleCharacterAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      'test=es',\n" +
                        "      'testing=t',\n" +
                        "      'middle=dd',\n" +
                        "      'A=A',\n" +
                        "      'Hello=l',\n" +
                        "      'Java=av',\n" +
                        "      'OpenAI=en',\n" +
                        "      'testing=t',\n" +
                        "      'testing=t',\n" +
                        "      'Programming=a',\n" +
                        "      'Algorithm=r',\n" +
                        "      'DataStructures=ru',\n" +
                        "      'Hello, World!= ',\n" +
                        "      'Hello, World!= ',\n" +
                        "      'OpenAI ChatGPT= C',\n" +
                        "      '12345=3',\n" +
                        "      'ABCDE=C',\n" +
                        "      'Testing 123=n',\n" +
                        "      'Hello, World!= ',\n" +
                        "      'Hello, World!= ',\n" +
                        "      'OpenAI Model=I ',\n" +
                        "      'Hello, World!= '\n" +
                        "    ],\n" +
                        "    'size':22\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':26,\n" +
                        "    'description':[\n" +
                        "      'Order matters...\\nYou need to work with three-digit numbers. \\nSolve the algorithm for changing the number according to the given examples: \\nExamples: 111=>222, 123=>423, 679=>078, 999=>000, 012=>312, 090=>110, 444=>555, 090=>110, 916=>702'\n" +
                        "    ],\n" +
                        "    'name':'NumberOrderAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '111=222',\n" +
                        "      '222=333',\n" +
                        "      '333=444',\n" +
                        "      '444=555',\n" +
                        "      '555=666',\n" +
                        "      '100=121',\n" +
                        "      '123=423',\n" +
                        "      '999=000',\n" +
                        "      '789=089',\n" +
                        "      '000=111',\n" +
                        "      '909=001',\n" +
                        "      '090=110'\n" +
                        "    ],\n" +
                        "    'size':12\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':27,\n" +
                        "    'description':[\n" +
                        "      'Continue the sequence 101, 112, 131, 415, 161, 718... \\ni.e f(1) = 101, f(2) = 112, ...\\nHint: Look at the whole picture'\n" +
                        "    ],\n" +
                        "    'name':'Sequence1Algorithm',\n" +
                        "    'qa':[\n" +
                        "      '1=101',\n" +
                        "      '2=112',\n" +
                        "      '3=131',\n" +
                        "      '4=415',\n" +
                        "      '5=161',\n" +
                        "      '6=718',\n" +
                        "      '7=192',\n" +
                        "      '8=021',\n" +
                        "      '9=222',\n" +
                        "      '10=324',\n" +
                        "      '11=252',\n" +
                        "      '12=627',\n" +
                        "      '13=282',\n" +
                        "      '14=930',\n" +
                        "      '15=313',\n" +
                        "      '16=233',\n" +
                        "      '17=343',\n" +
                        "      '18=536',\n" +
                        "      '19=373',\n" +
                        "      '20=839',\n" +
                        "      '21=404',\n" +
                        "      '22=142',\n" +
                        "      '23=434',\n" +
                        "      '24=445',\n" +
                        "      '25=464'\n" +
                        "    ],\n" +
                        "    'size':25\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':28,\n" +
                        "    'description':[\n" +
                        "      'Please implement algorithm that converts number from one numeral system to another. Method should accept number, source numeral system and target numeral system.'\n" +
                        "    ],\n" +
                        "    'name':'NumeralSystemAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '10, 10, 10=10',\n" +
                        "      '10, 10, 2=1010',\n" +
                        "      '10, 2, 10=2',\n" +
                        "      '1000, 10, 16=3e8',\n" +
                        "      '1000, 16, 10=4096',\n" +
                        "      '1000, 16, 2=1000000000000',\n" +
                        "      '1ACD, 16, 2=1101011001101',\n" +
                        "      'ABCD, 16, 2=1010101111001101',\n" +
                        "      '34BE, 16, 10=13502',\n" +
                        "      '1000, 2, 16=8',\n" +
                        "      '1010, 2, 16=a',\n" +
                        "      '1010101, 2, 4=1111',\n" +
                        "      '1010101, 2, 6=221',\n" +
                        "      '1010101, 2, 8=125',\n" +
                        "      '1010101, 2, 10=85',\n" +
                        "      '1010101, 2, 12=71',\n" +
                        "      '1010101, 2, 14=61',\n" +
                        "      '1010101, 2, 16=55',\n" +
                        "      '0, 2, 16=0',\n" +
                        "      '360, 10, 60=360',\n" +
                        "      '360, 10, 12=260'\n" +
                        "    ],\n" +
                        "    'size':21\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':30,\n" +
                        "    'description':[\n" +
                        "      'Make a method that returns a Fibonacci number from the series by its number:\\nf(0) = 0\\nf(1) = 1\\nf(2) = 0 + 1 = 1\\nf(3) = 1 + 1 = 2\\nf(4) = 1 + 2 = 3\\nf(5) = 2 + 3 = 5\\nf(6) = 3 + 5 = 8\\nf(7) = 5 + 8 = 13\\nf(8) = 8 + 13 = 21\\nf(9) = 13 + 21 = 34\\netc...'\n" +
                        "    ],\n" +
                        "    'name':'FibonacciNumbersAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '1=1',\n" +
                        "      '1=1',\n" +
                        "      '3=2',\n" +
                        "      '4=3',\n" +
                        "      '5=5',\n" +
                        "      '6=8',\n" +
                        "      '7=13',\n" +
                        "      '8=21',\n" +
                        "      '9=34',\n" +
                        "      '10=55',\n" +
                        "      '11=89',\n" +
                        "      '12=144',\n" +
                        "      '13=233',\n" +
                        "      '14=377',\n" +
                        "      '15=610',\n" +
                        "      '16=987',\n" +
                        "      '17=1597',\n" +
                        "      '18=2584',\n" +
                        "      '19=4181',\n" +
                        "      '20=6765',\n" +
                        "      '21=10946',\n" +
                        "      '22=17711',\n" +
                        "      '23=28657',\n" +
                        "      '24=46368',\n" +
                        "      '25=75025'\n" +
                        "    ],\n" +
                        "    'size':25\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':35,\n" +
                        "    'description':[\n" +
                        "      'Divide an integer into multiples of prime numbers:\\n1 -> [1]\\n2 -> [2]\\n3 -> [3]\\n4 -> [2,2]\\n6 -> [2,3]\\n9 -> [3,3]\\n12 -> [2,2,3]\\n15 -> [3,5]\\netc...'\n" +
                        "    ],\n" +
                        "    'name':'PrimeFactoryAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '1=[1]',\n" +
                        "      '2=[2]',\n" +
                        "      '3=[3]',\n" +
                        "      '4=[2,2]',\n" +
                        "      '5=[5]',\n" +
                        "      '6=[2,3]',\n" +
                        "      '7=[7]',\n" +
                        "      '8=[2,2,2]',\n" +
                        "      '9=[3,3]',\n" +
                        "      '10=[2,5]',\n" +
                        "      '11=[11]',\n" +
                        "      '12=[2,2,3]',\n" +
                        "      '13=[13]',\n" +
                        "      '14=[2,7]',\n" +
                        "      '15=[3,5]',\n" +
                        "      '16=[2,2,2,2]',\n" +
                        "      '17=[17]',\n" +
                        "      '18=[2,3,3]',\n" +
                        "      '19=[19]',\n" +
                        "      '20=[2,2,5]',\n" +
                        "      '21=[3,7]',\n" +
                        "      '22=[2,11]',\n" +
                        "      '23=[23]',\n" +
                        "      '24=[2,2,2,3]',\n" +
                        "      '25=[5,5]'\n" +
                        "    ],\n" +
                        "    'size':25\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':36,\n" +
                        "    'description':[\n" +
                        "      '2 to the power of 15 = 32768, the sum of digits of the result 3 + 2 + 7 + 6 + 8 = 26. What is the sum of the digits of 2 to the power of i?\\nWrite a method for calculation that takes int and returns the result as a String'\n" +
                        "    ],\n" +
                        "    'name':'PowerDigitSumAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '1=2',\n" +
                        "      '2=4',\n" +
                        "      '3=8',\n" +
                        "      '4=7',\n" +
                        "      '5=5',\n" +
                        "      '6=10',\n" +
                        "      '7=11',\n" +
                        "      '8=13',\n" +
                        "      '3=8',\n" +
                        "      '4=7',\n" +
                        "      '11=14',\n" +
                        "      '12=19',\n" +
                        "      '13=20',\n" +
                        "      '14=22',\n" +
                        "      '15=26',\n" +
                        "      '16=25',\n" +
                        "      '11=14',\n" +
                        "      '12=19',\n" +
                        "      '19=29',\n" +
                        "      '20=31',\n" +
                        "      '15=26',\n" +
                        "      '16=25',\n" +
                        "      '23=41',\n" +
                        "      '24=37',\n" +
                        "      '19=29'\n" +
                        "    ],\n" +
                        "    'size':25\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':37,\n" +
                        "    'description':[\n" +
                        "      'You have bricks of size 5 (bigCount) and 1 (smallCount). Write a method that can determine if a given set of bricks can be used to build a wall of a given length. a given set of bricks to build a wall of a given length (length). For example: \\nmethod(3, 1, 8) → true\\nmethod(3, 1, 9) → false\\nmethod(3, 2, 10) → true'\n" +
                        "    ],\n" +
                        "    'name':'MakeBricksAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '0, 1, 5=true',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '1, 0, 2=false',\n" +
                        "      '0, 1, 5=true'\n" +
                        "    ],\n" +
                        "    'size':48\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':40,\n" +
                        "    'description':[\n" +
                        "      'Roman number algorithm. Convert arabic number to roman number.'\n" +
                        "    ],\n" +
                        "    'name':'ArabicToRomanAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '1=I',\n" +
                        "      '2=II',\n" +
                        "      '3=III',\n" +
                        "      '4=IV',\n" +
                        "      '5=V',\n" +
                        "      '6=VI',\n" +
                        "      '7=VII',\n" +
                        "      '8=VIII',\n" +
                        "      '9=IX',\n" +
                        "      '10=X',\n" +
                        "      '11=XI',\n" +
                        "      '12=XII',\n" +
                        "      '13=XIII',\n" +
                        "      '14=XIV',\n" +
                        "      '15=XV',\n" +
                        "      '16=XVI',\n" +
                        "      '17=XVII',\n" +
                        "      '18=XVIII',\n" +
                        "      '19=XIX',\n" +
                        "      '20=XX',\n" +
                        "      '30=XXX',\n" +
                        "      '35=XXXV',\n" +
                        "      '36=XXXVI',\n" +
                        "      '46=XLVI',\n" +
                        "      '57=LVII',\n" +
                        "      '67=LXVII',\n" +
                        "      '89=LXXXIX',\n" +
                        "      '123=CXXIII',\n" +
                        "      '234=CCXXXIV',\n" +
                        "      '345=CCCXLV',\n" +
                        "      '456=CDLVI',\n" +
                        "      '567=DLXVII',\n" +
                        "      '678=DCLXXVIII',\n" +
                        "      '890=DCCCXC',\n" +
                        "      '1234=MCCXXXIV',\n" +
                        "      '2345=MMCCCXLV',\n" +
                        "      '3456=MMMCDLVI'\n" +
                        "    ],\n" +
                        "    'size':37\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':41,\n" +
                        "    'description':[\n" +
                        "      'Write a function that converts a Roman number to Arabic'\n" +
                        "    ],\n" +
                        "    'name':'RomanToArabicAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      'I=1',\n" +
                        "      'II=2',\n" +
                        "      'III=3',\n" +
                        "      'IV=4',\n" +
                        "      'V=5',\n" +
                        "      'VI=6',\n" +
                        "      'VII=7',\n" +
                        "      'VIII=8',\n" +
                        "      'IX=9',\n" +
                        "      'X=10',\n" +
                        "      'XI=11',\n" +
                        "      'XII=12',\n" +
                        "      'XIII=13',\n" +
                        "      'XIV=14',\n" +
                        "      'XV=15',\n" +
                        "      'XVI=16',\n" +
                        "      'XVII=17',\n" +
                        "      'XVIII=18',\n" +
                        "      'XIX=19',\n" +
                        "      'XX=20',\n" +
                        "      'XXX=30',\n" +
                        "      'XXXV=35',\n" +
                        "      'XXXVI=36',\n" +
                        "      'XLVI=46',\n" +
                        "      'LVII=57',\n" +
                        "      'LXVII=67',\n" +
                        "      'LXXXIX=89',\n" +
                        "      'CXXIII=123',\n" +
                        "      'CCXXXIV=234',\n" +
                        "      'CCCXLV=345',\n" +
                        "      'CDLVI=456',\n" +
                        "      'DLXVII=567',\n" +
                        "      'DCLXXVIII=678',\n" +
                        "      'DCCCXC=890',\n" +
                        "      'MCCXXXIV=1234',\n" +
                        "      'MMCCCXLV=2345',\n" +
                        "      'MMMCDLVI=3456'\n" +
                        "    ],\n" +
                        "    'size':37\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':42,\n" +
                        "    'description':[\n" +
                        "      'Write a method that takes one int argument and that returns the factorial of that number as a String.\\nWarning: Int/long overflow is possible.'\n" +
                        "    ],\n" +
                        "    'name':'FactorialAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '1=1',\n" +
                        "      '2=2',\n" +
                        "      '3=6',\n" +
                        "      '4=24',\n" +
                        "      '5=120',\n" +
                        "      '6=720',\n" +
                        "      '7=5040',\n" +
                        "      '8=40320',\n" +
                        "      '9=362880',\n" +
                        "      '10=3628800',\n" +
                        "      '11=39916800',\n" +
                        "      '12=479001600',\n" +
                        "      '13=6227020800',\n" +
                        "      '14=87178291200',\n" +
                        "      '15=1307674368000',\n" +
                        "      '16=20922789888000',\n" +
                        "      '17=355687428096000',\n" +
                        "      '18=6402373705728000',\n" +
                        "      '19=121645100408832000',\n" +
                        "      '20=2432902008176640000',\n" +
                        "      '21=51090942171709440000',\n" +
                        "      '22=1124000727777607680000',\n" +
                        "      '23=25852016738884976640000',\n" +
                        "      '24=620448401733239439360000',\n" +
                        "      '25=15511210043330985984000000'\n" +
                        "    ],\n" +
                        "    'size':25\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':45,\n" +
                        "    'description':[\n" +
                        "      'For the most of numbers iterative 'reverse and add' actions lead to palindrome number. For example: \\nNumber 23: 23 + 32 = 55; \\nNumber 254: 254 + 452 = 706; 706 + 607 = 1313; 1313 + 3131 = 4444;\\nWrite a method which calculates 'ReverseAndAdd' palindrome for a number. i.e f(23) = 55; f(254) = 4444'\n" +
                        "    ],\n" +
                        "    'name':'ReverseAddPalindromeAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '1=2',\n" +
                        "      '2=4',\n" +
                        "      '3=6',\n" +
                        "      '4=8',\n" +
                        "      '5=11',\n" +
                        "      '6=33',\n" +
                        "      '7=55',\n" +
                        "      '9=99',\n" +
                        "      '5=11',\n" +
                        "      '11=22',\n" +
                        "      '6=33',\n" +
                        "      '123=444',\n" +
                        "      '234=666',\n" +
                        "      '345=888',\n" +
                        "      '456=1221',\n" +
                        "      '567=3663',\n" +
                        "      '678=23232',\n" +
                        "      '789=66066',\n" +
                        "      '1234=5555',\n" +
                        "      '2345=7777',\n" +
                        "      '3456=9999',\n" +
                        "      '4567=12221',\n" +
                        "      '5678=48884',\n" +
                        "      '6789=993399',\n" +
                        "      '6789=993399',\n" +
                        "      '12345=66666',\n" +
                        "      '123456=777777',\n" +
                        "      '1234567=8888888',\n" +
                        "      '12345678=99999999',\n" +
                        "      '123456789=1222222221',\n" +
                        "      '1234567890=3344444433'\n" +
                        "    ],\n" +
                        "    'size':31\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':50,\n" +
                        "    'description':[\n" +
                        "      'Continue the sequence 971, 874, 787, 709, 639...\\ni.e f(1) = 971, f(2) = 874, ...\\nHint: Use subtraction'\n" +
                        "    ],\n" +
                        "    'name':'Sequence2Algorithm',\n" +
                        "    'qa':[\n" +
                        "      '1=971',\n" +
                        "      '2=874',\n" +
                        "      '3=787',\n" +
                        "      '4=709',\n" +
                        "      '5=639',\n" +
                        "      '6=576',\n" +
                        "      '7=519',\n" +
                        "      '8=468',\n" +
                        "      '9=422',\n" +
                        "      '10=380',\n" +
                        "      '11=342',\n" +
                        "      '12=308',\n" +
                        "      '13=278',\n" +
                        "      '14=251',\n" +
                        "      '15=226',\n" +
                        "      '16=204',\n" +
                        "      '17=184',\n" +
                        "      '18=166',\n" +
                        "      '19=150',\n" +
                        "      '20=135',\n" +
                        "      '21=122',\n" +
                        "      '22=110',\n" +
                        "      '23=99',\n" +
                        "      '24=90',\n" +
                        "      '25=81'\n" +
                        "    ],\n" +
                        "    'size':25\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':51,\n" +
                        "    'description':[\n" +
                        "      'You are given an array of vertical lines height, so that Y-axis is the line height and X-axis is line index from an array. Write a Javascript function that finds two lines that together forms the rectangle with largest area. Return the maximum area number and line coordinates in format {area}:{x1},{x2}. For example:\\n 1, 6, 3, 2, 8 => 18:1,4\\n 5, 2, 8, 1, 4 => 16:0,4\\n 7, 10, 2, 3, 1 => 9:0,3',\n" +
                        "      'Solve this task with O(n) complexity.',\n" +
                        "      'Return line coordinates of last found rectangle.'\n" +
                        "    ],\n" +
                        "    'name':'MaxSquareAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '3, 6, 2, 5, 4, 8, 3=24:1,5',\n" +
                        "      '1, 1, 1, 1, 1=4:0,4',\n" +
                        "      '1, 2, 1, 2, 1=4:1,3',\n" +
                        "      '1, 1, 1, 1, 1=4:0,4',\n" +
                        "      '1, 5, 10, 5, 1=10:1,3',\n" +
                        "      '5, 1, 10, 1, 5=20:0,4',\n" +
                        "      '100, 5, 1, 5, 100=400:0,4',\n" +
                        "      '100, 5, 1, 5, 100=400:0,4',\n" +
                        "      '1, 100, 1, 100, 1=200:1,3'\n" +
                        "    ],\n" +
                        "    'size':9\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':55,\n" +
                        "    'description':[\n" +
                        "      'The first 10 prime numbers are 2, 3, 5, 7, 11, 13, 17, 19, 23, 29. Write a method that returns the i-th prime number.'\n" +
                        "    ],\n" +
                        "    'name':'XthPrimeAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '1=2',\n" +
                        "      '2=3',\n" +
                        "      '3=5',\n" +
                        "      '4=7',\n" +
                        "      '5=11',\n" +
                        "      '6=13',\n" +
                        "      '7=17',\n" +
                        "      '8=19',\n" +
                        "      '9=23',\n" +
                        "      '10=29',\n" +
                        "      '11=31',\n" +
                        "      '12=37',\n" +
                        "      '13=41',\n" +
                        "      '14=43',\n" +
                        "      '15=47',\n" +
                        "      '16=53',\n" +
                        "      '17=59',\n" +
                        "      '18=61',\n" +
                        "      '19=67',\n" +
                        "      '20=71',\n" +
                        "      '21=73',\n" +
                        "      '22=79',\n" +
                        "      '23=83',\n" +
                        "      '24=89',\n" +
                        "      '25=97'\n" +
                        "    ],\n" +
                        "    'size':25\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':57,\n" +
                        "    'description':[\n" +
                        "      'Write a js function that takes an integer index as input and returns a string in the format 'number:divisors:fizzBuzz', where 'number' is the nth positive integer that has at least two distinct dividers [3, 5, 7, 9, 13] and is divisible by them without a rest, 'divisors' is a separated by '*' list of the distinct prime factors of 'number', and 'fizzBuzz' is the result of calling a function 'fizzBuzz(number)'. If the input index is less than or equal to 0 or greater than or equal to 25, return 'none'.',\n" +
                        "      'JavaScript program:\\nfunction fizzBuzz(number) {\\n    const divisors = [3, 5, 7, 11, 13];\\n    const strings = ['Fizz', 'Buzz', 'Muzz', 'Duzz', 'Cazz'];\\n    let str = '';\\n    for (let i = 0; i < divisors.length; i++) {\\n        if (number % divisors[i] === 0) {\\n            str += strings[i];\\n        }\\n    }\\n    return str || number.toString();\\n}',\n" +
                        "      'For example:\\n1=>15:3*5:FizzBuzz\\n2=>21:3*7:FizzMuzz\\n3=>33:3*11:FizzDuzz\\n10=>105:3*5*7:FizzBuzzMuzz\\n12=>165:3*5*11:FizzBuzzDuzz\\n13=>195:3*5*13:FizzBuzzCazz\\n21=>1155:3*5*7*11:FizzBuzzMuzzDuzz\\n23=>2145:3*5*11*13:FizzBuzzDuzzCazz\\n24=>3003:3*7*11*13:FizzMuzzDuzzCazz\\n26=>15015:3*5*7*11*13:FizzBuzzMuzzDuzzCazz'\n" +
                        "    ],\n" +
                        "    'name':'FizzBuzzMultiplierAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '1=15:3*5:FizzBuzz',\n" +
                        "      '2=21:3*7:FizzMuzz',\n" +
                        "      '3=33:3*11:FizzDuzz',\n" +
                        "      '4=35:5*7:BuzzMuzz',\n" +
                        "      '5=39:3*13:FizzCazz',\n" +
                        "      '6=55:5*11:BuzzDuzz',\n" +
                        "      '7=65:5*13:BuzzCazz',\n" +
                        "      '8=77:7*11:MuzzDuzz',\n" +
                        "      '9=91:7*13:MuzzCazz',\n" +
                        "      '10=105:3*5*7:FizzBuzzMuzz',\n" +
                        "      '11=143:11*13:DuzzCazz',\n" +
                        "      '12=165:3*5*11:FizzBuzzDuzz',\n" +
                        "      '13=195:3*5*13:FizzBuzzCazz',\n" +
                        "      '14=231:3*7*11:FizzMuzzDuzz',\n" +
                        "      '15=273:3*7*13:FizzMuzzCazz',\n" +
                        "      '16=385:5*7*11:BuzzMuzzDuzz',\n" +
                        "      '17=429:3*11*13:FizzDuzzCazz',\n" +
                        "      '18=455:5*7*13:BuzzMuzzCazz',\n" +
                        "      '19=715:5*11*13:BuzzDuzzCazz',\n" +
                        "      '20=1001:7*11*13:MuzzDuzzCazz',\n" +
                        "      '21=1155:3*5*7*11:FizzBuzzMuzzDuzz',\n" +
                        "      '22=1365:3*5*7*13:FizzBuzzMuzzCazz',\n" +
                        "      '23=2145:3*5*11*13:FizzBuzzDuzzCazz',\n" +
                        "      '24=3003:3*7*11*13:FizzMuzzDuzzCazz',\n" +
                        "      '25=5005:5*7*11*13:BuzzMuzzDuzzCazz',\n" +
                        "      '26=15015:3*5*7*11*13:FizzBuzzMuzzDuzzCazz',\n" +
                        "      '27=none'\n" +
                        "    ],\n" +
                        "    'size':27\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':60,\n" +
                        "    'description':[\n" +
                        "      'Write a method that divides two numbers in a column to within 100 digits. If there is a period in the result, it should be written as follows:\\n212/133 = 1.(593984962406015037)\\n87/78 = 1.1(153846)'\n" +
                        "    ],\n" +
                        "    'name':'LongDivisionAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '1, 2=0.5',\n" +
                        "      '1, 1=1',\n" +
                        "      '1, 1=1',\n" +
                        "      '55, 5=11',\n" +
                        "      '55, 44=1.25',\n" +
                        "      '0, 56=0',\n" +
                        "      '56, 1=56',\n" +
                        "      '1, -2=-0.5',\n" +
                        "      '1, -2=-0.5',\n" +
                        "      '1, 2=0.5',\n" +
                        "      '1, 1000=0.001',\n" +
                        "      '56, 45=1.2(4)',\n" +
                        "      '111, 110=1.00(90)',\n" +
                        "      '111, 11=10.0(90)',\n" +
                        "      '11111, 11=1010.0(90)',\n" +
                        "      '-11, -222=0.0(495)',\n" +
                        "      '111, -22=-5.0(45)',\n" +
                        "      '1, 3000=0.000(3)',\n" +
                        "      '87, 78=1.1(153846)',\n" +
                        "      '45, 56=0.803(571428)',\n" +
                        "      '212, 133=1.(593984962406015037)',\n" +
                        "      '11111, 115=96.6(1739130434782608695652)',\n" +
                        "      '123, 345=0.3(5652173913043478260869)',\n" +
                        "      '66666666, 77727777=0.8576942320118070532237143486041032667124906968586017840186012266888836921194851616559161340739231484',\n" +
                        "      '666666660, 77727777=8.5769423201180705322371434860410326671249069685860178401860122668888369211948516165591613407392314847',\n" +
                        "      '666666660, 7772777=85.7694309253951322673994120762759564567464112247141529983428059238030371899258141588263756955847311713',\n" +
                        "      '100, 97=1.0(309278350515463917525773195876288659793814432989690721649484536082474226804123711340206185567010)',\n" +
                        "      '999, 0=Div by zero error!'\n" +
                        "    ],\n" +
                        "    'size':28\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':2147483647,\n" +
                        "    'description':[\n" +
                        "      'No more Levels. You win!'\n" +
                        "    ],\n" +
                        "    'name':'NullLevel',\n" +
                        "    'qa':[],\n" +
                        "    'size':0\n" +
                        "  }\n" +
                        "]",
                JsonUtils.prettyPrint(
                        new GameSettings().levels().stream()
                                .map(level -> new JSONObject(){{
                                    put("name", level.name());
                                    put("description", level.description());
                                    put("complexity", level.complexity());
                                    put("size", level.size());
                                    put("qa", level.getQuestionAnswers());
                                }})
                                .collect(toList())
                ));
    }
}