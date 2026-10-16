package com.dsa.util;

public class StringBuilderUtil {
    public static void main(String[] args) {

        // constructors - with initial allotted capacity, len = 0
        StringBuilder sb = new StringBuilder(10);

        // can append char, String, int, float, long
        sb.append('D');
        sb.append("Tony");
        sb.append(123);

        // character at specific index
        char ch = sb.charAt(0);

        // modify particular index
        sb.setCharAt(0, 'A');

        // reverse the string
        sb.reverse();

        // length of string
        int len = sb.length();

        // append anything multiple times
        sb.repeat("Bye", 2);

        // convert to string
        String output = sb.toString();

        System.out.println(output);
    }
}
