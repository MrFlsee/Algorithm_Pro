package Algorithm_class.Day_2.represent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class source {
    static int N, M;
    static int[] arr;
    static int tn;
    static long[] tree, minTree, maxTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (tn = 1; tn < N; tn *= 2) {
        }

        arr = new int[N + 1];
        tree = new long[414141];
        minTree = new long[414141];
        maxTree = new long[414141];
        StringTokenizer s = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(s.nextToken());
            insert(i, arr[i]);
        }

//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(tree));
//        System.out.println(Arrays.toString(minTree));
//        System.out.println(Arrays.toString(maxTree));

        M = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < M; i++) {
            s = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(s.nextToken());
            int b = Integer.parseInt(s.nextToken());

            bw.write(String.valueOf(searchMin(a, b)) + " " + String.valueOf(searchMax(a, b)) + " " + String.valueOf(search(a, b) + "\n"));
        }

        bw.flush();
        bw.close();

    }

    private static long searchMax(int s, int e) {
        long res = 0;


        s = tn + s - 1;
        e = tn + e - 1;

        while (s <= e) {
            if (s % 2 == 1) {
                if(res < maxTree[s])
                    res = maxTree[s];

                s++;
            }

            if (e % 2 == 0) {
                if(res < maxTree[e])
                    res = maxTree[e];

                e--;
            }

            s /= 2;
            e /= 2;

        }

        return res;
    }

    private static long searchMin(int s, int e) {
        long res = 0;

        s = tn + s - 1;
        e = tn + e - 1;

        while (s <= e) {
            if (s % 2 == 1) {
                if(minTree[s] != 0 && (res == 0 || res > minTree[s]))
                    res = minTree[s];

                s++;
            }

            if (e % 2 == 0) {
                if(minTree[e] != 0 && (res == 0 || res > minTree[e]))
                    res = minTree[e];

                e--;
            }

            s /= 2;
            e /= 2;
        }


        return res;
    }

    private static long search(int s, int e) {
        long res = 0;
        s = tn + s - 1;
        e = tn + e - 1;

        while (s <= e) {
            if (s % 2 != 0) {
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

            if (minTree[i] == 0 || minTree[i] > g)
                minTree[i] = g;

            if (maxTree[i] < g)
                maxTree[i] = g;
        }
    }
}
