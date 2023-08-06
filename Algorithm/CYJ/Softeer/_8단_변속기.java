import java.util.*;

public class _8단_변속기
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int[] dct = new int[8];
        String answer = "";
        for(int i = 0; i < 8; i++) {
            dct[i] = sc.nextInt();
        }
        if(dct[0] == 1) {
            answer = "ascending";
            for(int i = 1; i < 8; i++) {
                if(dct[i] != dct[i - 1] + 1) {
                    answer = "mixed";
                    break;
                }
            }
        } else if(dct[0] == 8) {
            answer = "descending";
            for(int i = 1; i < 8; i++) {
                if(dct[i] != dct[i - 1] - 1) {
                    answer = "mixed";
                    break;
                }
            }
        } else {
            answer = "mixed";
        }
        System.out.println(answer);
        sc.close();
    }
}