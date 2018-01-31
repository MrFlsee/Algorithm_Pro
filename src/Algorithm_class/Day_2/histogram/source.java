package Algorithm_class.Day_2.histogram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class source {
    static int N;
    static long[] L, R;
    static int[] H;
    static Stack<Integer> st, stw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        L = new long[121212];
        R = new long[121212];
        H = new int[121212];

        while (true) {
            StringTokenizer s = new StringTokenizer(br.readLine());

            N = Integer.parseInt(s.nextToken());
            if (N == 0) {
                break;
            }
            for (int i = 1; i <= N; i++) {
                H[i] = Integer.parseInt(s.nextToken());
            }

            st = new Stack<>();
            stw = new Stack<>();

            st.push(-1);
            stw.push(0);


            for (int i = 1; i <= N; i++) {
                while (st.peek() >= H[i]) {
                    st.pop();
                    stw.pop();
                }

                L[i] = stw.peek() + 1;
                st.push(H[i]);
                stw.push(i);

            }

            st.clear();
            stw.clear();

            st.push(-1);
            stw.push(N + 1);

            for (int i = N; i > 0; i--) {
                while (st.peek() >= H[i]) {
                    st.pop();
                    stw.pop();
                }
                R[i] = stw.peek() - 1;
                st.push(H[i]);
                stw.push(i);
            }

            st.clear();
            stw.clear();

            long ans = -1;
            for (int i = 1; i <= N; i++) {
                if (ans < (R[i] - L[i] + 1) * H[i]) {
                    ans = (R[i] - L[i] + 1) * H[i];
                }
            }

            bw.write(String.valueOf(ans) + "\n");

        }


//        System.out.println(Arrays.toString(L));
//        System.out.println(Arrays.toString(R));

        bw.flush();
        bw.close();
    }
}
