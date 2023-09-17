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

        BigInteger N = new BigInteger(br.readLine(), 2);
        BigInteger val = new BigInteger("17");
        BigInteger M = N.multiply(val);
        System.out.println(M.toString(2));
    }
}
