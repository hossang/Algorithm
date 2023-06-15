import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class VVE {
    int v1;
    int v2;
    int e;

    public VVE(int v1, int v2, int e) {
        this.v1 = v1;
        this.v2 = v2;
        this.e = e;
    }
}

public class Main {
    private static StringBuilder sb;
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N+1;i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            int e = Integer.parseInt(st.nextToken());
            list.add(e);
        }
        for (int i = 0; i < list.size(); i++) {
            union(0,list.get(i));
        }

        PriorityQueue<VVE> pq = new PriorityQueue<>((o1,o2) -> o1.e - o2.e);
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new VVE(u,v,w));
        }
        long res = 0L;
        while(!pq.isEmpty()) {
            VVE now = pq.poll();

            if(find(now.v1)!=find(now.v2)) {
                union(now.v1, now.v2);
                res += now.e;
            }
        }

        System.out.print(res);
    }

    private static int find(int x) {
        if(parents[x] == x){
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x < y) {
            parents[y] = x;
            return;
        }
        parents[x] = y;
        return;
    }
}
