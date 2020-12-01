package BaekJun;

import java.util.Scanner;

public class Num9095 {
    public static int sol(int target, int now) {
        if (now == target) {
            return 1;
        }
        if (now > target) {
            return 0;
        }
        return sol(target, now + 1) + sol(target, now + 2) + sol(target, now + 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            System.out.println(sol(a, 0));
        }
    }
}
