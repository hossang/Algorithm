import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        Map<String,Integer> msi = new HashMap<>();
        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String str = st.nextToken();
                msi.put(str, msi.getOrDefault(str, 0) + 1);
            }
            int count = 1;
            for (int value : msi.values()) {
                count *= (value + 1);
            }
            sb.append(count - 1).append("\n");
            msi.clear();
        }

        System.out.print(sb);
    }
}