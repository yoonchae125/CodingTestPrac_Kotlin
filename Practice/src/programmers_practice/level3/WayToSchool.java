package programmers_practice.level3;

public class WayToSchool {
    public int solution(int m, int n, int[][] puddles) {
        int d[][] = new int[n+1][m+1];

        for(int i=0;i<puddles.length;i++){
            d[puddles[i][1]][puddles[i][0]] = -1;
        }
        d[1][1] = 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==0 && j==0){
                    continue;
                }
                if(d[i][j] == -1) {
                    d[i][j] = 0;
                    continue;
                }
                if (i == 1) {
                    d[i][j] += d[i][j - 1];
                } else {
                    d[i][j] = (d[i - 1][j] + d[i][j - 1]) % 1000000007;
                }
            }
        }

        return d[n][m];
    }
}
