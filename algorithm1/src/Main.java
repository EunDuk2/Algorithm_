import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] s = new String[n];
        int total = 0;

        for(int i = 0 ; i < n ; i++) {
            s[i] = br.readLine();
        }

        for(int i = 0 ; i < m ; i++) {
            String a = br.readLine();
            for(int j = 0; j < n ; j++) {
                if(s[j].equals(a)) {
                    total++;
                }
            }
        }

        System.out.println(total);
    }
}