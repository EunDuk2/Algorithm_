import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        // 1
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++) {
            q.add(i);
        }
        String[] aArr = br.readLine().split(" ");

        // 2
        int min = 0;
        for(int i = 0 ; i < M ; i++) {
            int a = Integer.parseInt(aArr[i]);

            if(q.indexOf(a) <= q.size() / 2) {
                // 2번
                while(q.peekFirst() != a) {
                    q.addLast(q.removeFirst());
                    min++;
                }
            } else {
                // 3번
                while(q.peekFirst() != a) {
                    q.addFirst(q.removeLast());
                    min++;
                }
            }
            q.pollFirst();
        }
        System.out.println(min);
    }
}