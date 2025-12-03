import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> doubleList = new ArrayList();
    static int N, M, V;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMV = br.readLine().split(" ");
        N = Integer.parseInt(NMV[0]);
        M = Integer.parseInt(NMV[1]);
        V = Integer.parseInt(NMV[2]);

        visited = new boolean[N+1];

        for(int i = 0 ; i < N+1 ; i++) {
            doubleList.add(new ArrayList());
        }

        for(int i = 0 ; i < M ; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            doubleList.get(a).add(b);
            doubleList.get(b).add(a);
        }

        for(List<Integer> list : doubleList) {
            list.sort(Comparator.naturalOrder());
        }

        dfs(V);

        visited = new boolean[N+1];
        sb.append("\n");
        bfs(V);

        System.out.println(sb);

    }
    static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for(int n : doubleList.get(start)) {
            if(!visited[n]) dfs(n);
        }
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");

            for(int n : doubleList.get(current)) {
                if(!visited[n]) {
                    q.add(n);
                    visited[n] = true;
                }
            }
        }
    }
}