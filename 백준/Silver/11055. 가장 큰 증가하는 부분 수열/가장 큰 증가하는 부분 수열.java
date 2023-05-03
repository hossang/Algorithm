import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[2][N];
        dp[0][0] = 1;
        dp[1][0] = A[0];
        for (int i = 1; i < N; i++) {
            dp[0][i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    if (dp[0][i] < dp[0][j] + 1) {
                        dp[0][i] = dp[0][j] + 1;
                        dp[1][i] = Math.max(dp[1][j], dp[1][i]);
                    }
                }
            }
            dp[1][i] += A[i];
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[1][i]);
        }
        System.out.println(result);
    }
}
