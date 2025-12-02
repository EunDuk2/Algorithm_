import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        for(int i = 0 ; i < N ; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        long count = 0;
        long sum = 0;
        int lt = 0;
        for(int rt = 0 ; rt < N ; rt++) {
            sum += numbers[rt];
            while(sum > K) {
                count += N-rt;
                sum -= numbers[lt];
                lt++;
            }
        }
        System.out.println(count);
    }
}