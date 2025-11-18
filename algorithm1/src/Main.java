import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine().replace('#', '1').replace('*', '0');

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++) {
            String cut = s.substring(0, 7);
            char c = (char) Integer.parseInt(cut, 2);
            sb.append(c);
            s = s.substring(7);
        }
        System.out.println(sb);
    }
}