package com.dsa.algorithms.Arrays;

public class IsSumOfSquareOfDigitsConvergesToOne {

    private static int sumOfSquareOfDigits(int num) {
        int result = 0;
        while(num != 0) {
            int digit = num % 10;
            result += digit * digit;
            num /= 10;
        }
        return result;
    }

    public static boolean isSumOfSquareOfDigitsConvergesToOne(int num) {
        int slow = num;
        int fast = sumOfSquareOfDigits(num);
        while (fast != 1 && slow != fast) {
            slow = sumOfSquareOfDigits(slow);
            fast = sumOfSquareOfDigits(fast);
            fast = sumOfSquareOfDigits(fast);
        }

        return fast == 1;
    }

    public static void main(String[] args) {
        System.out.println(isSumOfSquareOfDigitsConvergesToOne(7));
    }
}
