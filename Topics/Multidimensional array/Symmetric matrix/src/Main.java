import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Import multi-dimensional array size and elements from stdin
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] multiDimArray = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                multiDimArray[i][j] = scanner.nextInt();
            }
        }

        // Compare each row to each column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Ignore elements on the diagonal
                if (i == j) {
                    continue;
                }
                if (multiDimArray[i][j] != multiDimArray[j][i]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}