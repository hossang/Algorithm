import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] notebook = new int[Y][X]; //노트북
        //스티커 붙이기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[y][x];
            for (int j = 0; j < y; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < x; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            b:for (int n = 0; n < 4; n++) {
                //스티커가 노트북보다 작거나 같으면
                if (y <= Y && x <= X) {
                    //스티커 붙여보기
                    for (int j = 0; j <= Y - y; j++) { //notebookY
                        a:for (int k = 0; k <= X - x; k++) { //notebookX
                            for (int l = 0; l < y; l++) { //stickery
                                for (int m = 0; m < x; m++) { //stickerx
                                    if (notebook[j + l][k + m] == 1 && sticker[l][m] == 1) {
                                        continue a;
                                    }
                                }
                            }
                            //적합한 스티커를 찾았다
                            for (int l = 0; l < y; l++) { //stickery
                                for (int m = 0; m < x; m++) { //stickerx
                                    if (notebook[j + l][k + m] == 0 && sticker[l][m] == 1) {
                                        notebook[j + l][k + m] = sticker[l][m];
                                    }
                                }
                            }
                            //스티커 바꾸기
                            break b;
                        }
                    }
                }
                //스티커 회전시키기
                sticker = rotateSticker(sticker);
                y = sticker.length;
                x = sticker[0].length;
            }
        }
        //갯수세기
        int count = 0;
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (notebook[i][j] == 1) {
                    count++;
                }
            }
        }
        //출력
        System.out.println(count);
    }

    private static int[][] rotateSticker(int[][] sticker) {
        int y = sticker[0].length;
        int x = sticker.length;
        int[][] arr = new int[y][x];
        for (int j = 0; j < y; j++) {
            for (int k = 0; k < x; k++) {
                if (sticker[x - 1 - k][j] == 1) {
                    arr[j][k] = 1;
                }
            }
        }
        return arr;
    }
}