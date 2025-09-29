import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        // 1
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1 ; i <= N ; i++) {
            dq.addLast(i);
        }
        String[] aArr = br.readLine().split(" ");

        // 2
        int min = 0;
        for(int i = 0 ; i < M ; i++) {
            int a = Integer.parseInt(aArr[i]);

            int count1 = 0;
            Deque<Integer> dq1 = new ArrayDeque<>(dq);
            int count2 = 0;
            Deque<Integer> dq2 = new ArrayDeque<>(dq);

            // 2번
            while(dq1.peekFirst() != a) {
                dq1.addFirst(dq1.pollLast());
                count1++;
            }
            // 3번
            while(dq2.peekFirst() != a) {
                dq2.addLast(dq2.pollFirst());
                count2++;
            }

            if(count1 < count2) {
                dq = dq1;
                dq.pollFirst();
                min += count1;
            } else {
                dq = dq2;
                dq.pollFirst();
                min += count2;
            }
        }

        System.out.println(min);
    }
}