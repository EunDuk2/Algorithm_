import java.util.*;
import java.io.*;

public class Main {
    static int n, a, b, m;
    static List<List<Integer>> doubleList = new ArrayList();
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] ab = br.readLine().split(" ");
        a = Integer.parseInt(ab[0]);
        b = Integer.parseInt(ab[1]);
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        dist = new int[n+1];

        for(int i = 0 ; i < n+1 ; i++) {
            doubleList.add(new ArrayList());
        }
        for(int i = 0 ; i < m ; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            doubleList.get(x).add(y);
            doubleList.get(y).add(x);
        }

        bfs(a);
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int curret = q.poll();
            for(int next : doubleList.get(curret)) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    dist[next] = dist[curret] + 1; // trouble
                }
            }
        }
        if(dist[b] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dist[b]);
        }
    }
}
