import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        Stack<Integer> stack = new Stack();

        for(char c : arr) {
            if(c == '+' || c == '-' || c == '*' || c == '/') {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(c == '+') {
                    stack.push(num1 + num2);
                } else if(c == '-') {
                    stack.push(num1 - num2);
                } else if(c == '*') {
                    stack.push(num1 * num2);
                } else {
                    stack.push(num1 / num2);
                }
            } else {
                stack.push(c - '0');
            }
        }
        System.out.println(stack.pop());
    }
}