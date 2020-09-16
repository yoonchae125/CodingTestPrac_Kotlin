package programmers_practice.level2;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        long[][] pictures = new long[picture.length][picture[0].length];
        for(int i=0;i<picture.length;i++){
            for(int j=0;j<picture[i].length;j++){
                pictures[i][j] = picture[i][j];
            }
        }
        int dx[] = {0,0,1,-1,-1,1,-1,1};
        int dy[] = {1,-1,0,0,-1,1,1,-1};
        int area = 0;
        for(int i=0;i<pictures.length;i++) {
            for(int j=0;j<pictures[i].length;j++){
                if(pictures[i][j]==0)
                    continue;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                queue.add(j);
                long num = pictures[i][j];
                pictures[i][j] = 0;
                numberOfArea++;

                while(!queue.isEmpty()){
                    area++;
                    int x = queue.poll(); int y = queue.poll();
                    for(int d = 0; d<4; d++){
                        int nx = x + dx[d]; int ny = y+dy[d];
                        if(nx<0|| nx>=pictures.length||ny<0||ny>=pictures[0].length)
                            continue;
                        if(pictures[nx][ny]==0)
                            continue;
                        if(pictures[nx][ny]!=num)
                            continue;
                        queue.add(nx);
                        queue.add(ny);
                        pictures[nx][ny] = 0;
                    }
                }
                if(maxSizeOfOneArea==0){
                    maxSizeOfOneArea = area;
                }else{
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
                }
                area = 0;
            }
        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
