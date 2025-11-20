import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        char[] ana = br.readLine().toCharArray();

        // ana -> map
        Map<Character, Integer> anaMap = new HashMap();
        for(char c : ana) {
            anaMap.put(c, anaMap.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> inputMap = new HashMap();
        int count = 0;
        int lt = 0;
        for(int rt = 0 ; rt < input.length ; rt++) {
            inputMap.put(input[rt], inputMap.getOrDefault(input[rt], 0)+1);

            if(rt - lt + 1 == ana.length) {
                if(inputMap.equals(anaMap)) {
                    count++;
                }

                inputMap.put(input[lt], inputMap.get(input[lt]) - 1);
                if(inputMap.get(input[lt]) == 0) inputMap.remove(input[lt]);
                lt++;
            }

        }
        System.out.println(count);
    }
}