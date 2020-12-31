package BaekJun;

import java.util.Scanner;

public class Num17143 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int M = sc.nextInt();

        Shark[] sharks = new Shark[M + 1];
        int[][] map = new int[R][C];
        for (int i = 1; i <= M; i++) {
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;
            int s = sc.nextInt();
            int d = sc.nextInt() - 1;
            int z = sc.nextInt();
            if (d < 2) {
                s = s % (R * 2 - 2);
            } else {
                s = s % (C * 2 - 2);
            }
            sharks[i] = new Shark(s, d, z);
            map[r][c] = i;
        }
        int ans = 0;
        for (int t = 0; t < C; t++) {
            // 낚시
            for (int i = 0; i < R; i++) {
                if (map[i][t] > 0) {
                    ans += sharks[map[i][t]].z;
                    map[i][t] = 0;
                    break;
                }
            }
            int[][] newMap = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 0) continue;
                    Shark s = sharks[map[i][j]];
                    int x = i;
                    int y = j;
                    for(int k=0;k<s.s;k++){
                        int nx=x+dx[s.d];
                        int ny=y+dy[s.d];
                        if(nx<0||nx>=R||ny<0||ny>=C){
                            k--;
                            switch (s.d){
                                case 0: s.d = 1; break;
                                case 1: s.d = 0; break;
                                case 2: s.d = 3; break;
                                case 3: s.d = 2; break;
                            }
                            continue;
                        }
                        x = nx;
                        y = ny;
                    }
                    if(newMap[x][y] == 0) {
                        newMap[x][y] = map[i][j];
                    }else{
                        Shark s1 = sharks[newMap[x][y]];
                        Shark s2 = sharks[map[i][j]];
                        if(s1.z<s2.z){
                            newMap[x][y] = map[i][j];
                        }
                    }
                }
            }
            map = newMap;
        }
        System.out.println(ans);
    }

    static class Shark {
        int s, d, z;

        Shark(int s, int d, int z) {

            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
