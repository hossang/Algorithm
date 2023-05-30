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

        String  s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int sub = 1;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                sub *= 2; 
            } else if(s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                sub *= 3; 
            } else if(s.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if(s.charAt(i-1) == '(') {
                    result += sub;
                }
                stack.pop();
                sub /= 2;
            } else if(s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (s.charAt(i - 1) == '[') {
                    result += sub;
                }
                stack.pop();
                sub /= 3;
            }
        }
        
        if(!stack.isEmpty()){
            sb.append(0).append("\n");
        } else{ 
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
