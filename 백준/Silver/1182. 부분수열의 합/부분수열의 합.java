import java.io.*;
import java.util.*;

public class Main {
    private static long sum = 0L;
    private static int n,s;
    private static int[] arr;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken()); //부분수열의 원소의 합
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        brackTracking(0,0L);
        System.out.println(sum);
    }

    private static void brackTracking(int start, long subsum) {
        if (start >= n) {
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                subsum += arr[i];
                if (subsum == s) {
                    sum++;
                }
                brackTracking(i + 1, subsum);
                visited[i] = false;
                subsum -= arr[i];
            }
        }
    }
}
