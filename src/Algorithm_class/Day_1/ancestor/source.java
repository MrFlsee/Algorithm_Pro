package Algorithm_class.Day_1.ancestor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
    static int N, R, Q;
    static ArrayList<Integer>[] tree;
    static int[] S, E;
    static int[] name;
    static int cnt = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(st.nextToken());

            if (i != R) {
                tree[a].add(i);
            }
        }

//        for (int i = 1; i <= N; i++) {
//            System.out.println(tree[i]);
//        }
        S = new int[20];
        E = new int[20];
        name = new int[20];

        dfs(R);

        System.out.println(Arrays.toString(S));
        System.out.println(Arrays.toString(E));
        System.out.println(Arrays.toString(name));

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (S[a] <= name[b] && name[b] <= E[a]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    private static void dfs(int w) {

        S[w] = cnt;
        name[w] = cnt++;

        for (Integer next : tree[w]) {
            dfs(next);
        }

        E[w] = cnt - 1;

    }
}
