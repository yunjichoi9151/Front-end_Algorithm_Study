import java.util.*;
import java.io.*;

public class 금고털이
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);
        for(int i = 0; i < n; i++) {
            if(w <= arr[i][0]) {
                ans += w * arr[i][1];
                break;
            } else {
                ans += arr[i][0] * arr[i][1];
                w -= arr[i][0];
            }
        }
        System.out.println(ans);

    }
}