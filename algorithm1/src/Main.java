import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NKB = br.readLine().split(" ");
        int N = Integer.parseInt(NKB[0]);
        int K = Integer.parseInt(NKB[1]);
        int B = Integer.parseInt(NKB[2]);

        int[] numbers = new int[N];
        for(int i = 0 ; i < B ; i++) {
            int index = Integer.parseInt(br.readLine())-1;
            numbers[index] = 1;
        }

        int answer = -1;
        question: for(int i = 0 ; i <= B ; i++) {
            int lt = 0;
            int currentK = 0;
            for(int rt = 0 ; rt < N ; rt++) {
                if(numbers[rt] == 1) {
                    currentK++;
                    while(currentK > i) {
                        if(numbers[lt] == 1) currentK--;
                        lt++;
                    }
                }
                if((rt-lt+1) == K) {
                    answer = i;
                    break question;
                }
            }
        }
        System.out.println(answer);
    }
}