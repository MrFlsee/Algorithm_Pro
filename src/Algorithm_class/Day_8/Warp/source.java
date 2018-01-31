package Algorithm_class.Day_8.Warp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class source {
    static int n, m;
    static ArrayList<Integer>[] adj = new ArrayList[121212];
    static long[] dist = new long[121212];
    static boolean[] visited = new boolean[121212];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());
        m = Integer.parseInt(s.nextToken());

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            s = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(s.nextToken());
            int b = Integer.parseInt(s.nextToken());
            int c = Integer.parseInt(s.nextToken());

            adj[a].add(b);
            adj[a].add(c);
        }

        Arrays.fill(dist, (long) 1e19);

        Queue<Integer> que = new PriorityQueue<>();
        que.offer(1);
        dist[1] = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();
            visited[cur] = true;

            ArrayList<Integer> list = adj[cur];
            int len = list.size() / 2;
            for (int i = 0; i < len; i++) {
                int next = list.get(i);
                if (!visited[next]) {
                    int nCost = list.get(i + 1);

                    if (dist[next] > nCost + dist[cur]) {
                        dist[next] = nCost + dist[cur];
                        que.offer(next);
                    }
                }

            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (dist[n] == (long) 1e19) {
            bw.write("-1\n");
        } else {
            bw.write(String.valueOf(dist[n]) + "\n");
        }
        bw.flush();
        bw.close();

    }
}
