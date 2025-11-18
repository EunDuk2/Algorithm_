import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] strArrA = br.readLine().split(" ");
        String[] strArrB = br.readLine().split(" ");
        int[] A = new int[N];
        int[] B = new int[N];

        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(strArrA[i]);
        }
        for(int i = 0 ; i < N ; i++) {
            B[i] = Integer.parseInt(strArrB[i]);
        }

        for(int i = 0 ; i < N ; i++) {
            int currentA = A[i];
            int currentB = B[i];

            if(currentA == currentB) System.out.println("D");
            else if(currentA == 1 && currentB == 3) System.out.println("A");
            else if(currentA == 2 && currentB == 1) System.out.println("A");
            else if(currentA == 3 && currentB == 2) System.out.println("A");
            else System.out.println("B");
        }
    }
}