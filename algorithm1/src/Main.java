import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        Stack<Character> stack = new Stack();

        int count = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == '(') {
                stack.push(arr[i]);
            } else {
                if(arr[i-1] == '(') {
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}