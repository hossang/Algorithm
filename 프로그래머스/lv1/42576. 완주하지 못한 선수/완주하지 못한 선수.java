import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String s : participant) {
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for (String s : completion) {
            if(map.get(s)>0) {
                map.put(s,map.getOrDefault(s,0)-1);
            }
        }
        for (String s : map.keySet()) {
            if(map.get(s)>0) {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}