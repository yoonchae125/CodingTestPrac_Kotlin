package programmers_practice.kakao2021blind;

import java.util.*;

public class SearchRank {
    //              조건               지원자
    static HashMap<String, ArrayList<Integer>> hm = new HashMap<>();

    public static void makeQuery(String[] conditions, int id, int idx, StringBuilder sb) {

        if (idx == 4) {
//            System.out.println(sb.toString());
            if (hm.containsKey(sb.toString())) {
                hm.get(sb.toString()).add(id);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(id);
                hm.put(sb.toString(), list);
            }
            return;
        }
        StringBuilder sb1 = new StringBuilder(sb);
        makeQuery(conditions, id, idx + 1, sb.length() == 0 ? sb1.append(conditions[idx]) : sb1.append(" and ").append(conditions[idx]));
        StringBuilder sb2 = new StringBuilder(sb);
        makeQuery(conditions, id, idx + 1, sb.length() == 0 ? sb2.append("-") : sb2.append(" and -"));
    }

    public static int[] solution(String[] info, String[] query) {
//        코딩테스트 참여 개발언어 항목에 cpp, java, python 중 하나를 선택해야 합니다.
//        지원 직군 항목에 backend와 frontend 중 하나를 선택해야 합니다.
//        지원 경력구분 항목에 junior와 senior 중 하나를 선택해야 합니다.
//        선호하는 소울푸드로 chicken과 pizza 중 하나를 선택해야 합니다.


        int[] scores = new int[info.length];
        for (int i = 0; i < info.length; i++) {
            String[] strs = info[i].split(" ");
            makeQuery(strs, i, 0, new StringBuilder());
            scores[i] = Integer.parseInt(strs[4]);
        }

        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            int findIdx;
            for (findIdx = query[i].length() - 1; findIdx >= 0; findIdx--) {
                if (query[i].charAt(findIdx) == ' ') {
                    break;
                }
            }
            String q = query[i].substring(0, findIdx);
            int score = Integer.parseInt(query[i].substring(findIdx + 1));
            ArrayList<Integer> list = hm.get(q);

            if (list == null || list.size() == 0) {
                continue;
            }
            if (list.size() == 1) {
                if (scores[list.get(0)] >= score) {
                    answer[i] = 1;
                }
                continue;
            }
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return scores[o1] - scores[o2];
                }
            });
            if (scores[list.get(0)] >= score) {
                answer[i] = list.size();
                continue;
            }
            if (scores[list.get(list.size() - 1)] < score) {
                continue;
            }
//            for (int l : list) {
//                System.out.println(l + " " + scores[l]);
//            }
            int left = 0;
            int right = list.size() - 1;

            while(left < right) {
                int mid = (left + right) / 2;

                if(scores[list.get(mid)] >= score) {
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }
            answer[i] = list.size() - right;
        }

        return answer;
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
