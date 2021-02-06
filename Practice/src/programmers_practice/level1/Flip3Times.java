package programmers_practice.level1;

public class Flip3Times {
    public static int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.insert(0,n%3);
            n = n/3;
        }
        sb.reverse();
        for(int i=0;i<sb.length();i++){
            int idx = sb.length()-i-1;
            int num = sb.charAt(idx)-'0';
            answer+=Math.pow(3, i)*num;
        }
        return answer;
    }

    public static void main(String[] args) {
        int a = solution(45);
        System.out.println(a);
    }
}
