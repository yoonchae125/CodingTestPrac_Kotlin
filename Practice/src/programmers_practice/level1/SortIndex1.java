package programmers_practice.level1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortIndex1 {
    public static String[] solution(String[] strings, int n) {
        String[] answer = strings.clone();
        String s= "Zbcdefg";
        char[] chars = s.toCharArray();

        Arrays.sort(chars);

        char[] temp = new char[chars.length];
        for(int i=0;i<temp.length;i++){
            temp[i] = chars[chars.length-1-i];
        }
        long num = (long) Math.sqrt(121);
        System.out.println(num);
        return answer;
    }
    public static void main(String[] args){
        String[] ans = solution(new String[]{"sun", "bed", "car"}, 1);
        for(String a:ans){
//            System.out.println(a);
        }
    }
}
