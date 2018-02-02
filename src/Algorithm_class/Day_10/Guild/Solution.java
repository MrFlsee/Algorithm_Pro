package Algorithm_class.Day_10.Guild;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int T;
    static int n, m;
    static int[] Set = new int[121212];
    static ArrayList<Integer>[] adj = new ArrayList[121212];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            n = Integer.parseInt(s.nextToken());
            m = Integer.parseInt(s.nextToken());

            for (int i = 1; i <= n; i++) {
                Set[i] = i;
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                s = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(s.nextToken());
                int b = Integer.parseInt(s.nextToken());

                adj[a].add(b);
                adj[b].add(a);

                union(a, b);
            }

            int q = Integer.parseInt(br.readLine());
            for (int i = 0; i < q; i++) {
                s = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(s.nextToken());
                if (a == 1) {

                } else { //q
                    int b = Integer.parseInt(s.nextToken());
                    int c = Integer.parseInt(s.nextToken());

                    if (find(b) == find(c)) {
                        bw.write("1");
                    } else {
                        bw.write("0");
                    }
                }

            }

        }

        bw.flush();
        bw.close();
    }

    private static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A != B) {
            Set[A] = B;
        }
    }

    private static int find(int n) {
        if (Set[n] == n) {
            return n;
        }

        return Set[n] = find(Set[n]);
    }
}
