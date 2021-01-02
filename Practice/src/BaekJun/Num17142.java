package BaekJun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Num17142 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static ArrayList<Pair> virus = new ArrayList<>();
    static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        a = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 2) {
                    virus.add(new Pair(i, j));
                }
            }
        }
        select(virus.size(), new int[M], 0, 0);
        System.out.println(answer);
    }

    static int answer = -1;

    static void select(int size, int[] activeVirus, int idx,int cnt) {
        if (cnt == M) {
            int n = spread(activeVirus);
            if(n == -1){

            }else if (answer == -1) {
                answer = n;
            } else {
                answer = Math.min(answer, n);
            }
            return;
        }if (size == idx ) {
            return;
        }

        activeVirus[cnt] = idx;
        select(size, activeVirus, idx + 1,cnt+1);
        select(size, activeVirus, idx + 1, cnt);
    }

    static int spread(int[] activeVirus) {
        Queue<Pair> queue = new LinkedList<>();
        int[][] check = new int[N][N];
        for (int i = 0; i < M; i++) {
            int idx = activeVirus[i];
            Pair p = virus.get(idx);
            queue.add(p);
            check[p.x][p.y] = 1;
        }

        if(isSpread(check) ==0){
            return 0;
        }
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            for(int d=0;d<4;d++){
                int nx = p.x+dx[d];
                int ny = p.y+dy[d];
                if(nx<0||nx>=N||ny<0||ny>=N)
                    continue;
                if(check[nx][ny]==0 && a[nx][ny]!=1){
                    check[nx][ny] = check[p.x][p.y]+1;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
        int isSpread = isSpread(check);
        if(isSpread>0){
            return isSpread-1;
        }
        return isSpread;
    }
    static int isSpread(int[][] check){
        int time = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(check[i][j] == 0 && a[i][j] == 0){
                    return -1;
                }
                if(a[i][j] == 0){ // *******************지대중요***********************
                    time = Math.max(time, check[i][j]);

                }
            }
        }
        return time;
    }
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
