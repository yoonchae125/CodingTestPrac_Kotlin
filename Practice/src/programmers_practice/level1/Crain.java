package programmers_practice.level1;

import java.util.Stack;

public class Crain {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer>[] stacks = new Stack[n];
        for (int j = 0; j < n; j++) {
            stacks[j] = new Stack<>();
            for (int i = n-1; i >= 0; i--) {
                if(board[i][j]==0) continue;
                stacks[j].add(board[i][j]);
            }
        }

        Stack<Integer> basket = new Stack<>();
        for(int m:moves){
            if(stacks[m-1].isEmpty()) continue;
            int ball = stacks[m-1].pop();
            if(basket.isEmpty()){
                basket.add(ball); continue;
            }
            if (basket.peek()==ball){
                System.out.println("remove");
                answer+=2;
                basket.pop();
            }else{
                basket.add(ball);
            }
        }

        return answer;
    }
    public static void main(String[] args){
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int ans = solution(board, moves);
        System.out.println(ans);
    }
}
