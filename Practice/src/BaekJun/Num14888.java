package BaekJun;

import java.util.Scanner;

public class Num14888 {
    static int min = 1000000000;
    static int max = -1000000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        // + - * /
        int[] op = new int[4];
        for(int i=0;i<4;i++){
            op[i] = sc.nextInt();
        }
        go(op[0], op[1], op[2], op[3], arr, arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }
    static void go(int plus, int minus, int times, int div, int[] arr, int now, int idx){
        if(idx == arr.length){

            min = Math.min(min, now);
            max = Math.max(max, now);
            return;
        }
        if(plus>0){
            go(plus-1,minus,times,div,arr,now+arr[idx],idx+1);
        }
        if(minus>0){
            go(plus,minus-1,times,div,arr,now-arr[idx],idx+1);
        }
        if(times>0){
            go(plus,minus,times-1,div,arr,now*arr[idx],idx+1);
        }
        if(div>0){
            go(plus,minus,times,div-1,arr,now/arr[idx],idx+1);
        }
    }
}
