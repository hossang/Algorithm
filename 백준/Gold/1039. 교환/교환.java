import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
class Tmp {
    String num;
    int k;

    public Tmp(String num, int k) {
        this.num = num;
        this.k = k;
    }
}

public class Main {
    private static int len;
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String str = st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        len = str.length();
        if (len == 1) {
            System.out.println(-1);
            return;
        }
        //BFS
        Deque<Tmp> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[K + 1][1_000_001];
        visited[0][Integer.parseInt(str)] = true;
        dq.addLast(new Tmp(str, 0));
        int max = -1;
        while (!dq.isEmpty()) {
            Tmp now = dq.pollFirst();

            if (now.k == K) {
                max = Math.max(max, Integer.parseInt(now.num));
                continue;
            }

            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    int swap = swap(now.num, i, j);
                    if (swap != -1 && !visited[now.k + 1][swap]) {
                        visited[now.k + 1][swap] = true;
                        dq.addLast(new Tmp(String.valueOf(swap), now.k + 1));
                    }

                }
            }
        }
        System.out.println(max);
    }

    private static int swap(String num, int i, int j) {
        char[] chars = num.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        int swap = Integer.parseInt(String.valueOf(chars));
        if (String.valueOf(swap).length() != len) {
            swap = -1;
        }
        return swap;
    }
}
