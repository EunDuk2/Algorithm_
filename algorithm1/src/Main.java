import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        String[] numbers = br.readLine().split(" ");

        Map<String, Integer> map = new HashMap();

        StringBuilder sb = new StringBuilder();
        int lt = 0;
        for(int rt = 0 ; rt < N ; rt++) {
            map.put(numbers[rt], map.getOrDefault(numbers[rt], 0)+1);
            if(rt-lt+1 == K) {
                sb.append(map.size()).append(" ");
                map.put(numbers[lt], map.get(numbers[lt])-1);
                if(map.get(numbers[lt]) == 0) {
                    map.remove(numbers[lt]);
                }
                lt++;
            }
        }
        System.out.println(sb);
    }
}