import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] input = br.readLine().split(" ");

        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int answer = 0;
        while(lt <= rt) {
            // count가 M보다 크면 mid가 큰 것임
            int mid = (lt+rt) / 2;
            int count = count(arr, mid);
            if(count > M) {
                lt = mid+1;
            } else {
                answer = mid;
                rt = mid-1;
            }
        }
        System.out.println(answer);
    }
    static int count(int[] arr, int capacity) {
        // capacity에 넣을 때, 최대 몇 세트가 나오는지 반환
        int sum = 0;
        int count = 1;
        for(int i = 0 ; i < arr.length ; i++) {
            sum += arr[i];
            if(sum > capacity) {
                sum = arr[i];
                count++;
            }
        }
        return count;
    }
}