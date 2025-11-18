import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3 ; i < dp.length ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < dp.length ; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }
}