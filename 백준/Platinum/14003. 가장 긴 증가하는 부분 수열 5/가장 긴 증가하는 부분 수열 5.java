import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    private static int[] arr, lis, dp;
    private static Map<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        arr = new int[N];
        lis = new int[N];
        dp = new int[N];

        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lis[0] = arr[0];
        dp[0] = 1;
        map.put(lis[0], 1);

        int idx = 1;
        for (int i = 1; i < N; i++) {
            if (lis[idx - 1] < arr[i]) {
                dp[i] = idx + 1;
                lis[idx++] = arr[i];
                map.put(arr[i], idx);
                continue;
            }
            binarySearch(arr[i], idx, i);
        }
        sb.append(idx).append("\n");
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == idx) {
                idx--;
                dq.addFirst(arr[i]);
            }
        }
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }

    private static void binarySearch(int key, int r, int a) {
        int l = -1;
        int m;

        while (l + 1 < r) {
            m = l + (r - l) / 2;

            if (lis[m] < key) {
                l = m;
                continue;
            }
            r = m;
        }
        map.put(key, map.get(lis[r]));
        dp[a] = map.get(key);
        lis[r] = key;
    }


}
