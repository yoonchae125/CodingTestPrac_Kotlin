package BaekJun;

import java.util.*;

public class Num16235 {
    public static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] A = new int[N][N];
        int[][] map = new int[N][N];
        ArrayList<Integer>[][] trees = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
                map[i][j] = 5;
                trees[i][j] = new ArrayList<Integer>();
            }
        }

        while (M-- > 0) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int age = sc.nextInt();
            trees[x][y].add(age);
        }

        while (K-- > 0) {
            // 봄
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (trees[i][j].size() == 0) continue;
                    Collections.sort(trees[i][j]);
                    int idx;
                    for (idx = 0; idx < trees[i][j].size(); idx++) {
                        int age = trees[i][j].get(idx);
                        if (map[i][j] < age) break;
                        map[i][j] -= age;
                        trees[i][j].set(idx, age + 1);
                    }
                    int size = trees[i][j].size();
                    for (int id = idx; id < size; id++) {
                        int age = trees[i][j].remove(idx);
                        map[i][j] += age / 2;
                    }
                }
            }

            // 가을
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (trees[i][j].size() == 0) continue;
                    for (int id = 0; id < trees[i][j].size(); id++) {
                        int age = trees[i][j].get(id);
                        if (age % 5 == 0) {
                            for (int d = 0; d < 8; d++) {
                                int nx = i + dx[d];
                                int ny = j + dy[d];
                                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                                trees[nx][ny].add(1);
                            }
                        }
                    }
                }
            }

            // 겨울
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] += A[i][j];
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans += trees[i][j].size();
            }
        }
        System.out.println(ans);
    }

    static class Tree implements Comparable<Tree> {
        int x, y, age;

        Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree t) {
            if (this.x == t.x) {
                if (this.y == t.y) {
                    return this.age - t.age;
                } else {
                    return this.y - t.y;
                }
            } else {
                return this.x - t.x;
            }
        }
    }
}
