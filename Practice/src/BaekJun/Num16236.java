package BaekJun;

import java.util.*;

public class Num16236 {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[N][N];
        int X = 0, Y = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 9) {
                    arr[i][j] = 0;
                    X = i;
                    Y = j;
                }
            }
        }
        int age = 2;
        int eat = 0;
        int t = 0;
        while (true) {
            int[][] check = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(check[i], -1);
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(X);
            queue.add(Y);
            check[X][Y] = 0;

            boolean isEat = false;
            ArrayList<int[]> canEat = new ArrayList();

            while (!queue.isEmpty()) {
                int x = queue.poll();
                int y = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || check[nx][ny] > -1 || arr[nx][ny] > age) continue;
                    if (arr[nx][ny] == age || arr[nx][ny] == 0) {
                        // 지나가기
                    } else {
                        // 먹기
                        canEat.add(new int[]{nx, ny});
                        isEat = true;
                    }
                    check[nx][ny] = check[x][y] + 1;
                    queue.add(nx);
                    queue.add(ny);
                }

            }
            if (isEat) {
                Collections.sort(canEat, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if(check[o1[0]][o1[1]] == check[o2[0]][o2[1]]){
                            if(o1[0] == o2[0]){
                                return o1[1] - o2[1];
                            }else{
                                return o1[0] - o2[0];
                            }
                        }else {
                            return check[o1[0]][o1[1]] - check[o2[0]][o2[1]];
                        }
                    }
                });
                int[] e = canEat.get(0);
                int mx = e[0], my=e[1];

                arr[mx][my] = 0;
                eat++;
                t += check[mx][my];
                X = mx;
                Y = my;
                if (eat == age) {
                    age++;
                    eat = 0;
                }
            }else {
                break;
            }
        }
        System.out.println(t);
    }
}
