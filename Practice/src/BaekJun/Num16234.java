package BaekJun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Num16234 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        boolean move = true;
        while (move) {
            boolean[][] check = new boolean[N][N];
            move = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j]) continue;
                    Queue<Pair> queue = new LinkedList<>();
                    Pair p = new Pair(i, j);
                    queue.add(p);
                    check[i][j] = true;
                    ArrayList<Pair> city = new ArrayList<>();
                    city.add(p);
                    int sum = map[i][j];
                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = pair.r + dx[d];
                            int ny = pair.c + dy[d];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N || check[nx][ny])
                                continue;
                            int diff = Math.abs(map[pair.r][pair.c] - map[nx][ny]);
                            if (diff >= L && diff <= R) {
                                Pair np = new Pair(nx, ny);
                                queue.add(np);
                                city.add(np);
                                sum += map[nx][ny];
                                check[nx][ny] = true;
                            }
                        }
                    }
                    if (city.size() > 1) {
                        int v = sum / city.size();
                        for (Pair pair : city) {
                            map[pair.r][pair.c] = v;
                        }
                        move = true;
                    }
                }
            }
            if (move) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
