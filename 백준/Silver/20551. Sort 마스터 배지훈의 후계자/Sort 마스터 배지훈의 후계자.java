import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            int D = Integer.parseInt(br.readLine());

            int l = -1;
            int r = N;
            int m;
            while (l + 1 < r) {
                m = l + (r - l) / 2;

                if (arr[m] < D) {
                    l = m;
                    continue;
                }
                r = m;
            }

            if (r < N && arr[r] == D) {
                System.out.println(r);
                continue;
            }
            System.out.println(-1);
        }
    }
}
