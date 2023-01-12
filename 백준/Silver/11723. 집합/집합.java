import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<Integer> si;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        si = new HashSet<>();
        int x = Integer.parseInt(br.readLine());
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "add":
                    si.add(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    int z = si.contains(Integer.parseInt(st.nextToken())) ? 1 : 0;
                    sb.append(z).append("\n");
                    break;
                case "remove":
                    si.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "toggle":
                    int aa = Integer.parseInt(st.nextToken());
                    if (si.contains(aa)) {
                        si.remove(aa);
                    } else {
                        si.add(aa);
                    }
                    break;
                case "all":
                    si.clear();
                    for (int y = 1; y <= 20; y++) {
                        si.add(y);
                    }
                    break;
                case "empty":
                    si.clear();
                    break;
                default:
                    break;
            }
        }
        System.out.print(sb);



    }
}
