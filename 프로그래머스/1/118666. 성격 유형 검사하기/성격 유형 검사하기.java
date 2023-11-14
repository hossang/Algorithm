import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        //지문이 너--무 길어
        Map<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        
        for(int i=0;i<survey.length;i++) {
            if(choices[i]<4) {
                char c = survey[i].charAt(0);
                map.put(c,map.getOrDefault(c,0) + 4-choices[i]);
                continue;
            }
            if(choices[i]>4) {
                char c = survey[i].charAt(1);
                map.put(c,map.getOrDefault(c,0) + choices[i]-4);
            }
        }
        String[] arr = {"RT", "CF", "JM", "AN"};
        char[] carr = new char[4];
        for(int i=0;i<4;i++) {
            char c1 = arr[i].charAt(0);
            char c2 = arr[i].charAt(1);
            
            if(map.get(c1) >= map.get(c2)) {
                carr[i] = c1;
                continue;
            }
            carr[i] = c2;
        }
        
        return String.valueOf(carr);
        
    }
}