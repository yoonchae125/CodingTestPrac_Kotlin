package programmers_practice.level2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Paper> printer = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            printer.add(new Paper(i, priorities[i]));
        }

        int turn = 0;
        while (!printer.isEmpty()) {
            Iterator<Paper> it = printer.iterator();
            int priority = printer.peek().priority;
            boolean flag = false;
            while (it.hasNext()) {
                Paper paper = it.next();
                if (paper.priority > priority) {
                    printer.add(printer.poll());
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            Paper p = printer.poll();
            turn++;
            if (p.id == location) {
                return turn;
            }
        }
        return answer;
    }

    class Paper {
        int id;
        int priority;

        Paper(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
}
