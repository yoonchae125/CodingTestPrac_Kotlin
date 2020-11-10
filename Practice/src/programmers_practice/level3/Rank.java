package programmers_practice.level3;

public class Rank {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int max = 1000000;

        int arr[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    arr[i][j] = 0;
                else
                    arr[i][j] = max;
            }
        }

        for(int[] result:results){
            arr[result[0]][result[1]] = 1;
            arr[result[0]][result[1]] = 1;
        }

        for(int mid = 1; mid<=n;mid++){
            for(int i=1;i<=n;i++){
                if(i==mid) continue;
                for(int j=1;j<=n;j++){
                    if(j==mid) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][mid]+arr[mid][j]);
                }
            }
        }

        for(int i=1;i<=n;i++){
            boolean flag = true;
            for(int j=1;j<=n;j++){
                if(arr[i][j] == max && arr[j][i] == max){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }

        return answer;
    }
}
