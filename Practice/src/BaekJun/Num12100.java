package BaekJun;

import java.util.Scanner;

public class Num12100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
//        right(N, arr);
        go(N, arr, 0);
        System.out.println(ans);
    }
    static int ans = 0;
    static void go(int n, int[][] arr, int times){
        if(times>=5){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    ans = Math.max(ans, arr[i][j]);
                }
            }
            return;
        }
        int[][] arr1 = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr1[i][j] = arr[i][j];
            }
        }
        up(n, arr1);
        go(n, arr1, times+1);

        int[][] arr2 = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr2[i][j] = arr[i][j];
            }
        }
        down(n, arr2);
        go(n, arr2, times+1);

        int[][] arr3 = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr3[i][j] = arr[i][j];
            }
        }
        right(n, arr3);
        go(n, arr3, times+1);

        int[][] arr4 = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr4[i][j] = arr[i][j];
            }
        }
        left(n, arr4);
        go(n, arr4, times+1);
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void up(int n, int[][] arr) {
        int d = 0;
        boolean[][] check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = arr[i][j];
                int x = i;
                int y = j;
                while (true) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        arr[i][j] = 0;
                        arr[x][y] = v;
                        break;
                    }
                    if (arr[nx][ny] == 0) {
                        x = nx;
                        y = ny;
                    }else if(!check[nx][ny] && arr[nx][ny] == v){
                        arr[i][j] = 0;
                        arr[nx][ny] = v*2;
                        check[nx][ny] = true;
                        break;
                    }else{
                        arr[i][j] = 0;
                        arr[x][y] = v;
                        break;
                    }
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
    static void down(int n, int[][] arr) {
        int d = 1;
        boolean[][] check = new boolean[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int v = arr[i][j];
                int x = i;
                int y = j;
                while (true) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        arr[i][j] = 0;
                        arr[x][y] = v;
                        break;
                    }
                    if (arr[nx][ny] == 0) {
                        x = nx;
                        y = ny;
                    }else if(!check[nx][ny] && arr[nx][ny] == v){
                        arr[i][j] = 0;
                        arr[nx][ny] = v*2;
                        check[nx][ny] = true;
                        break;
                    }else{
                        arr[i][j] = 0;
                        arr[x][y] = v;
                        break;
                    }
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
    static void right(int n, int[][] arr) {
        int d = 2;
        boolean[][] check = new boolean[n][n];
        for (int j = n-1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                int v = arr[i][j];
                int x = i;
                int y = j;
                while (true) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        arr[i][j] = 0;
                        arr[x][y] = v;
                        break;
                    }
                    if (arr[nx][ny] == 0) {
                        x = nx;
                        y = ny;
                    }else if(!check[nx][ny] && arr[nx][ny] == v){
                        arr[i][j] = 0;
                        arr[nx][ny] = v*2;
                        check[nx][ny] = true;
                        break;
                    }else{
                        arr[i][j] = 0;
                        arr[x][y] = v;
                        break;
                    }
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
    static void left(int n, int[][] arr) {
        int d = 3;
        boolean[][] check = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                int v = arr[i][j];
                int x = i;
                int y = j;
                while (true) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        arr[i][j] = 0;
                        arr[x][y] = v;
                        break;
                    }
                    if (arr[nx][ny] == 0) {
                        x = nx;
                        y = ny;
                    }else if(!check[nx][ny] && arr[nx][ny] == v){
                        arr[i][j] = 0;
                        arr[nx][ny] = v*2;
                        check[nx][ny] = true;
                        break;
                    }else{
                        arr[i][j] = 0;
                        arr[x][y] = v;
                        break;
                    }
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
}
