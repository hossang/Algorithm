import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = arr[1];
        if(n==1) {
            System.out.print(dp[1]);
            return;
        }
        dp[2] = arr[1] + arr[2];
        if(n==2) {
            System.out.print(dp[2]);
            return;
        }
        for(int i=3;i<=n;i++) {
            dp[i] = Math.max(Math.max(arr[i]+dp[i-2], dp[i-3]+arr[i]+arr[i-1]),
                    dp[i-1]);
        }
        System.out.print(dp[n]);
    }
}
