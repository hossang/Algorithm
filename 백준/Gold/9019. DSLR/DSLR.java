import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String[] command = new String[10000];
            boolean[] visited = new boolean[10000];
            Queue<Integer> q = new LinkedList<>();

            visited[a] = true;
            q.add(a);
            Arrays.fill(command,"");
            while (!q.isEmpty() && !visited[b]){
                int now =q.poll();
                int D = (2*now)%10000;
                int S = (now == 0) ? 9999 : now-1;
                int L = (now % 1000) * 10 + now/1000;
                int R = (now % 10) * 1000 + now/10;

                if(!visited[D]){
                    q.add(D);
                    visited[D]=true;
                    command[D]=command[now] + "D";
                }

                if(!visited[S]){
                    q.add(S);
                    visited[S]=true;
                    command[S]=command[now] + "S";
                }
                if(!visited[L]){
                    q.add(L);
                    visited[L]=true;
                    command[L]=command[now] + "L";
                }
                if(!visited[R]){
                    q.add(R);
                    visited[R]=true;
                    command[R]=command[now] + "R";
                }
            }
            System.out.println(command[b]);
        }

    }
}