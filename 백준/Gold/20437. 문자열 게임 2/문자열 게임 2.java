import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            List<List<Integer>> list = new ArrayList<>(26);
            for (int j = 0; j < 26; j++) {
                list.add(new ArrayList<>());
            }
            for (int j = 0; j < W.length(); j++) {
                list.get(W.charAt(j) - 'a').add(j);
            }

            int min1 = Integer.MAX_VALUE;
            int max2 = 0;
            for (int j = 0; j < 26; j++) {
                if (list.get(j).size() >= K) {
                    for (int k = 0; k <= list.get(j).size() - K; k++) {
                        int tmp1 = list.get(j).get(k + K - 1) - list.get(j).get(k);
                        min1 = Math.min(min1, tmp1 + 1);
                        max2 = Math.max(max2, tmp1 + 1);
                    }
                }
            }

            if (min1 == Integer.MAX_VALUE || max2 == 0) {
                sb.append(-1).append("\n");
                continue;
            }
            sb.append(min1).append(' ').append(max2).append("\n");
        }

        System.out.println(sb);
    }
}

