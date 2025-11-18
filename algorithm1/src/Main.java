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

        int count = 0;
        int height = 0;

        for(int i = 0 ; i < N ; i++) {
            if(input[i] > height) {
                count++;
                height = input[i];
            }
        }
        System.out.println(count);
    }
}