package SDESheet;

import java.util.*;

public class SetMatrixZeroes {
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {

        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for(int i = 0;i < matrix.length;i++) {
            for (int j = 0;j < matrix[i].length;j++) {
                int el = matrix[i][j];
                if (el == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int i = 0;i < matrix.length;i++) {
            for(int j = 0;j < matrix[i].length;j++) {
                if (row.contains(i)) {
                    matrix[i][j] = 0;
                }

                if (col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
