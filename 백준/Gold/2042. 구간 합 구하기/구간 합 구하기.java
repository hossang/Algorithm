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
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K, firstLeaf;
    private static long[] tree, arr;

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //수 갯수
        M = Integer.parseInt(st.nextToken()); //수의 변경 횟수
        K = Integer.parseInt(st.nextToken()); //구간의 합을 구하는 횟수
        M += K;
        // 내가 생각하는 어려운점
        // 1. 배열 생성
        // 2. search할 때 여기가 지금 어느 구간(e.g 1-4)인지 어캐 알지 ?
        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        firstLeaf = 1;
        while (firstLeaf < N) {
            firstLeaf *= 2;
        }
        tree = new long[firstLeaf * 2]; //원래는 firstLeaft * 2 - 1 개 필요한데, 배열은 0부터 시작이니까 1부터 시작하게 하려고 + 1 해줌
        for (int i = 1; i <= N; i++) {
            tree[firstLeaf + i - 1] = arr[i];
        }
        for (int i = firstLeaf - 1; i >= 1; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long c;
                b = Integer.parseInt(st.nextToken());
                c = Long.parseLong(st.nextToken());
                edit(b, c);
            } else {
                int c;
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                System.out.println(sum(1, 1, firstLeaf, b, c));
                //sum (idx, left, right, b ,c) 에서 left와 right는 현재 구할 수 있는 구간합의 범위를 나타내고
                // b c는 구해야하는 구간합의 범위를 나타낸다. 당연히 left 1이고, right에서 N이 2^n의 숫자가 아니면, 
                // 비어있는 공간을 추가해 2^n 꼴로 맞줘야한다. 여기서 firstLeaf는 항상 완성된 2^n의 형식을 가짐  
            }
        }

    }

    private static void edit(int i, long v) {
        int idx = firstLeaf + i - 1;
        tree[idx] = v;
        idx /= 2;

        while (idx >= 1) {
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
            idx /= 2;
        }
    }

    private static long sum(int idx, int left, int right, int b, int c) {
        if (c < left || right < b) {
            return 0L;
        }
        if (b <= left && right <= c) {
            return tree[idx];
        }

        return sum(idx * 2, left, (left + right) / 2, b, c) +
                sum(idx * 2 + 1, (left + right) / 2 + 1, right, b, c);
    }
}