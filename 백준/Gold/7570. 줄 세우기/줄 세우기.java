import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Flower{
    int start;
    int end;

    public Flower(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] childs = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            childs[x] = childs[x - 1] + 1;
        }
        int max = 0;
        for(int i = 1; i <= N ; i++) {
            max = Math.max(max, childs[i]);
        }
        System.out.println(N - max);

    }
}
