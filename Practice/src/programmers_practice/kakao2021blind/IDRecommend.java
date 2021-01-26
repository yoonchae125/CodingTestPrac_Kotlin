package programmers_practice.kakao2021blind;

public class IDRecommend {
    public static String solution(String new_id) {
        String answer = "";

        // len: 3-15
        // small, -, _, .
        // . : 연속x, prefix x, suffix x

//        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();
//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<new_id.length();i++){
            char c = new_id.charAt(i);
            if(Character.isAlphabetic(c)){
                sb.append(c); continue;
            }
            if(Character.isDigit(c)){
                sb.append(c); continue;
            }
            if(c == '-'){
                sb.append(c); continue;
            }
            if(c == '_'){
                sb.append(c); continue;
            }
            if(c == '.'){
                sb.append(c); continue;
            }
        }
//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        StringBuffer sb2 = new StringBuffer();
        int count = 0;
        for(int i=0;i<sb.length();i++){
            char c = sb.charAt(i);
            if(c == '.'){
                count++;
            }else{
                count = 0;
            }
            if(count==0 || count==1){
                sb2.append(c);
            }
        }
//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(sb2.length()!=0 && sb2.charAt(0)=='.'){
            sb2.deleteCharAt(0);
        }
        int lastIdx = sb2.length()-1;
        if(sb2.length()!=0 && sb2.charAt(lastIdx)=='.'){
            sb2.deleteCharAt(lastIdx);
        }

//        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(sb2.length()==0){
            sb2.append('a');
        }
//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if(sb2.length()>=16) {
            sb2.delete(15,  sb2.length());
        }

//      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        lastIdx = sb2.length()-1;
        if(sb2.charAt(lastIdx)=='.'){
            sb2.deleteCharAt(lastIdx);
        }
//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        lastIdx = sb2.length()-1;
        char last = sb2.charAt(lastIdx);
        while (sb2.length()<3){
            sb2.append(last);
        }
        answer = sb2.toString();
        return answer;
    }
    public static void main(String[] args){
        String ans = solution("..!@BaT#*..y.abcdefghijklm");
        String ans1 = solution("abcdefghijklmn.p");
        System.out.println(ans1);
    }
}
