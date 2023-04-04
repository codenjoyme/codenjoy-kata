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
import org.json.JSONObject;
import org.junit.Test;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class GameSettingsTest {

    @Test
    public void shouldGetAllParameters_withKeys() {
        assertEquals("WIN_SCORE        =[Score] Win score\n" +
                    "LOSE_PENALTY     =[Score] Lose penalty\n" +
                    "A_CONSTANT       =[Score] A constant\n" +
                    "B_CONSTANT       =[Score] B constant\n" +
                    "C_CONSTANT       =[Score] C constant\n" +
                    "D_CONSTANT       =[Score] D constant\n" +
                    "SHOW_DESCRIPTION =[Game] Show algorithm description in the request\n" +
                    "LEVELS_COUNT     =[Game] Levels count",
                TestUtils.toString(new GameSettings().allKeys()));
    }

    @Test
    public void shouldGetAllParameters_alsoWithoutKeys() {
        assertEquals("{\n" +
                        "  'Level1 name':'HelloWorldAlgorithm',\n" +
                        "  'Level10 name':'ReverseAddPalindromeAlgorithm',\n" +
                        "  'Level11 name':'Sequence2Algorithm',\n" +
                        "  'Level12 name':'XthPrimeAlgorithm',\n" +
                        "  'Level13 name':'LongDivisionAlgorithm',\n" +
                        "  'Level2 name':'FizzBuzzAlgorithm',\n" +
                        "  'Level3 name':'SumSquareDifferenceAlgorithm',\n" +
                        "  'Level4 name':'Sequence1Algorithm',\n" +
                        "  'Level5 name':'FibonacciNumbersAlgorithm',\n" +
                        "  'Level6 name':'PrimeFactoryAlgorithm',\n" +
                        "  'Level7 name':'PowerDigitSumAlgorithm',\n" +
                        "  'Level8 name':'MakeBricksAlgorithm',\n" +
                        "  'Level9 name':'FactorialAlgorithm',\n" +
                        "  '[Game] Levels count':13,\n" +
                        "  '[Game] Show algorithm description in the request':true,\n" +
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
                        "    'description':'Напиши метод, принимающий один String аргумент и возвращающий строку 'world' если на вход пришло 'hello',и 'hello' - если пришло 'world', в противном случае алгоритм должен вернуть ту же строчку, что пришла на вход. \\nАлгоритм реализован для проверки конневшена клиента к серверу.',\n" +
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
                        "    'description':'Напиши метод, принимающий один int аргумент и возвращающий String. Для тех чисел, которые делятся нацело на 3 метод должен вернуть “Fizz”, для тех, что делятся на 5 - “Buzz”, для тех же, что делятся и на 3 и на 5 - “FizzBuzz”, ну а для всех остальных - само число.',\n" +
                        "    'name':'FizzBuzzAlgorithm',\n" +
                        "    'qa':[\n" +
                        "      '1=1',\n" +
                        "      '2=2',\n" +
                        "      '3=Fizz',\n" +
                        "      '4=4',\n" +
                        "      '5=Buzz',\n" +
                        "      '3=Fizz',\n" +
                        "      '7=7',\n" +
                        "      '8=8',\n" +
                        "      '3=Fizz',\n" +
                        "      '5=Buzz',\n" +
                        "      '11=11',\n" +
                        "      '3=Fizz',\n" +
                        "      '13=13',\n" +
                        "      '14=14',\n" +
                        "      '15=FizzBuzz',\n" +
                        "      '16=16',\n" +
                        "      '17=17',\n" +
                        "      '3=Fizz',\n" +
                        "      '19=19',\n" +
                        "      '5=Buzz',\n" +
                        "      '3=Fizz',\n" +
                        "      '22=22',\n" +
                        "      '23=23',\n" +
                        "      '3=Fizz',\n" +
                        "      '5=Buzz'\n" +
                        "    ],\n" +
                        "    'size':25\n" +
                        "  },\n" +
                        "  {\n" +
                        "    'complexity':10,\n" +
                        "    'description':'Сумма квадратов первых десяти натуральных чисел 1^2 + 2^2 + ... + 10^2 = 385. А квадрат суммы - (1 + 2 + ... + 10)^2 = 55^2 = 3025. Потому разность между суммой квадратов и квадратом суммы первых десяти натуральных чисел равна 3025 − 385 = 2640. Создай метод, вычисляющий разность между суммой квадратов и квадратом суммы для натурального числа i.',\n" +
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
                        "    'complexity':15,\n" +
                        "    'description':'Continue the sequence 101, 112, 131, 415, 161, 718... \\ni.e f(1) = 101, f(2) = 112, ...\\nHint: Look at the whole picture',\n" +
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
                        "    'description':'Сделай метод, возвращающий числ Фибоначчи из ряда по его номеру:\\nf(0) = 0\\nf(1) = 1\\nf(2) = 0 + 1 = 1\\nf(3) = 1 + 1 = 2\\nf(4) = 1 + 2 = 3\\nf(5) = 2 + 3 = 5\\nf(6) = 3 + 5 = 8\\nf(7) = 5 + 8 = 13\\nf(8) = 8 + 13 = 21\\nf(9) = 13 + 21 = 34\\nи так далее...',\n" +
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
                        "    'description':'Разложи целое число на множители из простых чисел:\\n1 -> [1]\\n2 -> [2]\\n3 -> [3]\\n4 -> [2,2]\\n6 -> [2,3]\\n9 -> [3,3]\\n12 -> [2,2,3]\\n15 -> [3,5]\\nи так далее...',\n" +
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
                        "    'description':'2 в степени 15 = 32768, сумма цифр результата 3 + 2 + 7 + 6 + 8 = 26. Какова сумма цифр 2 в степени i? Напиши для расчета метод принимающий int и возвращающий результат в виде String',\n" +
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
                        "    'description':'У тебя есть кирпичики размером 5 (bigCount) и 1 (smallCount). Напиши метод, который смог бы определить получится из заданного набора кирпичиков  построить стенку заданной длинны (length). Например: \\nmethod(3, 1, 8) → true\\nmethod(3, 1, 9) → false\\nmethod(3, 2, 10) → true',\n" +
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
                        "    'description':'Напиши метод, принимающий один int аргумент и возвращающий факториал этого числа в виде String. \\nВнимание! Возможно переполнение int/long.',\n" +
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
                        "    'description':'For the most of numbers iterative 'reverse and add' actions lead to palindrome number. For example: \\nNumber 23: 23 + 32 = 55; \\nNumber 254: 254 + 452 = 706; 706 + 607 = 1313; 1313 + 3131 = 4444;\\nWrite a method which calculates 'ReverseAndAdd' polyndrom for a number. i.e f(23) = 55; f(254) = 4444',\n" +
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
                        "    'description':'Continue the sequence 971, 874, 787, 709, 639...\\ni.e f(1) = 971, f(2) = 874, ...\\nHint: Use subtraction',\n" +
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
                        "    'description':'Первые 10 простых чисел - 2, 3, 5, 7, 11, 13, 17, 19, 23, 29. Напиши метод, который вернет i-тое простое число.',\n" +
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
                        "    'description':'Напиши метод, который делит два числа в столбик с точностью до 100 знака. Если в результате встречается период, его стоит записать так: \\n212/133 = 1.(593984962406015037)\\n87/78   = 1.1(153846)',\n" +
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