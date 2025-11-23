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
            int minIndex = i;
            for(int j = i+1 ; j < N ; j++) {
                if(input[j] < input[minIndex]) minIndex = j;
            }
            int temp = input[i];
            input[i] = input[minIndex];
            input[minIndex] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(int n : input) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}