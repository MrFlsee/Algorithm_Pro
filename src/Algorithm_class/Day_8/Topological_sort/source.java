package Algorithm_class.Day_8.Topological_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class source {
    static int v, e;
    static ArrayList<Integer>[] adj = new ArrayList[51212];
    static int[] in = new int[51212];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine());
        v = Integer.parseInt(s.nextToken());
        e = Integer.parseInt(s.nextToken());

        for (int i = 1; i <= v; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            s = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(s.nextToken());
            int b = Integer.parseInt(s.nextToken());

            adj[a].add(b);
            in[b]++;
        }

        Queue<Integer> que = new PriorityQueue<>();
        for (int i = 1; i <= v; i++) {
            if(in[i] == 0)
                que.offer(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (!que.isEmpty()) {
            int cur = que.poll();

            bw.write(String.valueOf(cur) + " ");
            for (Integer next : adj[cur]) {
                in[next]--;

                if (in[next] == 0) {
                    que.offer(next);
                }
            }
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
