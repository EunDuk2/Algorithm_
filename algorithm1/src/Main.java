import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] x = new long[N+1];
        long[] y = new long[N+1];

        for(int i=0; i<N; i++){
            String[] arr = br.readLine().split(" ");
            x[i] = Long.parseLong(arr[0]);
            y[i] = Long.parseLong(arr[1]);
        }

        // 마지막 점은 다시 처음으로 연결
        x[N] = x[0];
        y[N] = y[0];

        long sum = 0;
        for(int i=0; i<N; i++){
            sum += x[i] * y[i+1] - y[i] * x[i+1];
        }

        double area = Math.abs(sum) / 2.0;

        System.out.printf("%.1f", area);
    }
}