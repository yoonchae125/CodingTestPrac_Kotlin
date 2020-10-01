package NAVER2020;

public class Num2 {
    public int[] solution(int[][] blocks) {
        int n = blocks.length; // 피라미드 높이
        int[] answer = new int[(n + 1) * n / 2];

        int pyramid[][] = new int[n][];
        for (int i = 0; i < n; i++) {
            pyramid[i] = new int[i + 1];
        }

        for (int i = 0; i < n; i++) {
            pyramid[i][blocks[i][0]] = blocks[i][1];
            if(i==0) continue;
            for(int j=blocks[i][0]-1;j>=0;j--){
                pyramid[i][j] = pyramid[i-1][j] - pyramid[i][j+1];
            }
            for(int j=blocks[i][0]+1;j<pyramid[i].length;j++){
                pyramid[i][j] = pyramid[i-1][j-1] - pyramid[i][j-1];
            }
        }

        int index = 0;
        for(int i=0;i<n;i++){
            for(int j=0; j<pyramid[i].length;j++){
                answer[index++] = pyramid[i][j];
            }
        }
        return answer;
    }
}
