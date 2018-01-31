package Self_study.사선검색;

import java.util.Arrays;

public class diagonal {
    public static void main(String[] args) throws Exception {
        int[][] a = new int[5][5];

        int cnt = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j + i - 1 < 5; j++) {
                a[j][j + i - 1] = cnt++;
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
