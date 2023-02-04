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
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<MV> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new MV(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list, new Comparator<MV>() {
            @Override
            public int compare(MV o1, MV o2) {
                if (o1.m == o2.m) {
                    return o2.v - o1.v;
                }
                return o1.m - o2.m;
            }
        });
        for (int i = 0; i < N; i++) {
            int nowm = list.get(i).m;
            int nowv = list.get(i).v;
            pq.offer(nowv);
            if (nowm < pq.size()) {
                pq.poll();
            }
        }
        long result =0L;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }
        System.out.println(result);
    }
}
