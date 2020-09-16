package programmers_practice.level2;

public class ZipString {
    public int solution(String s) {
        int answer = 0;
        if (s.length() == 1)
            return 1;

        int n = s.length() / 2;
        for (int len = 1; len <= n; len++) {
            String prev = "";
            int count = 1;
            int result = s.length() % len;
            for (int i = 0; i + len - 1 < s.length(); i = i + len) {
                String sub = s.substring(i, i + len);
                if (sub.equals(prev)) {
                    count++;
                } else {
                    if (prev.equals("")) {
                        //
                    } else if (count == 1) {
                        result += len;
                        if(len==1){
                            System.out.println("aa "+result);
                        }
                    } else {
                        String str = count+"";
                        result += len + str.length();
                    }
                    count = 1;
                }
                prev = sub;
            }
            if (count == 1) {
                result += len;
            } else {
                String str = count+"";
                result += len + str.length();
            }

            if (answer == 0) {
                answer = result;
            } else {
                if (result < answer) {
                    System.out.println(len);
                }
                answer = Math.min(answer, result);
            }
        }
        return answer;
    }
}
