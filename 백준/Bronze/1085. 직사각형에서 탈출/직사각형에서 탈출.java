import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int xx;
        int yy;
        if (y - 0 >= h - y) {
            yy = h - y;
        } else {
            yy = y - 0;
        }

        if (x - 0 >= w - x) {
            xx = w - x;
        } else {
            xx = x - 0;
        }

        if (xx > yy) {
            System.out.println(yy);
        } else {
            System.out.println(xx);
        }
    }
}
