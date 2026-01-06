package com.dsa.algorithms.TwoPointers;

/**
 * Given a string, s, return TRUE if it is a palindrome; otherwise, return FALSE.<br>
 * A phrase is considered a palindrome if it reads the same backward as forward after converting all uppercase letters to lowercase and removing any characters that are not letters or numbers. Only alphanumeric characters (letters and digits) are taken into account.
 * @Time - O(n)
 * @Space - O(1)
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) left++;
            else if (!Character.isLetterOrDigit(s.charAt(right))) right--;
            else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            else {
                left++;
                right--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "Able was I, I saw Elba!";
        System.out.println(isPalindrome(str));
    }
}
