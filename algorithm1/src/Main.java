import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] inputStr = br.readLine().split(" ");

        Queue<Integer> q = new LinkedList();
        for(int i = 0 ; i < N ; i++) {
            q.add(Integer.parseInt(inputStr[i]));
        }

        int target = M;
        int count = 0;
        while(!q.isEmpty()) {
            int current = q.peek();
            // 큐에 자신보다 큰 수가 있다면
            if(q.stream().anyMatch(n -> n > current)) {
                q.add(q.poll());
                if(target == 0) {
                    target = q.size()-1;
                } else {
                    target--;
                }
            } else {
                count++;
                if(target == 0) break;
                q.poll();
                target--;
            }
        }

        System.out.println(count);
    }
}