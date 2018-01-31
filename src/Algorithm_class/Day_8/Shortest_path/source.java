package Algorithm_class.Day_8.Shortest_path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class source {
    static int n, m;
    static ArrayList<Pair>[] adj = new ArrayList[121212];
    static long[] dist = new long[121212];

    static class Pair implements Comparable {
        int n;
        long dist;

        public Pair(int n, long dist) {
            this.n = n;
            this.dist = dist;
        }

        @Override
        public int compareTo(Object o) {
            return (this.dist - ((Pair) o).dist > 0) ? 1 : -1;
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

        for (int i = 0; i < m; i++) {
            s = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(s.nextToken());
            int b = Integer.parseInt(s.nextToken());
            int c = Integer.parseInt(s.nextToken());

            adj[a].add(new Pair(b, c));
            adj[b].add(new Pair(a, c));
        }

        Arrays.fill(dist, (long) 1e19);
        Queue<Pair> que = new PriorityQueue<>();

        que.offer(new Pair(1, 0));
//        dist[1] = 0;
        while (!que.isEmpty()) {
            Pair cur = que.poll();

//            if (dist[cur.n] < cur.dist) {
//                continue;
//            }

            for (Pair next : adj[cur.n]) {
                if (dist[next.n] > cur.dist + next.dist) {
                    dist[next.n] = cur.dist + next.dist;
                    next.dist = dist[next.n];
                    que.offer(next);
                }
            }
        }
//        for (int i = 0; i <= n; i++) {
//            System.out.printf("%3d", dist[i]);
//        }
//        System.out.println();

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
