import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        sb.append(dp[str1.length()][str2.length()]).append("\n");

        Deque<Character> dq = new ArrayDeque<>();
        int i = str1.length();
        int j = str2.length();
        while(i>0 && j>0) {
            if (i == 0 || j == 0) {
                break;
            }

            if(dp[i][j] == dp[i-1][j]) {
                i--;
            }else if(dp[i][j] == dp[i][j-1]) {
                j--;
            }else {
                dq.addLast(str1.charAt(i-1));
                i--;
                j--;
            }
        }
        while(!dq.isEmpty()) {
            sb.append(dq.pollLast());

        }
        System.out.println(sb);
    }
}