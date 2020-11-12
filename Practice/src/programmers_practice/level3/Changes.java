package programmers_practice.level3;

import java.util.Arrays;

public class Changes {
    int MOD = 1000000007;

    public int solution(int n, int[] money) {
        int[] d = new int[n+1];
        d[0] = 1;

        Arrays.sort(money);

        for(int i=0; i<money.length; i++) {
            for(int j=money[i]; j<=n; j++) {
                d[j] = (d[j] + d[j-money[i]])% MOD;
            }
        }
        return d[n];
    }
}
