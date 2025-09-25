import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> doubleList = new ArrayList();
    static List<Integer> temp = new ArrayList();
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        // 1
        dfs(1);

        // 2
        StringBuilder sb = new StringBuilder();
        for(List<Integer> list : doubleList) {
            for(int i = 0 ; i < list.size() ; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int start) {
        if(temp.size() == M) {
            doubleList.add(new ArrayList(temp));
            return;
        }
        for(int i = start ; i <= N ; i++) {
            temp.add(i);
            dfs(i+1);
            temp.remove(temp.size()-1);
        }
    }
}