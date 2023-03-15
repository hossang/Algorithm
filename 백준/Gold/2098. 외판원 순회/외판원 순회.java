import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static final int INF = 123_456_789;
    private static int N, x, result;
    private static int[][] citys, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        citys = new int[N + 1][N + 1];
        x = (1 << N) - 1;
        dp = new int[N + 1][x + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                citys[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = INF;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= x; j++) {
                dp[i][j] = INF;
            }
        }
        dp[1][1] = 0;
        getDP(1, 1);
        System.out.println(result);
    }

    private static void getDP(int now, int visit) {
        if (visit == x) {
            if (citys[now][1] == 0) {
                return;
            }
            result = Math.min(result, dp[now][visit] + citys[now][1]);
        }

        for (int i = 1; i <=N; i++) {
            int next = (1 << (i - 1));
            int nextvisit = visit | next;
            if (nextvisit == visit) {
                continue;
            }
            if (citys[now][i] == 0) {
                continue;
            }
            if (dp[i][nextvisit] > dp[now][visit] + citys[now][i]) {
                dp[i][nextvisit] = dp[now][visit] + citys[now][i];
                getDP(i,nextvisit);
            }
        }
    }
}