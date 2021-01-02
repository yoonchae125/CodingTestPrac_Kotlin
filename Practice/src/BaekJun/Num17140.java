package BaekJun;

import java.util.*;

public class Num17140 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        int k = sc.nextInt();

        int[][] A = new int[3][3];
        int R = 3;
        int C = 3;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        int time = 0;
        boolean flag = false;
        while (time <= 100) {
            if(r>=R || c>=C){}
            else{
                if (A[r][c] == k) {
                    flag = true;
                    break;
                }
            }
            if (R >= C) {
                // R sort
                HashMap<Integer, Integer>[] hm = new HashMap[R];
                int CC = C;
                for (int i = 0; i < R; i++) {
                    hm[i] = new HashMap<>();
                    for (int j = 0; j < C; j++) {
                        int n = A[i][j];
                        if (n == 0) continue;
                        if (hm[i].containsKey(n)) {
                            hm[i].replace(n, hm[i].get(n) + 1);
                        } else {
                            hm[i].put(n, 1);
                        }
                    }
                    CC = Math.max(CC, hm[i].size() * 2);
                }
                C = CC;
                int[][] AA = new int[R][C];
                for (int i = 0; i < R; i++) {
                    Integer[] keys = new Integer[hm[i].size()];
                    Set<Integer> keySet = hm[i].keySet();
                    keySet.toArray(keys);
                    int finalI = i;
                    Arrays.sort(keys, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            Integer v1 = hm[finalI].get(o1);
                            Integer v2 = hm[finalI].get(o2);
                            if (v1.compareTo(v2) == 0) {
                                return o1.compareTo(o2);
                            } else {
                                return v1.compareTo(v2);
                            }
                        }
                    });

                    for (int id = 0; id < hm[i].size(); id++) {
                        AA[i][id * 2] = keys[id];
                        AA[i][id * 2 + 1] = hm[i].get(keys[id]);
                    }
                }
                A = AA;
            } else {
                // C sort
                int RR = R;
                HashMap<Integer, Integer>[] hm = new HashMap[C];
                for (int j = 0; j < C; j++) {
                    hm[j] = new HashMap<>();
                    for (int i = 0; i < R; i++) {
                        int n = A[i][j];
                        if (n == 0) continue;
                        if (hm[j].containsKey(n)) {
                            hm[j].replace(n, hm[j].get(n) + 1);
                        } else {
                            hm[j].put(n, 1);
                        }
                    }
                    RR = Math.max(RR, hm[j].size() * 2);
                }
                R=RR;
                int[][] AA = new int[R][C];

                for (int j = 0; j < C; j++) {
                    Integer[] keys = new Integer[hm[j].size()];
                    Set<Integer> keySet = hm[j].keySet();
                    keySet.toArray(keys);
                    int finalJ = j;
                    Arrays.sort(keys, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            Integer v1 = hm[finalJ].get(o1);
                            Integer v2 = hm[finalJ].get(o2);
                            if (v1.compareTo(v2) == 0) {
                                return o1.compareTo(o2);
                            } else {
                                return v1.compareTo(v2);
                            }
                        }
                    });

                    for (int id = 0; id < hm[j].size(); id++) {
                        AA[id * 2][j] = keys[id];
                        AA[id * 2 + 1][j] = hm[j].get(keys[id]);
                    }
                }
                A = AA;
            }
            time++;
        }
        if(!flag){
            time = -1;
        }
        System.out.println(time);

    }
}
