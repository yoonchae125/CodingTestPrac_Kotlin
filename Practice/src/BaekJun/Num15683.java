package BaekJun;

import java.util.*;

public class Num15683 {
    static int answer = -1;
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int[][] arr = new int[N][M];

        ArrayList<Pair> cctv = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] >= 1 && arr[i][j] <= 5) {
                    cctv.add(new Pair(i, j));
                }
            }
        }
        go(cctv, 0, arr);

        System.out.println(answer);
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static void go(ArrayList<Pair> cctv, int idx, int[][] arr) {
//        System.out.println("idx: "+idx+" size: "+cctv.size());
        if (idx == cctv.size()) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 0) {
                        count++;
                    }
                }
            }
//            System.out.println(count);
            if (answer == -1) {
                answer = count;
            } else {
                answer = Math.min(answer, count);
            }
            return;
        }
        Pair p = cctv.get(idx);
        switch (arr[p.x][p.y]) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    int[][] arr1 = cloneArr(arr);
                    search(arr1, i, p);
                    go(cctv, idx + 1, arr1);
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    int[][] arr1 = cloneArr(arr);
                    search(arr1, i, p);
                    search(arr1, i + 2, p);
                    go(cctv, idx + 1, arr1);
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    int[][] arr1 = cloneArr(arr);
                    search(arr1, i, p);
                    search(arr1, (i + 1) % 4, p);
                    go(cctv, idx + 1, arr1);
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    int[][] arr1 = cloneArr(arr);
                    search(arr1, i, p);
                    search(arr1, (i + 1) % 4, p);
                    search(arr1, (i + 3) % 4, p);
                    go(cctv, idx + 1, arr1);
                }
                break;
            case 5:
                int[][] arr1 = cloneArr(arr);

                for (int i = 0; i < 4; i++) {
                    search(arr1, i, p);
                }
                go(cctv, idx + 1, arr1);
                break;
        }
    }

    static void search(int[][] arr, int d, Pair p) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(p);
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int nx = pair.x + dx[d];
            int ny = pair.y + dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                break;
            }
            if (arr[nx][ny] == 6) {
                break;
            } else {
                if(arr[nx][ny] == 0)
                    arr[nx][ny] = -1;
                queue.add(new Pair(nx, ny));
            }
        }
    }

    static int[][] cloneArr(int[][] arr) {
        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = arr[i][j];
            }
        }
        return array;
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
