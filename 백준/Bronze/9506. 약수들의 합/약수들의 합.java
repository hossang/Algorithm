import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }
            SortedSet<Integer> set = new TreeSet<>();
            int res = 1;
            set.add(1);
            for (int i = 2; i < n; i++) {
                if (n % i == 0 && !set.contains(i)) {
                    set.add(n / i);
                    set.add(i);
                    res += i;
                    res += n / i;
                }
            }
            List<Integer> list = new ArrayList<>(set);
            if (res == n) {
                sb.append(n).append(" = ");
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) {
                        sb.append(list.get(i)).append("\n");
                        continue;
                    }
                    sb.append(list.get(i)).append(" + ");
                }
                continue;
            }
            sb.append(n).append(" is NOT perfect.").append("\n");
        }
        System.out.println(sb);

    }
}
