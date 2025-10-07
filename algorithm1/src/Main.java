import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 1;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new boolean[N][N];

        int maxHeight = 1;
        for(int i = 0 ; i < N ; i++) {
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++) {
                int num = Integer.parseInt(line[j]);
                graph[i][j] = num;
                if(graph[i][j] > maxHeight) maxHeight = graph[i][j];
            }
        }

        for(int h = 1 ; h <= maxHeight ; h++) {
            for(int x = 0 ; x < N ; x++) {
                for(int y = 0 ; y < N ; y++) {
                    if(graph[x][y] > h && !visited[x][y]) {
                        bfs(x, y, h);
                    }
                }
            }
            visited = new boolean[N][N];
            result = Math.max(result, cnt);
            cnt = 0;
        }
        System.out.println(result);
    }
    static void bfs(int x, int y, int h) {
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        cnt++;
        while(!q.isEmpty()) {
            int[] current = q.poll();
            for(int i = 0 ; i < 4 ; i++) {
                int curX = current[0] + dx[i];
                int curY = current[1] + dy[i];
                if(curX >= 0 && curX < N && curY >= 0 && curY < N && graph[curX][curY] > h && !visited[curX][curY]) {
                    q.add(new int[]{curX, curY});
                    visited[curX][curY] = true;
                }
            }
        }
    }
}
