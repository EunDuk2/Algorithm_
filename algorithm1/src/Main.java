import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static List<List<Integer>> doubleList = new ArrayList();
    static boolean[] visited;
    static List<Integer> order = new ArrayList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMV = br.readLine().split(" ");

        N = Integer.parseInt(NMV[0]);
        M = Integer.parseInt(NMV[1]);
        V = Integer.parseInt(NMV[2]);

        for(int i = 0 ; i < N+1 ; i++) {
            doubleList.add(new ArrayList());
        }

        visited = new boolean[N+1];

        for(int i = 0 ; i < M ; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            doubleList.get(x).add(y);
            doubleList.get(y).add(x);
        }

        for(List<Integer> list : doubleList) {
            Collections.sort(list);
        }

        StringBuilder sb = new StringBuilder();

        // 1
        dfs(V);
        for(int a : order) {
            sb.append(a).append(" ");
        }
        sb.append("\n");

        // 초기화
        visited = new boolean[N+1];
        order.clear();

        // 2
        bfs(V);
        for(int a : order) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }
    static void dfs(int start) {
        if(!visited[start]) {
            visited[start] = true;
            order.add(start);
            for(int next : doubleList.get(start)) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList();
        q.add(start);
        visited[start] = true;
        order.add(start);
        while(!q.isEmpty()) {
            int current = q.poll();
            for(int next : doubleList.get(current)) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    order.add(next);
                }
            }
        }
    }
}
