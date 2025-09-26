import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] aStr = br.readLine().split(" ");
        int X = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList();
        for(String s : aStr) {
            list.add(Integer.parseInt(s));
        }
        list.sort(Comparator.naturalOrder());

        int result = 0;

        int a = 0;
        int b = list.size()-1;
        while(a < b) {
            int sum = list.get(a) + list.get(b);

            if(sum < X) {
                a += 1;
            } else if(sum > X) {
                b -= 1;
            } else {
                result += 1;
                a += 1;
                b = list.size()-1;
            }
        }

        System.out.println(result);
    }
}