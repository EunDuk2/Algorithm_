import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char c : str.toCharArray()) left.push(c);

        while (M-- > 0) {
            String cmd = br.readLine();
            switch (cmd.charAt(0)) {
                case 'L':
                    if (!left.isEmpty()) right.push(left.pop());
                    break;

                case 'D':
                    if (!right.isEmpty()) left.push(right.pop());
                    break;

                case 'B':
                    if (!left.isEmpty()) left.pop();
                    break;

                case 'P':
                    left.push(cmd.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : left) sb.append(c);
        while (!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);
    }
}