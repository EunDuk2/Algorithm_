import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][5];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        Map<Integer, Integer> map = new HashMap();

        // 학생별로 반복
        for(int i = 0 ; i < N ; i++) {
            // 비교할 학생별로 반복
            for(int j = i+1 ; j < N ; j++) {
                // 5개 학년 비교
                for(int k = 0 ; k < 5 ; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        map.put(i+1, map.getOrDefault(i+1, 0)+1);
                        map.put(j+1, map.getOrDefault(j+1, 0)+1);
                        break;
                    }
                }
            }
        }
        int maxStudent = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; i++) {
            if(map.get(i+1) != null && map.get(i+1) > max) {
                maxStudent = i+1;
                max = map.get(i+1);
            }
        }
        System.out.println(maxStudent);
    }
}