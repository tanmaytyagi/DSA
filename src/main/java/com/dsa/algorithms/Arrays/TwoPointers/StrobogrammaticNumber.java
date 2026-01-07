package com.dsa.algorithms.Arrays.TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

    private static final Map<Character, Character> map = new HashMap<>();
    static {
        map.put('6', '9');
        map.put('9', '6');
        map.put('1', '1');
        map.put('8', '8');
        map.put('0', '0');
    }

    public static boolean isStrobogrammatic(String num) {
        if(num == null) throw new NullPointerException("num is null");
        if(num.isEmpty()) throw new IllegalArgumentException("num is empty");

        int i = 0;
        int j = num.length() - 1;

        while(i <= j) {
            char ci = num.charAt(i);
            char cj = num.charAt(j);
            if(!map.containsKey(ci) ||  map.get(ci) != cj) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("96"));
    }
}
