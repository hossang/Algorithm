import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());
        int set = 0; // ...000000000000(2)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int param;
            switch (st.nextToken()) {
                case "add":
                    param = Integer.parseInt(st.nextToken());
                    set |= (1 << (param - 1));
                    break;

                case "check": //★
                    param = Integer.parseInt(st.nextToken());
                    if ((set & (1 << (param - 1))) != 0) {
                    //if ((set & (1 << (param - 1))) == 1) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");

                    }
                    break;

                case "remove":
                    param = Integer.parseInt(st.nextToken());
                    set &= ~(1 << (param - 1));
                    break;

                case "toggle":
                    param = Integer.parseInt(st.nextToken());
                    set ^= (1 << (param-1));
                    break;

                case "all": //★
                    for (int j = 0; j < 20; j++) {
                        set |= (1 << j);
                    }
                    break;

                case "empty": //★
                    set &= 0;
                    break;

                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}