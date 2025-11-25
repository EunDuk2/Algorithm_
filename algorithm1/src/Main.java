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
            int mid = (lt+rt) / 2;
            if(count(arr, mid) <= M) {
                answer = mid;
                rt = mid-1;
            } else {
                lt = mid+1;
            }
        }
        System.out.println(answer);
    }
    // 배열이랑 용량받고, 몇 개 필요한지 반환
    static int count(int[] arr, int capa) {
        int count = 1;
        int sum = 0;
        for(int n : arr) {
            if(sum+n > capa) {
                count++;
                sum = n;
            } else {
                sum += n;
            }
        }
        return count;
    }
}