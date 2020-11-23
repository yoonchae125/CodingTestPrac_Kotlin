package programmers_practice.level2_review;

public class QuadZip {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        int n = arr.length;
        boolean[][] checked = new boolean[n][n];

        for(int i=n;i>0;i=i/2){
//            System.out.println(i);
            for(int x = 0;x<n;x+=i){
                for(int y = 0; y<n; y+=i){
                    if(checked[x][y])
                        continue;
                    int result = isSame(arr, i, x, y);
//                    System.out.println(result);
                    if(result != -1){
                        for(int a = x; a<x+i;a++){
                            for(int b=y; b<y+i;b++){
                                checked[a][b] = true;
                            }
                        }
                        answer[result]++;
                    }
                }
            }
        }

        return answer;
    }
    int isSame(int[][] arr, int size, int x, int y){
        boolean isSame = true;
        int value = arr[x][y];
        for(int i = x; i<x+size;i++){
            for(int j=y; j<y+size;j++){
                if(arr[i][j]!=value){
                    isSame = false;
                    break;
                }
            }
        }
        if(isSame){
            return value;
        }else{
            return -1;
        }
    }
}
