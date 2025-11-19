import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            String[] strArr = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        int count = 0;
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                int current = arr[i][j];
                boolean isTop = true;
                for(int k = 0 ; k < 4 ; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] >= current) {
                        isTop = false;
                        break;
                    }
                }
                if(isTop) count++;
            }
        }
        System.out.println(count);
    }
}