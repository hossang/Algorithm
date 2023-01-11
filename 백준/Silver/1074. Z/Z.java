import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//2178
public class Main {
    public static int count = 0;
    public static int r;
    public static int c;
    public static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) + 1;
        c = Integer.parseInt(st.nextToken()) + 1;
        /*0 ≤ r, c < 2N
         * r,c를 기준으로 재귀를 돌아야할 듯?
         * 행렬을 만들 필요 없을 듯
         * 3 7 7 -> 63
         * 4 7 7 -> 63
         *
         * */
        int nn = (int) Math.pow(2, n);
        recur(1, nn, 1, nn);
        System.out.println(count);
    }

    private static void recur(int nl, int nr, int ml, int mr) { //n-행,m-열

        if (nl - nr == 0) {
            return;
        } else {
            if ((r >= nl && r <= (nl + nr) / 2) && (c >= ml && c <= (ml + mr) / 2)) {
                recur(nl, (nl + nr) / 2, ml, (ml + mr) / 2);
            } else if ((r >= nl && r <= (nl + nr) / 2) && (c >= (ml + mr) / 2 + 1 && c <= mr)) {
                count += (nr - nl + 1) * (nr - nl + 1) / 4;
                recur(nl, (nl + nr) / 2, (ml + mr) / 2 + 1, mr);
            } else if ((r >= (nl + nr) / 2 + 1 && r <= nr) && (c >= ml && c <= (ml + mr) / 2)) {
                count += ((nr - nl + 1) * (nr - nl + 1) / 4) * 2;
                recur((nl + nr) / 2 + 1, nr, ml, (ml + mr) / 2);
            } else if ((r >= (nl + nr) / 2 + 1 && r <= nr) && (c >= (ml + mr) / 2 + 1 && c <= mr)) {
                count += ((nr - nl + 1) * (nr - nl + 1) / 4) * 3;
                recur((nl + nr) / 2 + 1, nr, (ml + mr) / 2 + 1, mr);
            }


        }
    }
}
