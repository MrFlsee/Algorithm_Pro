package Algorithm_class.Day_1.numberOfInversion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    static int N;
    static int[] arr;
    static long cnt;
    static int[] sorted;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;

        mergeSort(0, N - 1);

        System.out.println(cnt);
    }

    private static void mergeSort(int start, int end) {

        int mid;
        if (start < end) {
            mid = start + (end - start) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);

        }
    }

    private static void merge(int start, int mid, int end) {
        int l = start;
        int r = mid + 1;
        int cur = start;

        while (l <= mid && r <= end) {
            if (arr[l] < arr[r]) {
                sorted[cur] = arr[l];
                l++;
            } else {
                sorted[cur] = arr[r];
                r++;
                cnt += (mid - l + 1);
            }
            cur++;
        }

        while (l <= mid) {
            sorted[cur] = arr[l];
            l++;
            cur++;
        }

        while (r <= end) {
            sorted[cur] = arr[r];
            r++;
            cur++;
        }

        for (int i = start; i <= end; i++) {
            arr[i] = sorted[i];
        }

    }
}
