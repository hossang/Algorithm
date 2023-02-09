import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int firstleaf;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int candys = 1_000_000;
        firstleaf = 1;
        while (firstleaf < candys) {
            firstleaf *= 2;
        }
        tree = new int[firstleaf * 2];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a, b, c;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int x = search(b);
                edit(x, -1);
                sb.append(x).append("\n");
            } else {
                c = Integer.parseInt(st.nextToken());
                edit(b, c);
            }
        }
        System.out.println(sb);
    }

    private static int search(int b) {
        int left = 2;
        int right = 3;
        while (left < firstleaf) {
            if (tree[left] >= b) {
                left = left * 2;
                right = left + 1;
            } else {
                b -= tree[left];
                left = right * 2;
                right = left + 1;
            }
        }
        if (tree[left] >= b) {
            return left - firstleaf + 1;
        }
        return right - firstleaf + 1;
    }

    private static void edit(int i, int c) {
        int idx = i + firstleaf - 1;
        tree[idx] += c;
        while (idx > 1) {
            idx /= 2;
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
        }
    }
}