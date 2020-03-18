package calculator;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(final String... args) {
        final Calculator calc = new Calculator();
        calc.init();
    }
}

class Calculator {
    static String result = "Invalid expression";
    static ArrayDeque<String> rpn = new ArrayDeque<>();
    static ArrayDeque<String> tokens = new ArrayDeque<>();
    static HashMap<String, BigInteger> vars = new HashMap<>();
    static boolean isError = false;
    static boolean isAssignment = false;
    static HashMap<String, Integer> precedence = new HashMap<>(
        Map.of("(", 0, "+", 1, "-", 1, "*", 2, "/", 2, ")", 3, "^", 4));


    /**
     * void calculate(String)
     *
     * Printing an answer if succeed calculations, error otherwise.
     */
    void calculate(final String line) {
        Tokenizer.tokenize(line);
        ErrorCheck.check();

        if (!isError) {
            Notation.rpn();
        }
        if (!isError) {
            evaluate();
        }
        if (!isAssignment) {
            System.out.println(result);
        }

        isError = false;
        isAssignment = false;
        rpn.clear();
        tokens.clear();
        result = "Invalid expression";
    }

    /**
     * void evaluate()
     *
     * Evaluate set of tokens in RPN form
     */
    void evaluate() {
        final ArrayDeque<BigInteger> rpnHelper = new ArrayDeque<>();

        while (!rpn.isEmpty()) {
            if (rpn.peekFirst().matches("[+-]?\\d+")) {
                rpnHelper.offer(new BigInteger(rpn.poll()));

            } else if (rpnHelper.size() < 2) {
                isError = true;
                return;

            } else {
                BigInteger a = rpnHelper.pollLast();
                BigInteger b = rpnHelper.pollLast();

                switch (rpn.peekFirst()) {
                    case "+":
                        rpnHelper.offer(b.add(a));
                        break;

                    case "-":
                        rpnHelper.offer(b.subtract(a));
                        break;

                    case "/":
                        if (a.equals(0)) {
                            result = "Division by zero!";
                            isError = true;
                            return;
                        }

                        rpnHelper.offer(b.divide(a));
                        break;

                    case "*":
                        rpnHelper.offer(b.multiply(a));
                        break;

                    case "^":
                        System.out.println("Exponent can't be negative with BigInteger!\nIf negative exponent will occur it will be changed to positive!");
                        rpnHelper.offer(b.pow(Math.abs(a.intValue())));
                        break;
                }

                rpn.poll();
            }
        }

        result = String.valueOf(rpnHelper.pollLast());
    }

    /**
     * void init()
     *
     * turn on the ~C-A-L-C-U-L-A-T-O-R~
     */
    void init() {
        final Scanner sc = new Scanner(System.in);

        while (true) {
            final String line = sc.nextLine().trim();

            if ("/exit".equals(line)) {
                System.out.println("Bye!");
                sc.close();
                return;
            }

            if ("/help".equals(line)) {
                final String msg = "Simple calculator with +/-*^ expr. and also has support for )(.\n"
                    + "It's possible to make a variable! a = -1 or a = -c\n"
                    + "Sequence of signs transforms into one. 3 --- 3  ->  3 - 3\n"
                    + "Unary support!\n"
                    + "Calculator performs integer division. 3 / 2  ->  1\n"
                    + "Can't do something similar to: 2-(-(2+3)) :(\n"
                    + "> 3 + 8 * ((4 + 3) * 2 + 1) - 6 / (2 + 1)\n"
                    + "121\n\n"
                    + "> a = 2\n"
                    + "> b = 3\n"
                    + "> c = 4\n"
                    + "> d = 4\n"
                    + "> e = 5\n"
                    + "> z = 3\n"
                    + "> o = 5\n"
                    + "> a + 8 * ((-e + a) * b + c) - d / (b + c) + z ^ -o\n"
                    + "-38";

                System.out.println(msg);
                continue;
            }

            if (line.isEmpty()) {
                continue;
            }

            if (line.charAt(0) == '/') {
                System.out.println("Unknown command");
                continue;
            }

            calculate(line);
        }
    }
}

/**
 * Tokenizer.
 *
 * Tokenize expressions.
 * (2 + 2) / 2  ->  [(, 2, +, 2, ), /, 2]
 */
class Tokenizer extends Calculator {
    static String minus = "";
    static String digitOrVariable = "";

    static void tokenize(final String line) {
        int state = 0;

        if (!line.contains("=")) {
            for (int i = 0; i < line.length(); i++) {
                final char chr = line.charAt(i);

                if (chr == '(' || chr == ')' || chr == '/' || chr == '*' || chr == '^') {
                    probablyAdd(state, 1);
                    tokens.offer("" + chr);
                    state = 1;

                } else if (chr == '+' || chr == '-') {
                    probablyAdd(state, 2);
                    minus += chr;
                    state = 2;

                } else if (Character.isLetterOrDigit(chr)) {
                    probablyAdd(state, 3);
                    digitOrVariable += chr;
                    state = 3;

                } else if (chr == ' ' && state != 2) {
                    probablyAdd(state, 0);

                } else if (chr != ' ') {
                    isError = true;
                    return;
                }
            }

            probablyAdd(state, 0);

        } else {
            ErrorCheck.check(line);
        }
    }

