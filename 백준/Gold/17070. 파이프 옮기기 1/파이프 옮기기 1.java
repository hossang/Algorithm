import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        long[][][] dp = new long[3][N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0][1] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (arr[i][j] == 1) {
                    continue;
                }
                dp[0][i][j] = dp[0][i][j - 1] + dp[2][i][j - 1];

                if (i == 0) {
                    continue;
                }
                dp[1][i][j] = dp[1][i - 1][j] + dp[2][i - 1][j];
                if (arr[i - 1][j] == 1 || arr[i][j - 1] == 1) {
                    continue;
                }
                dp[2][i][j] = dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];


            }
        }

        System.out.println(dp[0][N-1][N-1]+dp[1][N-1][N-1]+dp[2][N-1][N-1]);
    }
}
