package programmers_practice.level1;

public class Keypad {
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] keypad = new int[12][12];
        keypad[10][2] = 4;
        keypad[10][5] = 3;
        keypad[10][8] = 2;
        keypad[10][0] = 1;
        keypad[1][2] = 1;
        keypad[1][5] = 2;
        keypad[1][8] = 3;
        keypad[1][0] = 4;
        keypad[4][2] = 2;
        keypad[4][5] = 1;
        keypad[4][8] = 2;
        keypad[4][0] = 3;
        keypad[7][2] = 3;
        keypad[7][5] = 2;
        keypad[7][8] = 1;
        keypad[7][0] = 2;

        keypad[11][2] = 4;
        keypad[11][5] = 3;
        keypad[11][8] = 2;
        keypad[11][0] = 1;
        keypad[3][2] = 1;
        keypad[3][5] = 2;
        keypad[3][8] = 3;
        keypad[3][0] = 4;
        keypad[6][2] = 2;
        keypad[6][5] = 1;
        keypad[6][8] = 2;
        keypad[6][0] = 3;
        keypad[9][2] = 3;
        keypad[9][5] = 2;
        keypad[9][8] = 1;
        keypad[9][0] = 2;

        keypad[2][5] = 1;
        keypad[2][8] = 2;
        keypad[2][0] = 3;
        keypad[5][2] = 1;
        keypad[5][8] = 1;
        keypad[5][0] = 2;
        keypad[8][2] = 2;
        keypad[8][5] = 1;
        keypad[8][0] = 1;
        keypad[0][2] = 3;
        keypad[0][5] = 2;
        keypad[0][8] = 1;
        int right = 11;
        int left = 10;
        for (int num : numbers) {
            if(num == 1 || num ==4|| num==7){
                left = num;
                answer+="L";
            }else if(num == 3 || num ==6|| num==9){
                right = num;
                answer+="R";
            }else{
                int l = keypad[left][num];
                int r = keypad[right][num];
                if(l>r){
                    right = num;
                    answer+="R";
                }else if(r>l){
                    left = num;
                    answer+="L";
                }else{
                    if(hand.equals("right")){
                        right = num;
                        answer+="R";
                    }else{
                        left = num;
                        answer+="L";
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String result = solution(numbers, "right");
        System.out.println(result);
    }
}
