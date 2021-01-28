package programmers_practice.kakao2021blind;

import java.util.*;

public class SearchRank2 {
    static String[][] con = {
            {"cpp", "java", "python"},
            {"backend", "frontend"},
            {"junior", "senior"},
            {"chicken", "pizza"}
    };

    public static int[] solution(String[] info, String[] query) {
        int[] scores = new int[info.length];
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            String s[] = info[i].split(" ");
            int score = Integer.parseInt(s[4]);
            scores[i] = score;
            StringBuilder sb = new StringBuilder(s[0]);
            for (int j = 1; j < 4; j++) {
                sb.append(" and ").append(s[j]);
            }
            String key = sb.toString();
//            System.out.println(key);
            if (hm.containsKey(key)) {
                hm.get(key).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hm.put(key, list);
            }
        }
        int[] answer = new int[query.length];

        for (int i=0;i<query.length;i++) {
            String s[] = query[i].split(" and ");
            String[] ss = s[3].split(" ");
            s[3] = ss[0];
            int score = Integer.parseInt(ss[1]);
            ArrayList<String> keyList = new ArrayList<>();
            makeQuery(s, 0, new StringBuilder(), keyList);
            HashSet<Integer> set = new HashSet<>();
            for(String key:keyList){
                if(hm.containsKey(key)){
                    set.addAll(hm.get(key));
                }
            }

            if(set.size()==0) {
//                System.out.println(i+": "+"none");
                continue;
            }
            if(set.size()==1){
                Integer[] array = new Integer[set.size()];
                set.toArray(array);
                if(scores[array[0]]>=score){
                    answer[i] = 1;
                }
                continue;
            }

            Integer[] array = new Integer[set.size()];
            set.toArray(array);
            // 점수로 정렬
            Arrays.sort(array, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return scores[o1] - scores[o2];
                }
            });
//            System.out.println(i+": "+score);
//            for(int a:array){
//                System.out.print(a+"- "+scores[a]+", ");
//            }
//            System.out.println();
            int left = 0;
            int right = array.length - 1;
            int mid = 0;
            boolean flag = false;
//            System.out.println("size "+list.size());
            while (left <= right) {
                mid = (left + right) / 2;
//                System.out.println(mid);
                if (scores[array[mid]] == score) {
                    while (true) {
                        if (mid - 1 >= 0 && scores[array[mid - 1]] == score) {
                            mid--;
                        } else {
                            break;
                        }
                    }
                    flag = true;
                    break;
                } else if (scores[array[mid]] < score) {
                    if (mid + 1 < array.length && scores[array[mid + 1]] >= score) {
                        mid++;
                        flag = true;
                        break;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (mid - 1 < 0) {
                        flag = true;
                        break;
                    } else if (scores[array[mid - 1]] < score) {
                        flag = true;
                        break;
                    } else {
                        right = mid - 1;
                    }
                }
            }
//            System.out.println(i+" "+flag+" mid "+mid);
            if (!flag) {
//                System.out.println("no mid");
                continue;
            }
//            System.out.println("len= "+array.length+" mid= "+mid);
            answer[i] = array.length - mid;

        }
        return answer;
    }

    public static void makeQuery(String[] conditions, int idx, StringBuilder sb, ArrayList<String> keyList) {
        if (idx == 4) {
//            System.out.println("key " + sb.toString());
            keyList.add(sb.toString());
            return;
        }
        if (conditions[idx].equals("-")) {
            for (int i = 0; i < con[idx].length; i++) {
                StringBuilder sb1 = new StringBuilder(sb);
                makeQuery(conditions, idx + 1, sb.length() == 0 ? sb1.append(con[idx][i]) : sb1.append(" and ").append(con[idx][i]), keyList);
            }
        }else{
            StringBuilder sb2 = new StringBuilder(sb);
            makeQuery(conditions, idx + 1, sb.length() == 0 ? sb2.append(conditions[idx]) : sb2.append(" and ").append(conditions[idx]), keyList);
        }

    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] ans = solution(info, query);
        for (int a : ans) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
