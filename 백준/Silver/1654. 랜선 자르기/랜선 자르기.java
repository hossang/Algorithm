import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        long right = 0;
        
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (right < arr[i]) {
                right = arr[i];
            }
        }

        long left = 0;
        long mid = 0;
        right++;

        while (left < right) {
            mid = (left + right) / 2;
            long count = 0;

            for (int v : arr) {
                count += v / mid;
            }

            if (count < n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }

}
