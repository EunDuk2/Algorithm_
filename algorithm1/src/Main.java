import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                boolean isPeak = true;

                // 상
                if (i - 1 >= 0 && arr[i - 1][j] >= arr[i][j]) isPeak = false;

                // 하
                if (i + 1 < N && arr[i + 1][j] >= arr[i][j]) isPeak = false;

                // 좌
                if (j - 1 >= 0 && arr[i][j - 1] >= arr[i][j]) isPeak = false;

                // 우
                if (j + 1 < N && arr[i][j + 1] >= arr[i][j]) isPeak = false;

                if (isPeak) count++;
            }
        }
        System.out.println(count);
    }
}
