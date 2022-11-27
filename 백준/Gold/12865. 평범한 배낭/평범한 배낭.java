import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] item = new int[k + 1][2];
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            item[i][0] = w; //무게
            item[i][1] = v; //가치치
        }
        //dp 채우기, 보통 이중 for문과 다르게 내부for문이 세로임
        for (int i = 1; i <= k; i++) { //무게 (가로)
            for (int j = 1; j <= n; j++) { //아이템 (세로) 
                if (item[j][0] > i) {
                    dp[j][i] = dp[j - 1][i];
                    continue;
                }
                dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - item[j][0]] + item[j][1]);
            }
        }
        System.out.println(dp[n][k]);

    }
}