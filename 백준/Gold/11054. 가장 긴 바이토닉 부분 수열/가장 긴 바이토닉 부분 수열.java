import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[2][N];
        dp[0][0] = 1;
        for (int i = 1; i < N; i++) {
            dp[0][i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
                }
            }
        }
        dp[1][N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            dp[1][i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (A[i] > A[j]) {
                    dp[1][i] = Math.max(dp[1][i], dp[1][j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[0][i] + dp[1][i]);
        }
        System.out.println(max - 1);
    }
}