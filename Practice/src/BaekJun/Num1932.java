package BaekJun;

import java.util.Scanner;

public class Num1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][];
        int[][] d = new int[n][];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[i + 1];
            d[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
                if (i == 0) {
                    d[i][j] = arr[i][j];
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j < i) {
                    d[i][j] = d[i - 1][j] + arr[i][j];
                }
                if (j - 1 >= 0)
                    d[i][j] = Math.max(d[i][j], d[i - 1][j - 1] + arr[i][j]);

            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, d[n - 1][i]);
        }
        System.out.println(max);
    }
}
