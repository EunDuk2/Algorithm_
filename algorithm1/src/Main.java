import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static int x, y;
    static int d = 2; // 0-3 : 북동남서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        board = new int[N][N];
        x = 0;
        y = 0;
        
        for(int i = N*N ; i > 0 ; i--) {
            board[x][y] = i;
            nextXy();
        }

        StringBuilder sb = new StringBuilder();
        for(int[] a : board) {
            for(int b : a) {
                sb.append(b).append(" ");
            }
            sb.append("\n");
        }
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(board[i][j] == M) {
                    sb.append((i+1) + " " + (j+1));
                }
            }
        }
        System.out.println(sb);
    }
    // 다음 위치 계산하고 못가면 방향바꾼 다음 위치로 반환
    static void nextXy() {
        if(d == 0) {
            if(x-1 < 0 || board[x-1][y] != 0) {
                d = 3;
                y = y-1;
            } else {
                x = x-1;
            }
        } else if(d == 1) {
            if(y+1 >= N || board[x][y+1] != 0) {
                d = 0;
                x = x-1;
            } else {
                y = y+1;
            }
        } else if(d == 2) {
            if(x+1 >= N || board[x+1][y] != 0) {
                d = 1;
                y = y+1;
            } else {
                x = x+1;
            }
        } else if(d == 3) {
            if(y-1 < 0 || board[x][y-1] != 0) {
                d = 2;
                x = x+1;
            } else {
                y = y-1;
            }
        }
    }
}