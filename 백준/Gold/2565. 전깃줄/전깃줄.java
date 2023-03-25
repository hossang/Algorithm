import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class AB {
    int A;
    int B;

    public AB(int a, int b) {
        A = a;
        B = b;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<AB> list = new ArrayList<>();
        int[] dp = new int[501];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.add(new AB(A, B));
        }
        Collections.sort(list, (o1, o2) -> o1.A - o2.A);
        dp[0] = list.get(0).B;
        int cnt = 1;
        for (int i = 1; i < list.size(); i++) {
            if (dp[cnt - 1] < list.get(i).B) {
                dp[cnt++] = list.get(i).B;
            }
            int idx = binarySearch(list.get(i).B, dp, cnt);
            dp[idx] = list.get(i).B;
        }
        System.out.println(N-cnt);
    }

    private static int binarySearch(int v, int[] dp, int r) {
        int l = -1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (dp[mid] < v) {
                l = mid;
                continue;
            }
            r = mid;
        }
        return r;
    }
}