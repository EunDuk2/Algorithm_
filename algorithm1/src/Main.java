import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] graph;
    static List<List<Integer>> doubleList = new ArrayList();
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            doubleList.add(new ArrayList());
        }

        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0 ; j < input.length ; j++) {
                int n = Integer.parseInt(input[j]);
                graph[i][j] = Integer.parseInt(input[j]);
                if(n == 1) {
                    doubleList.get(i).add(j);
                }
            }
        }

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                visited = new boolean[N];
                bfs(i, j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int[] arr : graph) {
            for(int n : arr) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int start, int goal) {
        Queue<Integer> q = new LinkedList();
        q.add(start);
        while(!q.isEmpty()) {
            int current = q.poll();
            for(int next : doubleList.get(current)) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    graph[start][next] = 1;
                }
            }
        }
    }
}