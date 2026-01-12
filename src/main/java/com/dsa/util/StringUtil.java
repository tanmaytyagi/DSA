package com.dsa.util;


@SuppressWarnings("all")
public class StringUtil {
    public static void main(String[] args) {

        // ================== CHARACTER ARRAYS ==================





        // ================== STRING ==================

        String s = "abc";

        // length of the String
        int n = s.length();

        // char at index
        char ch = s.charAt(0);

        // check if equal
        boolean isEqual1 = s.equals("abc");
        boolean isEqual2 = s.equalsIgnoreCase("ABC");

        // compare two string
        int diff = s.compareTo("zzz");

        // convert to char array
        char[] arr = s.toCharArray();





        // ================== STRING BUILDER ==================

        StringBuilder sb = new StringBuilder();

        // append
        sb.append('c');
        sb.append("hello");
        sb.append(123);

        // length
        int l = sb.length();

        // char at index
        char c = sb.charAt(0);

        // modify at index
        sb.setCharAt(0, 'A');

        // convert to string
        String result = sb.toString();

        // reverse
        sb.reverse();
    }
}
