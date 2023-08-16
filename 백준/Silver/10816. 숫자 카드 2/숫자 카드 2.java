import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int x = Integer.parseInt(br.readLine());
        int[] arr = new int[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < x; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a < 0) {
                a = -1 * a + 10000000;
                ++arr[a];
            } else {
                ++arr[a];
            }

        }
        int y = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < y; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a < 0) {
                a = -1 * a + 10000000;
                sb.append(arr[a]).append(" ");
            } else {
                sb.append(arr[a]).append(" ");
            }

        }
        System.out.println(sb);
    }
}
