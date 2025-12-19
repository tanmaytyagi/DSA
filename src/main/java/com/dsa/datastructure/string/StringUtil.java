package com.dsa.datastructure.string;

public class StringUtil {
    public static void main(String[] args) {
        String s = "abc";
        char[] arr = {'h','e','l','l','o'};
        String s1 = new String(arr);

        byte[] bytes = {65, 66, 67};
        String s2 = new String(bytes);

        StringBuilder sb = new StringBuilder("abc");
        String s3 = new String(sb);

        int length = s1.length();
        boolean b = s1.isEmpty();

        char ch =  s1.charAt(0);
        char[]a = s1.toCharArray();


    }
}
