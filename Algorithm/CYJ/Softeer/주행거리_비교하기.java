import java.util.*;

public class 주행거리_비교하기
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a == b) {
            System.out.println("same");
        } else {
            System.out.println(a > b ? "A" : "B");
        }
        sc.close();
    }
}
