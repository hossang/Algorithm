import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int completewhite = 0;
    static int completeblack = 0;
    public static void recur(int hlt, int hrt, int vlt, int vrt) { //h - 가로(행) , v - 세로(열)
        //언제까지?
        //★한 영역이 같은지 어캐 판단? -> 흰색과 검은색의 갯수?
        int w;
        int b;
        w = b = 0;
        for (int i = hlt; i <= hrt; i++) {
            for (int j = vlt; j <= vrt; j++) {
                if (arr[i][j] == 0) {
                    w++;
                } else {
                    b++;
                }
            }
        }
        if (w == 0 || b == 0) { //한 영역이 모두 같으면
            if (w == 0) {
                completeblack++;
            } else {
                completewhite++;
            }
        } else { //다르면
            recur(hlt, (hlt + hrt) / 2, vlt, (vlt + vrt) / 2); //1사분면
            recur(hlt,(hlt + hrt) / 2,(vlt + vrt) / 2 + 1, vrt); //2사분면
            recur((hlt + hrt) / 2 + 1, hrt, vlt, (vlt + vrt) / 2); //3사분면
            recur((hlt + hrt) / 2 + 1, hrt, (vlt + vrt) / 2 + 1, vrt);//4사분면
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // N은 2, 4, 8, 16, 32, 64, 128
        arr = new int[n][n];

        for (int i = 0; i < n; i++) { //값 넣기
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, n - 1, 0, n - 1);

        System.out.println(completewhite);
        System.out.println(completeblack);
    }
}
