import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList();
        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new int[2]);
            list.get(i)[0] = Integer.parseInt(input[0]);
            list.get(i)[1] = Integer.parseInt(input[1]);
        }

        list.sort((a, b) -> {
           int compare1 = a[0] - b[0];
           if(compare1 != 0) return compare1;
           int compare2 = a[1] - b[1];
           return compare2;
        });

        for(int[] n : list) {
            System.out.println(n[0] + " " + n[1]);
        }
    }
}