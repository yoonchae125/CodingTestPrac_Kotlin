package BaekJun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Num20058 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        int len = (int) Math.pow(2, N);
        int[][] arr = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int q = 0; q < Q; q++) {
            int L = sc.nextInt();
//            if(L==0) continue;
            if (L != 0) {
                int block = (int) Math.pow(2, L);
                int[][] newArr = new int[len][len];
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        newArr[i][j] = arr[i][j];
                    }
                }
                for (int si = 0; si < len; si += block) {
                    for (int sj = 0; sj < len; sj += block) {

                        int nsj = sj;
                        for (int i = si; i < si + block; i++) {
                            int nsi = si + block - 1;
                            for (int j = sj; j < sj + block; j++) {
                                newArr[i][j] = arr[nsi][nsj];
                                nsi--;
                            }
                            nsj++;
                        }
                    }
                }
                arr = newArr;
            }
            ArrayList<int[]> remove = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (arr[i][j] == 0) continue;
                    int count = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || nx >= len || ny < 0 || ny >= len) {
                            continue;
                        }
                        if (arr[nx][ny] == 0) continue;
                        count++;
                    }
                    if (count < 3) {
                        remove.add(new int[]{i, j});
                    }
                }
            }
            for (int[] p : remove) {
                arr[p[0]][p[1]] = arr[p[0]][p[1]] - 1;
            }
        }
        int max = 0;
        int sum = 0;

        boolean[][] checked = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sum += arr[i][j];
                if (checked[i][j]) continue;
                if (arr[i][j] == 0) continue;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                queue.add(j);
                checked[i][j] = true;
                int size = 0;
//                System.out.println(i + ", " + j);
                while (!queue.isEmpty()) {
                    size++;
                    int x = queue.poll();
                    int y = queue.poll();

                    for (int d = 0; d < 4; d++) {

                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx < 0 || nx >= len || ny < 0 || ny >= len) {
                            continue;
                        }
//                        System.out.println("queue " + x + "," + y);
                        if (checked[nx][ny]) {
//                            System.out.println("checked " + nx + "," + ny);
                            continue;
                        }
                        if (arr[nx][ny] == 0) {
//                            System.out.println("zero " + nx + "," + ny);
                            continue;
                        }

                        checked[nx][ny] = true;
                        queue.add(nx);
                        queue.add(ny);
//                        System.out.println("add " + nx + "," + ny);
                    }
                }
//                System.out.println(size);
                max = Math.max(max, size);
            }
        }

        System.out.println(sum);
        System.out.println(max);
    }
}
