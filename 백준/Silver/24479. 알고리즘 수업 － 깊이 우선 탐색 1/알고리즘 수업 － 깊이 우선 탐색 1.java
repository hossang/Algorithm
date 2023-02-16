import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static ArrayList<SortedSet<Integer>> aai; //인접리스트
    static int[] visited; //방문했는지 기록
    static int count = 1;

    public static void dfs(int z) {
        visited[z] = count++;
        for (int node : aai.get(z)) {
            if (visited[node] == 0) { //방문하지 않았으면
                dfs(node);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken()) + 1;
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        visited = new int[x]; // 방문한거 확인하기
        aai = new ArrayList<>(x); //인접리스트 초기화(1 ~ x)
        for (int i = 0; i < x; i++) {
            aai.add(new TreeSet<>());
        }
        //값 넣기
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            aai.get(a).add(b);
            aai.get(b).add(a);
        }

        dfs(z);

        for (int i = 1; i < x; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);

    }
}
