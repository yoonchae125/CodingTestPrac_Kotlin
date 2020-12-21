package BaekJun;

import java.util.Scanner;

public class Num14503 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();
        int td = sc.nextInt();
        int d = 0;
        switch (td) {
            case 0:
                d = 0;
                break;
            case 1:
                d = 3;
                break;
            case 2:
                d = 2;
                break;
            case 3:
                d = 1;
                break;
        }

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int answer = 1;


        int changed = 0;
        boolean[][] check = new boolean[N][M];
        check[x][y] = true;
        while (true) {
            System.out.println(changed);

            if (changed >= 4) {
                int t = (d + 2) % 4;
                int nx = x + dx[t];
                int ny = y + dy[t];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1) {
                    break;
                }
                System.out.println("back");
                x = nx;
                y = ny;
            }
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1 || check[nx][ny]) {
                System.out.println("change dir");
                d = (d + 1) % 4;
                changed++;
                continue;
            }
            System.out.println("clean");
            check[nx][ny] = true;
            changed = 0;
            answer++;
            x = nx;
            y = ny;
            d = (d + 1) % 4;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print((check[i][j]?1:0)+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println(answer);
    }
}
