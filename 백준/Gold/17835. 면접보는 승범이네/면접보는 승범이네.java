import java.io.*;
import java.util.*;

class VE{
    int v;
    long e;
    VE(int v, long e) {
        this.v = v;
        this.e = e;
    }
}

public class Main {
    private static StringBuilder sb;
    private static long[] dist;
    private static final long INF = 1_000_000_000_001L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st=new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<VE>> graph = new ArrayList<>();
        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }
        //그래프 역순
        for(int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine(), " ");
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(V).add(new VE(U,C));
        }
        st=new StringTokenizer(br.readLine(), " ");
        dist = new long[N+1];
        Arrays.fill(dist,INF);
        PriorityQueue<VE> pq = new PriorityQueue<>((o1,o2) -> Long.compare(o1.e,o2.e));
        Set<Integer> set = new HashSet<>();
        while(st.hasMoreTokens()) {
            int e = Integer.parseInt(st.nextToken());
            set.add(e);
            dist[e] = 0;
            pq.offer(new VE(e,0));

        }

        while(!pq.isEmpty()) {
            VE now = pq.poll();

            if(now.e >dist[now.v]) {
                continue;
            }

            for(VE next : graph.get(now.v)) {
                if(dist[next.v] > now.e +next.e) {
                    dist[next.v] = now.e + next.e;
                    pq.offer(new VE(next.v,dist[next.v]));
                }
            }
        }

        int ans1 = 0;
        long ans2 = 0;
        for (int i = 1; i <= N; i++) {
            if(set.contains(i)) {
                continue;
            }
            if (ans2 < dist[i]) {
                ans1 = i;
                ans2 = dist[i];
            }
        }
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
