package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1003 {
    public static void sol(int n) {
        int[] d = new int[n + 1];
        if (n == 0) {
            System.out.println("1 0");
            return;
        }
        if (n == 1) {
            System.out.println("0 1");
            return;
        }
        if (n >= 2) {
            d[1] = 1;
            for (int i = 2; i <= n; i++) {
                d[i] = d[i - 2] + d[i - 1];
            }
        }
        System.out.println(d[n - 1] + " " + d[n]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            sol(Integer.parseInt(br.readLine()));
        }
    }
}
