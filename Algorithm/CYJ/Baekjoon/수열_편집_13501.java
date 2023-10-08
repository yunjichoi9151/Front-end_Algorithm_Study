import java.util.LinkedList;
import java.util.Scanner;

public class 수열_편집_13501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 1; tc <= t; tc++) {
            LinkedList<Integer> list = new LinkedList<>();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int l = sc.nextInt();
            for(int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            for(int i = 0; i < m; i++) {
                String c = sc.next();
                int idx = 0;
                int num = 0;
                switch(c) {
                    case "I":
                        idx = sc.nextInt();
                        num = sc.nextInt();
                        list.add(idx, num);
                        break;
                    case "D":
                        idx = sc.nextInt();
                        list.remove(idx);
                        break;
                    case "A":
                        idx = sc.nextInt();
                        num = sc.nextInt();
                        list.set(idx, num);
                        break;
            }
            }
            System.out.println("#" + tc + " " + (l >= list.size() ? -1 : list.get(l)));
        }
        sc.close();
    }
}
