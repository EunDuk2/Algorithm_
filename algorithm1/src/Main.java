import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] inputArr = br.readLine().split(" ");
        int[] input = new int[N];
        for(int i = 0 ; i < N ; i++) {
            input[i] = Integer.parseInt(inputArr[i]);
        }

        for (int i = 1; i < N; i++) {
            int key = input[i];     // 끼워 넣을 값
            int j = i - 1;

            // key보다 큰 값들은 오른쪽으로 이동
            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j--;
            }

            // key를 제자리 삽입
            input[j + 1] = key;
        }

        StringBuilder sb = new StringBuilder();
        for(int n : input) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}