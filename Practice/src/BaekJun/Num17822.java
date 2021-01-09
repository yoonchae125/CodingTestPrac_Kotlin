package BaekJun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Num17822 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();

        ArrayList<Integer>[] A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                A[i].add(sc.nextInt());
            }
        }

        for (int t = 0; t < T; t++) {
            int x = sc.nextInt();
            int d = sc.nextInt();
            int k = sc.nextInt();
            for (int i = x; i <= N; i += x) {
                if (d == 1) { // 반시계
                    for (int kk = 0; kk < k; kk++) {
                        A[i].add(A[i].remove(0));
                    }
                } else { // 시계
                    for (int kk = 0; kk < k; kk++) {
                        A[i].add(0, A[i].remove(M - 1));
                    }
                }
            }
            boolean[][] remove = new boolean[N + 1][M];
            boolean flag = false;

            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < M; j++) {
                    if (A[i].get(j) == -1) continue;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = (j + dy[dir] + M)%M;
                        if (nx < 1 || nx > N) {
                            continue;
                        }
                        if (A[i].get(j).equals(A[nx].get(ny))) {
                            flag = true;
                            remove[i][j] = true;
                            remove[nx][ny] = true;
                        }
                    }

                }
            }


            int sum = 0;
            int count = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < M; j++) {
                    if (remove[i][j]) {
                        A[i].remove(j);
                        A[i].add(j, -1);
                    } else {
                        int a = A[i].get(j);
                        if (a != -1) {
                            sum += a;
                            count++;
                        }
                    }
                }
            }

            float ave = (float) sum / count;
            if (!flag) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (A[i].get(j) == -1) continue;
                        if (A[i].get(j) < ave) {
                            int a = A[i].remove(j);
                            A[i].add(j, a + 1);
                        } else if (A[i].get(j) > ave) {
                            int a = A[i].remove(j);
                            A[i].add(j, a - 1);
                        }
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                int a = A[i].get(j);
                if (a == -1) continue;
                sum += a;
            }
        }

        System.out.println(sum);
    }
}
