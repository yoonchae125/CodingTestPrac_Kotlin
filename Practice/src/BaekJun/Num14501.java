package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num14501 {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.parseInt(br.readLine());
        int[] T = new int[days];
        int[] P = new int[days];
        for(int i=0; i<days; i++){
            String[] s = br.readLine().split(" ");
            T[i] = Integer.parseInt(s[0]);
            P[i] = Integer.parseInt(s[1]);
        }
        go(days, T, P, 0, 0);
        System.out.println(answer);
    }
    public static void go(int days, int[] T, int[] P, int now, int day){
        if(day==days){
            answer = Math.max(answer, now);
            return;
        }
        if(day>days){
            return;
        }
        go(days, T, P, now+P[day], day+T[day]);
        go(days, T, P, now, day+1);
    }
}
