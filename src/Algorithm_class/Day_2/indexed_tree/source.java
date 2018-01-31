package Algorithm_class.Day_2.indexed_tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class source {
    static int N, Q;
    static long[] arr, tree;
    static int tn;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Q = Integer.parseInt(br.readLine());
        arr = new long[N + 1];

        for (int i = 0; i < 100000; i++) {
            int pow = (int) Math.pow(2, i);
            if (pow >= N) {
                tn = pow;
                break;
            }
        }

        tree = new long[N * 5];

        for (int i = 1; i <= N; i++) {
            insert(i, i);
        }

        for (int i = 0; i < Q; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            if (a == 0) {
                // 아마 가져와서 바꿔야할 거 같은데
                long get = search(b, b);


                insert(b, c - (int) get);
            } else {
                bw.write(String.valueOf(search(b, c)) + "\n");
//                System.out.println(ret);
            }
        }

        bw.flush();
        bw.close();
    }

    static long search(int s, int e) {
        long res = 0;
        s = s + tn - 1;
        e = e + tn - 1;

        while (s <= e) {
            if (s % 2 == 1) {
                res += tree[s];
                s++;
            }

            if (e % 2 == 0) {
                res += tree[e];
                e--;
            }

            s /= 2;
            e /= 2;
        }
        return res;
    }

    private static void insert(int w, int g) {
        for (int i = tn + w - 1; i > 0; i /= 2) {
            tree[i] += g;
        }
    }
}