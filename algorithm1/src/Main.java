import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] SN = br.readLine().split(" ");
        int S = Integer.parseInt(SN[0]);
        int N = Integer.parseInt(SN[1]);

        String[] inputArr = br.readLine().split(" ");
        int[] input = new int[N];
        for(int i = 0 ; i < N ; i++) {
            input[i] = Integer.parseInt(inputArr[i]);
        }

        LinkedList<Integer> q = new LinkedList();
        for(int i = 0 ; i < S ; i++) {
            q.add(0);
        }
        for(int i = 0 ; i < N ; i++) {
            // 1. 해야할 작업이 캐시에 없는 상태 -> 마지막꺼 없애고, 맨앞에 새로운 작업 추가
            if(!q.contains(input[i])) {
                q.addFirst(input[i]);
                q.removeLast();
            }
            // 2. 해야할 작업이 캐시에 있는 경우 -> 해당 작업 빼서 맨 앞에 추가
            else {
                q.remove(q.indexOf(input[i]));
                q.addFirst(input[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int n : q) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}