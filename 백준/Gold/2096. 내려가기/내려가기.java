import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int len;
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dpmax = new int[N + 1][3];
        int[][] dpmin = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            dpmax[i][0] = Math.max(dpmax[i - 1][0], dpmax[i - 1][1]) + arr[i - 1][0];
            dpmax[i][1] = Math.max(dpmax[i - 1][0], Math.max(dpmax[i - 1][1], dpmax[i - 1][2])) + arr[i - 1][1];
            dpmax[i][2] = Math.max(dpmax[i - 1][1], dpmax[i - 1][2]) + arr[i - 1][2];

            dpmin[i][0] = Math.min(dpmin[i - 1][0], dpmin[i - 1][1]) + arr[i - 1][0];
            dpmin[i][1] = Math.min(dpmin[i - 1][0], Math.min(dpmin[i - 1][1], dpmin[i - 1][2])) + arr[i - 1][1];
            dpmin[i][2] = Math.min(dpmin[i - 1][1], dpmin[i - 1][2]) + arr[i - 1][2];
        }

        System.out.println(Math.max(dpmax[N][0],Math.max(dpmax[N][1],dpmax[N][2])) +
                " " + Math.min(dpmin[N][0],Math.min(dpmin[N][1],dpmin[N][2])));


    }
}