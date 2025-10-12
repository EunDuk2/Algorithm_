import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int[] dist;
    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] FSGUD = br.readLine().split(" ");
        F = Integer.parseInt(FSGUD[0]);
        S = Integer.parseInt(FSGUD[1]);
        G = Integer.parseInt(FSGUD[2]);
        U = Integer.parseInt(FSGUD[3]);
        D = Integer.parseInt(FSGUD[4]);

        visited = new boolean[F+1];
        dist = new int[F+1];

        bfs(S);

        if(visited[G]) {
            System.out.println(dist[G]);
        } else {
            System.out.println("use the stairs");
        }
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int current = q.poll();
            int down = current - D;
            int up = current + U;
            if(down >= 1 && !visited[down]) {
                q.add(down);
                visited[down] = true;
                dist[down] = dist[current] + 1;
            }
            if(up <= F && !visited[up]) {
                q.add(up);
                visited[up] = true;
                dist[up] = dist[current] + 1;
            }
        }
    }
}
