package BaekJun;

import java.util.ArrayList;
import java.util.Scanner;

public class Num17144 {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int T = sc.nextInt();

        int[] machine = new int[2];
        int idx = 0;
        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1) {
                    machine[idx++] = i;
                }
            }
        }
        while (T-- > 0) {
            // spread
            int[][] temp = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == -1 || map[i][j] == 0) continue;
                    int count = 0;
                    int val = map[i][j] / 5;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1)
                            continue;
                        temp[nx][ny] += val;
                        count++;
                    }
                    map[i][j] -= count * val;
                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j] += temp[i][j];
                }
            }
            // clean up
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i < C; i++) {
                list.add(map[machine[0]][i]);
            }
            for (int i = machine[0] - 1; i >= 0; i--) {
                list.add(map[i][C - 1]);
            }
            for (int i = C - 2; i >= 0; i--) {
                list.add(map[0][i]);
            }
            for (int i = 1; i < machine[0]; i++) {
                list.add(map[i][0]);
            }
            list.add(0, 0);
            int id = 0;
            for (int i = 1; i < C; i++) {
                map[machine[0]][i] = list.get(id++);
            }
            for (int i = machine[0] - 1; i >= 0; i--) {
                map[i][C - 1] = list.get(id++);
            }
            for (int i = C - 2; i >= 0; i--) {
                map[0][i] = list.get(id++);
            }
            for (int i = 1; i < machine[0]; i++) {
                map[i][0] = list.get(id++);
            }

            ArrayList<Integer> list2 = new ArrayList<>();
            for (int i = 1; i < C; i++) {
                list2.add(map[machine[1]][i]);
            }
            for (int i = machine[1] + 1; i < R; i++) {
                list2.add(map[i][C - 1]);
            }
            for (int i = C - 2; i >= 0; i--) {
                list2.add(map[R - 1][i]);
            }
            for (int i = R - 2; i > machine[1]; i--) {
                list2.add(map[i][0]);
            }
            list2.add(0, 0);
            id = 0;
            for (int i = 1; i < C; i++) {
                map[machine[1]][i] = list2.get(id++);
            }
            for (int i = machine[1] + 1; i < R; i++) {
                map[i][C - 1] = list2.get(id++);
            }
            for (int i = C - 2; i >= 0; i--) {
                map[R - 1][i] = list2.get(id++);
            }
            for (int i = R - 2; i > machine[1]; i--) {
                map[i][0] = list2.get(id++);
            }
        }
        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) continue;
                ans += map[i][j];
            }
        }
        System.out.println(ans);
    }
}
