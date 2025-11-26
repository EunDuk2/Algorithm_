import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // (는 스택에 넣고
        // )는 스택에 (로 제거하고, 스택에 (가 없으면 count++
        // 끝나고는 스택에 남은 ( 개수 count++

        char[] input = br.readLine().toCharArray();

        int count = 0;
        Stack<Character> stack = new Stack();
        for(char c : input) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    count++;
                }
            }
        }
        count += stack.size();

        System.out.println(count);
    }
}