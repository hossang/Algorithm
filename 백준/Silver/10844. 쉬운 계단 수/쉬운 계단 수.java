import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    public static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(9);
            return;
        }
        if (N == 2) {
            System.out.println(17);
            return;
        }
        int[][] dp = new int[12][N + 1];
        for (int i = 2; i < 11; i++) {
            dp[i][1] = 1;
        }
        dp[1][2] = 1;
        dp[10][2] = 1;
        for (int i = 2; i < 10; i++) {
            dp[i][2] = 2;
        }

        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < 11; j++) {
                dp[j][i] = (dp[j - 1][i - 1] % MOD + dp[j + 1][i - 1] % MOD) % MOD;
            }
        }
        long result = 0;
        for (int i = 2; i < 11; i++) {
            result = (result + dp[i][N]) % MOD;
        }
        System.out.println(result % MOD);
    }
}
