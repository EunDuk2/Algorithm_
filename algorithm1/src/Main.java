import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input1 = br.readLine().toCharArray();
        char[] input2 = br.readLine().toCharArray();

        Map<Character, Integer> map1 = new HashMap();
        for(char c : input1) {
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> map2 = new HashMap();
        for(char c : input2) {
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }

        boolean isAnswer = true;
        for(char c : map1.keySet()) {
            if(!map2.containsKey(c)) {
                isAnswer = false;
                break;
            }
            if(map1.get(c) != map2.get(c)) {
                isAnswer = false;
                break;
            }
        }
        if(isAnswer) System.out.println("YES");
        else System.out.println("NO");
    }
}