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
var cutFunctionTest = function() {

    toString = function (data) {
        if (data === undefined || data == null) {
            return data;
        }
        return JSON.stringify(data).split('"').join('\'');
    }

    assertEquals = function (expected, actual) {
        expected = toString(expected);
        actual = toString(actual);
        if (expected !== actual) {
            console.log('Expected:');
            console.log(expected);

            console.log('Actual:');
            console.log(actual);

            throw Error('Expected: "' + expected + '" but was: "' + actual + '"');
        }
    }

    assertCode = function(inputData, expectedCode) {
        var code = cutFunction(inputData);
        assertEquals(expectedCode, code);
    }

    runTest = function () {

        assertCode( // with tabs, text qround
`Here is the JavaScript program that meets the requirements:

    function program(question) {
        if (question.toLowerCase() === 'hello') {
            return 'world';
        }
        return '';
    }

This program takes in a single string argument called 'question'. If the string equals 'hello' (ignoring case), it returns the string 'world'. Otherwise, it returns an empty string.`,
`    function program(question) {
        if (question.toLowerCase() === 'hello') {
            return 'world';
        }
        return '';
    }`);

        assertCode( // without tabs, text around
`Here is the JavaScript program that meets the requirements:

function program(question) {
	if (question.toLowerCase() === 'hello') {
		return 'world';
	}
	return '';
}

This program takes in a single string argument called 'question'. If the string equals 'hello' (ignoring case), it returns the string 'world'. Otherwise, it returns an empty string.`,
            `function program(question) {
	if (question.toLowerCase() === 'hello') {
		return 'world';
	}
	return '';
}`);

        assertCode( // only function
`function program(question) {
      if(question==='hello'){
        return 'world';
      }
  }`,
`function program(question) {
      if(question==='hello'){
        return 'world';
      }
  }`);

        assertCode( // three '''
`JavaScript program:

\`\`\`
function program(question) {
  if (question === 'hello') {
    return 'world';
  } else {
    return 'Invalid input';
  }
}
\`\`\`

Explanation:

We write a function program that takes a parameter \`question\`. Inside the function, we check if the parameter is equal to \`'hello'\` using the comparison operator \`===\`. If the condition is true, it means that the input provided is \`'hello'\`, and the function returns the string \`'world'\`. In all other cases where the input is not 'hello', the function will return the string 'Invalid input'.`,
`function program(question) {
  if (question === 'hello') {
    return 'world';
  } else {
    return 'Invalid input';
  }
}`);

        assertCode( // three ''' with code labguage
`JavaScript program:

\`\`\`javascript
function program(question) {
  if (question === 'hello') {
    return 'world';
  } else {
    return 'Invalid input';
  }
}
\`\`\`

Explanation:

We write a function program that takes a parameter \`question\`. Inside the function, we check if the parameter is equal to \`'hello'\` using the comparison operator \`===\`. If the condition is true, it means that the input provided is \`'hello'\`, and the function returns the string \`'world'\`. In all other cases where the input is not 'hello', the function will return the string 'Invalid input'.`,
`function program(question) {
  if (question === 'hello') {
    return 'world';
  } else {
    return 'Invalid input';
  }
}`);

        assertCode( // three ''' with code explanation
`Here's the JavaScript program that takes a single string argument and returns 'world' if 'hello' was passed as an argument:

\`\`\`javascript
function program(question) {
   if (question === 'hello') {
      return 'world';
   } else {
      // If argument is not 'hello', you can return any other string as per your requirement.
      return 'unknown';
  }
}

// Example usage
console.log(program('hello')); // Output: world
console.log(program('hi')); // Output: unknown
\`\`\`

In the code above, a simple if else statement is used. If the argument passed in is 'hello', the program returns 'world'. Otherwise, it will return 'unknown'.`,
`function program(question) {
   if (question === 'hello') {
      return 'world';
   } else {
      // If argument is not 'hello', you can return any other string as per your requirement.
      return 'unknown';
  }
}

// Example usage
console.log(program('hello')); // Output: world
console.log(program('hi')); // Output: unknown`);

        assertCode( // starts with function with code explanation
`function program(question) {
       if(question === 'hello'){
        return 'world';
      }
      return 'answer';
}

//Example usage
console.log(program('hello')); // Output: 'world'
console.log(program('hi')); // Output: 'answer'`,
`function program(question) {
       if(question === 'hello'){
        return 'world';
      }
      return 'answer';
}`);

        assertCode( // end with code with tabs
`JavaScript program:

    function program(question) {
        if(question === 'hello') { // check if the input is 'hello'
            return 'world'; // return 'world' if the input is 'hello'
        }
        else {
            return 'invalid input'; // return 'invalid input' for other inputs
        }
    }`,
`    function program(question) {
        if(question === 'hello') { // check if the input is 'hello'
            return 'world'; // return 'world' if the input is 'hello'
        }
        else {
            return 'invalid input'; // return 'invalid input' for other inputs
        }
    }`);

        assertCode( // two code snipets
`JavaScript program:
\`\`\`
function program(question) {
	if(question === 'hello') { // check if the input is 'hello'
		return 'world'; // return 'world' if the input is 'hello'
	}
	else {
		return 'invalid input'; // return 'invalid input' for other inputs
	}
}
\`\`\`
Some bla bla bla bla
\`\`\`
function another(question) {
	// do nothing
}
\`\`\`
Some bla bla`,
            `function program(question) {
	if(question === 'hello') { // check if the input is 'hello'
		return 'world'; // return 'world' if the input is 'hello'
	}
	else {
		return 'invalid input'; // return 'invalid input' for other inputs
	}
}`);
    }

    runTest();
}