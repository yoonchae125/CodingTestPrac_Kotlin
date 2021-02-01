package programmers_practice.level1;

import java.util.Arrays;

public class Exercising {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] student = new int[n];
        Arrays.fill(student,1);
        for(int lo: lost){
            student[lo-1]=student[lo-1]-1;
        }
        for(int re: reserve){
            student[re-1]=student[re-1]+1;
        }

        for(int i=0;i<n;i++){
            if(student[i]==1){
                answer++;
            }else if(student[i]==2){
                answer++;
                if(i-1>=0&&student[i-1]==0){
                    answer++;
                }else if(i+1<n && student[i+1]==0){
                    student[i+1] = 1;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args){
        int ans = solution(5, new int[]{2,4}, new int[]{1,3,5});
        System.out.println(ans);
    }
}
