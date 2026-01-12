package com.dsa.util;

import java.util.HashSet;
import java.util.Set;

public class SetUtil {
    public static void main(String[] args) {

        // initialize the set
        Set<Integer> s = new HashSet<>();

        // add element
        s.add(1);

        // remove element
        s.remove(2);

        // check if exist
        boolean isExist = s.contains(10);

        // size of set
        int size = s.size();

        // check if set is empty
        boolean isEmpty = s.isEmpty();

        // iteration
        for(Integer i : s) { System.out.println("i = " + i); }
    }
}
