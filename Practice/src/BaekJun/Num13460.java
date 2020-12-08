package BaekJun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Num13460 {
    static int N;
    static int M;
    static Queue<Integer> queue = new LinkedList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        char[][] arr = new char[N][M];
        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == 'R') {
                    arr[i][j] = '.';
                    rx = i;
                    ry = j;
                    continue;
                }
                if (c == 'B') {
                    arr[i][j] = '.';
                    bx = i;
                    by = j;
                    continue;
                }
                arr[i][j] = c;

            }
        }
        boolean[][][][] check = new boolean[N][M][N][M];
        check[rx][ry][bx][by] = true;
        queue.add(rx);
        queue.add(ry);
        queue.add(bx);
        queue.add(by);
        queue.add(0);
        System.out.print(go(arr, check));
    }

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static int go(char[][] arr, boolean[][][][] check) {

        while (!queue.isEmpty()) {
            int rx = queue.poll();
            int ry = queue.poll();
            int bx = queue.poll();
            int by = queue.poll();
            int cnt = queue.poll();

            if (cnt > 10) {
                continue;
            }
            if (arr[bx][by] == 'O') {
                continue;
            }
            if (arr[rx][ry] == 'O') {
                return cnt;
            }
            for (int d = 0; d < 4; d++) {
                int nrx = rx, nry = ry, nbx = bx, nby = by;
                while (true) {
                    if (!(arr[nbx][nby] == '#' || arr[nbx][nby] == 'O')) {
                        nbx += dx[d];
                        nby += dy[d];
                    }else{
                        if(arr[nbx][nby] == '#'){
                            nbx -= dx[d];
                            nby -= dy[d];
                        }
                        break;
                    }
                }
                while (true) {
                    if (!(arr[nrx][nry] == '#' || arr[nrx][nry] == 'O')) {
                        nrx += dx[d];
                        nry += dy[d];
                    }else{
                        if(arr[nrx][nry] == '#'){
                            nrx -= dx[d];
                            nry -= dy[d];
                        }
                        break;

                    }
                }
                if (nrx == nbx && nry == nby) {
                    if(arr[nrx][nry]!='O'){
                        int costR = Math.abs(nrx - rx);
                        costR = Math.max(costR, Math.abs(nry - ry));
                        int costB = Math.abs(nbx - bx);
                        costB = Math.max(costB, Math.abs(nby - by));

                        if (costR > costB) {
                            nrx -= dx[d];
                            nry -= dy[d];
                        } else {
                            nbx -= dx[d];
                            nby -= dy[d];
                        }
                    }
                }
                if (!check[nrx][nry][nbx][nby]) {
                    check[nrx][nry][nbx][nby] = true;
                    queue.add(nrx);
                    queue.add(nry);
                    queue.add(nbx);
                    queue.add(nby);
                    queue.add(cnt + 1);
                }
            }
        }
        return -1;
    }
}
