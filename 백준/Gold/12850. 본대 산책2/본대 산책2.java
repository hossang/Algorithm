import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class Main {
    private static final int M = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        long[][] adjacencyMatrix = {
                {0, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 0}
        };
        int D = Integer.parseInt(br.readLine());
        long[][] result = repowermatrix(adjacencyMatrix, D);
        System.out.println(result[0][0]);
        
    }

    private static long[][] repowermatrix(long[][] matrix, int d) {
        if (d == 1) {
            return matrix;
        } else if (d % 2 == 0) {
            return repowermatrix(powermatrix(matrix, matrix), d / 2);
        } else {
            return powermatrix(matrix, repowermatrix(powermatrix(matrix, matrix), d / 2));
        }
    }

    private static long[][] powermatrix(long[][] matrix1, long[][] matrix2) {
        long[][] newMatrix = new long[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                newMatrix[i][j] = recur(matrix1, matrix2, i, j, 8);
            }
        }
        return newMatrix;
    }
    public static long recur(long[][] matrix1, long[][] matrix2, int i, int j,int xx) {
        if (xx == 0) {
            return 0;
        }
        return ((matrix1[i][xx - 1] % M * matrix2[xx - 1][j] % M) % M + recur(matrix1, matrix2, i, j, xx - 1) % M) % M;
    }
}
