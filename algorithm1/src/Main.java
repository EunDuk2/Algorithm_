import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int total = 0;
        Set<String> set = new HashSet();

        for(int i = 0 ; i < n ; i++) {
            set.add(br.readLine());
        }
        for(int i = 0 ; i < m ; i++) {
            if(set.contains(br.readLine())) {
                total += 1;
            }
        }
        System.out.println(total);
    }
}