import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;

    static List<Integer> numbers = new ArrayList();
    static List<List<Integer>> doubleList = new ArrayList();
    static List<Integer> temp = new ArrayList();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        visited = new boolean[N];

        String[] inputNumbers = br.readLine().split(" ");
        for(int i = 0 ; i < inputNumbers.length ; i++) {
            numbers.add(Integer.parseInt(inputNumbers[i]));
        }
        numbers.sort(Comparator.naturalOrder());

        dfs(0);

        for (List<Integer> list : doubleList) {
            for (int n : list) System.out.print(n + " ");
            System.out.println();
        }
    }
    static void dfs(int depth) {
        if(temp.size() == M) {
            doubleList.add(new ArrayList(temp));
            return;
        }
        for(int i = 0 ; i < numbers.size() ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(numbers.get(i));
                dfs(depth+1);
                visited[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}