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

        int N = Integer.parseInt(br.readLine());
        SortedMap<String, SortedMap> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            SortedMap target = map;
            for (int j = 0; j < K; j++) {
                String name = st.nextToken();
                if (target.get(name) == null) {
                    target.put(name, new TreeMap<>());
                }
                target = (TreeMap) target.get(name);
            }
        }
        getResult(map, 0);
        System.out.println(sb);
    }

    private static void getResult(SortedMap<String, SortedMap> map, int n) {
        for(Object s : map.keySet()) {
            for(int i = 0 ; i < n ; i++)
                sb.append("--");
            sb.append(s + "\n");
            getResult((TreeMap)map.get(s),n+1);
        }
    }
}
