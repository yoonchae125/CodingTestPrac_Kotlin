package BaekJun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Num17779 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] a = new int[N][N];

        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = sc.nextInt();
                total += a[i][j];
            }
        }

        int min = -1;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; x + d1 < N; d1++) {
                    for (int d2 = 1; x + d1 + d2 < N; d2++) {
                        if (y - d1 < 0) continue;
                        if (y + d2 >= N) continue;
                        if(x==0 && y-d1==0 && y+d2==N-1 && x+d1+d2 == N-1) continue;
                        ArrayList<Integer> counts = new ArrayList<>();
                        int sum1 = 0;
                        int sum2 = 0;
                        int sum3 = 0;
                        int sum4 = 0;
                        int sum5 = total;
                        // 1
                        int ny = y;
                        for (int i = 0; i < x + d1; i++) {
                            if (i >= x) {
                                ny--;
                            }
                            for (int j = 0; j <= ny; j++) {
                                sum1 += a[i][j];
                            }
                        }
                        // 2
                        ny = y + 1;
                        for (int i = 0; i <= x + d2; i++) {
                            if (i > x) {
                                ny++;
                            }
                            for (int j = ny; j < N; j++) {
                                sum2 += a[i][j];
                            }
                        }
                        // 3
                        ny = y - d1;
                        for (int i = x + d1; i < N; i++) {
                            if (i > x + d1 && i <= x + d1 + d2) {
                                ny++;
                            }
                            for (int j = 0; j < ny; j++) {
                                sum3 += a[i][j];
                            }
                        }
                        // 4
                        ny = y + d2;
                        for (int i = x + d2 + 1; i < N; i++) {
                            if (i != x + d2 + 1 && i <= x + d1 + d2 + 1) {
                                ny--;
                            }
                            for (int j = ny; j < N; j++) {
                                sum4 += a[i][j];
                            }
                        }
                        sum5 -= sum1+sum2+sum3+sum4;
                        counts.add(sum1);
                        counts.add(sum2);
                        counts.add(sum3);
                        counts.add(sum4);
                        counts.add(sum5);
                        Collections.sort(counts);
                        int diff = counts.get(4) - counts.get(0);
                        if (min == -1) {
                            min = diff;
                        } else {
                            min = Math.min(min, diff);
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }
}
