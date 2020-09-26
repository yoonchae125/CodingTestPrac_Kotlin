package programmers_practice.level2;

import java.util.ArrayList;
import java.util.Collections;

public class NewsClustering {
    public int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        for(int i=0;i< str1.length()-1;i++){
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);

            if(!Character.isAlphabetic(c1) || !Character.isAlphabetic(c2)){
                continue;
            }
            list1.add(c1+""+c2);
        }
        for(String s:list1){
            System.out.print(s+" ");
        }System.out.println();
        for(int i=0;i< str2.length()-1;i++){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);

            if(!Character.isAlphabetic(c1) || !Character.isAlphabetic(c2)){
                continue;
            }
            list2.add(c1+""+c2);
        }
//        for(String s:list2){
//            System.out.print(s+" ");
//        }System.out.println();

        if(list1.size()==0 && list2.size()==0) {
            return 65536;
        }
        int sum = list1.size()+list2.size();
        int count = 0;
        for (int i=0;i<list1.size();i++){
            if(list2.contains(list1.get(i))){
                list2.remove(list1.get(i));
                count++;
            }
        }

        answer = 65536*count/(sum-count);
        return answer;
    }
}
