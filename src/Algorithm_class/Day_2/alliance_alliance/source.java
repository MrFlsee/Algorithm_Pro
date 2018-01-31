package Algorithm_class.Day_2.alliance_alliance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    static int N, Q;
    static int[] Set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Q = Integer.parseInt(br.readLine());

        Set = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            Set[i] = i;
        }
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0) {
                union(b, c);
            } else {
                int B = find(b);
                int C = find(c);

                if (B == C) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
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
