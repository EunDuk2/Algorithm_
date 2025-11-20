import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        Stack<Character> stack = new Stack();

        for(char c : input) {
            if(c == ')') {
                while(stack.pop() != '(');
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());
    }
}