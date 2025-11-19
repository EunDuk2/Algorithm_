import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = br.readLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);

        int[][] arr = new int[M][N];

        for(int i = 0 ; i < M ; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 학생별로 돌면서, 자기보다 높은애들을 set에 넣고, 인원수 - set.size
        int count = 0;
        for(int i = 1 ; i <= N ; i++) {
            Set<Integer> set = new HashSet();
            for(int j = 0 ; j < M ; j++) {
                for(int k = 0 ; k < N ; k++) {
                    if(i == arr[j][k]) {
                        break;
                    } else {
                        set.add(arr[j][k]);
                    }
                }
            }
            count += N - set.size()-1;
        }
        System.out.println(count);
    }
}