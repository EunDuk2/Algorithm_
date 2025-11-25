import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] inputStr = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(inputStr[i]);
        }
        Arrays.sort(arr);
        int answer = -1;

        int lt = 0;
        int rt = arr.length-1;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(arr[mid] == M) {
                answer = mid+1;
                break;
            }
            else if(arr[mid] > M) rt = mid-1;
            else lt = mid+1;
        }

        System.out.println(answer);
    }
}