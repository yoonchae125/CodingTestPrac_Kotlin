package programmers_practice.level3;

public class Jump {
    public long solution(int n) {
        int MOD = 1234567;

        int[] d = new int[n+1];
        d[0] = 1;
        d[1] = 1;

        for(int i=2;i<=n;i++){
            d[i] = (d[i-1]+d[i-2]) % MOD;
        }

        return d[n];
    }
}
