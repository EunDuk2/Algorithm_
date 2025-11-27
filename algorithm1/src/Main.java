import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        String[] input = br.readLine().split(" ");
        int[] numbers = new int[N];
        for(int i = 0 ; i < N ; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int lt = 0;

        for(int rt = 0 ; rt < N ; rt++) {
            sum += numbers[rt];
            if((rt-lt+1) == K) {
                max = Math.max(max, sum);
                sum -= numbers[lt++];
            }
        }
        System.out.println(max);
    }
}