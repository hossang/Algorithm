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
            //r 을 N으로 잡으면 안되네 why? -> lis배열의 빈곳은 0으로 되어 있음 
            binarySearch(A[i], lis, idx);
        }
        System.out.println(idx);

    }

    private static void binarySearch(int key, int[] arr, int r) {
        int l = -1;
        int mid;
        while (l + 1 < r) {
            mid = l + (r - l) / 2;
            
            if(arr[mid]<key) {
                l = mid;
            } else {
                r = mid;
            }
        }
        arr[r] = key;
    }
}