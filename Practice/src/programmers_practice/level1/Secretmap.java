package programmers_practice.level1;

public class Secretmap {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            int a1 = arr1[i];
            int a2 = arr2[i];
            String str=Integer.toBinaryString(a1 | a2);
            System.out.println(str);
            answer[i]="";
            for(int j=0;j<n;j++){
                if(j<n-str.length()){
                    answer[i] += " ";
                }else {
                    if (str.charAt(j-n+str.length()) == '0') {
                        answer[i] += " ";
                    } else {
                        answer[i] += "#";
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
//        5
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
//        출력	["#####","# # #", "### #", "# ##", "#####"]
        String[] ans = solution(6, arr1, arr2);
        for(String a:ans){
            System.out.println(a+" ");
        }
    }
}
