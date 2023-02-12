import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] matrixs = new int[N][2];
        int [][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrixs[i][0] = Integer.parseInt(st.nextToken());
            matrixs[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                dp[j][j + i] = Integer.MAX_VALUE;
                for (int k = 0; k < i; k++) {
                    int cost = dp[j][j + k] + dp[j + k + 1][j + i] + matrixs[j][0] * matrixs[j + k][1] * matrixs[j + i][1];
                    dp[j][j + i] = Math.min(dp[j][j + i], cost);
                }
            }
        }
        System.out.println(dp[0][N - 1]);
    }
}