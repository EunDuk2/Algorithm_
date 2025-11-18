import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int[] input = new int[N];

        for(int i = 0 ; i < N ; i++) {
            input[i] = Integer.parseInt(strArr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++) {
            if(i == 0) {
                sb.append(input[i]).append(" ");
            } else {
                if(input[i-1] < input[i]) {
                    sb.append(input[i]).append(" ");
                }
            }
        }
        System.out.println(sb);
    }
}