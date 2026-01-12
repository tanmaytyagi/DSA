package com.dsa.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {
    public static void main(String[] args) {

        // ================== HASHMAP ==================

        Map<Integer, Integer> m = new HashMap<>();

        // insert into map
        m.put(1, 2);

        // get from the map
        Integer val = m.getOrDefault(2, null);

        // remove from the map
        m.remove(1);

        // check if exist
        boolean ifExist = m.containsKey(1);

        // get the size
        int size = m.size();

        // check if map is empty
        boolean isEmpty = m.isEmpty();

        // iterate over keys
        for(Integer key : m.keySet()) { System.out.println("key: " + key); }

        // iterate over values
        for(Integer value : m.values()) { System.out.println("value: " + value); }
    }
}
