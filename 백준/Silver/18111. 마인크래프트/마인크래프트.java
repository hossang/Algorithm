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
        int B = Integer.parseInt(st.nextToken()); //인벤토리
        int min = 256;
        int max = 0;

       int[][] arr = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < X; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }
        //땅 고르기
        int time = 64_000_001;
        int height = -1;
        a:for (int i = min; i <= max; i++) {
            int tmpT = 0;
            int tmpB = B;
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < X; k++) {
                    if (arr[j][k] > i) { //땅이 기준보다 높을 때
                        tmpT += (arr[j][k] - i) * 2;
                        tmpB += arr[j][k] - i;
                    }
                    if (arr[j][k] < i) { //땅이 기준보다 낮을 때
                        tmpT += (i - arr[j][k]) * 1;
                        tmpB -= i - arr[j][k];
                    }
                }
            }
            //블록이 부족할 경우 더 이상 볼 필요가 없다
            if (tmpB < 0) {
                break a;
            }
            //시간과 높이를 계산
            if (time >= tmpT) {
                if (time == tmpT && height < i) {
                    height = i;
                    time = tmpT;
                }
                height = i;
                time = tmpT;
            }
        }
        //출력하기
        System.out.println(time + " " + height);
    }
}