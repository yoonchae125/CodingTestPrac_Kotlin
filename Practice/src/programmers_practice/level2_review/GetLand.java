package programmers_practice.level2_review;

public class GetLand {
    int solution(int[][] land) {
        int answer = 0;
        int[][] big = new int[land.length][land[0].length];
        for(int i=0;i<land[0].length;i++){
            big[0][i] = land[0][i];
        }
        for(int i=1;i<big.length;i++){
            for(int j=0;j<4;j++){
                int max = 0;

                for(int k=0;k<4;k++){
                    if(j==k) continue;
                    max = Math.max(big[i-1][k], max);
                }
                big[i][j] = max+land[i][j];
            }
        }

        for(int i=0;i<4;i++) {
            answer = Math.max(big[land.length - 1][i], answer);
        }
        return answer;
    }
}
