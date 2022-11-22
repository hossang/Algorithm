import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] p) {
        Arrays.sort(p);
        
        for(int i=0;i<p.length-1;i++) {
            if(p[i+1].startsWith(p[i])) {
                return false;
            }
        }
        return true;
    }
}