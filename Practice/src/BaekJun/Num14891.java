package BaekJun;

import java.util.*;

public class Num14891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer>[] dq = new ArrayList[4];

        for (int i = 0; i < 4; i++) {
            dq[i] = new ArrayList();
            String str = sc.next();
            for (int j = 0; j < 8; j++) {
                dq[i].add(str.charAt(j) - '0');
            }
        }

        int K = sc.nextInt();

        for (int i = 0; i < K; i++) {
            int n = sc.nextInt() - 1;
            int d = sc.nextInt();
            int[] check = new int[4];
            Queue<Integer> q = new LinkedList<>();
            q.add(n);
            check[n] = d;
            while (!q.isEmpty()) {
                n = q.poll();
                if (n == 0) {
                    // check right
                    if (check[n + 1] == 0 && !dq[n].get(2).equals(dq[n + 1].get(6))) {
                        q.add(n + 1);
                        check[n + 1] = check[n] * -1;
                    }
                } else if (n == 3) {
                    // check left
                    if (check[n - 1] == 0 && !dq[n].get(6).equals(dq[n - 1].get(2))) {
                        q.add(n - 1);
                        check[n - 1] = check[n] * -1;
                    }
                } else {
                    // check both
                    if (check[n + 1] == 0 && !dq[n].get(2).equals(dq[n + 1].get(6))) {
                        q.add(n + 1);
                        check[n + 1] = check[n] * -1;
                    }
                    if (check[n - 1] == 0 && !dq[n].get(6).equals(dq[n - 1].get(2))) {
                        q.add(n - 1);
                        check[n - 1] = check[n] * -1;
                    }
                }
            }
            for (int c = 0; c < check.length; c++) {
                if (check[c] == 1) {
                    int t = dq[c].remove(7);
                    dq[c].add(0, t);
                } else if (check[c] == -1) {
                    int t = dq[c].remove(0);
                    dq[c].add(t);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans += dq[i].get(0) * Math.pow(2, i);
        }
        
        System.out.println(ans);
    }
}
