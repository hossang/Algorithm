import java.io.*;
import java.util.*;

class VVE {
    IXYZ v1;
    IXYZ v2;
    int e;

    VVE (IXYZ v1, IXYZ v2, int e) {
        this.v1 = v1;
        this.v2 = v2;
        this.e = e;
    }
}

class IXYZ {
    int i;
    int x;
    int y;
    int z;

    IXYZ(int i, int x, int y, int z) {
        this.i = i;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    private static int[] parents;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        for(int i = 0; i <= N; i++) {
            parents[i] = i;
        }
        PriorityQueue<VVE> pq = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);
        List<IXYZ> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            list.add(new IXYZ(i,x,y,z));
        }

        Collections.sort(list, (o1, o2) -> o1.x - o2.x);
        for (int i = 0; i < list.size() - 1; i++) {
            IXYZ A = list.get(i);
            IXYZ B = list.get(i+1);
            pq.offer(new VVE(A, B, B.x - A.x));

        }
        Collections.sort(list, (o1, o2) -> o1.y - o2.y);
        for (int i = 0; i < list.size() - 1; i++) {
            IXYZ A = list.get(i);
            IXYZ B = list.get(i+1);
            pq.offer(new VVE(A, B, B.y - A.y));

        }
        Collections.sort(list, (o1, o2) -> o1.z - o2.z);
        for (int i = 0; i < list.size() - 1; i++) {
            IXYZ A = list.get(i);
            IXYZ B = list.get(i+1);
            pq.offer(new VVE(A, B, B.z - A.z));

        }

        long res = 0L;
        while (!pq.isEmpty()) {
            VVE now = pq.poll();

            if (find(now.v1.i) != find(now.v2.i)) {
                union(now.v1.i, now.v2.i);
                res += now.e;
            }
        }

        System.out.print(res);
    }

    private static int find(int x) {
        if(parents[x] ==x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x<y) {
            parents[y] = x;
            return;
        }
        parents[x] = y;
    }
}
