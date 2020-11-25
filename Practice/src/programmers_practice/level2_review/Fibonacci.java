package programmers_practice.level2_review;

public class Fibonacci {
    public int solution(int n) {
        int mod = 1234567;

        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;

        for(int i=2;i<=n;i++){
            f[i] = (f[i-2]+f[i-1])%mod;
        }

        return f[n];
    }
}
