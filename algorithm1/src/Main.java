import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;

    static List<Integer> numbers = new ArrayList();
    static List<List<Integer>> doubleList = new ArrayList();
    static List<Integer> temp = new ArrayList();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        String[] inputNumbers = br.readLine().split(" ");

        Set<Integer> set = new TreeSet();

        for(int i = 0 ; i < inputNumbers.length ; i++) {
            set.add(Integer.parseInt(inputNumbers[i]));
        }
        N = set.size();

        for(int n : set) {
            numbers.add(n);
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for(List<Integer> list : doubleList) {
            for(int n : list) {
                sb.append(n).append(" ");
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
        for(int i = start ; i < N ; i++) {
            temp.add(numbers.get(i));
            dfs(i);
            temp.remove(temp.size()-1);
        }
    }
}