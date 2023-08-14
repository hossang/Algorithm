import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        int xy = x - y;
        int zx = z - x;
        int count = 1;
        if(zx == 0) {
            System.out.println(count);
            return;
        } else {
            count += (xy >= zx) ? 1 : (zx / xy);
            if (zx / xy > 0 && zx % xy > 0) {
                count++;
            }
        }
        System.out.println(count);
    }

}
