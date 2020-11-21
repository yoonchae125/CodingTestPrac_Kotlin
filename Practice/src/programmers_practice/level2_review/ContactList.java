package programmers_practice.level2_review;

public class ContactList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for(int i=0;i<phone_book.length;i++){
            for(int j=i+1;j<phone_book.length;j++){
                if(phone_book[i].startsWith(phone_book[j])) return false;
                if(phone_book[j].startsWith(phone_book[i])) return false;
            }
        }

        return answer;
    }
}
