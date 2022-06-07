package SDESheet;

// https://leetcode.com/problems/search-a-2d-matrix/ (Read Question Carefully because there is another question with same type)

public class SearchIn2D {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(search(matrix, 31));
        System.out.println(optimal(matrix, 3));
    }

    private static boolean search(int[][] matrix, int target) {
        int i = 0, j = matrix[i].length - 1;
        int n = matrix.length;
        while(i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }

            if (matrix[i][j] < target) {
                i++;
            }
            else {
                j--;
            }
        }

        return false;
    }

//    optimal
    private static boolean optimal(int[][] matrix, int target) {
        int lo = 0;
        if(matrix.length == 0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int hi = (n * m) - 1;

        while(lo <= hi) {
            int mid = (lo + (hi - lo) / 2);
            if(matrix[mid/m][mid % m] == target) {
                return true;
            }
            if(matrix[mid/m][mid % m] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
