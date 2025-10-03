import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R;
    static List<List<Integer>> doubleList = new ArrayList();
    static boolean[] visited;
    static int[] order;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMR = br.readLine().split(" ");

        int N = Integer.parseInt(NMR[0]);
        int M = Integer.parseInt(NMR[1]);
        int R = Integer.parseInt(NMR[2]);

        visited = new boolean[N+1];
        order = new int[N+1];

        for(int i = 0 ; i < N+1 ; i++) {
            doubleList.add(new ArrayList());
        }

        for(int i = 0 ; i < M ; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            doubleList.get(u).add(v);
            doubleList.get(v).add(u);
        }

        for(int i = 0 ; i < doubleList.size() ; i++) {
            Collections.sort(doubleList.get(i));
        }

        bfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i < order.length ; i++) {
            sb.append(order[i]).append("\n");
        }

        System.out.println(sb);
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList();
        q.add(start);
        visited[start] = true;
        order[start] = cnt++;

        while(!q.isEmpty()) {
            int target = q.poll();
            for(int next : doubleList.get(target)) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    order[next] = cnt++;
                }
            }
        }
    }
}
