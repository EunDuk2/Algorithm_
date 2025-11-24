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
        int[] sorted = input.clone();
        Arrays.sort(sorted);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++) {
            if(input[i] != sorted[i]) sb.append(i+1).append(" ");
        }
        System.out.println(sb);
    }
}