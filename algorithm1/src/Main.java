import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");

        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        Queue<Integer> q = new LinkedList();
        for(int i = 1 ; i <= N ; i++) {
            q.add(i);
        }

        int index = 1;
        while(q.size() > 1) {
            if(index == K) {
                q.poll();
                index = 1;
            } else {
                q.add(q.poll());
                index++;
            }
        }
        System.out.println(q.peek());
    }
}