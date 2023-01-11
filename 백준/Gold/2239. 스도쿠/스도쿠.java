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

class YX {
    int y;
    int x;

    public YX(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[][] sudoku;
    private static List<YX> list;
    private static int[] arrx = {-1, 1, 0, 0}; //좌우상하
    private static int[] arry = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = str.charAt(j) - '0';
                if (sudoku[i][j] == 0) {
                    list.add(new YX(i, j));
                }
            }
        }
        backTracking(0);

    }

    private static void backTracking(int idx) {
        if (idx == list.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
            return;
        }

        YX now = list.get(idx);
        boolean[] check = new boolean[10];
        //각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
        for (int i = 0; i < 4; i++) {
            int nextx = now.x;
            int nexty = now.y;
            while (true) {
                nextx += arrx[i];
                nexty += arry[i];

                if (nextx < 0 || nexty < 0 || nextx >= 9 || nexty >= 9) {
                    break;
                }
                check[sudoku[nexty][nextx]] = true;
            }
        }
        //굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
        for (int i = now.y / 3 * 3; i < now.y / 3 * 3 + 3; i++) {
            for (int j = now.x / 3 * 3; j < now.x / 3 * 3 + 3; j++) {
                check[sudoku[i][j]] = true;
                //오 내가 생각한건데 행렬 분할 꽤 깔끔하게 한듯? 뿌듯쓰
            }
        }
        //백트래킹 돌려
        for (int i = 1; i <= 9; i++) {
            if (!check[i]) {
                sudoku[now.y][now.x] = i;
                backTracking(idx + 1);
                sudoku[now.y][now.x] = 0;
            }
        }
    }
}