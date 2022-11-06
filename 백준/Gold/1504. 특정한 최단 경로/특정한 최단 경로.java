import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = 160000001;
    public static class EV {
        int e;
        int v;

        public EV(int e, int v) {
            this.e = e;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<EV>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            al.get(a).add(new EV(b, c));
            al.get(b).add(new EV(a, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr1 = {1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), n};
        int[] arr2 = {1, arr1[2], arr1[1], n};
        int sum1 = 0;
        int sum2 = 0;
        for (int i =0;i<arr1.length-1;i++) {
            PriorityQueue<EV> pq = new PriorityQueue<>(new Comparator<EV>() {
                @Override
                public int compare(EV o1, EV o2) {
                    return o1.v - o2.v;
                }
            });

            int[] dist = new int[n + 1];
            Arrays.fill(dist, INF);
            dist[arr1[i]] = 0;
            pq.add(new EV(arr1[i], 0));
            while (!pq.isEmpty()) {
                EV now = pq.poll();

                if (dist[now.e] < now.v) {
                    continue;
                }
                for (EV next : al.get(now.e)) {
                    if (dist[next.e] > now.v + next.v) {
                        dist[next.e] = now.v + next.v;
                        pq.add(new EV(next.e, dist[next.e]));
                    }
                }
            }
            sum1 += dist[arr1[i + 1]];
        }
        for (int i =0;i<arr2.length-1;i++) {
            PriorityQueue<EV> pq = new PriorityQueue<>(new Comparator<EV>() {
                @Override
                public int compare(EV o1, EV o2) {
                    return o1.v - o2.v;
                }
            });

            int[] dist = new int[n + 1];
            Arrays.fill(dist, INF);
            dist[arr2[i]] = 0;
            pq.add(new EV(arr2[i], 0));
            while (!pq.isEmpty()) {
                EV now = pq.poll();

                if (dist[now.e] < now.v) {
                    continue;
                }
                for (EV next : al.get(now.e)) {
                    if (dist[next.e] > now.v + next.v) {
                        dist[next.e] = now.v + next.v;
                        pq.add(new EV(next.e, dist[next.e]));
                    }
                }
            }
            sum2 += dist[arr2[i + 1]];
        }
        if (Math.min(sum1,sum2) >= INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(sum1,sum2));
    }
}