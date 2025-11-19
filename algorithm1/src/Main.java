import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int K = Integer.parseInt(NM[1]);

        String[] inputStr = br.readLine().split(" ");
        int[] numbers = new int[N];

        for(int i = 0 ; i < N ; i++) {
            numbers[i] = Integer.parseInt(inputStr[i]);
        }

        int lt = 0;
        int answer = 0;
        int cnt = 0;

        for(int rt = 0 ; rt < N ; rt++) {
            if(numbers[rt] == 0) cnt++;
            while(cnt > K) {
                if(numbers[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt-lt+1);
        }
        System.out.println(answer);
    }
}