package BaekJun;

import java.util.Scanner;

public class Num15684 {
    static int N, M, H;

    static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();

        int[][] ladder = new int[H][N];
        boolean[][] checked = new boolean[H][N];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            ladder[a][b] = 1;
            checked[a][b] = true;
        }
        go(0, checked, ladder);
        System.out.println(answer);
    }

    static void go(int add, boolean[][] checked, int[][] arr) {
        if (isSame(arr)) {
            if (answer == -1) {
                answer = add;
            } else {
                answer = Math.min(answer, add);
            }
            return;
        }
        if (add == 3) {
            return;
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (checked[i][j] || arr[i][j]==1) {
                    continue;
                }
                checked[i][j] = true;
                arr[i][j] = 1;
                go(add + 1, checked, arr);
                checked[i][j] = false;
                arr[i][j] = 0;
            }
        }
    }

    static boolean isSame(int[][] arr) {
        for (int i = 0; i < N; i++) {
            int b = i;
            for (int j = 0; j < H; j++) {
                if (arr[j][b] == 1) { // go right
                    b++;
                } else {
                    if (b - 1 >= 0 && arr[j][b - 1] == 1) { // go left
                        b--;
                    } else { // go down
                        continue;
                    }
                }
            }
            if (b != i) {
                return false;
            }
        }
        return true;
    }
}
