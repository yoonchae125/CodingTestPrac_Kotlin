package BaekJun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Num17837 {
    final static int MAX = 1000;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] A = new int[N][N];
        ArrayList<Integer>[][] map = new ArrayList[N][N];
        Horse[] horse = new Horse[K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < K; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int d = sc.nextInt() - 1;
            horse[i] = new Horse(x, y, d);
            map[x][y] = new ArrayList<>();
            map[x][y].add(i);
        }

        boolean flag = true;
        int times = 0;
        while (flag) {
            if (times > MAX) {
                System.out.println(-1);
                return;
            }
            times++;
            flag = false;
            for (int i = 0; i < K; i++) {
                int nx = horse[i].x + dx[horse[i].d];
                int ny = horse[i].y + dy[horse[i].d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || A[nx][ny] == 2) {
                    horse[i].changeDir();
                    nx = horse[i].x + dx[horse[i].d];
                    ny = horse[i].y + dy[horse[i].d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || A[nx][ny] == 2) {
                        continue;
                    }
                }
                flag = true;
                if (map[nx][ny] == null) {
                    map[nx][ny] = new ArrayList<>();
                }
                Iterator<Integer> it = map[horse[i].x][horse[i].y].iterator();
                boolean ch   = false;
                int last = map[nx][ny].size();
                while (it.hasNext()) {
                    int idx = it.next();
                    if (!ch) {
                        if (idx == i) {
                            ch = true;
                        }
                    }
                    if (ch) {
                        it.remove();
                        if (A[nx][ny] == 1) {
                            map[nx][ny].add(last,idx);
                        }else {
                            map[nx][ny].add(idx);
                        }
                        horse[idx].x = nx;
                        horse[idx].y = ny;
                    }
                }
                if (map[nx][ny].size() >= 4) {
                    System.out.println(times);
                    return;
                }
            }
        }
        if (!flag) {
            System.out.println(-1);
        } else {
            System.out.println(times);
        }
    }

    static class Horse {
        int x, y, d;

        Horse(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        void changeDir() {
            switch (d) {
                case 0:
                    d = 1;
                    break;
                case 1:
                    d = 0;
                    break;
                case 2:
                    d = 3;
                    break;
                case 3:
                    d = 2;
                    break;
            }
        }
    }
}
