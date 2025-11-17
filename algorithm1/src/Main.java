import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArr = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        for(char c : charArr) {
            if(!isText(c)) {
                sb.append(c);
            }
        }
        int result = Integer.parseInt(new String(sb));

        System.out.println(result);
    }
    static boolean isText(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}