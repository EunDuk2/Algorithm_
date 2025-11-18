import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");

        int[] input = new int[N];
        List<Integer> list = new ArrayList();
        for(int i = 0 ; i < N ; i++) {
            input[i] = Integer.parseInt(strArr[i]);
            list.add(input[i]);
        }

        list.sort(Comparator.reverseOrder());

        Map<Integer, Integer> map = new HashMap();
        int rank = 1;
        for(int score : list) {
            if(!map.containsKey(score)) map.put(score, rank);
            rank++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++) {
            sb.append(map.get(input[i])).append(" ");
        }
        System.out.println(sb);
    }
}