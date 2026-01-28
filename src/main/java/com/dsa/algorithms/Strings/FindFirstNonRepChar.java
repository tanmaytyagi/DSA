package com.dsa.algorithms.Strings;

import java.util.Arrays;
import java.util.HashMap;

public class FindFirstNonRepChar {

    // T = O(2n)
    public static char findFirstNonRepChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < str.length(); i++) {
            char c = str.charAt(i);
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        for(int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);
            int count = map.get(c);
            if(count == 1) return c;
        }

        return '$';
    }

    // optimized -> O(n)
    public static char findFirstNonRepChar2(String str) {
        int[] visited = new int[26];
        Arrays.fill(visited, -1);

        for(int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);
            if(visited[c - 'a'] == -1) visited[c - 'a'] = i;
            else visited[c - 'a'] = -2;
        }

        int idx = -1;
        for(int i = 0 ; i < 26 ; i++) {
            if(visited[i] >= 0 && (idx == -1 || visited[i] < visited[idx])) {
                idx = i;
            }
        }

        return idx == -1 ? '$' : str.charAt(visited[idx]);
    }

    public static void main(String[] args) {
        String s = "abbacdcerrpsllspd";
        System.out.println(findFirstNonRepChar2(s));
    }
}
