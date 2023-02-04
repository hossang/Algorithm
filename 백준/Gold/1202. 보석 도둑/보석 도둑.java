import javax.swing.*;
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
class MV {
    int m;
    int v;

    public MV(int m, int v) {
        this.m = m;
        this.v = v;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arrk = new int[K];
        PriorityQueue<MV> pq1 = new PriorityQueue<>(new Comparator<MV>() { //보석을 무게별로
            @Override
            public int compare(MV o1, MV o2) {
                return o1.m - o2.m;
            }
        });
        PriorityQueue<MV> pq2 = new PriorityQueue<>(new Comparator<MV>() { //보석을 가치별로
            @Override
            public int compare(MV o1, MV o2) {
                return o2.v - o1.v;
            }
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq1.offer(new MV(m, v));

        }
        for (int i = 0; i < K; i++) {
            arrk[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arrk);
        int idx = 0;
        long sum = 0L;
        while (idx < K) { //idx가 K와 같아질 때까지
            while (!pq1.isEmpty() && pq1.peek().m <= arrk[idx]) { //보석무게가 배낭무게보다 커질때까지 빼냄
                pq2.offer(pq1.poll());
            }
            if (!pq2.isEmpty()) {
                sum += pq2.poll().v;
            }
            idx++;
        }
        System.out.println(sum);
    }
}
