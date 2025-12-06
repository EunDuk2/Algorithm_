import java.io.*;
import java.util.*;

public class Main {
    static int V, E, K;
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] VE = br.readLine().split(" ");
        V = Integer.parseInt(VE[0]);
        E = Integer.parseInt(VE[1]);
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[V+1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < E; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]);
            int v = Integer.parseInt(uvw[1]);
            int w = Integer.parseInt(uvw[2]);

            graph.get(u).add(new int[]{v, w});
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void dijkstra(int start) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int[] currentArr = pq.poll();
            int current = currentArr[0];
            int currentCost = currentArr[1];

            if(currentCost > dist[current]) continue;

            for(int[] nextArr : graph.get(current)) {
                int next = nextArr[0];
                int nextCost = nextArr[1];

                if(dist[next] > dist[current] + nextCost) {
                    dist[next] = dist[current] + nextCost;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }
    }
}