import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int[] input = new int[N];
        for(int i = 0 ; i < N ; i++) {
            input[i] = Integer.parseInt(strArr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++) {
            int reverseNum = changeReverse(input[i]);
            if(isPrime(reverseNum)) sb.append(reverseNum).append(" ");
        }
        System.out.println(sb);
    }
    static int changeReverse(int num) {
        int temp = num;
        int reverse = 0;
        while(temp > 0) {
            int t = temp % 10;
            reverse = reverse * 10 + t;
            temp = temp / 10;
        }
        return reverse;
    }
    static boolean isPrime(int num) {
        if(num == 1 || num == 0) return false;
        for(int i = 2 ; i*i <= num ; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}