import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] inputArr = br.readLine().split(" ");
        Set<Integer> set = new HashSet();
        for(int i = 0 ; i < N ; i++) {
            set.add(Integer.parseInt(inputArr[i]));
        }

        if(set.size() == N) System.out.println("U");
        else System.out.println("D");
    }
}