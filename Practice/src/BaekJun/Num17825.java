package BaekJun;

import java.util.LinkedList;
import java.util.Scanner;

public class Num17825 {
    static int answer = 0;
    static LinkedList<Integer>[] link = new LinkedList[5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];

        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        }

        link[0] = new LinkedList<>();
        for (int i = 0; i <= 40; i += 2) {
            link[0].add(i);
        }
        link[0].add(-1);

        link[1] = new LinkedList<>();
        link[1].add(10);
        link[1].add(13);
        link[1].add(16);
        link[1].add(19);

        link[2] = new LinkedList<>();
        link[2].add(20);
        link[2].add(22);
        link[2].add(24);

        link[3] = new LinkedList<>();
        link[3].add(30);
        link[3].add(28);
        link[3].add(27);
        link[3].add(26);

        link[4] = new LinkedList<>();
        link[4].add(25);
        link[4].add(30);
        link[4].add(35);
        link[4].add(40);
        link[4].add(-1);

        Horse[] horses = new Horse[4];
        for (int h = 0; h < 4; h++) {
            horses[h] = new Horse();
        }

        boolean[][] check = new boolean[link.length][link[0].size()];
        search(a, 0, horses, 0, check);

        System.out.println(answer);
    }

    static void search(int[] a, int idx, Horse[] horse, int score, boolean[][] check) {
        if (idx == a.length) {
            answer = Math.max(answer, score);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (link[horse[i].link].get(horse[i].idx) == -1) {
                continue;
            }

            Horse[] horse2 = new Horse[4];
            for (int h = 0; h < 4; h++) {
                horse2[h] = new Horse();
                horse2[h].link = horse[h].link;
                horse2[h].idx = horse[h].idx;
            }

            boolean[][] check2 = new boolean[check.length][check[0].length];
            for (int j = 0; j < check.length; j++) {
                for (int k = 0; k < check[j].length; k++) {
                    check2[j][k] = check[j][k];
                }
            }
            if (go(horse2[i], a[idx], check2)) {
                int add = link[horse2[i].link].get(horse2[i].idx);
                if (add == -1) add = 0;
                search(a, idx + 1, horse2, score + add, check2);
            }
        }
    }

    static boolean go(Horse horse, int n, boolean[][] check) {
        int linkIdx = horse.link;
        int idx = horse.idx;
        boolean end = false;
        while (n > 0) {
            int left = link[linkIdx].size() - idx - 1;
            if (n <= left) {
                idx += n;
                n = 0;
            } else {
                if (linkIdx == 0 || linkIdx == 4) {
                    // end
                    end = true;
                    linkIdx = 0;
                    idx = link[0].size() - 1;
                    n = 0;
                } else {
                    n -= left + 1;
                    linkIdx = 4;
                    idx = 0;
                }
            }
        }
        if (linkIdx == 0) {
            int s = link[linkIdx].get(idx);
            if (s > 0 && s % 10 == 0 && s!=40) {
                linkIdx = s / 10;
                idx = 0;
            }
        }
        if (linkIdx == 0 && idx == 21 || linkIdx == 4 && idx == 4) {
            end = true;
        }
        if(linkIdx == 4 && idx==3){
            linkIdx = 0;
            idx = 20;
        }
        if (check[linkIdx][idx]) {
            return false;
        }
        check[horse.link][horse.idx] = false;
        if (!end)
            check[linkIdx][idx] = true;
        horse.link = linkIdx;
        horse.idx = idx;
        return true;
    }

    static class Horse {
        int link = 0, idx = 0;
    }
}
