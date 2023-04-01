/**
 * In this kata, your task is to create a regular expression capable of evaluating binary strings (strings with only 1s and 0s) and determining whether the given string represents a number divisible by 3.<br>
 * <ul>Take into account that:
 * <li>An empty string might be evaluated to true (it's not going to be tested, so you don't need to worry about it - unless you want)</li>
 * <li>The input should consist only of binary digits - no spaces, other digits, alphanumeric characters, etc.</li>
 * <li>There might be leading 0s.</li>
 * </ul>
 * <ul>Examples (Javascript)
 * <li>multipleof3Regex.test('000') should be true</li>
 * <li>multipleof3Regex.test('001') should be false</li>
 * <li>multipleof3Regex.test('011') should be true</li>
 * <li>multipleof3Regex.test('110') should be true</li>
 * <li>multipleof3Regex.test(' abc ') should be false</li>
 * </ul>
 * You can check more in the example test cases<br>
 * Note<br>
 * There's a way to develop an automata (FSM) that evaluates if strings representing numbers in a given base are divisible by a given number. You might want to check an example of an automata for doing this same particular task here.<br>
 * If you want to understand better the inner principles behind it, you might want to study how to get the modulo of an arbitrarily large number taking one digit at a time.<br>
 */
package codewars.binary.multiple.of.three;