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
                        "  '[Level] Map[10]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Divide an integer into multiples of prime numbers:\\\\n1 -> [1]\\\\n2 -> [2]\\\\n3 -> [3]\\\\n4 -> [2,2]\\\\n6 -> [2,3]\\\\n9 -> [3,3]\\\\n12 -> [2,2,3]\\\\n15 -> [3,5]\\\\netc...\\'\\n  ],\\n  \\'name\\':\\'PrimeFactoryAlgorithm\\',\\n  \\'winCode\\':\\'function program(number) {\\\\n    if (number == 1) {\\\\n        return \\\\\\\\'[1]\\\\\\\\';\\\\n    }\\\\n    const result = [];\\\\n    for (let i = 2; i <= Math.sqrt(number); i++) {\\\\n        while (number % i === 0) {\\\\n             result.push(i);\\\\n             number /= i;\\\\n        }\\\\n    }\\\\n    if (number > 1) {\\\\n        result.push(number);\\\\n    }\\\\n    return \\\\\\\\'[\\\\\\\\' + result.join(\\\\\\\\',\\\\\\\\') + \\\\\\\\']\\\\\\\\';\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[11]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'2 to the power of 15 = 32768, the sum of digits of the result 3 + 2 + 7 + 6 + 8 = 26. What is the sum of the digits of 2 to the power of i?\\\\nWrite a method for calculation that takes int and returns the result as a String\\'\\n  ],\\n  \\'name\\':\\'PowerDigitSumAlgorithm\\',\\n  \\'winCode\\':\\'function program(power) {\\\\n    const temp = (BigInt(1) << BigInt(power)).toString();\\\\n    let sum = 0;\\\\n    for (let i = 0; i < temp.length; i++) {\\\\n        sum += parseInt(temp[i]);\\\\n    }\\\\n    return sum.toString();\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[12]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'You have bricks of size 5 (bigCount) and 1 (smallCount). Write a method that can determine if a given set of bricks can be used to build a wall of a given length. a given set of bricks to build a wall of a given length (length). For example: \\\\nmethod(3, 1, 8) → true\\\\nmethod(3, 1, 9) → false\\\\nmethod(3, 2, 10) → true\\'\\n  ],\\n  \\'name\\':\\'MakeBricksAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n    const [small, big, goal] = input.split(\\\\\\\\', \\\\\\\\').map(number => parseInt(number));\\\\n    const result = (small >= (goal % 5) && small >= goal - big * 5);\\\\n    return String(result);\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[13]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Write a method that takes one int argument and that returns the factorial of that number as a String.\\\\nWarning: Int/long overflow is possible.\\'\\n  ],\\n  \\'name\\':\\'FactorialAlgorithm\\',\\n  \\'winCode\\':\\'function program(number) {\\\\n    const cache = {};\\\\n\\\\n    function calculate(number) {\\\\n        if (number == 0) {\\\\n            return 1n;\\\\n        }\\\\n\\\\n        if (number in cache) {\\\\n            return cache[number];\\\\n        }\\\\n\\\\n        const result = BigInt(number) * calculate(number - 1);\\\\n        cache[number] = result;\\\\n\\\\n        return result;\\\\n    }\\\\n\\\\n    return calculate(number).toString();\\\\n}\\\\n\\'\\n}',\n" +
                        "  '[Level] Map[14]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'For the most of numbers iterative \\\\\\\\'reverse and add\\\\\\\\' actions lead to palindrome number. For example: \\\\nNumber 23: 23 + 32 = 55; \\\\nNumber 254: 254 + 452 = 706; 706 + 607 = 1313; 1313 + 3131 = 4444;\\\\nWrite a method which calculates \\\\\\\\'ReverseAndAdd\\\\\\\\' palindrome for a number. i.e f(23) = 55; f(254) = 4444\\'\\n  ],\\n  \\'name\\':\\'ReverseAddPalindromeAlgorithm\\',\\n  \\'winCode\\':\\'function program(number) {\\\\n    let result = BigInt(number);\\\\n    do {\\\\n        result += BigInt(reverse(String(result))); \\\\n    } while (!isPalindrome(result));\\\\n    return String(result);\\\\n}\\\\n\\\\nfunction isPalindrome(input) {\\\\n    let number = String(input);\\\\n    return number === reverse(number);\\\\n}\\\\n\\\\nfunction reverse(string) {\\\\n    return string.split(\\\\\\\\'\\\\\\\\').reverse().join(\\\\\\\\'\\\\\\\\');\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[15]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Continue the sequence 971, 874, 787, 709, 639...\\\\ni.e f(1) = 971, f(2) = 874, ...\\\\nHint: Use subtraction\\'\\n  ],\\n  \\'name\\':\\'Sequence2Algorithm\\',\\n  \\'winCode\\':\\'function program(number) {\\\\n    let result = 971;\\\\n\\\\n    for (let i = 1; i < number; i++) {\\\\n        let string = result.toString().padStart(3, \\\\\\\\'0\\\\\\\\');\\\\n        result -= parseInt(string.substring(0, 2));\\\\n    }\\\\n\\\\n    return result.toString();\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[16]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'The first 10 prime numbers are 2, 3, 5, 7, 11, 13, 17, 19, 23, 29. Write a method that returns the i-th prime number.\\'\\n  ],\\n  \\'name\\':\\'XthPrimeAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n    let index = parseInt(input);\\\\n    let count = 0;\\\\n    let result = 2;\\\\n\\\\n    while (count < index) {\\\\n        let isPrime = true;\\\\n        for (let j = 2; j <= Math.sqrt(result); j++) {\\\\n            if (result % j === 0) {\\\\n                isPrime = false;\\\\n                break;\\\\n            }\\\\n        }\\\\n        if (isPrime) {\\\\n            count++;\\\\n            if (count === index) {\\\\n                return result;\\\\n            }\\\\n        }\\\\n        result++;\\\\n    }\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[17]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Write a method that divides two numbers in a column to within 100 digits. If there is a period in the result, it should be written as follows:\\\\n212/133 = 1.(593984962406015037)\\\\n87/78 = 1.1(153846)\\'\\n  ],\\n  \\'name\\':\\'LongDivisionAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n    let a = Number(input.split(\\\\\\\\',\\\\\\\\')[0]);\\\\n    let b = Number(input.split(\\\\\\\\',\\\\\\\\')[1]);\\\\n\\\\n    if (b === 0) {\\\\n        return \\\\\\\\'Div by zero error!\\\\\\\\';\\\\n    }\\\\n    if (a === 0) {\\\\n        return \\\\\\\\'0\\\\\\\\';\\\\n    }\\\\n    const isMinus = (a < 0 && b > 0 || a > 0 && b < 0);\\\\n    a = Math.abs(a);\\\\n    b = Math.abs(b);\\\\n\\\\n    const length = 100;\\\\n    const DOT = -1;\\\\n    const TEN = 10;\\\\n    const NOT_FOUND = -1;\\\\n\\\\n    const result = [];\\\\n\\\\n    const aa = new Array(length * 2).fill(0);\\\\n    let ia = 0;\\\\n    let ceilpos = 0;\\\\n\\\\n    let isCalcCeil = a >= b;\\\\n    if (!isCalcCeil) {\\\\n        result.push(\\\\\\\\'0\\\\\\\\', \\\\\\\\'.\\\\\\\\');\\\\n        aa[ia++] = 0;\\\\n        aa[ia++] = DOT;\\\\n        ceilpos = ia - 1;\\\\n    }\\\\n\\\\n    while (a != 0 && (result.length - ceilpos) <= length) {\\\\n        if (a < b) {\\\\n            if (isCalcCeil) {\\\\n                result.push(\\\\\\\\'.\\\\\\\\');\\\\n                aa[ia++] = DOT;\\\\n                ceilpos = ia - 1;\\\\n                isCalcCeil = false;\\\\n            }\\\\n            a *= TEN;\\\\n        }\\\\n        while (a < b) {\\\\n            result.push(\\\\\\\\'0\\\\\\\\');\\\\n            aa[ia++] = 0;\\\\n            a *= TEN;\\\\n        }\\\\n\\\\n        let found = NOT_FOUND;\\\\n        for (let ja = 0; ja < ia; ja++) {\\\\n            if (aa[ja] === a) {\\\\n                found = ja;\\\\n                break;\\\\n            }\\\\n        }\\\\n        if (found !== NOT_FOUND) {\\\\n            result.splice(found, 0, \\\\\\\\'(\\\\\\\\');\\\\n            result.push(\\\\\\\\')\\\\\\\\');\\\\n            break;\\\\n        }\\\\n\\\\n        const c = Math.floor(a / b);\\\\n        if (isCalcCeil) {\\\\n            let c1 = c;\\\\n            while (c1 / TEN > 10000000) {\\\\n                aa[ia++] = c1 % TEN;\\\\n                c1 = Math.floor(c1 / TEN);\\\\n            }\\\\n            aa[ia++] = c1;\\\\n        } else {\\\\n            aa[ia++] = a;\\\\n        }\\\\n        const d = a % b;\\\\n        result.push(c);\\\\n        a = d;\\\\n\\\\n    }\\\\n\\\\n    return ((isMinus) ? \\\\\\\\'-\\\\\\\\' : \\\\\\\\'\\\\\\\\') + result.join(\\\\\\\\'\\\\\\\\');\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[18]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'No more Levels. You win!\\'\\n  ],\\n  \\'name\\':\\'NullLevel\\',\\n  \\'winCode\\':\\'function program(question) {\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[1]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Write a method that takes a single string argument and return the string \\\\\\\\'world\\\\\\\\' if \\\\\\\\'hello\\\\\\\\' came in.\\',\\n    \\'Please write js method.\\',\\n    \\'Now please improve the algorithm so that it returns\\\\\\\\'hello\\\\\\\\' if \\\\\\\\'world\\\\\\\\' came in. Previous logic should work also\\',\\n    \\'One more improvement: in other cases the algorithm should return the same string that came in.\\'\\n  ],\\n  \\'name\\':\\'HelloWorldAlgorithm\\',\\n  \\'winCode\\':\\'function program(question) {\\\\n    if (question == \\\\\\\\'hello\\\\\\\\'){\\\\n        return \\\\\\\\'world\\\\\\\\';\\\\n    }\\\\n    if (question == \\\\\\\\'world\\\\\\\\'){\\\\n        return \\\\\\\\'hello\\\\\\\\';\\\\n    }\\\\n    return question;\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[2]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Write a javascript method that takes one int argument and returns a string containing the number itself.\\',\\n    \\'For those numbers that are divisible by 3, the method should return \\\\\\\\'Fizz\\\\\\\\'\\',\\n    \\'For those numbers divisible by 5 it should return \\\\\\\\'Buzz\\\\\\\\'.\\',\\n    \\'For those numbers divisible by both 3 and 5 - \\\\\\\\'FizzBuzz\\\\\\\\'.\\',\\n    \\'Proceed in the same way if there is a number with a divisor of 7. The word \\\\\\\\'Muzz\\\\\\\\' is used for it. .\\',\\n    \\'Please write optimized code without any duplication.\\',\\n    \\'For divider 11 - the word must be \\\\\\\\'Duzz\\\\\\\\'.\\',\\n    \\'For divider 13 - the word must be \\\\\\\\'Cazz\\\\\\\\'.\\'\\n  ],\\n  \\'name\\':\\'FizzBuzzAlgorithm\\',\\n  \\'winCode\\':\\'function program(number) {\\\\n  let result = \\\\\\'\\\\\\';\\\\n  if (number % 3 === 0) {\\\\n    result += \\\\\\'Fizz\\\\\\';\\\\n  }\\\\n  if (number % 5 === 0) {\\\\n    result += \\\\\\'Buzz\\\\\\';\\\\n  }\\\\n  if (number % 7 === 0) {\\\\n    result += \\\\\\'Muzz\\\\\\';\\\\n  }\\\\n  if (number % 11 === 0) {\\\\n    result += \\\\\\'Duzz\\\\\\';\\\\n  }\\\\n  if (number % 13 === 0) {\\\\n    result += \\\\\\'Cazz\\\\\\';\\\\n  }\\\\n  return result || number.toString();\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[3]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Write a javascript method that takes one int argument and returns a string based on fizzBuzz algorithm:\\\\n1=>15:3*5:FizzBuzz\\\\n2=>21:3*7:FizzMuzz\\\\n3=>33:3*11:FizzDuzz\\\\n4=>35:5*7:BuzzMuzz\\\\n25=>none\\'\\n  ],\\n  \\'name\\':\\'FizzBuzzMultiplierAlgorithm\\',\\n  \\'winCode\\':\\'function program(index) {\\\\n    if (index <= 0 || index >= 25) {\\\\n        return \\\\\\\\'none\\\\\\\\';\\\\n    }\\\\n    \\\\n    const PRIMES = [3, 5, 7, 11, 13];\\\\n    \\\\n    let number = 0;\\\\n    let found = 0;\\\\n    \\\\n    const divisors = [];\\\\n    \\\\n    while (found != index) {\\\\n        number++;\\\\n        let rest = number;\\\\n        divisors.length = 0;\\\\n        \\\\n        for (let i = 0; i < PRIMES.length && rest > 1; i++) {\\\\n            if (rest <= PRIMES[i]) {\\\\n                break;\\\\n            }\\\\n            if (number % PRIMES[i] === 0) {\\\\n                divisors.push(PRIMES[i]);\\\\n                rest /= PRIMES[i];\\\\n            }\\\\n        }\\\\n        \\\\n        if (divisors.length > 1 && rest === 1) {\\\\n            found++;\\\\n        }\\\\n    }\\\\n    \\\\n    const divisorsStr = divisors.join(\\\\\\'*\\\\\\');\\\\n    return `${number}:${divisorsStr}:${fizzBuzz(number)}`;\\\\n}\\\\nfunction fizzBuzz(number) {\\\\n  let result = \\\\\\'\\\\\\';\\\\n  if (number % 3 === 0) {\\\\n    result += \\\\\\'Fizz\\\\\\';\\\\n  }\\\\n  if (number % 5 === 0) {\\\\n    result += \\\\\\'Buzz\\\\\\';\\\\n  }\\\\n  if (number % 7 === 0) {\\\\n    result += \\\\\\'Muzz\\\\\\';\\\\n  }\\\\n  if (number % 11 === 0) {\\\\n    result += \\\\\\'Duzz\\\\\\';\\\\n  }\\\\n  if (number % 13 === 0) {\\\\n    result += \\\\\\'Cazz\\\\\\';\\\\n  }\\\\n  return result || number.toString();\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[4]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'The sum of the squares of the first ten positive integers \\\\n1^2 + 2^2 + ... + 10^2 = 385. \\\\nAnd the square of the sum is \\\\n(1 + 2 + ... + 10)^2 = 55^2 = 3025. \\\\nTherefore, the difference between the sum of the squares and the square of the sum of the first ten natural numbers is equal to 3025 - 385 = 2640. \\\\nCreate a method that calculates the difference between the sum squares and the square of the sum for the natural number i.\\'\\n  ],\\n  \\'name\\':\\'SumSquareDifferenceAlgorithm\\',\\n  \\'winCode\\':\\'function program(question) {\\\\n    let number = parseInt(question);\\\\n    let sumOfSquares = (number * (number + 1) * (2 * number + 1)) / 6;\\\\n    let squareOfSum = Math.pow((number * (number + 1)) / 2, 2);\\\\n    return squareOfSum - sumOfSquares;\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[5]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Given the sequence: 1, 0, 3, 2, 5, 4, 7, 6, 9, 8, 11, 10, 13, 12, 15, 14...\\\\nThe sequence starts with element number 0: f(0)=1.\\\\nYour task is to write a function that returns the element at index n: f(n)=?\\'\\n  ],\\n  \\'name\\':\\'SimpleMathAlgorithm\\',\\n  \\'winCode\\':\\'function get(input) {\\\\n    let number = parseInt(input);\\\\n    return (number % 2 == 0)\\\\n        ? number + 1\\\\n        : number - 1;\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[6]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'The order matters...\\\\n Everything is quite simple. \\\\nIn a string of three characters, the last character becomes the first one,\\\\n and the first two characters shift one position to the right. \\\\nFor example: abc=>cab...\\'\\n  ],\\n  \\'name\\':\\'CharOrderAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n    return input.substring(2)\\\\n        + input.substring(0, 2);\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[7]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Order matters...\\\\nYou need to work with three-digit numbers. \\\\nSolve the algorithm for changing the number according to the given examples: \\\\nExamples: 111=>222, 123=>423, 679=>078, 999=>000, 012=>312, 090=>110, 444=>555, 090=>110, 916=>702\\'\\n  ],\\n  \\'name\\':\\'NumberOrderAlgorithm\\',\\n  \\'winCode\\':\\'function program(input) {\\\\n    return \\\\\\\\'\\\\\\\\' + getNextNumber(input.charAt(2))\\\\n        + getNextNumber(input.charAt(0))\\\\n        + getNextNumber(input.charAt(1));\\\\n}\\\\n\\\\nfunction getNextNumber(number) {\\\\n    return (parseInt(number) + 1) % 10;\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[8]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Continue the sequence 101, 112, 131, 415, 161, 718... \\\\ni.e f(1) = 101, f(2) = 112, ...\\\\nHint: Look at the whole picture\\'\\n  ],\\n  \\'name\\':\\'Sequence1Algorithm\\',\\n  \\'winCode\\':\\'function program(number) {\\\\n    const START_WITH = 10;\\\\n    const GROUP = 3;\\\\n    const MAX = number * GROUP;\\\\n    let i = 0;\\\\n    let buffer = \\\\\\'\\\\\\';\\\\n    while (buffer.length < MAX) {\\\\n        buffer += START_WITH + i;\\\\n        i++;\\\\n    }\\\\n    return buffer.substring(MAX - GROUP, MAX);\\\\n}\\'\\n}',\n" +
                        "  '[Level] Map[9]':'{\\n  \\'defaultCode\\':\\'function program(question) {\\\\n    // TODO implement your logic here\\\\n    return \\\\\\\\'answer\\\\\\\\';\\\\n}\\',\\n  \\'help\\':[\\n    \\'Make a method that returns a Fibonacci number from the series by its number:\\\\nf(0) = 0\\\\nf(1) = 1\\\\nf(2) = 0 + 1 = 1\\\\nf(3) = 1 + 1 = 2\\\\nf(4) = 1 + 2 = 3\\\\nf(5) = 2 + 3 = 5\\\\nf(6) = 3 + 5 = 8\\\\nf(7) = 5 + 8 = 13\\\\nf(8) = 8 + 13 = 21\\\\nf(9) = 13 + 21 = 34\\\\netc...\\'\\n  ],\\n  \\'name\\':\\'FibonacciNumbersAlgorithm\\',\\n  \\'winCode\\':\\'function program(number) {\\\\n    let previous = 0, current = 1;\\\\n    for (let i = 0; i < number; i++) {\\\\n         [previous, current] = [current, previous + current];\\\\n    }\\\\n    return String(previous);\\\\n}\\'\\n}',\n" +
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
                        "      'For divider 13 - the word must be 'Cazz'.'\n" +
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
                        "    'complexity':7,\n" +
                        "    'description':[\n" +
                        "      'Write a javascript method that takes one int argument and returns a string based on fizzBuzz algorithm:\\n1=>15:3*5:FizzBuzz\\n2=>21:3*7:FizzMuzz\\n3=>33:3*11:FizzDuzz\\n4=>35:5*7:BuzzMuzz\\n25=>none'\n" +
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
                        "      '25=none'\n" +
                        "    ],\n" +
                        "    'size':25\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':10,\n" +
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
                        "    'complexity':11,\n" +
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
                        "    'complexity':12,\n" +
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
                        "    'complexity':13,\n" +
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
                        "    'complexity':15,\n" +
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
                        "    'complexity':20,\n" +
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
                        "    'complexity':25,\n" +
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
                        "    'complexity':30,\n" +
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
                        "    'complexity':35,\n" +
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