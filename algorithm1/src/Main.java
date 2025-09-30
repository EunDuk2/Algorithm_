import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 1
        for(int i = 0 ; i < t ; i++) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            // 2
            String[] nums = br.readLine().split(" ");
            int[] list = new int[n];
            for (int j = 0; j < n; j++) {
                list[j] = Integer.parseInt(nums[j]);
            }
            Arrays.sort(list);

            // 3
            int left = 0;
            int right = list.length-1;

            int min = Integer.MAX_VALUE;
            int count = 0;

            while(left < right) {
                int sum = list[left] + list[right];
                int diff = Math.abs(sum-k);

                if(diff == min) {
                    count++;
                } else if(diff < min) {
                    min = diff;
                    count = 1;
                }

                if(sum > k) right--;
                else left++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}