
import java.io.*;
import java.util.*;

public class Main {
    private static int firstleaf;
    private static int[] maxs, mins;
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        firstleaf = 1;
        while (firstleaf < N) {
            firstleaf <<= 1;
        }
        maxs = new int[firstleaf * 2];
        Arrays.fill(maxs, Integer.MIN_VALUE);
        mins = new int[firstleaf * 2];
        Arrays.fill(mins, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            maxs[firstleaf + i] = num;
            mins[firstleaf + i] = num;
        }
        for (int i = firstleaf - 1; i >= 1; i--) { //maxtree
            maxs[i] = Math.max(maxs[i * 2], maxs[i * 2 + 1]);
        }
        for (int i = firstleaf - 1; i >= 1; i--) { //mintree
            mins[i] = Math.min(mins[i * 2], mins[i * 2 + 1]);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sl = Integer.parseInt(st.nextToken());
            int sr = Integer.parseInt(st.nextToken());
            sb.append(searchMin(1, 1, firstleaf, sl, sr)).append(" ").append(searchMax(1, 1, firstleaf, sl, sr)).append("\n");
        }
        System.out.println(sb);
    }

    private static int searchMax(int node, int l, int r, int sl, int sr) {
        //이 search 부분이 유일하게 어려워 (짜증짜증)
        if (sl > r || sr < l) { //아예 겹치는 부분이 없는 부분
            return Integer.MIN_VALUE;
        }

        //겹치는 부분이 있는 부분 중에
        if (sl <= l && r <= sr) { //★ sl과 sr이 l과 r을 잡아 먹을 수 있으면
            return maxs[node];
        }
        //일부분만 겹치면
        return Math.max(searchMax(node * 2, l, (l + r) / 2, sl, sr), searchMax(node * 2 + 1, (l + r) / 2 + 1, r, sl, sr));
    }

    private static int searchMin(int node, int l, int r, int sl, int sr) {
        //이 search 부분이 유일하게 어려워 (짜증짜증)
        if (sl > r || sr < l) { //아예 겹치는 부분이 없는 부분
            return Integer.MAX_VALUE;
        }

        //겹치는 부분이 있는 부분 중에
        if (sl <= l && r <= sr) { //★ sl과 sr이 l과 r을 잡아 먹을 수 있으면
            return mins[node];
        }
        //일부분만 겹치면
        return Math.min(searchMin(node * 2, l, (l + r) / 2, sl, sr), searchMin(node * 2 + 1, (l + r) / 2 + 1, r, sl, sr));
    }
}