import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static int visit_order[];
    static List<List<Integer>> graph;
    static boolean ans[];	// 단절점 여부 기록
    static int ansCnt;		// 단절점 개수
    static int num;			// 방문 순서


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visit_order = new int[V + 1];
        ans = new boolean[V + 1];

        for(int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // DFS로 단절점 찾기
        for(int i = 1; i <= V; i++) {
            // 그래프가 모두 연결되어 있는 상태가 아니기 때문에...
            if(visit_order[i] == 0) {
                // 시작하는 점을 root
                dfs(0, i, true);
            }
        }

        // 단절점 개수 count
        for(int i = 1; i <= V; i++) {
            if(ans[i]) ansCnt++;
        }
        sb.append(ansCnt).append("\n");

        for(int i = 1; i <= V; i++) {
            if(ans[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static int dfs(int parent, int cur, boolean isRoot) { //★ cur 현재 시작점, parent는 0??
        // 1. check in
        // 현재 노드 방문한 적 없는 경우에만 실행
        if(visit_order[cur] != 0) return 0;
        int min_visit_order = 10001;	// 현재 노드의 최소 방문 순서 = 자식 노드들 중 가장 작은 방문 순서로 초기화 ★ 10001 아니야 ?
        int chlcnt = 0;		// 자식 노드 개수

        // 방문 순서 입력
        num++;
        visit_order[cur] = num;

        // 2. (목적지에 도착했는가?)


        // 3. 연결된 곳 순회
        for(int i = 0; i < graph.get(cur).size(); i++) {
            int nxt = graph.get(cur).get(i);
            // 4. 갈 수 있는가
            // 간선이 부모 노드와의 간선이면 건너뜀 ★ 부모가 0 인데 그럼 같을 수가 있나 ? -> 95line 에서 바뀜
            if(nxt == parent) continue;

            // 연결된 노드가 방문한 적이 있고,
            if(visit_order[nxt] != 0) {
                // 현재 노드보다 일찍 방문했다면 자식 중 최소 방문 순서를 update
                if(visit_order[nxt] < min_visit_order) {
                    min_visit_order = visit_order[nxt];
                }
            }else {	// 연결된 노드가 방문한 적 없는 경우에만 방문

                // 5. 간다
                int tmp = dfs(cur, nxt, false);
                min_visit_order = Math.min(min_visit_order, tmp);

                if(isRoot != true && tmp >= visit_order[cur]) {
                    // 루트노드가 아니고,
                    // 연결된 점의 주변 최소 방문 순서가 현재 점보다 같거나 크면 현재 점은 단절점!
                    ans[cur] = true;
                }
                chlcnt++;
            }
        }

        // 리프노드면 단절점 처리 해주지 않음
        if(graph.get(cur).size() == 1) {
            return visit_order[cur];
        }

        // root 노드 예외 처리
        if(isRoot) {
            if(chlcnt >= 2) {
                ans[cur] = true;
            }
        }

        // 체크아웃
        return Math.min(min_visit_order, visit_order[cur]);
    }

}