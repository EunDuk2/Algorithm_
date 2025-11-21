import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int r, c, d;
    static int[][] room;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        String[] rcd = br.readLine().split(" ");
        r = Integer.parseInt(rcd[0]);
        c = Integer.parseInt(rcd[1]);
        d = Integer.parseInt(rcd[2]);

        room = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            String[] roomStr = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j++) {
                room[i][j] = Integer.parseInt(roomStr[j]);
            }
        }

        int answer = 0;
        while(true) {
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if(room[r][c] == 0) {
                room[r][c] = 2;
                answer++;
            }
            // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
            else if(isCleanAround()) {
                // 1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                int[] nextRc = nextRc(true);
                int nr = nextRc[0];
                int nc = nextRc[1];
                if(room[nr][nc] != 1) {
                    r = nr;
                    c = nc;
                }
                // 2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                else if(room[nr][nc] == 1) {
                    break;
                }
            }
            // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
            else if(!isCleanAround()) {
                // 1. 반시계 방향으로 90도 회전한다.
                d--;
                if(d == -1) d = 3;
                // 2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                int[] nextRc = nextRc(false);
                int nr = nextRc[0];
                int nc = nextRc[1];
                if(room[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                }
                // 3. 1번으로 돌아간다.
                continue;
            }
        }
        System.out.println(answer);
    }
    // 로봇 청소기의 다음 위치를 계산하여 반환 nr, nc (앞 뒤 기준 받기)
    static int[] nextRc(boolean isBack) {
        int[] rc = new int[2];

        if(d == 0) {
            if(!isBack) {
                rc[0] = r-1;
                rc[1] = c;
            } else {
                rc[0] = r+1;
                rc[1] = c;
            }
        } else if(d == 1) {
            if(!isBack) {
                rc[0] = r;
                rc[1] = c+1;
            } else {
                rc[0] = r;
                rc[1] = c-1;
            }
        } else if(d == 2) {
            if(!isBack) {
                rc[0] = r+1;
                rc[1] = c;
            } else {
                rc[0] = r-1;
                rc[1] = c;
            }
        } else if(d == 3) {
            if(!isBack) {
                rc[0] = r;
                rc[1] = c-1;
            } else {
                rc[0] = r;
                rc[1] = c+1;
            }
        }
        return rc;
    }
    // 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우: false, 없는 경우: true
    static boolean isCleanAround() {
        if(room[r-1][c] == 0 || room[r][c+1] == 0 || room[r+1][c] == 0 || room[r][c-1] == 0) {
            return false;
        }
        return true;
    }
}