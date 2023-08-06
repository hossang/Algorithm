import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < num; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
        }
        System.out.println(min * max);

    }
}
