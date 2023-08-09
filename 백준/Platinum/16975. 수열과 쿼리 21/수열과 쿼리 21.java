import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    private static long[] tree;
    private static int firstLeaf;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        firstLeaf = 1;
        while (firstLeaf < N) {
            firstLeaf <<= 1;
        }
        tree = new long[firstLeaf * 2];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tree[firstLeaf + i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for (int h = 0; h < M; h++) {
            st = new StringTokenizer(br.readLine(), " ");
            int Q = Integer.parseInt(st.nextToken());
            if (Q == 1) {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                update(1, 1, firstLeaf, i, j, k);
                continue;
            }
            int x = Integer.parseInt(st.nextToken());
            sb.append(search(x + firstLeaf - 1)).append("\n");
        }
        System.out.println(sb);
    }

    private static long search(int x) {
        long res = tree[x];
        while (x > 1) {
            x >>= 1;
            res += tree[x];
        }
        return res;
    }

    private static void update(int now, int l, int r, int sl, int sr, int k) {
        if (sr < l || r < sl) {
            return;
        }
        if (sl <= l && r <= sr) {
            tree[now] += k;
            return;
        }
        update(now * 2, l, (l + r) / 2, sl, sr, k);
        update(now * 2 + 1, (l + r) / 2 + 1, r, sl, sr, k);
    }
}
