package Algorithm_class.Day_10.Interstella;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int T;
    static int n, m, k;
    static class pair implements Comparable<pair>{
        int n;
        long dist;
        int p;

        public pair(int n, long dist, int p) {
            this.n = n;
            this.dist = dist;
            this.p = p;
        }

        @Override
        public int compareTo(pair o) {
            return this.dist - o.dist > 0 ? 1 : -1;
        }

    }
    static ArrayList<pair>[] adj = new ArrayList[121212];
    static long[][] dist = new long[3][121212];
    static boolean[] visited = new boolean[121212];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

//            for (int i = 1; i <= n; i++) {
//                adj[i] = new ArrayList<>();
//            }
            for (int i = 0; i < 3; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = -1;
                }
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (adj[u] == null) {
                    adj[u] = new ArrayList<>();
                }
                if (adj[v] == null) {
                    adj[v] = new ArrayList<>();
                }
                adj[u].add(new pair(v, c, 0));
                adj[v].add(new pair(u, c, 0));
            }
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            Queue<pair> pq = new PriorityQueue<>();
            pq.add(new pair(s, 0, 0));
            dist[0][s] = 0;

            while (!pq.isEmpty()) {
                pair here = pq.poll();

                if(dist[here.p][here.n] != here.dist)
                    continue;

                for (pair there : adj[here.n]) {
                    if (dist[here.p][there.n] == -1 || dist[here.p][there.n] > here.dist + there.dist) {
                        dist[here.p][there.n] = here.dist + there.dist;
                        pq.offer(new pair(there.n, here.dist + there.dist, here.p));
                    }

                    if (here.p < 2 && (dist[here.p + 1][there.n] == -1 || dist[here.p + 1][there.n] > here.dist + 1)) {
                        dist[here.p+1][there.n] = here.dist + 1;
                        pq.offer(new pair(there.n, here.dist + 1, here.p + 1));
                    }
                }
            }

//            for (int i = 0; i <= 2; i++) {
//                for (int j = 1; j <= n; j++) {
//                    System.out.printf("%3d", dist[i][j]);
//                }
//                System.out.println();
//            }
//
//            System.out.println();

//            long ans = (long) 1e19;
//            for (int i = 0; i <= k; i++) {
//                if (ans > dist[i][e]) {
//                    ans = dist[i][e];
//                }
//            }

            bw.write("#" + t + " " + String.valueOf(dist[k][e]) + "\n");
        }
        bw.flush();
        bw.close();

    }
}
