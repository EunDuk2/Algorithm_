import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        for(int i = 0 ; i < N ; i++) {
            numbers[i] = i+1;
        }

        int lt = 0, rt = 0;
        int sum = 0, count = 0;
        while(true) {
            if(sum == N) {
                count++;
                sum -= numbers[lt++];
            } else if(sum > N) {
                sum -= numbers[lt++];
            } else if(sum < N) {
                if(rt == N-1) break;
                sum += numbers[rt++];
            }
        }
        System.out.println(count);
    }
}