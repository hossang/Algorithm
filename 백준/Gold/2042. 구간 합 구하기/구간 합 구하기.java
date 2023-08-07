import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;
    private static int firstLeaf;
    private static long[] tree;
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // '+' 해둔 부분은 생각 못한부분
        firstLeaf = 1;
        while (firstLeaf < N) {
            firstLeaf *= 2;
        }
        //트리채우기
        tree = new long[firstLeaf * 2];
        for (int i = 0; i < N; i++) {
            tree[firstLeaf + i] = Long.parseLong(br.readLine());
        }
        for (int i = firstLeaf - 1; i > 0; i--) {
            tree[i] = tree[2 * i + 1] + tree[2 * i];
        }
        //문제풀기
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                edit(firstLeaf - 1 + b, c);
                continue;
            }
            int c = Integer.parseInt(st.nextToken());
            sb.append(search(1, 1, firstLeaf, b, c)).append("\n"); //+search(1, 1, N, b, c) -> search(1, 1, firstLeaf, b, c)
            //sum (idx, left, right, b ,c) 에서 left와 right는 현재 구할 수 있는 구간합의 범위를 나타내고
            // b c는 구해야하는 구간합의 범위를 나타낸다. 당연히 left 1이고, right에서 N이 2^n의 숫자가 아니면,
            // 비어있는 공간을 추가해 2^n 꼴로 맞줘야한다. 여기서 firstLeaf는 항상 완성된 2^n의 형식을 가짐  
        }
        System.out.println(sb);

    }

    private static long search(int now, int l, int r, int sl, int sr) {
        if (sr < l || r < sl) {
            return 0L;
        }
        if (sl <= l && r <= sr) {
            return tree[now];
        }
        return search(now * 2, l, (l + r) / 2, sl, sr) + search(now * 2 + 1, (l + r) / 2 + 1, r, sl, sr); //+ r / 2 -> (l + r) / 2
    }

    private static void edit(int i, long c) {
        tree[i] = c;
        while (1 < i) {
            i /= 2;
            tree[i] = tree[2 * i + 1] + tree[2 * i];
        }
    }
}
