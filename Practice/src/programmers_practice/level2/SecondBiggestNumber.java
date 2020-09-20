package programmers_practice.level2;

public class SecondBiggestNumber {
    public int solution(int n) {
        int answer = 0;
        int next = n+1;
        while (true){
            if(countOne(toBinaryNumber(next)) == countOne(toBinaryNumber(n))){
                answer = next;
                break;
            }
            next++;
        }
        return answer;
    }
    public String toBinaryNumber(int n){
        String str = "";
        while(n>0){
            str=n%2+str;
            n = n/2;
        }
        return str;
    }
    public int countOne(String n){
        int count = 0;
        for(int i=0;i<n.length();i++){
            if(n.charAt(i)=='1')
                count++;
        }
        return count;
    }
}
