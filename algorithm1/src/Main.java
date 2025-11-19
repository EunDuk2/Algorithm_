import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] inputStr = br.readLine().split(" ");
        int[] numbers = new int[N];

        for(int i = 0 ; i < N ; i++) {
            numbers[i] = Integer.parseInt(inputStr[i]);
        }

        int lt = 0;
        int rt = 0;

        int sum = 0;
        int count = 0;
        while(true) {
            if(sum == M) {
                count++;
                sum -= numbers[lt++];
            } else if(sum > M) {
                sum -= numbers[lt++];
            } else {
                if(rt >= N) break;
                sum += numbers[rt++];
            }
        }
        System.out.println(count);
    }
}