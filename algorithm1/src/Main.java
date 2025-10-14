import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        List<Integer> A = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            A.add(Integer.parseInt(input[i]));
        }

        int[] answer = new int[N];

        int index = 0;
        while(index != N) {
            int minIndex = A.indexOf(Collections.min(A));
            answer[minIndex] = index++;
            A.set(minIndex, Integer.MAX_VALUE);
        }

        StringBuilder sb = new StringBuilder();
        for(int a : answer) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }
}
