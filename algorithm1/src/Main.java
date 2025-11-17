import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();
        char[] charArr = str.toCharArray();

        String result = "YES";

        int lt = 0;
        int rt = charArr.length-1;

        while(lt < rt) {
            if(!isText(charArr[lt])) lt++;
            else if(!isText(charArr[rt])) rt--;
            else {
                if(charArr[lt] != charArr[rt]) {
                    result = "NO";
                    break;
                } else {
                    lt++;
                    rt--;
                }
            }
        }
        System.out.println(result);
    }
    static boolean isText(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}