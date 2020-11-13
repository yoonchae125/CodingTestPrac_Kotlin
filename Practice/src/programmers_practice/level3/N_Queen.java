package programmers_practice.level3;

public class N_Queen {
    int answer = 0;
    public int solution(int n) {

        int[] p = new int[n];

        search(n, p,0);

        return answer;
    }
    void search(int n, int[] p, int idx){
        if(idx == n){
            answer++;

            System.out.println();
            p[n - 1] = 0;
            return;
        }
        for(int i=0;i<n;i++){
            p[idx] = i;
            if(isPossible(idx, p)){
                search(n, p, idx+1);
            }else {
                p[idx] = 0;
            }
        }
    }
    private boolean isPossible(int n, int[] p){
        for(int i = 0 ; i < n ; ++i){
            if(p[i] == p[n]) return false;
            if(Math.abs(n - i) == Math.abs(p[n] - p[i])) return false;
        }

        return true;
    }
}
