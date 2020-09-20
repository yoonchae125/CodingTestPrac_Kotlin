package programmers_practice.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Tuple {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        s = s.replaceAll("\\{", "");
        String[] strs = s.split("}");
        ArrayList<Integer> list[] = new ArrayList[strs.length];
        for (int i = 0; i < list.length; i++) {
            String ns[] = strs[i].split(",");
            list[i] = new ArrayList<>();
            for (String ss : ns) {
                if(ss.equals(""))
                    continue;
                list[i].add(Integer.parseInt(ss));
            }
        }
        Arrays.sort(list, new Comparator<ArrayList>() {
            @Override
            public int compare(ArrayList o1, ArrayList o2) {
                if (o1.size() > o2.size()) {
                    return 1;
                } else if (o1.size() == o2.size()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        int[] answer = new int[list.length];

        for (int i = 0; i < list.length; i++) {
            Integer integer = list[i].get(0);
            answer[i] = integer;

//            System.out.println(list.get(i).get(0));
            for (int j = i; j < list.length; j++) {
                ArrayList l = list[j];
                l.remove(integer);
            }
        }
        return answer;
    }
}
