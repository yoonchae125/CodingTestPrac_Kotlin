package BaekJun;

import java.util.ArrayList;
import java.util.Scanner;

public class Num15685 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[101][101];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();

            ArrayList<Integer> dragon = new ArrayList<>();
            dragon.add(d);
            arr[x][y] = 1;
            int lastX = x + dx[d];
            int lastY = y + dy[d];
            arr[lastX][lastY] = 1;

            go(arr, g, 0, lastX, lastY, dragon);
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] == 0) {
                    continue;
                } else {
                    if (arr[i][j + 1] == 1 && arr[i + 1][j] == 1 && arr[i + 1][j + 1] == 1) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static void go(int[][] arr, int g, int now, int lastX, int lastY, ArrayList<Integer> dragon) {
        if (now == g) {
            return;
        }
        int a = lastX;
        int b = lastY;
        int size = dragon.size();
        for (int i = size - 1; i >= 0; i--) {
            int nd = (dragon.get(i) + 1) % 4;
            a = a + dx[nd];
            b = b + dy[nd];
            arr[a][b] = 1;
            dragon.add(nd);
        }
        go(arr, g, now + 1, a, b, dragon);
    }
}
