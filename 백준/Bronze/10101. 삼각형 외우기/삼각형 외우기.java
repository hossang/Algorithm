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

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        if (a + b + c != 180) {
            System.out.print("Error");
            return;
        } 
        if (a == 60 && b == 60 && c == 60) {
            System.out.print("Equilateral");
            return;
        } 
        if (a == b || b == c || c == a) {
            System.out.print("Isosceles");
            return;
        } else {
            System.out.print("Scalene");
        }
        
    }
}
