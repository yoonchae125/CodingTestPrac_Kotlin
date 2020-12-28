package BaekJun;

import java.util.ArrayList;
import java.util.Scanner;

public class Num15686 {
    static int N, M;
    static int answer = 0;
    static ArrayList<Pair> house = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] map = new int[N][N];
        ArrayList<Pair> store = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    store.add(new Pair(i, j));
                } else if (map[i][j] == 1) {
                    house.add(new Pair(i, j));
                }
            }
        }
        if (store.size() == M) {
            answer = chickenDistance(store);
        } else {
            select(store, 0, new ArrayList<Pair>());
        }
        System.out.println(answer);
    }

    static int chickenDistance(ArrayList<Pair> store) {
        int dist = 0;
        for (Pair h : house) {
            int d = 0;
            for (Pair s : store) {
                int dd = Math.abs(h.r - s.r) + Math.abs(h.c - s.c);
                if (d == 0) {
                    d = dd;
                } else {
                    d = Math.min(d, dd);
                }
            }
            dist += d;
        }
        return dist;
    }

    static void select(ArrayList<Pair> store, int idx, ArrayList<Pair> selectedStore) {
        if (idx == store.size()) {
            if (selectedStore.size() == M) {
                int dist = chickenDistance(selectedStore);
                if (answer == 0) {
                    answer = dist;
                } else {
                    answer = Math.min(answer, dist);
                }
            }
            return;
        }
        if (selectedStore.size() > M) {
            return;
        }
        selectedStore.add(store.get(idx));
        select(store, idx + 1, selectedStore);
        selectedStore.remove(selectedStore.size() - 1);
        select(store, idx + 1, selectedStore);
    }

    static class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
