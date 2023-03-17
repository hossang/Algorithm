import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int firstLeaf;
    private static int[] tree, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        firstLeaf = 1;
        while (firstLeaf < N) {
            firstLeaf <<= 1;
        }
        tree = new int[firstLeaf * 2];
        Arrays.fill(tree, Integer.MAX_VALUE);
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i + firstLeaf] = i;
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = firstLeaf - 1; i >= 1; i--) {
            if (tree[i * 2 + 1] == Integer.MAX_VALUE) {
                tree[i] = tree[i * 2];
                continue;
            }
            if (arr[tree[i * 2]] <= arr[tree[i * 2 + 1]]) {
                tree[i] = tree[i * 2];
                continue;
            }
            tree[i] = tree[i * 2 + 1];
        }
        int M = Integer.parseInt(br.readLine());
        for (int h = 0; h < M; h++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int i;
            if (num == 1) {
                i = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[i - 1] = v;
                tree[firstLeaf + i - 1] = i - 1;
                edit(firstLeaf + i - 1);
                continue;
            } else {
                i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                sb.append(search(1, 1, firstLeaf, i, j) + 1).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int search(int node, int l, int r, int sl, int sr) {
        if (sl > r || sr < l) {
            return Integer.MAX_VALUE;
        }

        //겹치는 부분이 있는 부분 중에
        if (sl <= l && r <= sr) {
            return tree[node];
        }

        int ll = search(node * 2, l, (l + r) / 2, sl, sr);
        int rr = search(node * 2 + 1, (l + r) / 2 + 1, r, sl, sr);

        if (rr == Integer.MAX_VALUE) {
            return ll;
        }
        if (ll == Integer.MAX_VALUE) {
            return rr;
        }
        if (arr[ll] <= arr[rr]) {
            return ll;
        }
        return rr;
    }

    private static void edit(int i) {
        while (i > 1) {
            i >>= 1;
            if (tree[i * 2 + 1] == Integer.MAX_VALUE) {
                tree[i] = tree[i * 2];
                continue;
            }
            if (arr[tree[i * 2]] <= arr[tree[i * 2 + 1]]) {
                tree[i] = tree[i * 2];
                continue;
            }
            tree[i] = tree[i * 2 + 1];
        }
    }
}