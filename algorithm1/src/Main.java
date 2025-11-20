import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        Stack<Character> stack = new Stack();

        boolean isAnswer = true;
        for(char c : input) {
            if(c == '(') stack.push(c);
            else {
                if(stack.isEmpty()) {
                    isAnswer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty() && isAnswer) System.out.println("YES");
        else System.out.println("NO");
    }
}