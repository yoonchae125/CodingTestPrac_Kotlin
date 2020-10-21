package programmers_practice.level2_review;

public class SkillTree {
    int answer = 0;

    public int solution(String skill, String[] skill_trees) {

        for(String skill_tree: skill_trees) {
            find(skill, skill_tree);
            System.out.println(skill_tree+":"+answer);
        }

        return answer;
    }
    void find(String skill, String tree){

        char f = skill.charAt(0);
        for(int i=0;i<tree.length();i++) {
            if(tree.charAt(i) == f){
                if(skill.length() == 1){
                    answer++;
                    return;
                }
                String nSkill = skill.substring(1);
                if(tree.length()-1 == i){
                    answer++;
                    return;
                }
                String nTree = tree.substring(i+1);
                find(nSkill, nTree);
                return ;
            }else {
                if(skill.contains(tree.charAt(i)+"")){
                    System.out.println("wrong order");
                    return;
                }
            }
            if(tree.length()-1 == i){
                answer++;
                System.out.println(skill+","+tree+"다 못하고 끝");

                return;
            }
        }
    }
}
