import java.io.*;
import java.util.*;
/*

@author s_cheol.park
https://www.acmicpc.net/problem/1854
K번째 최단경로 찾기
다익스트라 알고리즘
최단거리 배열을 1차원으로 선언해서, 최종적으로 K 번째의 값만 알수있는 방식임.
최단거리 배열을 우선순위 큐를 이용해서 구할수도 있음 (모든 최단거리를 다 들고 있는 방식)
*/
class VE {
    int v;
    int e;

    public VE(int v, int e) {
        this.v = v;
        this.e = e;
    }
}

public class Main {
    static int N, M, K;
    static List<List<VE>> graph;
    static int [] distance;
    static int [] visit;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        distance = new int [N + 1];
        visit = new int [N + 1];
        for(int i = 0 ; i <= N ; i++) {
            graph.add(new ArrayList<>());
            distance[i] = INF;
        }
        int a, b, c;
        for(int i = 1 ; i <= M ;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new VE(b, c));
        }

        dijkstra(1);

        for(int i = 1 ; i <= N ; i++) {
            if(visit[i] == K) {
                sb.append(distance[i]).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<VE> pq = new PriorityQueue<>((o1,o2) -> o1.e-o2.e);
        pq.add(new VE(start,0));

        while(!pq.isEmpty()) {
            VE now = pq.poll();

            if(visit[now.v] == K) {
                continue;
            }

            visit[now.v]++;
            distance[now.v] = now.e;

            for(VE next : graph.get(now.v)) {
                if(visit[next.v] < K) {
                    pq.add(new VE(next.v, distance[now.v] + next.e));
                }
            }
        }
    }
}