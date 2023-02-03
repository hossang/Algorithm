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

public class Main {

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] ceil = new int[H];
        int[] ground = new int[H];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int hei = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                ground[H - hei]++;
            } else {
                ceil[hei - 1]++;
            }
        }
        for (int i = 1; i < H; i++) {
            ground[i] += ground[i - 1];
        }
        for (int i = H - 2; i >= 0; i--) {
            ceil[i] += ceil[i + 1];
        }
        for (int i = 0; i < H; i++) {
            pq.offer(ceil[i] + ground[i]);
        }
        int min = pq.poll();
        int cnt = 1;
        while (!pq.isEmpty() && min == pq.peek()) {
            pq.poll();
            cnt++;
        }
        System.out.println(min + " " + cnt);
    }
}
