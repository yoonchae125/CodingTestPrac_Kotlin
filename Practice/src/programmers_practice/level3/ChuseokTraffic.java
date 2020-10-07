package programmers_practice.level3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ChuseokTraffic {
    public int solution(String[] lines) {
        int answer = 0;
        List<Long> checkPointList = new ArrayList<Long>();
        List<Log> logList = new ArrayList<Log>();

        for (String line : lines) {
            Log log = new Log(line);
            checkPointList.add(log.getStart());
            checkPointList.add(log.getEnd());
            logList.add(log);
        }

        Collections.sort(checkPointList);

        int top = 0;
        for (int i = 0; i < checkPointList.size(); i++) {
            int count = 0;
            for (Log log : logList) {
                if (log.isIn(checkPointList.get(i), checkPointList.get(i) + 999)) {
                    count++;
                }
            }

            if (count > top) {
                top = count;
            }
        }

        answer = top;
        return answer;
    }

    class Log {
        private long start = 0;
        private long duration = 0;
        private long end = 0;

        public Log(String line) {
            String[] split = line.split(" ");
            String dateString = split[0] + " " + split[1];
            try {
                Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
                this.end = startDate.getTime();

                String[] split2 = split[2].split("s");
                double parseDouble = Double.parseDouble(split2[0]);
                this.duration = (long) (parseDouble * 1000);

                this.start = this.end - this.duration;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public boolean isIn(long checkPointStart, long checkPointEnd) {
            if (this.end < checkPointStart || this.start >= checkPointEnd) {
                return false;
            } else
                return true;
        }

        public long getStart() {
            return start;
        }

        public void setStart(long start) {
            this.start = start;
        }

        public long getDuration() {
            return duration;
        }

        public void setDuration(long duration) {
            this.duration = duration;
        }

        public long getEnd() {
            return end;
        }

        public void setEnd(long end) {
            this.end = end;
        }
    }
}
