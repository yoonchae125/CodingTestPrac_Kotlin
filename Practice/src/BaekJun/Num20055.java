package BaekJun;

import java.util.ArrayList;
import java.util.Scanner;

public class Num20055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<Integer> belt = new ArrayList<>();
        ArrayList<Boolean> robot = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < 2 * N; i++) {
            if(i<N){
                robot.add(false);
            }
            int p = sc.nextInt();
            belt.add(p);
            if(p==0) k++;
        }
        int level = 0;
        while (k<K){
            level++;
            // rotate
            // (1) move belt
            belt.add(0, belt.remove(2*N-1));
            // (2) move robot
            robot.remove(N-1);
            robot.add(0, false);

            // robot move
            for(int i=N-1;i>=0;i--){
                if(!robot.get(i)) continue;
                if(i+1 == N){
                    robot.set(i, false);
                    continue;
                }
                if(robot.get(i+1)) continue;
                if(belt.get(i+1) == 0) continue;
                robot.set(i, false);
                robot.set(i+1, true);
                int p = belt.get(i+1)-1;
                if(p==0) k++;
                belt.set(i+1, p);
            }

            // add robot
            if(!robot.get(0) && belt.get(0)>0){
                robot.set(0,true);
                int p = belt.get(0)-1;
                if(p==0) k++;
                belt.set(0, p);
            }
        }
        System.out.println(level);
    }
}
