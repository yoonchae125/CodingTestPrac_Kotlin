package programmers_practice.level3;

import java.util.ArrayList;

public class ColumnAndRow {

    public int[][] solution(int n, int[][] build_frame) {
        int[][] map = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                map[i][j] = -1;
            }
        }
        for(int[] build: build_frame){
            int x = build[0];
            int y = build[1];
            int type = build[2]; // 0:col 1:row
            int act = build[3]; // 0:del 1:create
            if(type==0){ // col
                if(act == 0){ // del
                    int temp[][] = new int[n+1][n+1];
                    for(int i=0;i<=n;i++){
                        for(int j=0;j<=n;j++){
                            temp[i][j] = map[i][j];
                        }
                    }
                    temp[x][y] = -1;
                    if(!isAvailable(temp,x-1, y, 0))
                        continue;
                    if(!isAvailable(temp,x+1, y, 0))
                        continue;
                    if(!isAvailable(temp,x, y-1, 1))
                        continue;
                    if(!isAvailable(temp,x, y, 1))
                        continue;
                    if(!isAvailable(temp,x-1, y-1, 1))
                        continue;
                    if(!isAvailable(temp,x-1, y, 1))
                        continue;
                    // isAvailable
                    // commit
                    temp[x][y] = -1;

                }else{ // create
                    System.out.println(x+","+y);
                    int[][] temp = new int[n+1][n+1];
                    for(int i=0;i<=n;i++){
                        for(int j=0;j<=n;j++){
                            temp[i][j] = map[i][j];
                        }
                    }
                    temp[x][y] = 1;
                    if(isAvailable(temp, x, y, type)){
                        //commit
                        map[x][y] = type;
                    }
                }
            }else{ // row
                if(act == 0){ // del
                    int temp[][] = new int[n+1][n+1];
                    for(int i=0;i<=n;i++){
                        for(int j=0;j<=n;j++){
                            temp[i][j] = map[i][j];
                        }
                    }
                    temp[x][y] = -1;
                    if(!isAvailable(temp, x, y-1, 1))
                        continue;
                    if(!isAvailable(temp,x, y+1, 1))
                        continue;
                    if(!isAvailable(temp,x-1, y, 0))
                        continue;
                    if(!isAvailable(temp,x, y, 0))
                        continue;
                    if(!isAvailable(temp,x, y+1, 0))
                        continue;
                    if(!isAvailable(temp,x-1, y+1, 0))
                        continue;
                    // isAvailable
                    // commit
                    map[x][y] = -1;
                }else{ // create
                    int temp[][] = new int[n+1][n+1];
                    for(int i=0;i<=n;i++){
                        for(int j=0;j<=n;j++){
                            temp[i][j] = map[i][j];
                        }
                    }
                    temp[x][y] = 0;
                    if(isAvailable(temp, x, y, type)){
                        //commit
                        map[x][y] = type;
                    }
                }
            }
        }
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(map[i][j]==-1)
                    continue;
                int[] t = new int[3];
                t[0] = i;
                t[1] = j;
                t[2] = map[i][j];
                list.add(t);
            }
        }

        int[][] answer = new int[list.size()][3];
        for(int i=0;i<answer.length;i++){
            int[] t = list.get(i);
            answer[i][0] = t[0];
            answer[i][1] = t[1];
            answer[i][2] = t[2];
        }
        return answer;
    }
    boolean isAvailable(int[][] map, int x, int y, int type){
        if(x<0||x>=map.length||y<0||y>=map.length)
            return false;
        if(type==0){ // 기둥
            if(y == 0){
                return true;
            }
            if(x-1>=0 && y-1>=0){
                if(map[x-1][y-1] == 1)
                    return true;
            }
            if(x-1>=0){
                if(map[x-1][y] == 1)
                    return true;
            }
            if(y-1>=0){
                // (x-1, y) 에 기둥
                if(map[x][y-1] == 0)
                    return true;
                if(map[x][y-1] == 1)
                    return true;
            }
        }else{ // 보
            if(x-1>=0 && x+1<map[0].length){
                if(map[x-1][y]==1 && map[x+1][y]==1){
                    return true;
                }
            }
            if(map[x][y]==0){
                return true;
            }
            if(map[x+1][y]==0){
                return true;
            }

            if(x+1<map.length && y+1<map.length){
                if(map[x][y+1]==0){
                    return true;
                }
                if(map[x+1][y+1]==0){
                    return true;
                }
            }
        }
        return false;
    }
}
