import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    public static final int INF = 2_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N][3];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) { //r시작, g시작, b시작

            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[0][j] = rgb[0][i];
                    continue;
                }
                dp[0][j] = INF;
            }

            for (int j = 1; j < N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + rgb[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + rgb[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + rgb[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    result = Math.min(result, dp[N - 1][j]);
                }
            }
        }
        System.out.println(result);
    }
}
