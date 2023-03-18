import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class VE {
    int v;
    int e;

    public VE(int v, int e) {
        this.v = v;
        this.e = e;
    }
}

public class Main {
    private static int Y;
    private static int[] depths;
    private static int[][] sparseTable,minDP, maxDP;
    private static List<List<VE>> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int tmp = 1;
        while (tmp < N) {
            tmp <<= 1;
            Y++;
        }
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            tree.get(A).add(new VE(B, C));
            tree.get(B).add(new VE(A, C));
        }
        depths = new int[N + 1];
        sparseTable = new int[Y + 1][N + 1];
        minDP = new int[Y + 1][N + 1];
        maxDP = new int[Y + 1][N + 1];
        /*for (int i = 0; i < Y + 1; i++) {
            Arrays.fill(minDP[i],Integer.MAX_VALUE);
            Arrays.fill(maxDP[i],Integer.MIN_VALUE);
        }*/
        depths[1] = 1;
        dfs(new VE(1, 0));
        for (int i = 1; i <= Y; i++) {
            for (int j = 1; j <= N; j++) {
                sparseTable[i][j] = sparseTable[i - 1][sparseTable[i - 1][j]];
                minDP[i][j] = Math.min(minDP[i - 1][sparseTable[i - 1][j]], minDP[i - 1][j]);
                maxDP[i][j] = Math.max(maxDP[i - 1][sparseTable[i - 1][j]], maxDP[i - 1][j]);
            }
        }
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int[] lca = lca(D, E);
            sb.append(lca[0]).append(" ").append(lca[1]).append("\n");
        }
        System.out.println(sb);
    }

    private static int[] lca(int d, int e) {
        int[] arr = new int[2];
        if (depths[d] < depths[e]) {
            int tmp = d;
            d = e;
            e = tmp;
        }
        arr[0] = Integer.MAX_VALUE; //min
        arr[1] = Integer.MIN_VALUE; //max
        for (int i = 0; i <= Y; i++) {
            if (((depths[d] - depths[e]) & (1 << i)) >= 1) { //이 부분 살짝 까먹었네
                arr[0] = Math.min(arr[0], minDP[i][d]);
                arr[1] = Math.max(arr[1], maxDP[i][d]);
                d = sparseTable[i][d];
            }
        }
        if (d == e) {
            return arr;
        }
        for (int i = Y; i >= 0; i--) {
            if (sparseTable[i][d] != sparseTable[i][e]) {
                //Math.min(arr[0], minDP[i][d]) 만 했었는데, e도 생각해줘야지
                arr[0] = Math.min(arr[0], Math.min(minDP[i][d], minDP[i][e]));
                arr[1] = Math.max(arr[1], Math.max(maxDP[i][d], maxDP[i][e]));
                d = sparseTable[i][d];
                e = sparseTable[i][e];
            }
        }
        //여기서도 Math.min(arr[0], minDP[i][d]) 만 했었는데, e도 생각해줘야지
        arr[0] = Math.min(arr[0], Math.min(minDP[0][d], minDP[0][e]));
        arr[1] = Math.max(arr[1], Math.max(maxDP[0][d], maxDP[0][e]));
        return arr;
    }

    private static void dfs(VE now) {
        for (VE next : tree.get(now.v)) {
            if (depths[next.v] == 0) {
                depths[next.v] = depths[now.v] + 1;
                sparseTable[0][next.v] = now.v;
                minDP[0][next.v] = next.e;
                maxDP[0][next.v] = next.e;
                dfs(next);
            }
        }
    }
}