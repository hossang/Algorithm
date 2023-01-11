import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int completem1 = 0;
    static int complete0 = 0;
    static int complete1=0;
    static int[][] arr;

    public static void recur(int vl, int vr, int hl, int hr) {
        int mo = 0;
        int z = 0;
        int o = 0;
        for (int i = hl; i <= hr; i++) {
            for (int j = vl; j <= vr; j++) {
                switch (arr[i][j]) {
                    case -1:
                        mo++;
                        break;
                    case 0:
                        z++;
                        break;
                    case 1:
                        o++;
                        break;
                }
            }
        }
        if ((mo == 0 && z == 0) || (mo == 0 && o == 0) || (z == 0 && o == 0)) {
            if (mo == 0 && z == 0) {
                complete1++;
            } else if (mo == 0 && o == 0) {
                complete0++;
            } else if (z == 0 && o == 0) {
                completem1++;
            }
        } else {
            int h = (hr - hl + 1) / 3;
            int h1 = h - 1;
            int h2 = h * 2 - 1;
            int h3 = h * 3 - 1;
            int v = (vr - vl + 1) / 3;
            int v1 = v - 1;
            int v2 = v * 2 - 1;
            int v3 = v * 3 - 1;
            recur(vl, vl + v1, hl, hl + h1);//1
            recur(vl, vl + v1, hl + h1 + 1, hl + h2);//2
            recur(vl, vl + v1, hl + h2 + 1, hl + h3);//3
            recur(vl + v1 + 1, vl + v2, hl, hl + h1);//4
            recur(vl + v1 + 1, vl + v2, hl + h1 + 1, hl + h2);//5
            recur(vl + v1 + 1, vl + v2, hl + h2 + 1, hl + h3);//6
            recur(vl + v2 + 1, vl + v3, hl, hl + h1);//7
            recur(vl + v2 + 1, vl + v3, hl + h1 + 1, hl + h2);//8
            recur(vl + v2 + 1, vl + v3, hl + h2 + 1, hl + h3);//9
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        arr = new int[num][num];
        StringTokenizer st;
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0, num - 1, 0, num - 1);
        System.out.println(completem1);
        System.out.println(complete0);
        System.out.println(complete1);
    }
}
