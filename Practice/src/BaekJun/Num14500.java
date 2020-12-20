package BaekJun;

import java.util.Scanner;

public class Num14500 {
    // 19 4 2
    static int[][][] block = {
            {{0, 1}, {0, 2}, {0, 3}},
            {{1, 0}, {2, 0}, {3, 0}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{0, 1}, {1, 0}, {2, 0}},
            {{0, 1}, {0, 2}, {1, 2}},
            {{1, 0}, {2, 0}, {2, -1}},
            {{0, 1}, {0, 2}, {-1, 2}},
            {{1, 0}, {2, 0}, {2, 1}},
            {{0, 1}, {0, 2}, {1, 0}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 1}, {1, 0}, {1, 1}},
            {{0, 1}, {-1, 1}, {-1, 2}},
            {{1, 0}, {1, 1}, {2, 1}},
            {{0, 1}, {1, 1}, {1, 2}},
            {{1, 0}, {1, -1}, {2, -1}},
            {{0, 1}, {0, 2}, {-1, 1}},
            {{0, 1}, {0, 2}, {1, 1}},
            {{1, 0}, {2, 0}, {1, 1}},
            {{1, 0}, {2, 0}, {1, -1}},
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 19; k++) {
                    int sum = 0;
                    boolean flag = true;
                    for (int l = 0; l < 3; l++) {
                        int x = i + block[k][l][0];
                        int y = j + block[k][l][1];
                        if (x < 0 || x >= N || y < 0 || y >= M) {
                            flag = false;
                            break;
                        }
                        sum += arr[x][y];
                    }
                    if (flag) {
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
