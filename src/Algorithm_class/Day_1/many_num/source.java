package Algorithm_class.Day_1.many_num;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class source {
    static int N;
    static int[] arr, cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        cnt = new int[N];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());

            arr[i] = a;
        }

        Arrays.sort(arr);

//        System.out.println(Arrays.toString(arr));
        cnt[0] = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] != arr[i - 1]) {
                cnt[i] = 1;
            } else {
                cnt[i] = cnt[i - 1] + 1;
            }
        }
//        System.out.println(Arrays.toString(cnt));

        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                result = arr[i];
            }
        }

        System.out.println(result);

    }
}
