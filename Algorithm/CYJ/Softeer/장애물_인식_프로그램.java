import java.util.*;
import java.io.*;

public class 장애물_인식_프로그램
{
    static int cnt = 1;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 2][n + 2];
        int[][] check = new int[n + 2][n + 2];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            String[] tmp = br.readLine().split("");
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(tmp[j - 1]);
            }
        }
        for(int i = 0; i < n + 2; i++) {
            for(int j = 0; j < n + 2; j++) {
                if(map[i][j] == 1 && check[i][j] == 0) {
                    dfs(map, check, i, j, n);
                    list.add(cnt);
                    cnt = 1;
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        br.close();
    }

    public static void dfs(int[][] map, int[][] check, int i, int j, int n) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        check[i][j] = 1;
        int x, y;
        for(int k = 0; k < 4; k++) {
            x = i + dx[k];
            y = j + dy[k];
            if(x >= 0 && x <= n + 1 && y >= 0 && y <= n + 1) {
                if(map[x][y] == 1 && check[x][y] == 0) {
                    cnt++;
                    dfs(map, check, x, y, n);
                }
            }
        }
    }
}
