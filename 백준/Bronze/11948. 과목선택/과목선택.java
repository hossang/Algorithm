import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < 4; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < 3; i++) {
            res += pq.poll();
        }

        System.out.println(res + Math.max(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())));
    }
}
