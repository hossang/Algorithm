import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    private static int max;
    private static Integer[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new Integer[N + 1];
        dp = new Integer[N + 1];
        arr[0] = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        dp[1] = arr[1];

        if(N>=2) {
            dp[2] = arr[1] + arr[2];
        }
        System.out.println(topDown(N));

    }

    private static int topDown(int N) {
        if(dp[N]==null) {
            dp[N] = Math.max(topDown(N-2), topDown(N-3)+arr[N-1])+arr[N];
        }
        return dp[N];
    }
}
