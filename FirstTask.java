package PicsArtClone;

import java.sql.Struct;
import java.util.Arrays;

public class FirstTask {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0, 1, 1,},
                          {1, 1, 0, 1, 0},
                          {0, 0, 0, 0, 0}};

        int objects = findObjects(matrix);
        System.out.println(objects);

//        horizontalReversePicture(matrix);
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

    }

    public static void horizontalReversePicture(int[][] matrix) {
        for (int[] row : matrix ) {
            for (int j = 0; j < (matrix[0].length + 1) / 2; j++) {
                int temp = row[j] ^ 1;
                row[j] = row[matrix.length - 1- j] ^ 1;
                row[matrix.length - 1- j] = temp;
            }
        }
    }

    public static int findObjects(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int objects = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    ++objects;
                    checkTheNeighbours(matrix, i, j);
                }
            }
        }
        return objects;
    }

    private static void checkTheNeighbours(int[][] matrix, int row, int col) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (row < 0 || col < 0 || row >= rows || col >= cols || matrix[row][col] == 0) {
            return;
        }

        matrix[row][col] = 0;

        checkTheNeighbours(matrix, row - 1, col);
        checkTheNeighbours(matrix, row + 1, col);
        checkTheNeighbours(matrix, row, col - 1);
        checkTheNeighbours(matrix, row, col + 1);
    }
}
