package programmers_practice.level1;

import java.util.ArrayList;

public class DartGame {
    public int solution(String dartResult) {
        int answer = 0;

        ArrayList<String> arr = new ArrayList<>();

        int start = 0;
        char before = 'a';
        for(int i=2;i<dartResult.length();i++){
            char c = dartResult.charAt(i);
            if(Character.isDigit(c)){
                if(Character.isDigit(before)){
                    before = c;
                    continue;
                }
                arr.add(dartResult.substring(start,i));
                start = i;
            }
            before = c;
        }
        arr.add(dartResult.substring(start));

        int calc[] = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            String str = arr.get(i);
//            System.out.println(str);

            int num;
            char pow;
            boolean hasOption = false;
            char option = 0;
            if(Character.isDigit(str.charAt(1))) {
                num = 10;
                pow = str.charAt(2);
                if(str.length()==4){
                    hasOption = true;
                    option = str.charAt(3);
                }
            }else{
                num = str.charAt(0) - '0';
                pow = str.charAt(1);
                if(str.length()==3){
                    hasOption = true;
                    option = str.charAt(2);
                }
            }
            switch (pow){
                case 'S':
                    calc[i] = num;
                    break;
                case 'D':
                    calc[i] = num*num;
                    break;
                case 'T':
                    calc[i] = num*num*num;
                    break;
            }
            if(hasOption){
                if(option == '#'){
                    calc[i]*=-1;
                }else{
                    calc[i]*=2;
                    if(i!=0){
                        calc[i-1]*=2;
                    }
                }
            }
        }
        for(int c:calc){
            answer+=c;
        }
        return answer;
    }
}
