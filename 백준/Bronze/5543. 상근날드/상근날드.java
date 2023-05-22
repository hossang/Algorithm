import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int[] burger = new int[3];
        int[] drink = new int[2];
        for (int i = 0; i < 3; i++) {
            burger[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 2; i++) {
            drink[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(Math.min(burger[0], Math.min(burger[1], burger[2])) + Math.min(drink[0], drink[1]) - 50);
    }
}
