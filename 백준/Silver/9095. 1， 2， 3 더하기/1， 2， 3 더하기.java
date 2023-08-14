import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x <= 3) {
                sb.append(arr[x]).append("\n");
                continue;
            }
            for (int j = 4; j <= x; j++) {
                arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
            }
            sb.append(arr[x]).append("\n");
        }
        System.out.print(sb);

    }
}