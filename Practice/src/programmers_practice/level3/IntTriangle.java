package programmers_practice.level3;

public class IntTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;

        int d[][] = new int[triangle.length][];

        for (int i = 0; i < d.length; i++) {
            d[i] = new int[triangle[i].length];
        }

        d[0][0] = triangle[0][0];

        for (int i = 1; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                if (j - 1 < 0) {
                    d[i][j] = d[i - 1][j] + triangle[i][j];
                } else if (j == d[i].length - 1) {
                    d[i][j] = d[i - 1][j - 1] + triangle[i][j];
                } else {
                    d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }

        for (int i = 0; i < d[d.length - 1].length; i++) {
            answer = Math.max(answer, d[d.length - 1][i]);
        }
        return answer;
    }
}
