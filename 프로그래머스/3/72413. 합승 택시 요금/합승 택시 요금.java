import java.util.*;
import java.io.*;

class VE{
    int v;
    long e;
    
    VE(int v, long e) {
        this.v=v;
        this.e=e;
    }
}

class Solution {
    private static final long INF = 20_000L * 100_000L + 1;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<VE>> graph = new ArrayList<>();
        for(int i=0;i<n+1;i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<fares.length;i++) {
            graph.get(fares[i][0]).add(new VE(fares[i][1],fares[i][2]));
            graph.get(fares[i][1]).add(new VE(fares[i][0],fares[i][2]));
        }
        //1. 다익스트라 3번 
        long[] distA = dijkstra(a, n, graph);
        long[] distB = dijkstra(b, n, graph);
        long[] distS = dijkstra(s, n, graph);
        //2. distA[i] + distB[i] + distS[i] 최솟값찾기
        long min = INF;
        for(int i=1;i<n+1;i++) {
            if(min> distA[i] + distB[i] + distS[i]) {
                min = distA[i] + distB[i] + distS[i];
            }
        }
        
        return (int)min;
    }
    
    private long[] dijkstra(int a, int n, List<List<VE>> graph) {
        long[] dist = new long[n+1];
        Arrays.fill(dist,INF);
        PriorityQueue<VE> pq = new PriorityQueue<>((o1,o2) -> Long.compare(o1.e,o2.e));
        dist[a] = 0;
        pq.offer(new VE(a,0));
        
        while(!pq.isEmpty()) {
            VE now = pq.poll();
            
            if(dist[now.v] < now.e) {
                continue;
            }
            
            for(VE next : graph.get(now.v)) {
                if(dist[next.v] > now.e + next.e) {
                    dist[next.v] = now.e + next.e;
                    pq.offer(new VE(next.v,dist[next.v]));
                }
            }
        }
        return dist;
    }
}