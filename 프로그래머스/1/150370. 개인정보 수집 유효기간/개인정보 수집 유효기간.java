import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //모든 달은 28일까지 있다고 가정합니다.
        StringTokenizer st;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<terms.length;i++) {
            st = new StringTokenizer(terms[i], " .");
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<privacies.length;i++) {
            st = new StringTokenizer(privacies[i], " .");
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int pm = map.get(st.nextToken());
            int yy =y;
            int mm = m;
            int dd = d;
            if(d==1) {
                dd = 28;
                if(m==1) {
                    mm = pm;
                }
                if(m!=1) {
                    mm +=pm-1;
                }
                
            }
            if(d!=1) {
                dd-=1;
                mm+=pm;
            }
            
            while(mm>12) {
                yy++;
                mm -=12;
            }
            System.out.print(yy+" ");
            System.out.print(mm +" ");
            System.out.println(dd +" ");
            
            st = new StringTokenizer(today, " .");
            int ty = Integer.parseInt(st.nextToken());
            int tm = Integer.parseInt(st.nextToken());
            int td = Integer.parseInt(st.nextToken());
            //오늘 날짜보다 작으면 파기
            if(ty<yy) {
                continue;
            }
            if(ty==yy) {
                if(tm<mm) {
                    continue;
                }
                if(tm==mm) {
                    if(td<=dd) {
                        continue;
                    }
                }
                list.add(i+1);
                continue;
            }
            if(ty>yy) {
                list.add(i+1);
                continue;
                
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for(Integer x : list) {
            res[i++] = x;
        }
        return res;
    }
}