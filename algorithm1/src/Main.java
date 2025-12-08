import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N;
    static int[][] graph;
    static int[][] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            graph = new int[N][N];
            dist = new int[N][N];
            for(int[] d : dist) {
                Arrays.fill(d, INF);
            }

            for(int i = 0 ; i < N ; i++) {
                String[] input = br.readLine().split(" ");

                for(int j = 0 ; j < N ; j++) {
                    graph[i][j] = Integer.parseInt(input[j]);
                }
            }

            dijkstra(0, 0);
            System.out.println("Problem " + count++ + ": " + dist[N-1][N-1]);
        }
    }
    static void dijkstra(int x, int y) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> graph[a[0]][a[1]] - graph[b[0]][b[1]]);
        pq.add(new int[]{x, y});
        dist[x][y] = graph[x][y];

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0 ; i < 4 ; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx > -1 && nx < N && ny > -1 && ny < N) {
                    if(dist[nx][ny] > dist[cx][cy] + graph[nx][ny]) {
                        pq.add(new int[]{nx, ny});
                        dist[nx][ny] = dist[cx][cy] + graph[nx][ny];
                    }
                }
            }
        }
    }
}