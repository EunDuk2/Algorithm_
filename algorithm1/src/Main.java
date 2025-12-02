import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int S;
    static int[] numbers;
    static int sum;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NS = br.readLine().split(" ");
        N = Integer.parseInt(NS[0]);
        S = Integer.parseInt(NS[1]);

        String[] input = br.readLine().split(" ");
        numbers = new int[N];
        for(int i = 0 ; i < N ; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        dfs(0);

        System.out.println(count);
    }
    static void dfs(int start) {
        if(start == N) {

            return;
        }
        for(int i = start ; i < N ; i++) {
            sum += numbers[i];
            if(sum == S) count++;
            dfs(i+1);
            sum -= numbers[i];
        }
    }
}