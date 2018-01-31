package Algorithm_class.Day_1.house_by_jieun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class source {
    static int X, N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine()) * 10000000;
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = -1;
        int maxw = -1;

        for (int i = 0; i < N; i++) {
            int remain = X - arr[i];

            int s = i + 1;
            int e = N - 1;

            int res = -1;
            while (s <= e) {
                int m = s + (e - s) / 2;

                if (arr[m] == remain) {
                    res = m;
                    break;
                }

                if (remain < arr[m]) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }

            if (res == -1) {
                continue;
            }

            if (max < arr[res] - arr[i]) {
                max = arr[res] - arr[i];
                maxw = i;
            }
        }

        if (max == -1) {
            System.out.println("danger");
        } else {
            System.out.println("yes" + " " + arr[maxw] + " " + (X - arr[maxw]));
        }

    }
}
