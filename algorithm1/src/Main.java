import java.io.*;
import java.util.*;

public class Main {
    static int S, E;
    static int[] dist = new int[10001];
    static boolean[] visited = new boolean[10001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] SE = br.readLine().split(" ");
        S = Integer.parseInt(SE[0]);
        E = Integer.parseInt(SE[1]);

        bfs(S);

        System.out.println(dist[E]);

    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int current = q.poll();

            if(current == E) return;

            int[] next = {current+1, current-1, current+5};

            for(int n : next) {
                if(n > 0 && n < dist.length-1) {
                    if(!visited[n]) {
                        q.add(n);
                        visited[n] = true;
                        dist[n] = dist[current]+1;
                    }
                }
            }
        }
    }
}