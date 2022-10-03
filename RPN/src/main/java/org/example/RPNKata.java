package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RPNKata {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int process(final int firstArgument, final int secondArgument, final String operator) {
        switch (operator) {
            case "MAX":
                return Math.max(firstArgument, secondArgument);
            case "*":
                return firstArgument * secondArgument;
            case "/":
                return firstArgument / secondArgument;
            case "-":
                return firstArgument - secondArgument;
            case "+":
            default:
                return firstArgument + secondArgument;
        }
    }

    public int process(final String string) {
        final List<String> operation = Arrays.asList(string.split("\\s+"));
        if (operation.size() >= 2) {
            if (operation.contains("SQRT")) {
                return (int) Math.sqrt(Double.parseDouble(operation.get(0)));
            }
            final int firstArgument = Integer.parseInt(operation.get(0));
            final int secondArgument = Integer.parseInt(operation.get(1));
            final String operator = operation.get(2);
            if (isOnlyMax(string)) {
                return Integer.parseInt(Collections.max(operation.subList(0, operation.size() - 1)));
            }
            if (operatorIsANumber(operator)) {
                int positionToStart = operation.get(0).length() + 1;
                return process(firstArgument + " " +
                        (process(string.substring(positionToStart, string.length() - 2))) + " " +
                        string.substring(string.length() - 2).trim());
            }
            final String rest = String.join(" ", operation.subList(3, operation.size()));
            return process(process(firstArgument, secondArgument, operator) + " " + rest);
        } else {
            return Integer.parseInt(string.trim());
        }
    }

    private boolean isOnlyMax(final String string) {
        return string.matches("^[\\d\\s]+MAX$");
    }

    private boolean operatorIsANumber(final String operator) {
        return operator.matches("\\d+");
    }


}
