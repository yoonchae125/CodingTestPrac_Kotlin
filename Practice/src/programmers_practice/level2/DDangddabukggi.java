package programmers_practice.level2;

public class DDangddabukggi {
    int solution(int[][] land) {
        int answer = 0;

        int big[][] = new int[land.length][land[0].length];

        for(int i=0;i<land[0].length;i++){
            big[0][i] = land[0][i];
        }
        for(int i=1;i<land.length;i++){
            for(int j=0;j<land[i].length;j++){
                big[i][j] = land[i][j]+ big(i,j,big);
            }
        }
        for(int k=0;k<big[big.length-1].length;k++){
            if(big[big.length-1][k]>answer){
                answer = big[big.length-1][k];
            }
        }
        return answer;
    }
    public int big(int i, int j, int big[][]){
        int a= 0;

        for(int k=0;k<big[i-1].length;k++){
            if(k==j)
                continue;
            if(big[i-1][k]>a){
                a = big[i-1][k];
            }
        }

        return a;
    }
}
