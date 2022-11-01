import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        for (int i = 1; i <= n; i++) {
            dp[n][i] = arr[n][i];
        }

        for (int i = n; i >= 1; i--) { //i범위 확인
            for (int j = 1; j <= i; j++) {
                if (j - 1 != 0) {
                    dp[i - 1][j - 1] = Math.max(dp[i - 1][j - 1], arr[i - 1][j - 1] + dp[i][j]);
                }

                if (j != n) {
                    dp[i - 1][j] = Math.max(dp[i - 1][j], arr[i - 1][j] + dp[i][j]);
                }

            }
        }
        System.out.println(dp[1][1]);
    }
}