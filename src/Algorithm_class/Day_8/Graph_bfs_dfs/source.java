package Algorithm_class.Day_8.Graph_bfs_dfs;

import java.io.*;
import java.util.*;

public class source {
    static int v, e, s;
    static ArrayList<Integer>[] adj = new ArrayList[21212];
    static boolean[] visited = new boolean[21212];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= v; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        for (int i = 1; i <= v; i++) {
            Collections.sort(adj[i]);
        }
        dfs(s);
        Arrays.fill(visited, false);
        System.out.println();
        bfs();
    }

    private static void dfs(int s) {
        System.out.printf("%d ", s);
        visited[s] = true;

        for (Integer next : adj[s]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> que = new LinkedList<>();

        que.add(s);
        visited[s] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            bw.write(String.valueOf(cur) + " ");

            for (Integer next : adj[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.offer(next);
                }
            }
        }

        bw.write("\n");
        bw.flush();

    }
}
