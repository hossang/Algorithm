import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;
    private static int firstLeaf;
    private static int[] tree1, tree2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        firstLeaf = 1;
        while (firstLeaf < N) {
            firstLeaf <<= 1;
        }

        tree1 = new int[firstLeaf * 2]; //최소
        Arrays.fill(tree1, (int) (1e9 + 1));
        tree2 = new int[firstLeaf * 2]; //최대
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            tree1[firstLeaf + i] = x;
            tree2[firstLeaf + i] = x;
        }
        for (int i = firstLeaf - 1; i > 0; i--) {
            tree1[i] = Math.min(tree1[i * 2], tree1[i * 2 + 1]);
            tree2[i] = Math.max(tree2[i * 2], tree2[i * 2 + 1]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int min = minSearch(1, 1, firstLeaf, a, b);
            int max = maxSearch(1, 1, firstLeaf, a, b);
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static int maxSearch(int now, int l, int r, int sl, int sr) {
        if (sr < l || r < sl) {
            return 0;
        }
        if (sl <= l && r <= sr) {
            return tree2[now];
        }
        return Math.max(maxSearch(now * 2, l, (l + r) / 2, sl, sr),
                maxSearch(now * 2 + 1, (l + r) / 2 + 1, r, sl, sr));
    }

    private static int minSearch(int now, int l, int r, int sl, int sr) {
        if (sr < l || r < sl) {
            return (int) (1e9 + 1);
        }
        if (sl <= l && r <= sr) {
            return tree1[now];
        }
        return Math.min(minSearch(now * 2, l, (l + r) / 2, sl, sr),
                minSearch(now * 2 + 1, (l + r) / 2 + 1, r, sl, sr));
    }
}
