import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chArr = br.readLine().toCharArray();

        int left = 0;
        int right = chArr.length-1;

        while(left<right) {
            while (left < right && !isText(chArr[left])) {
                left++;
            }

            while (left < right && !isText(chArr[right])) {
                right--;
            }

            char rightCh = chArr[right];
            chArr[right] = chArr[left];
            chArr[left] = rightCh;

            left++;
            right--;
        }

        System.out.println(chArr);
    }

    static boolean isText(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}