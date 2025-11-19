import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<List<Integer>> doubleList = new ArrayList();
    static List<Integer> temp = new ArrayList();
    static boolean[] visited;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        visited = new boolean[N];

        String[] inputNumbers = br.readLine().split(" ");

        numbers = new int[N];
        for(int i = 0 ; i < N ; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }
        Arrays.sort(numbers);

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for(List<Integer> list : doubleList) {
            for(int i = 0 ; i < M ; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    static void dfs(int depth) {
        if(temp.size() == M) {
            doubleList.add(new ArrayList(temp));
            return;
        }

        for(int i = 0 ; i < N ; i++) {
            if(!visited[i]) {
                temp.add(numbers[i]);
                visited[i] = true;
                dfs(depth+1);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }
}