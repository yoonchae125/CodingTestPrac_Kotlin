package programmers_practice.level2_review;

import java.util.ArrayList;

public class SkillTree2 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<Character> skills = new ArrayList();
        for(char c:skill.toCharArray()){
            skills.add(c);
        }
        for(String s:skill_trees){
            int idx=0;
            boolean flag = true;
            for(char c:s.toCharArray()){
                if(skill.contains(c+"")){
                    if(c != skills.get(idx)){
                        flag = false;
                        break;
                    }else{
                        idx++;
                    }
                }
            }
            if(flag){
                answer++;
            }
        }

        return answer;
    }
}
