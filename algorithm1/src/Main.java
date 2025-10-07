import java.io.*;
import java.util.*;

public class Main {
    static int I;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T ; t++) {
            I = Integer.parseInt(br.readLine());
            graph = new int[I][I];
            visited = new boolean[I][I];
            dist = new int[I][I];

            String[] currentXY = br.readLine().split(" ");
            int currentX = Integer.parseInt(currentXY[0]);
            int currentY = Integer.parseInt(currentXY[1]);

            String[] targetXY = br.readLine().split(" ");
            int targetX = Integer.parseInt(targetXY[0]);
            int targetY = Integer.parseInt(targetXY[1]);

            bfs(currentX, currentY, new int[]{targetX, targetY});

            System.out.println(dist[targetX][targetY]);
        }
    }
    static void bfs(int x, int y, int[] target) {
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        dist[x][y] = 0;
        while(!q.isEmpty()) {
            int[] currentXY = q.poll();
            for(int i = 0 ; i < 8 ; i++) {
                int currentX = currentXY[0] + dx[i];
                int currentY = currentXY[1] + dy[i];
                if(currentX >= 0 && currentX < I && currentY >= 0 && currentY < I && !visited[currentX][currentY]) {
                    q.add(new int[]{currentX, currentY});
                    visited[currentX][currentY] = true;
                    dist[currentX][currentY] = dist[currentXY[0]][currentXY[1]] + 1;
                }
            }
        }
    }
}
