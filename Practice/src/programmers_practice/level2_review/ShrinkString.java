package programmers_practice.level2_review;

public class ShrinkString {
    public int solution(String s) {
        int answer = 0;

        if(s.length()==1)
            return 1;

        for (int unit = 1; unit <= s.length() / 2; unit++) {
            int len = shrink(s, unit);
            if (answer == 0)
                answer = len;
            else
                answer = Math.min(answer, len);
        }

        return answer;
    }

    int shrink(String s, int unit) {
        System.out.println("shrink "+s+" "+unit);

        int len = 0;

        int count = 0;
        String prev = "";
        for(int i=0;i<=s.length()-unit;i+=unit){
            String sub = s.substring(i, i+unit);
            System.out.println(sub);
            if(sub.equals(prev)){
                count++;
            }else{
                prev = sub;
                if(count!=0){
                    len += unit + (count+"").length();
                    if(count == 1){
                        len-=1;
                    }
                }
                count = 1;
            }
            System.out.println(len);
        }
        if(count!=0){
            len += unit + (count+"").length();
            if(count == 1){
                len-=1;
            }
        }
        len+=s.length()%unit;

        return len;
    }
}
