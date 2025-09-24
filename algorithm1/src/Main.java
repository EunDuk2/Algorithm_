import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1
        Map<Long, Integer> map = new HashMap();

        for(int i = 0 ; i < N ; i++) {
            Long key = Long.parseLong(br.readLine());
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        // 2
        List<Long> list = new ArrayList(map.keySet());

        list.sort((a, b) -> {
           int compare = map.get(b) - map.get(a);
           if(compare != 0) return compare;

           return Long.compare(a, b);
        });

        // 3
        System.out.println(list.get(0));
    }
}