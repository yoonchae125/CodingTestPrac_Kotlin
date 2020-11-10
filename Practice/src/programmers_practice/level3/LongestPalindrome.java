package programmers_practice.level3;

public class LongestPalindrome {
    public int solution(String s)
    {
        int answer = 1;
        char[] chr = s.toCharArray();
        for(int len = s.length();len>1;len--){

            for(int start = 0; start+len<=s.length(); start++){
                boolean result = true;
                int left = start;
                int right = start+len-1;
                int mid = len/2;
                for(int i=0;i<mid;i++){
                    if(chr[start+i] != chr[right-i]){
                        result = false;
                        break;
                    }
                }
                if(result)
                    return len;

            }
        }

        return answer;
    }
}
