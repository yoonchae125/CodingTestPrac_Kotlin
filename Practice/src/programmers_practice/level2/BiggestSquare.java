package programmers_practice.level2;

public class BiggestSquare {
    public int solution(int [][]board){
        int up, left, upleft;
        for(int y = 1 ; y < board.length; y++) {
            for(int x = 1 ; x < board[y].length; x++) {
                if(board[y][x] == 1) {
                    up = board[y-1][x];
                    left = board[y][x-1];
                    upleft = board[y-1][x-1];

                    int min = Math.min(up, left);
                    min = Math.min(min , upleft);
                    board[y][x] = min+1;
                }
            }
        }

        int ans = 0;
        for(int y = 0 ; y < board.length; y++) {
            for(int x= 0 ; x < board[0].length ; x++) {
                if(board[y][x] > 0) {
                    ans = Math.max(ans, board[y][x]);
                }
            }
        }
        return ans*ans;
    }
}
