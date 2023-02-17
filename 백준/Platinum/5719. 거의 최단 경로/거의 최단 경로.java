
import java.io.*;
import java.util.*;

class VE {
    int vertex;
    int edge;

    VE(int vertex, int edge) {
        this.vertex = vertex;
        this.edge = edge;
    }
}

public class Main {
    private static int INF = 123_456_789;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N ==0 && M==0) {
                break;
            }
            List<List<VE>> graph1 = new ArrayList<>();
            List<List<Integer>> graph2 = new ArrayList<>();
            for(int i=0;i<N;i++) {
                graph1.add(new ArrayList<>()); //그래프
                graph2.add(new ArrayList<>()); //최단 그래프
            }
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                graph1.get(U).add(new VE(V,P));
            }
            int[] dist = new int[N];
            Arrays.fill(dist, INF);
            //1. 다익스트라 한번 돌려
            dist[S] = 0;
            PriorityQueue<VE> pq = new PriorityQueue<>((o1, o2) -> o1.edge - o2.edge);
            pq.offer(new VE(S,0));
            while(!pq.isEmpty()) {
                VE now = pq.poll();

                if(dist[now.vertex] < now.edge) {
                    continue;
                }

                for(VE next : graph1.get(now.vertex)) {
                    if(dist[next.vertex] == next.edge + now.edge) { //최단 경로 여러개이면 graph2에 추가해주기
                        graph2.get(next.vertex).add(now.vertex);
                    }

                    if(dist[next.vertex] > next.edge + now.edge) {
                        dist[next.vertex] = next.edge + now.edge;
                        pq.offer(new VE(next.vertex, dist[next.vertex]));
                        //다익스트라에서 추가된 부분
                        graph2.get(next.vertex).clear(); // 갱신되면 dist[next.vertex] == next.edge + now.edge 해줬던거 다 없애줘야지
                        graph2.get(next.vertex).add(now.vertex);// 갱신된거 최단그래프에 넣어주기
                    }
                }
            }

            //2. 최단경로들 찾기
            boolean[][] shortestPaths = new boolean[N][N]; //경로를 기억하기
            dfs(D,S, graph2, shortestPaths);
            //3. 다익스트라 다시 돌려
            Arrays.fill(dist, INF);
            dist[S] = 0;
            pq = new PriorityQueue<>((o1, o2) -> o1.edge - o2.edge);
            pq.offer(new VE(S,0));
            while(!pq.isEmpty()) {
                VE now = pq.poll();

                if(dist[now.vertex] < now.edge) {
                    continue;
                }

                for(VE next : graph1.get(now.vertex)) {
                    if(shortestPaths[now.vertex][next.vertex]) { //1.에 없던 부분, 최단 경로였던 부분은 continue
                        continue;
                    }
                    if(dist[next.vertex] > next.edge + now.edge) {
                        dist[next.vertex] = next.edge + now.edge;
                        pq.offer(new VE(next.vertex, dist[next.vertex]));
                    }
                }
            }
            if(dist[D] == INF) { //최단경로가 없으면 -1 출력
                sb.append(-1).append("\n");
                continue;
            }
            sb.append(dist[D]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int now, int s, List<List<Integer>> reversegraph, boolean[][] shortestPaths) {
        if(now==s) {
            return;
        }
        //★ 아니 나 이부분 궁금한게 지금 남아 있는것들이 무조건 S->D의 최단경로들만 남은거야 ?
        for(int next:reversegraph.get(now)) {
            if (shortestPaths[next][now]==false) {
                shortestPaths[next][now] = true;
                dfs(next, s, reversegraph, shortestPaths);
            }
        }

    }
}
