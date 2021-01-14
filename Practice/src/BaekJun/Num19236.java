package BaekJun;

import java.util.Scanner;

public class Num19236 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Fish[] fishes = new Fish[17];
        int[][] map = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt() - 1;
                map[i][j] = a;
                fishes[a] = new Fish(i, j, b);
            }
        }

        int eat = map[0][0];
        int d = fishes[eat].d;
        fishes[eat] = null;
        map[0][0] = -1;
        go(map, fishes, 0, 0, d, eat);

        System.out.println(ans);
    }

    static int ans = 0;

    static void go(int[][] map, Fish[] fishes, int x, int y, int sd, int score) {

        for (int i = 1; i <= 16; i++) {
            Fish fish = fishes[i];
            if (fish == null) continue;

            for (int d = 0; d < 8; d++) {
                int nd = (fish.d + d) % 8;
                int nx = fish.x + dx[nd];
                int ny = fish.y + dy[nd];
                if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;

                int fid = map[nx][ny];
                if (fid == -1) continue; // shark

                if (fid != 0) { // not empty
                    fishes[fid].x = fish.x;
                    fishes[fid].y = fish.y;
                    map[fish.x][fish.y] = fid;
                }else{
                    map[fish.x][fish.y] = 0;
                }
                fishes[i].x = nx;
                fishes[i].y = ny;
                fishes[i].d = nd;
                map[nx][ny] = i;
                break;
            }
        }
        // shark move
        int t = 1;
        while (true) {
            int nx = x + dx[sd] * t;
            int ny = y + dy[sd] * t;
            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
                ans = Math.max(ans, score);
                return;
            }
            if (map[nx][ny] == 0) { // nothing to eat
                t++;
                continue;
            }

            int[][] map2 = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    map2[i][j] = map[i][j];
                }
            }

            Fish[] fishes2 = new Fish[17];
            for (int i = 1; i < 17; i++) {
                if (fishes[i] == null) {
                    fishes2[i] = null;
                    continue;
                }
                fishes2[i] = new Fish();
                fishes2[i].x = fishes[i].x;
                fishes2[i].y = fishes[i].y;
                fishes2[i].d = fishes[i].d;
            }

            map2[x][y] = 0;
            int eat = map2[nx][ny];
            map2[nx][ny] = -1;
            int nd = fishes2[eat].d;
            fishes2[eat] = null;
            go(map2, fishes2, nx, ny, nd, score + eat);

            t++;
        }
    }

    static class Fish {
        int x, y, d;

        Fish(){}
        Fish(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
