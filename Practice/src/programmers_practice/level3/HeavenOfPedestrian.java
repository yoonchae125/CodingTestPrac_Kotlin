package programmers_practice.level3;

public class HeavenOfPedestrian {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int answer;

        int arr[][][] = new int[m + 1][n + 1][2];

        arr[1][1][0] = arr[1][1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                switch (cityMap[i - 1][j - 1]) {
                    case 0:
                        arr[i][j][0] += (arr[i - 1][j][0] + arr[i][j - 1][1]) % MOD;
                        arr[i][j][1] += (arr[i - 1][j][0] + arr[i][j - 1][1]) % MOD;
                        break;
                    case 1:
                        break;
                    case 2:
                        arr[i][j][0] = arr[i - 1][j][0];
                        arr[i][j][1] = arr[i][j - 1][1];
                        break;
                }
            }
        }
        answer = arr[m][n][0];
        return answer;
    }
}
