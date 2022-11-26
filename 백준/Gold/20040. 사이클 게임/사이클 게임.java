import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int findx = find(x);
            int findy = find(y);
            if (findx == findy) {
                System.out.println(i);
                return;
            }
            union(x, y);
        }
        System.out.println(0);

    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            arr[y] = x;
        } else {
            arr[x] = y;
        }
    }

    private static int find(int x) {
        if (x == arr[x]) {
            return x;
        }
        return arr[x] = find(arr[x]); //arr[x]만 기억했었네
    }
}