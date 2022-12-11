import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long[][] dp = new long[n][21];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][arr[0]] = 1;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i][j] != 0) {
                    if (j + arr[i + 1] <= 20 && j + arr[i + 1] >=0) {
                        dp[i + 1][j + arr[i + 1]] += dp[i][j];
                    }
                    if (j - arr[i + 1] <= 20 && j - arr[i + 1] >= 0) {
                        dp[i + 1][j - arr[i + 1]] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[n-2][arr[n-1]]);
    }
}