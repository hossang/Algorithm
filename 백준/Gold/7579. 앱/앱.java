import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int totalCost = 0;
        int[][] apps = new int[2][N + 1];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                apps[i][j] = Integer.parseInt(st.nextToken()); // {메모리 ,비용}
            }
        }
        for (int i = 1; i <= N; i++) {
            totalCost += apps[1][i];
        }
        int[][] dp = new int[N + 1][totalCost + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= totalCost; i++) {
            for (int j = 1; j <= N; j++) {
                if (apps[1][j] > i) {
                    dp[j][i] = dp[j - 1][i];
                    continue;
                }
                dp[j][i] = Math.max(dp[j - 1][i], apps[0][j] + dp[j - 1][i - apps[1][j]]);
                if (dp[j][i] >= M) {
                    min = Math.min(min, i);
                }
            }
        }

        System.out.println(min);

    }
}