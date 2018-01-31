package Algorithm_class.Day_4.Matrix_chain_multiplication;

import java.util.Arrays;

public class source {

    public static void main(String[] args) throws Exception {

        int[][] d = new int[5][5];
        int cnt = 1;
        for (int i = 1; i <= 5; i++) { // i가 x가 아닌 y x 의 차이값이라고 생각한다
            for (int j = 0; j + i - 1 < 5; j++) {
                d[j][j + i - 1] = cnt++;
                for (int ii = 0; ii < 5; ii++) {
                    System.out.println(Arrays.toString(d[ii]));
                }
                System.out.println();

            }
        }


    }
}
