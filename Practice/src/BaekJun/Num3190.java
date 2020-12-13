package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Num3190 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

//        int N = Integer.parseInt(br.readLine());
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
//        int K = Integer.parseInt(br.readLine());
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
//            String[] s = br.readLine().split(" ");
//            int a = Integer.parseInt(s[0]) - 1;
            int a = sc.nextInt() - 1;
//            int b = Integer.parseInt(s[1]) - 1;
            int b = sc.nextInt() - 1;
            arr[a][b] = 2;
        }
//        int L = Integer.parseInt(br.readLine());
        int L = sc.nextInt();
        int d = 0;
        int x = 0, y = 0;
        int T = 0;

        ArrayList<Point> snake = new ArrayList<>();
        snake.add(new Point(0, 0));
        arr[0][0] = 1;
        for (int i = 0; i < L; i++) {
//            System.out.println(x + "," + y);
//            String[] s = br.readLine().split(" ");
//            int t = Integer.parseInt(s[0]) - T;
            int t = sc.nextInt() - T;
            String D = sc.next();
//            System.out.println(T);
            int nx = x + dx[d] * t;
            int ny = y + dy[d] * t;
//            System.out.println(nx+","+ny);

            if (nx < 0) {
//                System.out.println(T - x);
//                return;
                break;
            } else if (nx >= N) {
//                System.out.println(T + N - x);
//                return;
                break;
            } else if (ny < 0) {
//                System.out.println(T - y);
//                return;
                break;
            } else if (ny >= N) {
//                System.out.println(T + N - y);
//                return;
                break;
            }

            for (int k = 1; k <= t; k++) {
//                T+=k;
                x = x + dx[d];
                y = y + dy[d];

                snake.add(new Point(x, y));

                if (arr[x][y] == 1) { //  tail
//                    System.out.println("istail:" + x + ", " + y);
                    System.out.println(T + k);
                    return;
                }
                if (arr[x][y] == 2) { //  apple
                } else {
                    Point p = snake.remove(0);
                    arr[p.x][p.y] = 0;
                }
                arr[x][y] = 1;
//                System.out.println(T);
//                printArr(arr);
            }

            T += t;
            x = nx;
            y = ny;
            if (D.equals("L")) {
                d = (d + 3) % 4;

            } else if (D.equals("D")) {
                d = (d + 1) % 4;
            }
        }

//        System.out.println("d: " + d);
//        switch (d) {
//            case 0:
//                System.out.println(T + N - y);
//                break;
//            case 1:
//                System.out.println(T + N - x);
//                break;
//            case 2:
//                System.out.println(T + y + 1);
//                break;
//            case 3:
//                System.out.println(T + x + 1);
//                break;
//        }
        for (int i = 0; ; i++) {
            x = x + dx[d];
            y = y + dy[d];

            if (x < 0) {
                System.out.println(T + i + 1);
                return;
            } else if (x >= N) {
                System.out.println(T + i + 1);
                return;
            } else if (y < 0) {
                System.out.println(T + i + 1);
                return;
            } else if (y >= N) {
                System.out.println(T + i + 1);
                return;
            }

            snake.add(new Point(x, y));

            if (arr[x][y] == 1) { //  tail
//                System.out.println("tail");
                System.out.println(T + i + 1);
                return;
            }
            if (arr[x][y] == 2) { //  apple
            } else {
                Point p = snake.remove(0);
                arr[p.x][p.y] = 0;
            }
            arr[x][y] = 1;
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
