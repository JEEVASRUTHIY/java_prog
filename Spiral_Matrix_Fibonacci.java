import java.util.Scanner;

public class FibonacciSpiral {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows (M): ");
        int m = sc.nextInt();

        System.out.print("Enter number of columns (N): ");
        int n = sc.nextInt();

        long[][] matrix = new long[m][n];

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        long prev = 0;
        long curr = 1;

        while (top <= bottom && left <= right) {

            // 🔹 Left → Right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = prev;
                long next = prev + curr;
                prev = curr;
                curr = next;
            }
            top++;

            // 🔹 Top → Bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = prev;
                long next = prev + curr;
                prev = curr;
                curr = next;
            }
            right--;

            // 🔹 Right → Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = prev;
                    long next = prev + curr;
                    prev = curr;
                    curr = next;
                }
                bottom--;
            }

            // 🔹 Bottom → Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = prev;
                    long next = prev + curr;
                    prev = curr;
                    curr = next;
                }
                left++;
            }
        }

        // 🔹 Print Matrix
        System.out.println("\nOutput Matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
