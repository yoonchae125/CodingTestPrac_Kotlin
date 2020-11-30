package BaekJun;

import java.util.Scanner;

public class Num2839 {
    public static int solution(int n) {
        int[] d = new int[n + 1];
        if (n >= 3)
            d[3] = 1;
        if (n >= 5)
            d[5] = 1;
        for (int i = 6; i <= n; i++) {
            if (d[i - 3] == 0 && d[i - 5] == 0) {
                d[i] = 0;
            } else if (d[i - 3] == 0) {
                d[i] = d[i - 5] + 1;
            } else if (d[i - 5] == 0) {
                d[i] = d[i - 3] + 1;
            } else {
                d[i] = Math.min(d[i - 3], d[i - 5]) + 1;
            }
        }
        if (d[n] == 0)
            return -1;
        return d[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(solution(input));
    }
}
