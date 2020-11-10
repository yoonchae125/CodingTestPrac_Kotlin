package programmers_practice.level3;

import java.util.LinkedList;
import java.util.Queue;

public class MostFarNode {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        boolean a[][] = new boolean[n][n];
        int d[] = new int[n];
        boolean visited[] = new boolean[n];

        for(int[] e:edge){
            a[e[0]-1][e[1]-1] = true;
            a[e[1]-1][e[0]-1] = true;
        }

        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        visited[0] = true;
        d[0] = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i=1;i<n;i++){
                if(visited[i])
                    continue;
                if(!a[node][i])
                    continue;
                d[i] = d[node]+1;
                queue.add(i);
                visited[i] = true;
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            if(d[i]==max){
                answer++;
            }else{
                if(d[i]>max){
                    max = d[i];
                    answer=1;
                }
            }
        }

        return answer;
    }

}
