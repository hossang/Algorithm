import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //F S G U D
        /*스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고,
        스타트링크가 있는 곳의 위치는 G층이다.
        강호가 지금 있는 곳은 S층이고,
        이제 엘리베이터를 타고 G층으로 이동하려고 한다.
        * 어떤 층으로 이동할 수 있는 버튼이 있지만, 강호가 탄 엘리베이터는 버튼이 2개밖에 없다.
        U버튼은 위로 U층을 가는 버튼, D버튼은 아래로 D층을 가는 버튼이다.
        * */
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int[] ud = {Integer.parseInt(st.nextToken()), -Integer.parseInt(st.nextToken())};
        int[] visited = new int[1000001];
        Arrays.fill(visited, -1);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(s);
        visited[s] = 0;

        int idx = 1;
        a:while (!dq.isEmpty()) {
            int dqsize = dq.size();
            for (int j = 0; j < dqsize; j++) {
                int now = dq.pollFirst();

                if (now == g) {
                    break a;
                }
                for (int i = 0; i < 2; i++) {
                    int next = now + ud[i];
                    if (next >= f + 1 || next <= 0) {
                        continue;
                    }
                    if (visited[next] == -1) {
                        visited[next] = idx;
                        dq.addLast(next);
                    }
                }
            }
            idx++;
        }
        if (visited[g] == -1) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(visited[g]);

    }
}