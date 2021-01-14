package BaekJun;

import java.util.Scanner;

public class Num19237 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        k = sc.nextInt();

        int[][] map = new int[N][N];
        Smell[][] smells = new Smell[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                smells[i][j] = null;
            }
        }

        Shark[] sharks = new Shark[M + 1];

        for (int i = 1; i <= M; i++) {
            sharks[i] = new Shark(sc.nextInt() - 1);
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < 4; j++) {
                int p1 = sc.nextInt() - 1;
                int p2 = sc.nextInt() - 1;
                int p3 = sc.nextInt() - 1;
                int p4 = sc.nextInt() - 1;
                sharks[i].set(j, p1, p2, p3, p4);
            }
        }

        int time = 0;
        while (time < 1000) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j]+" ");
                }System.out.println();
            }System.out.println();

            if (!isLeft(map)) break;
            int[][] map2 = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int sid = map[i][j];
                    if (sid == 0) continue;
                    Shark shark = sharks[sid];
                    int[] prior = shark.getPriority();

                    boolean canGo = false;
                    int p;
                    int nx = 0;
                    int ny = 0;
                    for (p = 0; p < 4; p++) { // 빈칸 확인
                        nx = i + dx[prior[p]];
                        ny = j + dy[prior[p]];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (map[nx][ny] != 0) continue;
                        if (smells[nx][ny] == null) {
                            canGo = true;
                            break;
                        }
                    }
                    if (canGo) {
                        // go
                        smells[i][j] = new Smell(sid);
                        shark.dir = prior[p];
                        if (map2[nx][ny] > 0) {
                            if (map2[nx][ny] > sid) {
                                map2[nx][ny] = sid;
                            }
                        }else{
                            map2[nx][ny] = sid;
                        }
                    } else {
                        for (p = 0; p < 4; p++) { // 자기 냄새 확인
                            nx = i + dx[prior[p]];
                            ny = j + dy[prior[p]];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if (map[nx][ny] != 0) continue;
                            if (smells[nx][ny] != null && smells[nx][ny].id == sid) {
                                canGo = true;
                                break;
                            }
                        }
                        if (canGo) {
                            // go
                            smells[i][j] = new Smell(sid);
                            shark.dir = prior[p];
                            if (map2[nx][ny] > 0) {
                                if (map2[nx][ny] > sid) {
                                    map2[nx][ny] = sid;
                                }
                            }else{
                                map2[nx][ny] = sid;
                            }
                        }
                    }
                }
            }
            map = map2;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (smells[i][j] == null) continue;
                    int left = smells[i][j].remove();
                    if (left == 0) {
                        smells[i][j] = null;
                    }
                }
            }

            time++;
        }
        if (isLeft(map)) {
            time = -1;
        }
        System.out.println(time);
    }

    static boolean isLeft(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Shark {
        int[][] priority = new int[4][4];
        int dir;

        Shark(int dir) {
            this.dir = dir;
        }

        void set(int i, int p1, int p2, int p3, int p4) {
            priority[i][0] = p1;
            priority[i][1] = p2;
            priority[i][2] = p3;
            priority[i][3] = p4;
        }

        int[] getPriority() {
            return priority[dir];
        }
    }

    static class Smell {
        int left = k;
        int id;

        Smell(int id) {
            this.id = id;
        }

        int remove() {
            left--;
            return left;
        }
    }
}
