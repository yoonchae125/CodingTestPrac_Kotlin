package BaekJun;

import java.util.Scanner;

public class Num14890 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int ans = 0;


        for (int i = 0; i < N; i++) {
            int len = 0;
            int prev = -1;
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                // 가로 map[i][j]
                int now = map[i][j];
                if (prev == -1 || Math.abs(prev - now) == 0) {
                    len++;
                } else if (Math.abs(prev - now) > 1) {
                    flag = false;
                    break;
                } else if(now-prev == 1){
//                    System.out.println("bigger"+i+", "+j);
//                    System.out.println("len: "+len);
                    if(len<L){
                        flag = false;
                        break;
                    }
                    len = 1;
                } else if(prev-now==1){
                    // 뒤에 now랑 같은 높이 같이 L개 있는지
//                    System.out.println("smaller"+i+", "+j);
                    for(int k=j+1;k<j+L;k++){
                        if(k>=N || map[i][k]!=now){
                            flag = false;
                            break;
                        }
                    }
                    len = L*-1+1;
//                    System.out.println("len: "+len);
                }
//                System.out.println(len);
                prev = now;
            }
            if (flag) {
                ans++;
            }else{
//                System.out.println("no "+i);
            }
        }

        for (int i = 0; i < N; i++) {
            int len = 0;
            int prev = -1;
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                // 세로 map[j][i]
                int now = map[j][i];
                if (prev == -1 || Math.abs(prev - now) == 0) {
                    len++;
                } else if (Math.abs(prev - now) > 1) {
                    flag = false;
                    break;
                } else if(now-prev == 1){
                    if(len<L){
                        flag = false;
                        break;
                    }
                    len = 1;
                } else if(prev-now==1){
                    // 뒤에 now랑 같은 높이 같이 L개 있는지
                    for(int k=j+1;k<j+L;k++){
                        if(k>=N || map[k][i]!=now){
                            flag = false;
                            break;
                        }
                    }
                    len = L*-1+1;
                }
                prev = now;

            }
            if (flag) {
                ans++;
            }else{
//                System.out.println("no "+i);
            }
        }
        System.out.println(ans);
    }
}