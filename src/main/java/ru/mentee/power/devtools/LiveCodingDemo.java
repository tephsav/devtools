package ru.mentee.power.devtools;

import java.util.Arrays;
import java.util.List;

public class LiveCodingDemo {
    public static void main(String[] args) {
        // #1
        printFizzBuzz(15);

        // #2
        System.out.println(sumEven(new int[]{1, 2, 6, 5, 9, 8, 11}));

        // #3
        try {
            System.out.println(findMax(new int[]{}));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // live coding
        List<Integer> list = Arrays.asList(1, 2, null, 4, null, 5);
        LiveCodingDemo liveCodingDemo = new LiveCodingDemo();
        System.out.println(liveCodingDemo.sumOddElements(list));
    }

    // live coding
    public int sumOddElements(List<Integer> array) {
        if (array == null) {
            return 0;
        }

        int sum = 0;

        for (Integer item : array) {
            if (item != null && item % 2 != 0) {
                sum += item;
            }
        }

        return sum;
    }

    public static void printFizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static int sumEven(int[] numbers) {
        int sum = 0;

        for (int value : numbers) {
            if (value % 2 == 0) {
                sum += value;
            }
        }

        return sum;
    }

    public static int findMax(int[] numbers) {
        int max = Integer.MIN_VALUE;

        if (numbers.length == 0) {
           // return max;
            throw new IllegalArgumentException("Пустой массив");
        }

        for (int item : numbers) {
            if (item > max) {
                max = item;
            }
        }

        return max;
    }
}