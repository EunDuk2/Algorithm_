import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution s = new Solution();
//        System.out.println(s.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
        System.out.println(s.solution(new int[]{1, 2, 3, 1, 4}));
    }
}