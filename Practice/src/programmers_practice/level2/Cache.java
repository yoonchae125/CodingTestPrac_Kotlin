package programmers_practice.level2;

import java.util.ArrayList;

public class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        for(int i=0;i<cities.length;i++){
            cities[i] = cities[i].toLowerCase();
        }
        ArrayList<String> cache = new ArrayList<>();
        for (String city : cities) {
            if (cache.contains(city)) {
                answer += 1;
                cache.remove(city);
                cache.add(city);
            } else {
                answer += 5;
                cache.add(city);
                if (cache.size() > cacheSize)
                    cache.remove(0);
            }
        }
        return answer;
    }
}
