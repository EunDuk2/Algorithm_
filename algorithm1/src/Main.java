import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        String[] inputStr = br.readLine().split(" ");
        int[] numbers = new int[N];

        for(int i = 0 ; i < N ; i++) {
            numbers[i] = Integer.parseInt(inputStr[i]);
        }

        int start = 0;
        int end = K-1;

        int max = 0;
        for(int i = start ; i <= end ; i++) {
            max += numbers[i];
        }

        int sum = max;
        while(end < N-1) {
            sum -= numbers[start++];
            sum += numbers[++end];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}