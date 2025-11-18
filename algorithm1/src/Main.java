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

        int sum = 0;
        int score = 1;
        for(int i = 0 ; i < N ; i++) {
            if(input[i] == 1) {
                sum += score++;
            } else {
                score = 1;
            }
        }
        System.out.println(sum);
    }
}