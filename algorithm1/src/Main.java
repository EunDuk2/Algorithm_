import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = br.readLine().split(" ");

        String result = "";

        for(String s : strArr) {
            if(s.length() > result.length()) {
                result = s;
            }
        }

        System.out.println(result);
    }
}