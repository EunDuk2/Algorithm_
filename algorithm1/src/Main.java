import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        int M = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        int[] moves = new int[M];
        for(int i = 0 ; i < M ; i++) {
            moves[i] = Integer.parseInt(input2[i])-1;
        }

        int count = 0;
        Stack<Integer> stack = new Stack();
        // moves의 인덱스를 j로 두고 i를 순회
        for(int j : moves) {
            for(int i = 0 ; i < N ; i++) {
                // board[i][j]가 0이 아니면, 그 값을 스택에 담고, 0으로 수정
                if(board[i][j] != 0) {

                    // 스택 마지막 값이랑 같으면 안 넣고 하나 pop하고 +2
                    if(!stack.isEmpty() && stack.peek() == board[i][j]) {
                        stack.pop();
                        count += 2;
                    } else {
                        stack.push(board[i][j]);
                    }

                    board[i][j] = 0;
                    break;
                }

            }
        }
        System.out.println(count);
    }
}