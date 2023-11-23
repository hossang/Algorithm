import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");

        String ss = "";
        String tmp = "";
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)-'0'>=0&&s.charAt(i)-'0'<=9) {
                ss+= String.valueOf(s.charAt(i));
                continue;
            }
            int idx = i;
            while(idx<s.length()&&(s.charAt(idx)-'0'<0||s.charAt(idx)-'0'>9)) {
                tmp += String.valueOf(s.charAt(idx++));
                if(map.containsKey(tmp)) {
                    ss+=map.get(tmp);
                    break;
                }
            }
            tmp ="";
            i=--idx;
        }

        return Integer.parseInt(ss);
    }
}