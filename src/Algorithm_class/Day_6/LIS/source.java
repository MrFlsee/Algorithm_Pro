package Algorithm_class.Day_6.LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
    static int n;
    static int[] a = new int[312121];
    static int[] d = new int[312121];
    static int[] f = new int[312121];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer s = new StringTokenizer(br.readLine());
        f[0] = (int) -1e9;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s.nextToken());

            f[binarySearch(0, i, a[i])] = a[i];
        }

        System.out.println(Arrays.toString(f));


        System.out.println(ans);
    }

    private static int binarySearch(int s, int e, int v) {
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (f[mid] <= v) {
                break;
            } else if (f[mid] < v) {
                e = mid - 1;
            }
        }

        return mid;
    }
}
