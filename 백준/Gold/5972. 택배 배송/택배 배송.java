import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dist;
    private static final int INF = 500_000_01;

    private static class VE {
        int v;
        int e;

        public VE(int v, int e) {
            this.v = v;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        ArrayList<ArrayList<VE>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new VE(b, c));
            list.get(b).add(new VE(a, c));
        }

        PriorityQueue<VE> pq = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);

        pq.offer(new VE(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            VE now = pq.poll();

            if (dist[now.v] < now.e) {
                continue;
            }

            for (VE next : list.get(now.v)) {
                if (dist[next.v] > now.e + next.e) {
                    dist[next.v] = now.e + next.e;
                    pq.offer(new VE(next.v, dist[next.v]));
                }
            }
        }
        System.out.println(dist[n]);


    }
}