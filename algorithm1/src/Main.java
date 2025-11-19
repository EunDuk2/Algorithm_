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

        Arrays.sort(first);
        Arrays.sort(second);

        int fp = 0;
        int sp = 0;
        List<Integer> list = new ArrayList();

        while(fp < N && sp < M) {
            if(first[fp] == second[sp]) {
                list.add(first[fp]);
                fp++;
                sp++;
            } else if(first[fp] < second[sp]) {
                fp++;
            } else {
                sp++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int n : list) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}