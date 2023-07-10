import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        Deque<Integer> di = new ArrayDeque<>();
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < num; i++) {

            while (!di.isEmpty() && arr[di.peekLast()] < arr[i]) {
                arr[di.pollLast()] = arr[i];
            }
            di.addLast(i);

        }
        while (!di.isEmpty()) {
            arr[di.pollLast()] = -1;
        }

        for (int i = 0; i < num; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);
    }
}
