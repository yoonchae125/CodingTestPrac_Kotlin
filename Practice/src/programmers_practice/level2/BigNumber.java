package programmers_practice.level2;

public class BigNumber {
    long ans = 0;
    public String solution(String number, int k) {
        search(0,"",number,number.length()-k);

        return ans+"";
    }
    public void search(int idx,String now, String number, int n){
        if(n<0)
            return;
        if(idx == number.length()){
            if(n == 0){
                long num = Long.parseLong(now);
                ans = Math.max(ans,num);
            }
            return;
        }
        search(idx+1, now+number.charAt(idx),number,n-1);
        search(idx+1, now,number,n);
    }
}
