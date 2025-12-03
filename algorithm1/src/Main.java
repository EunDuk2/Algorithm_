import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> doubleList = new ArrayList();
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        dist = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 0 ; i < N+1 ; i++) {
            doubleList.add(new ArrayList());
        }
        for(int i = 0 ; i < M ; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            doubleList.get(a).add(b);
            doubleList.get(a).sort(Comparator.naturalOrder());
            doubleList.get(b).add(a);
            doubleList.get(b).sort(Comparator.naturalOrder());
        }


        bfs(1);

        int max = Arrays.stream(dist).max().getAsInt();
        int order = -1;
        int count = 0;

        for(int i = 0 ; i < dist.length ; i++) {
            if(dist[i] == max) {
                if(order == -1) order = i;
                count++;
            }
        }
        System.out.println(order + " " + max + " " + count);
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int current = q.poll();
            for(int next : doubleList.get(current)) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    dist[next] = dist[current]+1;
                }
            }
        }
    }
}