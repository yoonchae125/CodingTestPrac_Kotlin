package programmers_practice.level2_review;

public class BiggestSquare {
    public int solution(int[][] board) {
        int max = 0;
        if(board.length == 1 || board[0].length == 1){
            return board[0][0];
        }
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 0) continue;
                board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                max = Math.max(board[i][j], max);
            }
        }
        return max * max;
    }
}
