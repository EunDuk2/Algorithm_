import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            char[] chArr = br.readLine().toCharArray();

            for(int j = 0 ; j < chArr.length / 2 ; j++) {
                char start = chArr[j];
                char end = chArr[chArr.length-1-j];

                chArr[j] = end;
                chArr[chArr.length-1-j] = start;
            }

            System.out.println(new String(chArr));
        }
    }
}