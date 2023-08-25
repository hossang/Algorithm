import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        //뭔가 입력이 이해 안가는 건 또 처음이네...
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //A대학
        int M = Integer.parseInt(st.nextToken()); //B대학
        int C = Integer.parseInt(st.nextToken()); //성격

        int[][] arr = new int[C + 1][C + 1];
        for (int i = 1; i < C + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < C + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(st.nextToken());//오름차순
        }
        st = new StringTokenizer(br.readLine(), " ");
        int[] B = new int[M + 1];
        for (int i = 1; i < M + 1; i++) {
            B[i] = Integer.parseInt(st.nextToken());//오름차순
        }
        long[][] dp;
        if (N >= M) {
            dp = new long[N + 1][M + 1];
            for (int i = 1; i < M + 1; i++) { //가로
                for (int j = 1; j < N + 1; j++) { //세로
                    dp[j][i] = dp[j - 1][i];
                    dp[j][i] = Math.max(Math.max(dp[j][i], dp[j][i - 1]), arr[A[j]][B[i]] + dp[j - 1][i - 1]);
                }
            }
            System.out.println(dp[N][M]);
            return;
        }

        dp = new long[M + 1][N + 1];
        for (int i = 1; i < N + 1; i++) { //가로
            for (int j = 1; j < M + 1; j++) { //세로
                dp[j][i] = dp[j - 1][i];
                dp[j][i] = Math.max(Math.max(dp[j][i], dp[j][i - 1]), arr[B[j]][A[i]] + dp[j - 1][i - 1]);
            }
        }
        System.out.println(dp[M][N]);
    }
}
