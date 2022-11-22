import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        if(nums.length/2>=map.size()) {
            return map.size();
        }
        return nums.length/2;
    }
}