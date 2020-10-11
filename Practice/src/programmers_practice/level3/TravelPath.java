package programmers_practice.level3;

import java.util.*;

public class TravelPath {
    String[] answer;

    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];

        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });

        for (int i = 0; i < tickets.length; i++) {
            System.out.println(tickets[i][0]+","+tickets[i][1]);
        }

        int check[] = new int[tickets.length];
        ArrayList<String> countries = new ArrayList<String>();
        countries.add("ICN");
        search(answer.length, tickets, countries, 1, check, "ICN");

        return answer;
    }
    boolean flag = false;
    public void search(int last, String[][] tickets, ArrayList<String> countries, int idx, int check[], String country) {
        if(flag)
            return;
        if (idx == last) {
            flag = true;
            for (int i = 0; i < countries.size(); i++) {
                answer[i] = countries.get(i);
            }
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (check[i] == 1) continue;
            if (tickets[i][0].equals(country)) {
                check[i] = 1;
                countries.add(tickets[i][1]);

                search(last, tickets, countries, idx + 1, check, tickets[i][1]);
                countries.remove(idx);
                check[i] = 0;
            }
        }
    }
}
