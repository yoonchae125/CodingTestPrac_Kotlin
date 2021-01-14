package BaekJun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Num19238 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int fuel = sc.nextInt();
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int X = sc.nextInt()-1;
        int Y = sc.nextInt()-1;

        int[] dist = new int[M + 1];
        int[][] dst = new int[M + 1][];
        int[][] pmap = new int[N][N];
        for (int i = 1; i <= M; i++) {
            int sx = sc.nextInt()-1;
            int sy = sc.nextInt()-1;
            int ex = sc.nextInt()-1;
            int ey = sc.nextInt()-1;

            pmap[sx][sy] = i;
            dst[i] = new int[]{ex, ey};

            int check[][] = new int[N][N];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(sx);
            queue.add(sy);
            check[sx][sy] = 1;

            while (!queue.isEmpty()) {
                int x = queue.poll();
                int y = queue.poll();
                if (x == ex && y == ey) {
                    dist[i] = check[x][y] - 1;
                    break;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (map[nx][ny] == 1) continue;
                    if (check[nx][ny] > 0) continue;
                    queue.add(nx);
                    queue.add(ny);
                    check[nx][ny] = check[x][y] + 1;
                }
            }
            if(dist[i]==0){
                System.out.println(-1);
                return;
            }
        }

        while(M>0) {
            System.out.println(fuel);
            int p = 0;
            int check[][] = new int[N][N];

            Queue<Integer> queue = new LinkedList<>();

            boolean find = false;
            int time = 0;
            int xx =0; int yy = 0;

            if(pmap[X][Y]>0){
                find = true;
                p = pmap[X][Y];
                xx = X; yy = Y;
            }else{
                queue.add(X);
                queue.add(Y);
                check[X][Y] = 1;
            }


            while (!queue.isEmpty()) {
                int x = queue.poll();
                int y = queue.poll();
                if(time!=0 && check[x][y]>time) {
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (map[nx][ny] == 1) continue;
                    if (check[nx][ny] > 0) continue;
                    if(pmap[nx][ny]>0){
                        find = true;
                        time = check[x][y];
                        if(p == 0){
                            xx = nx; yy = ny;
                            p = pmap[nx][ny];
                        }else{
                            if(nx<xx){
                                xx = nx; yy = ny;
                                p = pmap[nx][ny];
                            }else if(nx==xx){
                                if(ny<yy){
                                    xx = nx; yy = ny;
                                    p = pmap[nx][ny];
                                }else { }
                            }else { }
                        }
                    }
                    queue.add(nx);
                    queue.add(ny);
                    check[nx][ny] = check[x][y] + 1;
                }

            }
            if(!find){
                System.out.println(-1);
                return;
            }
            if(p>0) {
                M--;
                pmap[xx][yy] = 0;
            }
            if(p==0) {
                fuel = -1;
                break;
            }
            if (time+dist[p] > fuel) {
                fuel = -1;
                break;
            }
            fuel-=time;
            fuel+=dist[p];

            X = dst[p][0];
            Y = dst[p][1];
        }
        System.out.println(fuel);
    }
}
