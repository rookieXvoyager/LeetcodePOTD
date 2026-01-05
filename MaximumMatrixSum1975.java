import java.util.*;

class MaximumMatrixSum1975 {

    static int maxMatrixSum(int[][] matrix) {
        long s = 0;
        int cnt = 0;
        int mi = Integer.MAX_VALUE;
        for (var row : matrix) {
            for (var v : row) {
                s += Math.abs(v);
                mi = Math.min(mi, Math.abs(v));
                if (v < 0) {
                    ++cnt;
                }
            }
        }
        if (cnt % 2 == 0 || mi == 0) {
            return (int) s;
        }
        return (int) s - mi * 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        String[] sizes = sc.nextLine().split(" ");
        int m = Integer.parseInt(sizes[0]), n = Integer.parseInt(sizes[1]);
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(
                "Maximum sum possible by multiplying adjacent values in the matrix through given conditions is "
                        + maxMatrixSum(matrix));
    }
}
