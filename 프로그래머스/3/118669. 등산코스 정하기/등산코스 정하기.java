import java.io.*;
import java.util.*;

class VE {
    int v;
    long e;
    
    VE(int v, long e) {
        this.v = v;
        this.e = e;
    }
}


class Solution {
    private static final long INF = 1234567891 + 1;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<VE>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<paths.length;i++) {
            graph.get(paths[i][0]).add(new VE(paths[i][1], paths[i][2]));
            graph.get(paths[i][1]).add(new VE(paths[i][0], paths[i][2]));
        }
        long[] dist = new long[n+1];
        Arrays.fill(dist,INF);
        PriorityQueue<VE> pq = new PriorityQueue<>((o1,o2) -> Long.compare(o1.e,o2.e));
        
        for(int i=0;i<gates.length;i++) {
            dist[gates[i]] = 0;
            pq.offer(new VE(gates[i],0));
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<summits.length;i++) {
            set.add(summits[i]);
        }
        
        while(!pq.isEmpty()) {
            VE now = pq.poll();
            
            if(dist[now.v] < now.e) {
                continue;
            }
            
            for(VE next : graph.get(now.v)) {
                if(dist[next.v] > Math.max(now.e, next.e)) {
                    dist[next.v] = Math.max(now.e, next.e);
                    if(set.contains(next.v)) {
                        continue;
                    }
                    pq.offer(new VE(next.v, dist[next.v]));
                }
             }
        }
        int[] res = new int[2]; 
        res[1] = Integer.MAX_VALUE;
        for(int i=1;i<dist.length;i++) {
            if(dist[i]==INF) {
                continue;
            }
            if(set.contains(i)) {
                if(res[1] >dist[i]) {
                    res[0] = i;
                    res[1] = (int)dist[i];
                    System.out.print(res[1]);
                }
            }
        }
        
        return res;
    }
}