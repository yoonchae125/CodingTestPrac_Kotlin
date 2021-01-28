package programmers_practice.kakao2021blind;


import java.util.Arrays;

public class Taxi {
    static final int MAX = 10000000;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = MAX;
        int[][] d = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(d[i], MAX);
            d[i][i] = 0;
        }
        for (int i = 0; i < fares.length; i++) {
            int n1 = fares[i][0];
            int n2 = fares[i][1];
            int f = fares[i][2];
            d[n1][n2] = f;
            d[n2][n1] = f;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        for (int cur = 1; cur <= n; cur++) {
            if (d[s][cur] == MAX || d[cur][a] == MAX || d[cur][b] == MAX) continue;
            answer = Math.min(answer, d[s][cur] + d[cur][a] + d[cur][b]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int a = solution(6, 4, 6, 2, fares);
        System.out.println(a);
    }
}
