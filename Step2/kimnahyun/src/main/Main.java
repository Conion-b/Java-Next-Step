package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
    }

    public static class Calculator {
        int add(int i, int j){
            return i + j;
        }

        int subtract(int i, int j) {
            return i - j;
        }

        int multiply(int i, int j) {
            return i * j;
        }

        int divide(int i, int j) {
            return i / j;
        }

    }

    public static class StringCalculator {

        public int add(String text) {
            if (toBlank(text)) {
                return 0;
            }

            return sum(toInts(split(text)));
        }

        private boolean toBlank(String text) {
            return text == null || text.isEmpty();
        }

        private String[] split(String text) {
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
            if (m.find()) {
                String customDelimeter = m.group(1);
                return m.group(2).split(customDelimeter);
            }
            return text.split(",|:");
        }

        private int[] toInts(String[] values) {
            int[] numbers = new int[values.length];
            for (int i = 0; i < values.length; i++) {
                numbers[i] = toPositive(values[i]);
            }
            return numbers;
        }

        private int sum(int[] numbers) {
            int sum = 0;
            for (int num : numbers) {
                sum += num;
            }
            return sum;
        }

        private int toPositive(String value) {
            int number = Integer.parseInt(value);
            if (number < 0) {
                throw new RuntimeException();
            }
            return number;
        }
    }
}