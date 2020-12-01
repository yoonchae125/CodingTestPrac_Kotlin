package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] price = new int[n][3];
        int[][] d = new int[n][3];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] s = str.split(" ");
            for (int j = 0; j < 3; j++) {
                price[i][j] = Integer.parseInt(s[j]);
                if (i == 0) {
                    d[i][j] = price[i][j];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(j==k){
                        continue;
                    }
                    if(d[i][j]==0){
                        d[i][j] = d[i-1][k] + price[i][j];
                    }else {
                        d[i][j] = Math.min(d[i][j], d[i-1][k] + price[i][j]);
                    }
                }
            }
        }
        int min = d[n-1][0];
        for (int i = 1; i < 3; i++) {
            min = Math.min(min, d[n-1][i]);
        }
        System.out.println(min);
    }
}
