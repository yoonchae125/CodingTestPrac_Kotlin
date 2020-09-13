package kakao_2019_blind;

import java.util.ArrayList;

public class Mukbang {
    public int solution(int[] food_times, long k) {
//        [3, 1, 2]
        int answer = 0;

        ArrayList<Food> foods = new ArrayList();
        for(int i=0;i<food_times.length;i++){
            foods.add(new Food(i+1, food_times[i]));
        }
        int i = 0;
        while(k-->0L){
            if(foods.size()==0) return -1;
            if(foods.get(i).left==1){
                foods.remove(i);
                if(i>foods.size()-1)
                    i=0;
            }else{
                foods.get(i).left = foods.get(i).left-1;
                i++;
                if(i>foods.size()-1)
                    i=0;
            }
            for(Food f:foods){
                System.out.print(f.idx+":"+f.left+", ");
            }
            System.out.println();
        }

        if(foods.size()==0) return -1;
        answer = foods.get(i).idx;
        return answer;
    }
    class Food{
        int idx;
        long left;
        Food(int idx, int left){
            this.idx = idx;
            this.left = left;
        }
    }
}
