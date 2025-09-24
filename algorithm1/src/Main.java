import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 1
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < N ; i++) {
            String key = br.readLine();
            if(key.length() >= M) {
                map.put(key, map.getOrDefault(key, 0)+1);
            }
        }

        // 2
        List<String> list = new ArrayList(map.keySet());
        list.sort((a, b) -> {
            int compare1 = map.get(b) - map.get(a);
            if(compare1 != 0) return compare1;

            int compare2 = b.length() - a.length();
            if(compare2 != 0) return compare2;

            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < list.size() ; i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}