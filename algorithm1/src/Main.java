import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> list = new ArrayList();
    static List<List<Integer>> doubleList = new ArrayList();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(List<Integer> list : doubleList) {
            for(int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int start) {
        if(list.size() == M) {
            doubleList.add(new ArrayList(list));
            return;
        }
        for(int i = start ; i <= N ; i++) {
            list.add(i);
            dfs(i);
            list.remove(list.size()-1);
        }
    }
}
