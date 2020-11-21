package programmers_practice.level2_review;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook2 {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        boolean[][] check = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(check[i][j]) continue;
                if(picture[i][j]==0) continue;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i); queue.add(j);
                numberOfArea++;
                check[i][j] = true;
                int area = 1;
                while (!queue.isEmpty()){
                    int x = queue.poll();
                    int y = queue.poll();
                    for(int d =0 ; d<4;d++){
                        int nx = x+dx[d];
                        int ny = y+dy[d];
                        if(nx<0||nx>=m||ny<0||ny>=n) continue;
                        if(check[nx][ny]) continue;
                        if(picture[nx][ny] ==picture[x][y]){
                            queue.add(nx); queue.add(ny);
                            check[nx][ny] = true;
                            area++;
                        }
                    }
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
