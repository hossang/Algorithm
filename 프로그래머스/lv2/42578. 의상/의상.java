import java.io.*;
import java.util.*;

class Solution {
    private static Map<String, Integer> map;
    private static List<String> list;
    private static int res;
    public int solution(String[][] clothes) {
        map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        list = new ArrayList<>();
        res = 1;
        for(String s : map.keySet()) {
            res*=(map.get(s)+1);
        }
        
        
        return res-1;
    }
    
}