package BaekJun;

import java.util.Scanner;

public class Num14501_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N+1];
        int[] P = new int[N+1];

        for(int i=1;i<=N;i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        int[] d = new int[N+2];

        for(int i=1;i<=N+1;i++){
            for(int j =1;j<i;j++){
                if(j+T[j]<=i){
                    d[i] = Math.max(d[i],d[j]+P[j]);
                }
            }
        }
        System.out.println(d[N+1]);
    }
}
