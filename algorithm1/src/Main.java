import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] inputArr = br.readLine().split(" ");
        int[] input = new int[N];
        for(int i = 0 ; i < N ; i++) {
            input[i] = Integer.parseInt(inputArr[i]);
        }

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N-1 ; j++) {
                if(input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int n : input) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}