import java.io.*;
import java.util.*;

public class Main {
    private static int firstLeaf;
    private static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        //tree
        firstLeaf = 1;
        while (firstLeaf < N) {
            firstLeaf <<= 1;
        }
        tree = new long[firstLeaf * 2];
        for (int i = 0; i < N; i++) {
            tree[firstLeaf + i] = A[i];
        }
        int M = Integer.parseInt(br.readLine());
        for (int h = 0; h < M; h++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                sum(1, 1, firstLeaf, i, j, k);
            } else {
                int x = Integer.parseInt(st.nextToken());
                sb.append(search(1,1,firstLeaf,x)).append("\n");
            }
        }
        System.out.print(sb);

    }

    private static long search(int node, int l, int r, int x) {
        long sum = 0L;
        while (node < firstLeaf) {
            int mid = l + (r - l) / 2;
            sum += tree[node];
            if (mid < x) {
                node = node * 2 + 1;
                l = mid + 1;
            } else {
                node = node * 2;
                r = mid;
            }
        }
        return sum + tree[node];
    }


    private static void sum(int node, int l, int r, int sl, int sr, int k) {
        if (r < sl || sr < l) {
            return;
        }
        if (sl <= l && r <= sr) {
            tree[node] += k;
            return;
        }

        sum(node * 2, l, (l + r) / 2, sl, sr, k);
        sum(node * 2 + 1, (l + r) / 2 + 1, r, sl, sr, k);


    }
}