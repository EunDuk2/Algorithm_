import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution s = new Solution();
        int[] nums = {9, 1, 5, 3, 6, 2};
//        int[] nums = {2, 3, 3, 5};
        System.out.println(Arrays.toString(s.solution(nums)));
    }
}
