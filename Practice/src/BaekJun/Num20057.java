package BaekJun;

import java.util.Scanner;

public class Num20057 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] sand = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sand[i][j] = sc.nextInt();
            }
        }

        int x = N / 2;
        int y = N / 2;
        int d = -1;
        visited[x][y] = true;

        int out = 0;
        while (!(x == 0 && y == 0)) {
            int nd = (d + 1) % 4;
            int nx = x + dx[nd];
            int ny = y + dy[nd];

            if (visited[nx][ny]) {
                nx = x + dx[d];
                ny = y + dy[d];
            } else {
                d = nd;
            }

            int s = sand[nx][ny];
            int left = s;

            sand[nx][ny] = 0;

            int dd = (d - 1 + 4) % 4;
            int xx = nx + dx[dd] * 2;
            int yy = ny + dy[dd] * 2;
            int m = (int) (s * 0.02);
            left -= m;
            if (isOut(N, xx, yy)) {
                out += m;
            } else {
                sand[xx][yy] += m;
            }

            dd = (d + 1)  % 4;
            xx = nx + dx[dd] * 2;
            yy = ny + dy[dd] * 2;
            m = (int) (s * 0.02);
            left -= m;
            if (isOut(N, xx, yy)) {
                out += m;
            } else {
                sand[xx][yy] += m;
            }

            dd = (d - 1 + 4) % 4;
            xx = nx + dx[dd];
            yy = ny + dy[dd];
            m = (int) (s * 0.07);
            left -= m;
            if (isOut(N, xx, yy)) {
                out += m;
            } else {
                sand[xx][yy] += m;
            }

            dd = (d + 1) % 4;
            xx = nx + dx[dd];
            yy = ny + dy[dd];
            m = (int) (s * 0.07);
            left -= m;
            if (isOut(N, xx, yy)) {
                out += m;
            } else {
                sand[xx][yy] += m;
            }

            dd = (d - 1 + 4) % 4;
            xx = nx + dx[d] + dx[dd];
            yy = ny + dy[d] + dy[dd];
            m = (int) (s * 0.1);
            left -= m;
            if (isOut(N, xx, yy)) {
                out += m;
            } else {
                sand[xx][yy] += m;
            }

            dd = (d + 1) % 4;
            xx = nx + dx[d] + dx[dd];
            yy = ny + dy[d] + dy[dd];
            m = (int) (s * 0.1);
            left -= m;
            if (isOut(N, xx, yy)) {
                out += m;
            } else {
                sand[xx][yy] += m;
            }

            xx = nx + dx[d] * 2;
            yy = ny + dy[d] * 2;
            m = (int) (s * 0.05);
            left -= m;
            if (isOut(N, xx, yy)) {
                out += m;
            } else {
                sand[xx][yy] += m;
            }

            dd = (d + 1) % 4;
            xx = x + dx[dd];
            yy = y + dy[dd];
            m = (int) (s * 0.01);
            left -= m;
            if (isOut(N, xx, yy)) {
                out += m;
            } else {
                sand[xx][yy] += m;
            }

            dd = (d - 1 + 4) % 4;
            xx = x + dx[dd];
            yy = y + dy[dd];
            m = (int) (s * 0.01);
            left -= m;
            if (isOut(N, xx, yy)) {
                out += m;
            } else {
                sand[xx][yy] += m;
            }

            xx = nx + dx[d];
            yy = ny + dy[d];
            if (isOut(N, xx, yy)) {
                out += left;
            } else {
                sand[xx][yy] += left;
            }

            x = nx;
            y = ny;
            visited[nx][ny] = true;
        }
        System.out.println(out);
    }

    static boolean isOut(int N, int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) return true;
        else return false;
    }
}
