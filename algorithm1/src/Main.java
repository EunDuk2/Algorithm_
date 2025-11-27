import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int answer = 0;
        int lt = 1;
        int rt = arr[N-1] - arr[0];
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(isPossible(arr, mid, M)) {
                answer = mid;
                lt = mid+1;
            } else {
                rt = mid-1;
            }
        }
        System.out.println(answer);
    }
    static boolean isPossible(int[] arr, int distance, int size) {
        int lt = 0;
        int count = 1;
        for(int rt = 1; rt < arr.length ; rt++) {
            if(arr[rt]-arr[lt] >= distance) {
                lt = rt;
                count++;
            }
        }
        return count >= size ? true : false;
    }
}