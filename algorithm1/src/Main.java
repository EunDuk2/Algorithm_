import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        Map<Character, Integer> map = new HashMap();

        for(char c : input) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int max = 0;
        char maxChar = input[0];
        for(char c : map.keySet()) {
            if(map.get(c) > max) {
                max = map.get(c);
                maxChar = c;
            }
        }
        System.out.println(maxChar);
    }
}