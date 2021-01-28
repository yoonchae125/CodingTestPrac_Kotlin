package programmers_practice.kakao2021blind;

import java.util.*;

public class MenuRenewal {
    static HashMap<String, Integer>[] map;

    public static String[] solution(String[] orders, int[] course) {

        map = new HashMap[course.length];
        for (int i = 0; i < course.length; i++) {
            map[i] = new HashMap<>();
        }
        for (String order : orders) {
            makeSet(order, 0, new ArrayList<Character>(), course);
        }
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            if (map[i].size() == 0) continue;
            String[] keys = new String[map[i].size()];
            map[i].keySet().toArray(keys);
            int idx = i;
            Arrays.sort(keys, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    Integer n1 = map[idx].get(o1);
                    Integer n2 = map[idx].get(o2);
                    if (o1.length() == o2.length()) {
                        if (n1.compareTo(n2) == 0) {
                            return o1.compareTo(o2);
                        } else {
                            return n2.compareTo(n1);
                        }
                    } else {
                        return o1.length() - o2.length();
                    }
                }
            });
            int max = map[i].get(keys[0]);
            if (max < 2) continue;
            for (String key : keys) {
                if (map[i].get(key) == max) {
                    ans.add(key);
                } else {
                    break;
                }
            }
        }

        Collections.sort(ans);
        String[] answer = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }

    static void makeSet(String order, int idx, ArrayList<Character> list, int[] course) {
        if (idx == order.length()) {
            if (list.size() >= 2) {
//                boolean flag = false;
                int courseIdx = -1;
                for (int i = 0; i < course.length; i++) {
                    if (list.size() == course[i]) {
                        courseIdx = i;
                        break;
                    }
                }
                if (courseIdx == -1)
                    return;
                Collections.sort(list);
                StringBuilder courses = new StringBuilder();
                for (char c : list) {
                    courses.append(c);
                }

                if (map[courseIdx].containsKey(courses.toString())) {
                    map[courseIdx].replace(courses.toString(), map[courseIdx].get(courses.toString()) + 1);

                } else {
                    map[courseIdx].put(courses.toString(), 1);
                }
            }
            return;
        }
        ArrayList<Character> list1 = (ArrayList<Character>) list.clone();
        list1.add(order.charAt(idx));
        makeSet(order, idx + 1, list1, course);
        makeSet(order, idx + 1, (ArrayList<Character>) list.clone(), course);
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
