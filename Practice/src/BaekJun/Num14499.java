package BaekJun;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Num14499 {
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    static ArrayList<Integer> col = new ArrayList<>();
    static ArrayList<Integer> row = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        col.add(0);
        col.add(0);
        col.add(0);
        col.add(0);

        row.add(0);
        row.add(0);
        row.add(0);

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);
        int y = Integer.parseInt(s[3]);
        int K = Integer.parseInt(s[4]);

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] ss = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(ss[j]);
            }
        }

        String[] ks = br.readLine().split(" ");

        for (int i = 0; i < K; i++) {
            int k = Integer.parseInt(ks[i]);

            int nx = x + dx[k];
            int ny = y + dy[k];
//            System.out.println(nx + ", " + ny);
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            rollDice(k);

            bw.write(col.get(1) + "");
            bw.newLine();

            if (map[nx][ny] == 0) {
                map[nx][ny] = col.get(3);
            } else {
                col.remove(3);
                col.add(3, map[nx][ny]);
                map[nx][ny] = 0;
            }

            x = nx;
            y = ny;
        }
        bw.flush();
        bw.close();
    }

    static void rollDice(int d) {
        int t;
        switch (d) {
            case 1:
                t = row.remove(0);
                row.add(col.remove(3));
                col.add(t);
                col.remove(1);
                col.add(1,row.get(1));
                break;
            case 2:
                t = row.remove(2);
                row.add(0,col.remove(3));
                col.add(t);
                col.remove(1);
                col.add(1,row.get(1));
                break;
            case 3:
                col.add(0, col.remove(3));
                row.remove(1);
                row.add(1,col.get(1));
                break;
            case 4:
                col.add(col.remove(0));
                row.remove(1);
                row.add(1,col.get(1));
        }
    }
}
