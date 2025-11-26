import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int C = Integer.parseInt(NM[1]);

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[N-1] - arr[0];
        int answer = 0;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            int count = count(arr, mid);

            if(count >= C) {      // mid 거리로 설치 가능
                answer = mid;    // 후보 업데이트
                lt = mid + 1;    // 더 큰 거리 탐색
            } else {
                rt = mid - 1;    // 더 작은 거리 탐색
            }
        }

        System.out.println(answer);
    }

    static int count(int[] arr, int dist) {
        int count = 1;
        int last = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - last >= dist) {
                count++;
                last = arr[i];
            }
        }
        return count;
    }
}
