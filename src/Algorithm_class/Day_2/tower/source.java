package Algorithm_class.Day_2.tower;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class source {
    static int N;
    static int[] arr;
    static Stack<Integer> st;
    static Stack<Integer> stw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        st = new Stack<>();
        stw = new Stack<>();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st.push(100000001);
        stw.push(0);

        StringTokenizer std = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(std.nextToken());
            while (!st.isEmpty() && st.peek() < arr[i]) {
                st.pop();
                stw.pop();
            }
            bw.write(String.valueOf(stw.peek()) + " ");

            st.push(arr[i]);
            stw.push(i);
        }


        bw.flush();
        bw.close();


    }
}
