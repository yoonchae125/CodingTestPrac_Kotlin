package programmers_practice.level2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
//        "CBD"	["BACDE", "CBADF", "AECB", "BDA"]
        for (String skill_tree : skill_trees) {
            Queue<Character> skillQueue = new LinkedList<>();
            for (int i = 0; i < skill.length(); i++) {
                skillQueue.add(skill.charAt(i));
            }
            for (int i = 0; i < skill_tree.length(); i++) {
                if(skillQueue.isEmpty()){
                    System.out.println(skill_tree);
                    answer++;
                    break;
                }
                int ch = skill_tree.charAt(i);
                int sk = skillQueue.peek();
                if(ch==sk){
                    skillQueue.poll();
                }else{
                    // skillQueue에 있으면 안됨
                    Iterator<Character> it = skillQueue.iterator();
                    Boolean flag = false;
                    while(it.hasNext()){
                        if(it.next() == ch){
                            flag = true;
                            break;
                        }
                    }
                    if(flag){
                        break;
                    }
                }
                if(i == skill_tree.length()-1){
                    answer++;
                }
           }
        }
        return answer;
    }
}
