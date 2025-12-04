import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static int[] sums;
    static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        int max = Arrays.stream(numbers).sum();
        sums = new int[max+1];

        dfs(0);

        int answer = max+1;
        for(int i = 1 ; i < sums.length ; i++) {
            if(sums[i] == 0) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    static void dfs(int start) {
        for(int i = start ; i < N ; i++) {
            sum += numbers[i];
            sums[sum] = 1;
            dfs(i+1);
            sum -= numbers[i];
        }
    }
}