package com.dsa.algorithms.Arrays.TwoPointers;

/**
 * "cal3ar" and "calendar" are valid word abbreviation, whereas
 * "c24r" and "calendar" are not.
 */

public class ValidWordAbbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while (i < word.length() && j < abbr.length()) {
            if(abbr.charAt(j) == '0') return false;
            if(Character.isDigit(abbr.charAt(j))) {
                int k = j;
                while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) j++;
                int num = Integer.parseInt(abbr.substring(k,j));
                if(i + num > word.length()) return false;
                i += num;
            } else {
                if(word.charAt(i++) != abbr.charAt(j++)) return false;
            }
        }

        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("abcdefg", "1b3f1"));
    }
}
