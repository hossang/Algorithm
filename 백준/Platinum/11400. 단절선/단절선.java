import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class VV {
    int v1;
    int v2;

    public VV(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
}

public class Main {
    static int V, E;
    static List<List<Integer>> graph;
    static int[] visit_order;
    static List<VV> answer;
    static int ordernum;

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visit_order = new int [V + 1];
        answer = new ArrayList<>();
        graph = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        int a, b;
        for(int i = 1 ; i <= E ;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        //DFS로 단절점 찾기
        // 단절되어 있는 그래프가 있을 수 있어
        for(int i = 1 ; i<= V ; i++) {
            if(visit_order[i] == 0) {
                dfs(i, 0);
            }
        }
        //단절점 출력
        sb.append(answer.size()).append("\n");
        Collections.sort(answer, new Comparator<VV>() {
            @Override
            public int compare(VV o1, VV o2) {
                if (o1.v1 == o2.v1) {
                    return o1.v2 - o2.v2;
                }
                return o1.v1 - o2.v1;
            }
        });
        for (VV vv : answer) {
            sb.append(vv.v1).append(" ").append(vv.v2).append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int now, int parent) {
        ordernum++; // 방문순서
        visit_order[now] = ordernum;
        int min_visit_order = ordernum; // 지금 정점이후에 도달훌수 있는 모든 정점들의 탐색순서 중 가장 작은값

        for (int next : graph.get(now)) {
            if (next == parent) { //★ 단절선에서 필수
                continue;
            }
            if (visit_order[next] == 0) {
                // 자식 정점 중 방문 순서가 가장 빠른 값.
                // 이때, 특정 자식 정점이 여러 개의 정점을 타고 타고 올라가서 1번 정점까지 갈 수도 있다는 점에 유의해야 함.
                int low = dfs(next, now); // 현재 정점의 다음에 방문할 모든 정점에 대해서 도달할수 있는 min_visit_order (우회로가 있나 찾아보는 것임)

                // Root 가 아니고, 내 다음에 방문할 정점의 순서가 모두 나보다 클 경우에 지금위치는 단절점이다.
                if (low > visit_order[now]) {
                    if (next < now) {
                        answer.add(new VV(next, now));
                    } else {
                        answer.add(new VV(now, next));
                    }
                }
                min_visit_order = Math.min(min_visit_order, low);
            } else { // 자식정점이 이미 방문한 경우
                min_visit_order = Math.min(min_visit_order, visit_order[next]);
            }
        }

        return min_visit_order;
    }
}