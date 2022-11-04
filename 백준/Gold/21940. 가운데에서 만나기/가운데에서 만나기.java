import java.io.*;
import java.util.*;

public class Main {
    //21940
    private static int[][] arr;
    private static int n, m;
    private static final int INF = 123456789;
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken()); //도시의 갯수
        m = Integer.parseInt(st.nextToken()); //도로의 갯수
        arr = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(arr[i],INF);
            arr[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[a][b] = Math.min(arr[a][b], t);
        }
        floyd();
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr2 = new int[k]; //친구들이 있는 도시
        for (int i = 0; i < k; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        int[] arr3 = new int[n + 1]; //왕복시간 계산
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j : arr2) {
                if (arr[i][j] != INF && arr[j][i] != INF && i != j) {
                    max = Math.max(max, arr[i][j] + arr[j][i]);
                }
            }
            arr3[i] = max;
            min = Math.min(min, max);
        }
        SortedSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            if (arr3[i] == min) {
                set.add(i);
            }
        }
        for (Integer i : set) {
            sb.append(i).append(" ");
        }
        
        System.out.println(sb);

    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
    }
}