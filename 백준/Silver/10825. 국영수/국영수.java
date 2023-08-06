import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<Integer, String> map = new HashMap<>();
        int[][] arr = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            map.put(i, s);
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                if (o1[2] == o2[2]) {
                    if (o2[3] == o1[3]) {
                        return map.get(o1[0]).compareTo(map.get(o2[0]));
                    }
                    return o2[3] - o1[3];
                }
                return o1[2] - o2[2];
            }
            return o2[1] - o1[1];
        });

        for (int i = 0; i < N; i++) {
            System.out.println(map.get(arr[i][0]));
        }
    }
}