    static void probablyAdd(final int a, final int b) {
        if (a != b) {
            if (!minus.isEmpty()) {
                final int countMinus = minus.replaceAll("[^-]", "").length();
                tokens.offer(countMinus % 2 == 1 ? "-" : "+");
                minus = "";
            }

            if (!digitOrVariable.isEmpty()) {
                String last = tokens.peekLast();
                if (!tokens.isEmpty() && last.matches("-")) {
                    digitOrVariable = last + digitOrVariable;
                    tokens.pollLast();
                    if (!tokens.isEmpty() && tokens.peekLast().matches("[+-]?[)0-9a-zA-Z]+")) {
                        tokens.offer("+");
                    }
                }
                tokens.offer(digitOrVariable);
                digitOrVariable = "";
            }
        }
    }
}

/**
 * Notation.
 * Transform tokens into RPN (reverse polish notation).
 * RPN is achieved by Shunting-yard Algorithm
 *
 * @see https://en.wikipedia.org/wiki/Shunting-yard_algorithm
 */
class Notation extends Calculator {
    static void rpn() {
        final ArrayDeque<String> stack = new ArrayDeque<>();

        while (!tokens.isEmpty()) {

            final String tkn = tokens.poll();

            if (tkn.matches("[+-]?\\d+")) {
                rpn.offer(tkn);

            } else if (tkn.matches("[+-]?[a-zA-Z]+")) {
                boolean isUnary = tkn.charAt(0) == '-' || tkn.charAt(0) == '+';
                if (isUnary) {
                    String substr = tkn.substring(1);
                    if (vars.containsKey(substr)) {
                        rpn.offer(tkn.charAt(0) + String.valueOf(vars.get(substr)));
                    } else {
                        result = "Unknown variable";
                        isError = true;
                        return;
                    }

                } else if (vars.containsKey(tkn)) {
                    rpn.offer(String.valueOf(vars.get(tkn)));

                } else {
                    result = "Unknown variable";
                    isError = true;
                    return;
                }

            } else if ("(".equals(tkn)) {
                stack.offer(tkn);

            } else if (")".equals(tkn)) {
                while (!stack.isEmpty() && !"(".equals(stack.peekLast())) {
                    rpn.offer(stack.pollLast());
                }
                if (!"(".equals(stack.peekLast())) {
                    isError = true;
                    return;
                }

                stack.pollLast();

            } else {
                while (!stack.isEmpty() && precedence.get(tkn) <= precedence.get(stack.peekLast())) {
                    rpn.offer(stack.pollLast());
                }
                stack.offer(tkn);
            }

        }

        while (!stack.isEmpty()) {
            rpn.offer(stack.pollLast());
        }
    }
}


/**
 * ErrorCheck
 * Check if an expression/assignment is valid and print an error if it isn't.
 */
class ErrorCheck extends Calculator {
    // check expressions
    static void check() {
        boolean isCanBeAdjecentOperator = true;
        boolean isPreviousOperand = false;
        boolean isCanBeVar = true;

        for (final String str : tokens) {
            final boolean isSymbol = str.matches("[\\+\\)\\/\\*\\(\\-\\^]");
            final boolean isNotAdjacentOperand = str.matches("[\\/\\*]");

            if (!isCanBeAdjecentOperator && isNotAdjacentOperand ||
                (!isCanBeVar && !isSymbol)) {
                isError = true;
                return;
            }

            isCanBeVar = isSymbol;
            isPreviousOperand = !isSymbol;
            isCanBeAdjecentOperator = !isNotAdjacentOperand;
        }
    }

    // check assignments
    static void check(final String tokens) {
        final String[] op = tokens.split("=");

        if (op.length != 2) {
            result = "Invalid assignment";
            isError = true;
            return;
        }

        final String varName = op[0].trim();
        final String varVal = op[1].trim();

        if (!varVal.matches("[+-]?\\s*[a-zA-Z0-9]+")) {
            result = "Invalid assignment";
            isError = true;

        } else if (!varName.matches("[+-]?[a-zA-Z]+")) {
            result = "Invalid identifier";
            isError = true;

        } else if (varVal.matches("[+-]?\\s*\\d+")) {
            vars.put(varName, new BigInteger(varVal.replaceAll("\\s*", "")));
            isAssignment = true;

        } else if (varVal.matches("[+-]?\\s*(?:\\d+|[a-zA-Z]+)")) {
            String vv = varVal.replaceAll("\\s*", "");
            boolean isUnary = vv.charAt(0) == '-' || vv.charAt(0) == '+';

            if (isUnary) {
                if (vv.matches("[+-]?\\d+")) {
                    vars.put(varName, new BigInteger(varVal));
                    isAssignment = true;
                } else {
                    String ss = vv.substring(1);
                    if (vars.containsKey(ss)) {
                        vars.put(varName, vv.charAt(0) == '-' ? (new BigInteger("-1")).multiply(vars.get(ss)) : vars.get(ss));
                        isAssignment = true;
                    } else {
                        result = "Unknown variable";
                        isError = true;
                    }
                }
            } else {
                if (vv.matches("\\d+")) {
                    vars.put(varName, new BigInteger(varVal));
                    isAssignment = true;
                } else {
                    if (vars.containsKey(vv)) {
                        vars.put(varName, vars.get(vv));
                        isAssignment = true;
                    } else {
                        result = "Unknown variable";
                        isError = true;
                    }
                }
            }

        } else if (vars.containsKey(varVal)) {
            vars.put(varName, vars.get(varVal));
            isAssignment = true;

        } else if (!varVal.matches(".*\\d+.*")) {
            result = "Unknown variable";
            isError = true;

        } else {
            result = "Invalid assignment";
            isError = true;
        }
    }
}
