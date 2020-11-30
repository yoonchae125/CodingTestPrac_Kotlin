package BaekJun;

import java.util.Scanner;

public class Num1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int[] d = new int[x+1];

        if(x>=3){
            d[3] = 1;
        }
        if(x>=2){
            d[2] = 1;
        }
        if(x>=1){
            d[1] = 1;
        }

        for(int i = 4; i<=x; i++){
            d[i] = d[i-1];
            if(i%2==0){
                d[i] = Math.min(d[i], d[i/2]);
            }
            if(i%3==0){
                d[i] = Math.min(d[i], d[i/3]);
            }
            d[i]++;
        }

        System.out.println(d[x]);
    }
}
