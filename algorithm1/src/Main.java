import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();
        Character ch = Character.toUpperCase(br.readLine().charAt(0));

        int result = 0;

        for(int i = 0 ; i < str.length() ; i++) {
            Character c = str.charAt(i);

            if(c.equals(ch)) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
