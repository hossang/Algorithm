import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        //이거 몇차원 배열을 써야할까?
        int[] arr = new int[num];
        int[] brr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            brr[i] = x;
        }
        Arrays.sort(arr);
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i : arr) {
            if (!hm.containsKey(i)) {
                hm.put(i, count++);
            }
        }
        for (int i : brr) {
            sb.append(hm.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
