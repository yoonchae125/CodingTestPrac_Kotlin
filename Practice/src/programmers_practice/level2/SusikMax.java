package programmers_practice.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SusikMax {
    public long solution(String expression) {
        long answer = 0;
        ArrayList<Long> operands = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        String operand = "";
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                operand+=c;
            }else{
                operands.add(Long.parseLong(operand));
                operand = "";
                operators.add(c);
                hm.put(c,0);
            }
        }
        operands.add(Long.parseLong(operand));
//        for(Integer i :operands){
//            System.out.println(i);
//        }
//
//        for(Character c :operators){
//            System.out.println(c);
//        }
        Set<Character> keySet = hm.keySet();
        int[] keys = new int[keySet.size()];
        Iterator<Character> it = keySet.iterator();
        int idx = 0;
        while(it.hasNext()){
            keys[idx++] = it.next();
        }
        do{
            ArrayList<Long> op = new ArrayList<>();
            for(Long o:operands){
                op.add(o);
            }
            ArrayList<Character> opt = new ArrayList<>();
            for(Character o:operators){
                opt.add(o);
            }
            for(int i=0;i<keys.length;i++){
                char key = (char) keys[i];
//                System.out.println("key: "+key);

                Iterator<Character> itr = opt.iterator();

                idx = 0;
                while(itr.hasNext()){
                    Character k = itr.next();
                    if(k==key){
                        long n1 = op.get(idx);
                        long n2 = op.get(idx+1);

                        op.remove(idx);
                        op.remove(idx);
//                        for(int o:op){
//                            System.out.println("operand "+o);
//                        }
                        if(k=='+') {
//                            System.out.println("plus");
                            op.add(idx, n1 + n2);
                        }
                        else if(k=='-') {
//                            System.out.println("minus");
                            op.add(idx, n1 - n2);
                        }
                        else {
//                            System.out.println("mult");
                            op.add(idx, n1 * n2);
                        }
//                        for(int o:op){
//                            System.out.println("operand af "+o);
//                        }
                        itr.remove();
                    }else{
                        idx++;
                    }
                }
            }
//            System.out.println("size: "+op.size());

            answer = Math.max(Math.abs(op.get(0)),answer);
//            System.out.println(answer);
        }while(next_permutation(keys));
        return answer;
    }
    public static boolean next_permutation(int[] a) { // 순열
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[j] <= a[i - 1]) {
            j -= 1;
        }

        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
}
