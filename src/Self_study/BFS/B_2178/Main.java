package Self_study.BFS.B_2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] a = new int[121][121];
    static int[][] dist = new int[121][121];
    static boolean[][] visited = new boolean[121][121];

    static class xy {
        int x, y;

        public xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());
        m = Integer.parseInt(s.nextToken());

        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= m; j++) {
                a[i][j] = tmp.charAt(j - 1) - '0';
            }
        }

        Queue<xy> que = new LinkedList<>();
        que.offer(new xy(1, 1));
        dist[1][1] = 1;
        visited[1][1] = true;
        while (!que.isEmpty()) {
            xy cur = que.poll();
            int d = dist[cur.y][cur.x];
            if (a[cur.y][cur.x - 1] == 1 && !visited[cur.y][cur.x - 1]) {
                visited[cur.y][cur.x - 1] = true;
                dist[cur.y][cur.x - 1] = d + 1;
                que.offer(new xy(cur.x - 1, cur.y));
            }

            if (a[cur.y - 1][cur.x] == 1 && !visited[cur.y - 1][cur.x]) {
                visited[cur.y - 1][cur.x] = true;
                dist[cur.y - 1][cur.x] = d + 1;
                que.offer(new xy(cur.x, cur.y - 1));
            }

            if (a[cur.y][cur.x + 1] == 1 && !visited[cur.y][cur.x + 1]) {
                visited[cur.y][cur.x + 1] = true;
                dist[cur.y][cur.x + 1] = d + 1;
                que.offer(new xy(cur.x + 1, cur.y));
            }

            if (a[cur.y + 1][cur.x] == 1 && !visited[cur.y + 1][cur.x]) {
                visited[cur.y + 1][cur.x] = true;
                dist[cur.y + 1][cur.x] = d + 1;
                que.offer(new xy(cur.x, cur.y + 1));
            }
        }

        /*for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }*/

        System.out.println(dist[n][m]);
    }
}
