
import java.io.*;
import java.util.*;


public class Main {
	public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int m = Integer.parseInt(br.readLine());
        int y = 0;
        int tmp = 1;
        while(tmp<500_000) {
        	tmp<<=1;
        	y++;
        }
        int[][] dp = new int[y+1][m+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1;i<=m;i++) {
        	dp[0][i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=y;i++) {
        	for(int j=1;j<=m;j++) {
        		dp[i][j] = dp[i-1][dp[i-1][j]];
        	}
        }
        int Q = Integer.parseInt(br.readLine());
       
        for(int i=0;i<Q;i++) {
        	st= new StringTokenizer(br.readLine()," ");
        	int n = Integer.parseInt(st.nextToken());
        	int x = Integer.parseInt(st.nextToken());
        	for(int j=0;j<=y;j++) {
        		if((n&(1<<j))>=1) {
        			x = dp[j][x];
        		}
        	}
        	sb.append(x).append("\n");
        }
        System.out.print(sb);
	}
}
