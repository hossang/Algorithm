import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int m = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    union(i, j);
                }

            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int pre = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < m; i++) {
            if (find(Integer.parseInt(st.nextToken())) != pre) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            arr[a] = b;
        } else {
            arr[b] = a;
        }
    }

    private static int find(int a) {
        if (a == arr[a]) {
            return a;
        } else {
            return arr[a] = find(arr[a]);
        }
    }
}