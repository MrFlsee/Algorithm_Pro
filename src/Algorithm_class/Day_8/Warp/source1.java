package Algorithm_class.Day_8.Warp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class source1 {
    static int n,m;
    static ArrayList<pair>[] adj = new ArrayList[121212];
    static long[] dist = new long[121212];
    static class pair implements Comparable{
        int n;
        long cost;

        public pair(int n, long cost){
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Object o) {
            return (this.cost - ((pair)o).cost > 0)? 1 : -1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());
        m = Integer.parseInt(s.nextToken());

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        Arrays.fill(dist, (long) 1e19);

        for (int i = 0; i < m; i++) {
            s = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(s.nextToken());
            int b = Integer.parseInt(s.nextToken());
            int c = Integer.parseInt(s.nextToken());

            adj[a].add(new pair(b, c));
        }

        Queue<pair> que = new PriorityQueue<>();
        que.offer(new pair(1, 0));
//        dist[1] = 0;
        while (!que.isEmpty()) {
            pair cur = que.poll();

            if (cur.cost > dist[cur.n]) {
                continue;
            }

            for (pair next : adj[cur.n]) {
                if (dist[next.n] > cur.cost + next.cost) {
                    dist[next.n] = cur.cost + next.cost;
                    next.cost = dist[next.n];
                    que.offer(next);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (dist[n] == (long) 1e19) {
            bw.write("-1\n");
        } else {
            bw.write(String.valueOf(dist[n]+"\n"));
        }

        bw.flush();
        bw.close();
    }
}
