import java.io.*;
import java.util.*;

/*
* LCA
* 1. sparseTable의 y값 구하기
* 2. DFS 한번 돌면서 노드별 각각의 깊이와 sparseTable[0] 채우기
* 3. sparseTable 다 채우기
* 4. 두 노드의 높이 맞춰주기 (트리로 볼 땐 높이를 올리는 거지만, sparseTable[y][x(동일한 높이의 노드 번호)]로 보면 x축을 결정하는 것임)
* 5. 조상 찾아 sparseTable[y][x] y축 한칸씩 올라가기
* */
public class Main {
    static private int sty;
    static private int[][] sparsetable;
    static private int[] depths;
    static private List<List<Integer>> tree;
    public static void main(String[] args) throws NumberFormatException, IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) { //★ N -1 : 트리의 간선갯수 N - 1 개임
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        //1.
        gety(N);
        //2.
        sparsetable = new int[sty + 1][N + 1];
        depths = new int[N + 1];
        depths[1] = 1;
        dfs(1);
        //3.
        for (int i = 1; i <= sty; i++) {
            for (int j = 1; j <= N; j++) {
                sparsetable[i][j] = sparsetable[i - 1][sparsetable[i - 1][j]];
            }
        }
        int M = Integer.parseInt(br.readLine());
        //4.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static void gety(int N) {
        int tmp = 1;
        while (tmp < N) { //이거 범위 햇갈리네...
            tmp <<= 1;
            sty++;
        }
    }

    private static void dfs(int now) {
        for (Integer next : tree.get(now)) {
            if (depths[next] == 0) {
                depths[next] = depths[now] + 1;
                sparsetable[0][next] = now;
                dfs(next);
            }
        }
    }

    private static int lca(int a, int b) {
        //a를 더 깊은 곳에 위치한 노드로 설정해주기 O ★ a를 더 큰 값을 가지게 해주기 X (a < b)
        if (depths[a] < depths[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        //4.
        for (int i = 0; i <= sty; i++) {
            if (((depths[a] - depths[b]) & (1 << i)) >= 1) {
                a = sparsetable[i][a];
            }
        }
        if (a == b) {
            return a;
        }
        for (int i = sty; i >= 0; i--) {
            if(sparsetable[i][a] != sparsetable[i][b]) {
                a = sparsetable[i][a];
                b = sparsetable[i][b];
            }
        }
        return sparsetable[0][a];
    }
}
/*20
1 2
1 3
2 4
3 7
6 2
3 8
4 9
2 5
5 11
7 13
10 4
11 15
12 5
14 7
15 16
16 17
17 18
18 19
19 20
1
13 20*/