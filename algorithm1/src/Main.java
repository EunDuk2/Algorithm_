import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashMap<String, Integer> map = new HashMap();

        for(int i = 0 ; i < n ; i++) {
            map.put(br.readLine(), 0);
        }
        for(int i = 0 ; i < m ; i++) {
            String a = br.readLine();
            if(map.get(a) != null) {
                map.put(a, map.get(a)+1);
            }
        }
        int total = 0;

        for(int a : map.values()) {
            total += a;
        }
        System.out.println(total);
    }
}