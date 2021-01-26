package programmers_practice.kakao2021blind;

import java.util.*;

public class MenuRenewal {
    static HashMap<String, Integer> map = new HashMap<>();

    public static String[] solution(String[] orders, int[] course) {


        for (String order : orders) {
            makeSet(order, 0, new ArrayList<Character>());
        }
        ArrayList<String> ans = new ArrayList<>();

        String[] keys = new String[map.size()];
        map.keySet().toArray(keys);
        Arrays.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer n1 = map.get(o1);
                Integer n2 = map.get(o2);
                if(o1.length() == o2.length()){
                    if(n1.compareTo(n2) == 0){
                        return o1.compareTo(o2);
                    }else {
                        return n2.compareTo(n1);
                    }
                }else {
                    return  o1.length() - o2.length() ;
                }
            }
        });
        int idx = 0;
        int count = -1;
        for(String key:keys){
            System.out.println(key+" "+map.get(key));
            if(idx==course.length) break;
            if(map.get(key)<2) continue;
            int len = key.length();
            int n = course[idx];
            int value = map.get(key);
//            System.out.println(len+" "+n);
            if(n==len){
                if(count==-1){
                    ans.add(key);
                    count = value;
                }else {
                    if(count==value){
                        ans.add(key);
                    }else {
                        idx++;
                        count = -1;
                    }
                }
            }else{
                count = -1;
                if(len<idx)
                    idx++;
            }

        }
        Collections.sort(ans);
        String[] answer = new String[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }

    static void makeSet(String order, int idx, ArrayList<Character> list) {
        if (idx == order.length()) {
            if (list.size() >= 2) {
                Collections.sort(list);
                StringBuilder course = new StringBuilder();
                for (char c : list) {
                    course.append(c);
                }
                System.out.println(course.toString());
                if (map.containsKey(course.toString())) {
                    map.replace(course.toString(), map.get(course.toString()) + 1);

                } else {
                    map.put(course.toString(), 1);
                }
            }
            return;
        }
        ArrayList<Character> list1 = (ArrayList<Character>) list.clone();
        list1.add(order.charAt(idx));
        makeSet(order, idx + 1, list1);
//        list.remove(list.size() - 1);
        makeSet(order, idx + 1, (ArrayList<Character>) list.clone());
    }

    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        String[] result = solution(orders, course);

        for (String res : result) {
            System.out.print(res + " ");
        }
        System.out.println();
    }
}
