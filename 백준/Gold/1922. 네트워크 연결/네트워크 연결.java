import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

class VVW {
    int vertex1;
    int vertex2;
    int weight;

    public VVW(int vertex1, int vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }
}

public class Main {
    private static int[] unionFind;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        /*List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            굳이 그래프 만들 필요가 없구나 !
        }*/
        unionFind = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            unionFind[i] = i;
        }
        PriorityQueue<VVW> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a != b) {
                pq.offer(new VVW(a, b, c));
            }
        }
        int cntE = 0;
        int sum = 0;
        while (!pq.isEmpty()) {
            VVW now = pq.poll();

            if (find(now.vertex1) != find(now.vertex2)) {
                union(now.vertex1, now.vertex2);
                sum += now.weight;
                cntE++;
            }
        }
        System.out.println(sum);

    }

    private static void union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);
        if (v1 < v2) {
            unionFind[v2] = v1;
        } else {
            unionFind[v1] = v2;
        }
    }

    private static int find(int v) {
        if (unionFind[v] == v) {
            return v;
        }
        return unionFind[v] = find(unionFind[v]);
    }
}
