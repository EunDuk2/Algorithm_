import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] isPrime = new int[N+1];

        for(int i = 2 ; i*i < N+1 ; i++) {
            for(int j = i*i ; j < N+1 ; j += i) {
                if(isPrime[j] == 0) {
                    isPrime[j] = 1;
                }
            }
        }

        int count = 0;
        for(int i = 2 ; i < isPrime.length ; i++) {
            if(isPrime[i] == 0) count++;
        }
        System.out.println(count);
    }
}