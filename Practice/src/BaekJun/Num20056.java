package BaekJun;

import java.util.*;

public class Num20056 {
    final static int R = 0;
    final static int C = 1;
    final static int M = 2;
    final static int S = 3;
    final static int D = 4;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<int[]> fireballs = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int[] ball = new int[5];
            for (int j = 0; j < 5; j++) {
                if (j < 2) {
                    ball[j] = sc.nextInt() - 1;
                } else {
                    ball[j] = sc.nextInt();
                }
            }
            fireballs.add(ball);
        }

        while (K-- > 0) {
            HashMap<Point, ArrayList<int[]>> hm = new HashMap<>();
            for (int i = 0; i < fireballs.size(); i++) {
                int[] ball = fireballs.get(i);
                int nx = (ball[R] + dx[ball[D]] * (ball[S] % N) + N) % N;
                int ny = (ball[C] + dy[ball[D]] * (ball[S] % N) + N) % N;
                ball[R] = nx;
                ball[C] = ny;
                Point p = new Point(nx, ny);
//                System.out.println(nx + " " + ny);
                if (hm.containsKey(p)) {
                    hm.get(p).add(ball);
                } else {
                    ArrayList<int[]> a = new ArrayList<>();
                    a.add(ball);
                    hm.put(p, a);
                }
            }
            if (hm.size() == fireballs.size()) {
//                for (int i = 0; i < fireballs.size(); i++) {
//                    for (int j = 0; j < 5; j++) {
//                        System.out.print(fireballs.get(i)[j] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println("중복 없음");
                continue;
            }
            fireballs = new ArrayList<>();

            Point[] keys = new Point[hm.size()];
            hm.keySet().toArray(keys);

            for (int i = 0; i < keys.length; i++) {
                ArrayList<int[]> balls = hm.get(keys[i]);
                if(balls.size() == 1){
                    fireballs.add(balls.get(0));
                    continue;
                }
                int sumM = 0;
                int sumS = 0;
                boolean flag = true;
                int prev = -1;
                for (int j = 0; j < balls.size(); j++) {
                    sumM += balls.get(j)[M];
                    sumS += balls.get(j)[S];
                    if (!flag) continue;
                    int now = balls.get(j)[D] % 2;
                    if (prev != -1) {
                        if (now != prev) {
                            flag = false;

                        }
                    }
                    prev = now;
                }
                int mm = sumM / 5;
                int ss = sumS / balls.size();
                if (mm == 0) {
//                    System.out.println("소멸");
                    continue; // 소멸
                }
                int dd;
                if (flag) dd = 0;
                else dd = 1;
                for (int d = dd; d < 8; d += 2) {
                    fireballs.add(new int[]{keys[i].r, keys[i].c, mm, ss, d});
//                    System.out.println(keys[i].r + " " + keys[i].c + " " + mm + " " + ss + " " + d);

                }
            }
        }
        int sum = 0;
        for (int i = 0; i < fireballs.size(); i++) {
            sum += fireballs.get(i)[M];
        }
        System.out.println(sum);
    }

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            if (p.r == this.r && p.c == this.c) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return r + 1000 + c;
        }
    }
}
