import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum = 0;
        long sum1 = 0;
        long sum2 = 0;
        
        Deque<Integer> dq1 = new ArrayDeque<>();
        Deque<Integer> dq2 = new ArrayDeque<>();
        
        for(int i=0;i<queue1.length;i++) {
            sum1 += queue1[i];
            dq1.addLast(queue1[i]);
        }
        for(int i=0;i<queue2.length;i++) {
            sum2 += queue2[i];
            dq2.addLast(queue2[i]);
        }
        sum = sum1 + sum2;
        sum /=2;
        int res = 0;
        boolean flag = false;
        for(int i=0;i<queue1.length * 3 + 1 ; i++) {
            if(sum1>sum) {
                int a = dq1.pollFirst();
                dq2.addLast(a);
                sum1-=a;
                sum2+=a;
                res++;
                continue;
            }
            if(sum1<sum) {
                int a = dq2.pollFirst();
                dq1.addLast(a);
                sum2-=a;
                sum1+=a;
                res++;
                continue;
            }
            if(sum1==sum) {
                flag = true;
                break;
            }
        }
        if(flag) {
            return res;
        }
        return -1;
    }
}