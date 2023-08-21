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
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[N];
        dp[0] = arr[0];
        int idx = 1;
        for (int i = 1; i < N; i++) {
            if (dp[idx - 1] < arr[i]) {
                dp[idx++] = arr[i];
                continue;
            }
            bs(arr[i], idx, dp);
        }
        System.out.println(N-idx);
    }

    private static void bs(int k, int r, int[] dp) {
        int l = -1;
        int m;
        while (l + 1 < r) {
            m = l + (r - l) / 2;

            if (dp[m] < k) {
                l = m;
                continue;
            }
            r = m;
        }
        dp[r] = k;
    }
}
