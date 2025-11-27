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

        int lt = 0;
        int k = 0;
        int maxLength = 0;
        for(int rt = 0 ; rt < N ; rt++) {
            if(numbers[rt] == 0) {
                k++;
                while(k>K) {
                    if(numbers[lt] == 0) k--;
                    lt++;
                }
            }
            maxLength = Math.max(maxLength, (rt-lt+1));
        }
        System.out.println(maxLength);
    }
}