import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        SortedMap<String, Integer> sortedMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            sortedMap.put(str, sortedMap.getOrDefault(str, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        String ans = "";

        for (String s : sortedMap.keySet()) {
            if (max < sortedMap.get(s)) {
                max = sortedMap.get(s);
                ans = s;
            }
        }
        System.out.println(ans);

    }
}