import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int compare = Math.abs(a) - Math.abs(b);
            if(compare != 0) return compare;
            return a - b;
        });

        // 2
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(x);
            }
        }
        
        System.out.println(sb);
    }
}