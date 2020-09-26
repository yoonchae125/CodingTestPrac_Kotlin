package programmers_practice.level2;

import java.util.HashMap;

public class EnglishConnectWord {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int count = 0;
        boolean flag = false;
        HashMap<String, Integer> wordMap = new HashMap<>();
        String prev = words[0].charAt(0) + "";
        for (String word : words) {
            count++;
            if (prev.charAt(prev.length() - 1) != word.charAt(0)) {
                flag = true;
                break;
            }
            prev = word;
            if (wordMap.get(word) == null) {
                wordMap.put(word, 1);
            } else {
                flag = true;
                break;
            }
        }

        System.out.println(count);
        if (flag) {
            answer[0] = (count - 1) % n + 1;
            answer[1] = (count - 1) / n + 1;
        }
        return answer;
    }
}
