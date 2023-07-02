import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n,m,r;
    public static int[] itemList;
    public static int[][] townMap;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        r = Integer.parseInt(stringTokenizer.nextToken());

        itemList = new int[n+1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= n; i++) {
            itemList[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        
        townMap = new int[n+1][n+1];
        for (int i = 0; i < r; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int ep1 = Integer.parseInt(stringTokenizer.nextToken());
            int ep2 = Integer.parseInt(stringTokenizer.nextToken());
            int distance = Integer.parseInt(stringTokenizer.nextToken());

            townMap[ep1][ep2] = distance;
            townMap[ep2][ep1] = distance;
        }

        result = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int[] visited = new int[n+1];
            bfs(i,visited);
        }

        Arrays.sort(result);
        System.out.println(result[n]);
    }

    private static void bfs(int start, int[] visited) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(start);
        int totalItem = itemList[start];

        while (!queue.isEmpty()){
            int now = queue.poll();

            for (int i = 1; i <= n; i++) {
                if(i == start || townMap[now][i] == 0 || visited[now] + townMap[now][i] > m) continue;

                if(visited[i] >= visited[now] + townMap[now][i]) {
                    visited[i] = visited[now] + townMap[now][i];
                    continue;
                }
                if(visited[i] > 0) continue;

                visited[i] = visited[now] + townMap[now][i];
                queue.add(i);
                totalItem += itemList[i];
            }
        }

        result[start] = totalItem;
    }
}
