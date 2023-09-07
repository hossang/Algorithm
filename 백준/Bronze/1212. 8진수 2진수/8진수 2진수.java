import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        String s = br.readLine();
        BigInteger N = new BigInteger(s, 8);
        String result = N.toString(2);
        System.out.println(result);
    }
}