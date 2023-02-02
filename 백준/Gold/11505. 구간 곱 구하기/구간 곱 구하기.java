import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K, firstLeaf;
    private static long[] tree;
    private static final int R = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //수 갯수
        M = Integer.parseInt(st.nextToken()); //수의 변경 횟수
        K = Integer.parseInt(st.nextToken()); //구간의 합을 구하는 횟수
        M += K;
        firstLeaf = 1;
        //트리만들기
        while (firstLeaf < N) {
            firstLeaf *= 2;
        }
        tree = new long[firstLeaf * 2];
        Arrays.fill(tree, 1);
        for (int i = 1; i <= N; i++) {
            tree[firstLeaf + i - 1] = Integer.parseInt(br.readLine());
        }
        for (int i = firstLeaf - 1; i >= 1; i--) {
            tree[i] = (tree[2 * i] % R * tree[2 * i + 1] % R) % R;
        }
        int a, b, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                chage(b, c);
            } else {
                sb.append(multiple(1, 1, firstLeaf, b, c)).append("\n");
            }
        }
        System.out.println(sb);

    }

    private static long multiple(int node, int left, int right, int b, int c) {
        if (left > c || right < b) {
            return 1L;
        }
        if (left >= b && right <= c) {
            return tree[node] % R;
        }

        return (multiple(node * 2, left, (left + right) / 2, b, c) % R *
                multiple(node * 2 + 1, (left + right) / 2 + 1, right, b, c) % R) % R;
    }


    private static void chage(int b, int c) {
        int idx = firstLeaf + b - 1;
        tree[idx] = c;
        idx /= 2;
        while (idx >= 1) {
            tree[idx] = (tree[2 * idx] % R * tree[2 * idx + 1] % R) % R;
            idx /= 2;
        }
    }
}