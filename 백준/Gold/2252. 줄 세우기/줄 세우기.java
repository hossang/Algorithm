import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static ArrayList<ArrayList<Integer>> aai;
    static StringBuilder sb;
    static int[] topological;

    public static void topologicalSort(Queue<Integer> qi) {

        while (qi.size() != 0) { //큐가 빌 때까지
            int x = qi.poll();
            topological[x]--;
            sb.append(x).append(" ");
            for (int node : aai.get(x)) {
                topological[node]--;
                if (topological[node] == 0) {
                    qi.offer(node);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken());
        
        topological = new int[n];

        aai = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            aai.add(new ArrayList<>());
        }
        //단방향 삽입? 양방향 삽입? -> 일단 단방향
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            aai.get(x).add(y);
            topological[y]++;
        }

        Queue<Integer> qi = new LinkedList<>();

        for (int i = 1; i < n; i++) { //일단 한번 돌면서 aai.get().size() ==0이면서 topological == 0 애들 없애?
            if (aai.get(i).size() == 0 && topological[i] == 0) {
                topological[i]--;
                sb.append(i).append(" ");
            } else if (aai.get(i).size() > 0 && topological[i] == 0) { //차수 0이면서 연결된 노드 있으면 큐에 넣어
                qi.offer(i);
            }
        }
        topologicalSort(qi);

        System.out.println(sb);
    }
}
