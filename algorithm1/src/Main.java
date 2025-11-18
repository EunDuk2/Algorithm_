import java.io.*;
import java.util.*;

public class Main {
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

        int max = Integer.MIN_VALUE;
        int line1 = 0;
        int line2 = 0;
        for(int i = 0 ; i < N ; i++) {
            int row = 0;
            int column = 0;
            for(int j = 0 ; j < N ; j++) {
                // 행
                row += arr[i][j];
                // 열
                column += arr[j][i];
            }
            line1 += arr[i][i];
            line2 += arr[i][N-1-i];
            max = Math.max(max, row);
            max = Math.max(max, column);
        }
        max = Math.max(max, line1);
        max = Math.max(max, line2);

        System.out.println(max);
    }
}