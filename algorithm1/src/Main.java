import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");

            int order = Integer.parseInt(input[0]);

            if(order == 1) {
                int num = Integer.parseInt(input[1]);
                deque.addFirst(num);
            } else if(order == 2) {
                int num = Integer.parseInt(input[1]);
                deque.addLast(num);
            } else if(order == 3) {
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
            } else if(order == 4) {
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
            } else if(order == 5) {
                sb.append(deque.size()).append("\n");
            } else if(order == 6) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if(order == 7) {
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            } else {
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}