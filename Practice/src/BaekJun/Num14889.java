package BaekJun;

import java.util.ArrayList;
import java.util.Scanner;

public class Num14889 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] S = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }
        go(N,S,new ArrayList<>(),new ArrayList<>(),0);

        System.out.println(min);
    }
    static int min = Integer.MAX_VALUE;
    static void go(int N, int[][] S, ArrayList<Integer> select,ArrayList<Integer> unSelect, int idx){
        if(idx == N){
            if(select.size() == N/2&&unSelect.size()==N/2){
//                for(int i=0;i<N/2;i++){
//                    System.out.print(select.get(i)+" ");
//                }System.out.println();
                int sum1 = 0;
                for(int i=0;i<N/2;i++){
                    int a = select.get(i);
                    for(int j=i+1;j<N/2;j++){
                        int b = select.get(j);
                        sum1+=S[a][b]+S[b][a];
                    }
                }
                int sum2 = 0;
                for(int i=0;i<N/2;i++){
                    int a = unSelect.get(i);
                    for(int j=i+1;j<N/2;j++){
                        int b = unSelect.get(j);
                        sum2+=S[a][b]+S[b][a];
                    }
                }
                min = Math.min(min, Math.abs(sum1-sum2));
            }
            return;
        }

        select.add(idx);
        go(N,S,select,unSelect,idx+1);
        select.remove(select.size()-1);
        unSelect.add(idx);
        go(N,S,select,unSelect,idx+1);
        unSelect.remove(unSelect.size()-1);

    }
}
