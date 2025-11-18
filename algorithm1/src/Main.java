import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArr = br.readLine().toCharArray();

        char temp = charArr[0];
        int count = 0;

        StringBuilder sb = new StringBuilder();
        for(char c : charArr) {
            if(temp == c) {
                count++;
            } else {
                sb.append(temp);
                if(count != 1) sb.append(count);
                temp = c;
                count = 1;
            }
        }
        sb.append(temp);
        if(count != 1) sb.append(count);
        System.out.println(sb);
    }
}