import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> set = new TreeSet(Comparator.reverseOrder());
    static int N, K;
    static int[] numbers;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);
        String[] arr = br.readLine().split(" ");

        numbers = new int[N];
        for(int i = 0 ; i < N ; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }
        dfs(0, 0);

        int index = 1;
        int answer = -1;
        for(int n : set) {
            if(index++ == K) answer = n;
        }
        System.out.println(answer);
    }
    static void dfs(int start, int depth) {
        if(depth == 3) {
            set.add(sum);
            return;
        }
        for(int i = start ; i < N ; i++) {
            sum += numbers[i];
            dfs(i+1, depth+1);
            sum -= numbers[i];
        }
    }
}