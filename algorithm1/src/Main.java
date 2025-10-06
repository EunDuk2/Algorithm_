import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] doubleList;
    static boolean[][] visited;
    static int result = 0;
    static int cnt = 0;
    static int maxHeight;
    static List<int[]> temp = new ArrayList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        temp.add(new int[]{0, 1});
        temp.add(new int[]{1, 0});
        temp.add(new int[]{-1, 0});
        temp.add(new int[]{0, -1});

        doubleList = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++) {
                doubleList[i][j] = Integer.parseInt(input[j]);
                if(maxHeight < doubleList[i][j]) maxHeight = doubleList[i][j];
            }
        }

        for(int h = 1 ; h <= maxHeight ; h++) {
            for(int i = 0 ; i < N ; i++) {
                for(int j = 0 ; j < N ; j++) {
                    if(!visited[i][j] && doubleList[i][j] > h) {
                        bfs(i, j, h);
                    }
                }
            }
            if(cnt > result) {
                result = cnt;
            }
            visited = new boolean[N][N];
            cnt = 0;
        }
        System.out.println(result == 0 ? 1 : result);
    }
    static void bfs(int x, int y, int h) {
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        cnt++;
        while(!q.isEmpty()) {
            int[] current = q.poll();

            for(int i = 0 ; i < temp.size() ; i++) {
                int a = current[0] + temp.get(i)[0];
                int b = current[1] + temp.get(i)[1];

                if(a >= 0 && a < N && b >= 0 && b < N) {
                    if(!visited[a][b] && doubleList[a][b] > h) {
                        q.add(new int[]{a, b});
                        visited[a][b] = true;
                    }
                }
            }
        }
    }
}
