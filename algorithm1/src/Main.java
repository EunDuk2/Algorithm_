import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = br.readLine().split(" ");
        char[] s = strArr[0].toCharArray();
        char t = strArr[1].charAt(0);

        int[] result = new int[s.length];

        int distance = 1000;
        for(int i = 0 ; i < s.length ; i++) {
            if(s[i] == t) {
                distance = 0;
            } else {
                distance++;
            }
            result[i] = distance;
        }
        distance = 1000;
        for(int i = s.length-1 ; i >= 0 ; i--) {
            if(s[i] == t) {
                distance = 0;
            } else {
                distance++;
            }
            result[i] = Math.min(result[i], distance);
        }
        StringBuilder sb = new StringBuilder();
        for(int n : result) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}