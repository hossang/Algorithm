import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int x;

    public static long recur(long[][] matrix1, long[][] matrix2, int i, int j,int xx) {
        if (xx == 0) {
            return 0;
        }
        return ((matrix1[i][xx - 1] % 1000L * matrix2[xx - 1][j] % 1000L) % 1000L + recur(matrix1, matrix2, i, j, xx - 1) % 1000L) % 1000L;
    }

    public static long[][] powermatrix(long[][] matrix1,long[][] matrix2) {
        long[][] newMatrix = new long[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                newMatrix[i][j] = recur(matrix1, matrix2, i, j, x);
            }
        }
        return newMatrix;
    }

    public static long[][] repowermatrix(long[][] matrix, long c) {
        if (c == 1) {
            return matrix;
        } else if (c % 2 == 0) {
            return repowermatrix(powermatrix(matrix, matrix), c / 2);
        } else {
            return powermatrix(matrix, repowermatrix(powermatrix(matrix, matrix), c / 2));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //행렬 만들기아 개 빡쵸... 사전작업왤캐 많아
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken()); // x * x 행렬
        long y = Long.parseLong(st.nextToken()); // y번 제곱
        long[][] xx = new long[x][x];
        for (int i = 0; i < x; i++) { //값 대입
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                xx[i][j] = Long.parseLong(st.nextToken());
            }
        }
        long[][] xxxx = repowermatrix(xx, y);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                sb.append(xxxx[i][j] % 1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}
