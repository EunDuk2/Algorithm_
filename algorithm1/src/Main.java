import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] firstArr = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] secondArr = br.readLine().split(" ");

        int[] first = new int[N];
        int[] second = new int[M];

        for(int i = 0 ; i < N ; i++) {
            first[i] = Integer.parseInt(firstArr[i]);
        }
        for(int i = 0 ; i < M ; i++) {
            second[i] = Integer.parseInt(secondArr[i]);
        }

        int fp = 0;
        int sp = 0;

        List<Integer> list = new ArrayList();

        while(fp < N && sp < M) {
            if(first[fp] < second[sp]) {
                list.add(first[fp]);
                fp++;
            } else {
                list.add(second[sp]);
                sp++;
            }
        }
        if(fp == N) {
            while(sp < M) {
                list.add(second[sp++]);
            }
        } else {
            while(fp < N) {
                list.add(first[fp++]);
            }
        }
        System.out.println(list);
    }
}