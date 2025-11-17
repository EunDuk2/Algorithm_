import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();
        char[] charArr = str.toCharArray();

        String result = "YES";
        for(int i = 0 ; i < charArr.length / 2 ; i++) {
            if(charArr[i] != charArr[charArr.length-1-i]) {
                result = "NO";
                break;
            }
        }
        System.out.println(result);
    }
}