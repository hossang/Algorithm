import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N];
        int[] lis = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        lis[0] = A[0];
        int idx = 1;
        for (int i = 1; i < N; i++) {
            if (lis[idx - 1] < A[i]) {
                lis[idx++] = A[i];
                continue;
            }
            binarySearch(A[i], lis, idx);
        }
        System.out.println(idx);

    }

    private static void binarySearch(int i, int[] arr, int r) {
        int l = 0;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < i) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        arr[l] = i;
    }
}