package programmers_practice.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SaveFileName {
    public String[] solution(String[] files) {
        ArrayList<File> fileList = new ArrayList<>();
        for(String file:files){
            boolean flag = false;
            File f = new File();
            for(int i=0;i<file.length();i++){
                char c = file.charAt(i);
                if(!flag){
                    if(Character.isDigit(c)){
                        flag = true;
                        f.number+=c;
                    }else{
                        f.head+=c;
                    }
                }else {
                    if(Character.isDigit(c)){
                        flag = true;
                        f.number+=c;
                    }else{
                        f.tail = file.substring(i,file.length());
                        break;
                    }
                }
            }
            fileList.add(f);
//            System.out.println(f.head+" "+f.number+" "+f.tail);
        }
        Collections.sort(fileList, new File());
        String[] answer = new String[fileList.size()];

        for(int i=0; i<answer.length;i++){
//            System.out.println(f.toString());
            answer[i] = fileList.get(i).toString();
        }
        return answer;
    }
    class File implements Comparator<File> {
        String head="";
        String number="";
        String tail="";

        @Override
        public String toString(){
            return head+number+tail;
        }
        @Override
        public int compare(File f1, File f2) {
            if(f1.head.toLowerCase().compareTo(f2.head.toLowerCase())<0){
                return -1;
            }else if(f1.head.toLowerCase().compareTo(f2.head.toLowerCase())==0){
                int i1 = Integer.parseInt(f1.number);
                int i2 = Integer.parseInt(f2.number);
                return i1-i2;
            }else{
                return 1;
            }
        }
    }
}
