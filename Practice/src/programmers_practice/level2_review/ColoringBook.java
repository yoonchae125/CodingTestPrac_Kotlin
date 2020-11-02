package programmers_practice.level2_review;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        int check[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(check[i][j]==1)
                    continue;
                if(picture[i][j]==0)
                    continue;
                System.out.println("----------"+picture[i][j]+"----------");
                Queue<Integer> q = new LinkedList<>();
                q.add(i); q.add(j);
                check[i][j] = 1;
                numberOfArea++;
                int count = 1;
                while(!q.isEmpty()){
                    int x = q.poll(); int y = q.poll();
                    System.out.println(x+", "+y);
                    for(int d=0;d<4;d++){
                        int nx = x+dx[d];
                        int ny = y+dy[d];
                        System.out.print(nx+", "+ny+": ");
                        if(nx<0||nx>=m||ny<0||ny>=n) {
                            System.out.println("out of area");
                            continue;
                        }
                        if(check[nx][ny]==1){
                            System.out.println("already searched");
                            continue;
                        }
                        if(picture[nx][ny] != picture[x][y]) {
                            System.out.println("diff");
                            continue;
                        }
                        System.out.println("good");
                        q.add(nx); q.add(ny);
                        check[nx][ny] = 1;
                        count++;
                    }
                }
                System.out.println("count: "+count);
                if(maxSizeOfOneArea == 0){
                    maxSizeOfOneArea = count;
                }else{
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
}
