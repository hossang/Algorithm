import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    private static int n,m;
    private static int[] arr;
    private static boolean[] visited;
    private static void backTracking(int mm) {
        if (mm == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=n;i++) {
            if(arr[mm] == 0 && visited[i] == false) {
                arr[mm] = i;
                visited[i] = true;
                backTracking(mm + 1);
                visited[i] = false;
                arr[mm] = 0;

            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        arr = new int[m+1];
        visited = new boolean[n + 1];
        backTracking(1);
        System.out.print(sb);
    }
}