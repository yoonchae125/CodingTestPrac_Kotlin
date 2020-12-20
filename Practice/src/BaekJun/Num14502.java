package BaekJun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Num14502 {
    static int N, M;
    static int[][] arr;
    static int answer = 0;
    static ArrayList<Integer> virus = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 2) {
                    virus.add(i);
                    virus.add(j);
                }
            }
        }

        wall(0);

        System.out.println(answer);
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static int count() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < virus.size(); i++) {
            queue.add(virus.get(i));
        }
        int[][] map = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j = 0;j<M;j++){
                map[i][j] = arr[i][j];
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if (map[nx][ny] == 0) {
                    queue.add(nx);
                    queue.add(ny);
                    map[nx][ny] = 2;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    count++;
            }
        }

//        System.out.println(count);
        return count;
    }

    public static void wall(int cnt) {
        if (cnt == 3) {
            answer = Math.max(answer, count());
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    wall(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }
}
