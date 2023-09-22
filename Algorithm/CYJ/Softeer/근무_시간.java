import java.util.*;

public class 근무_시간 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        for(int t = 0; t < 5; t++) {
            String start_str = sc.next();
            String[] startTime = start_str.split(":");
            String end_str = sc.next();
            String[] endTime = end_str.split(":");

            int startHour = Integer.parseInt(startTime[0]);
            int startMinute = Integer.parseInt(startTime[1]);
            int endHour = Integer.parseInt(endTime[0]);
            int endMinute = Integer.parseInt(endTime[1]);

            answer += (endHour * 60 + endMinute) - (startHour * 60 + startMinute);
        }
        System.out.println(answer);
        sc.close();
    }
}