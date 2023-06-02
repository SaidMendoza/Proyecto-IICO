/*import java.util.Scanner;

public class GaussJordanSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de filas de la matriz: ");
        int rows = scanner.nextInt();

        System.out.print("Ingrese el número de columnas de la matriz: ");
        int cols = scanner.nextInt();

        double[][] matrix = new double[rows][cols];

        System.out.println("Ingrese los elementos de la matriz:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Ingrese el elemento en la posición (" + (i+1) + ", " + (j+1) + "): ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Aplicar el método de Gauss-Jordan
        for (int i = 0; i < rows; i++) {
            if (matrix[i][i] == 0) {
                boolean rowSwapped = false;
                for (int j = i + 1; j < rows; j++) {
                    if (matrix[j][i] != 0) {
                        double[] temp = matrix[i];
                        matrix[i] = matrix[j];
                        matrix[j] = temp;
                        rowSwapped = true;
                        break;
                    }
                }
                if (!rowSwapped) {
                    System.out.println("No se puede resolver la matriz.");
                    return;
                }
            }

            double divisor = matrix[i][i];
            for (int j = i; j < cols; j++) {
                matrix[i][j] /= divisor;
            }

            for (int j = 0; j < rows; j++) {
                if (j != i) {
                    double factor = matrix[j][i];
                    for (int k = i; k < cols; k++) {
                        matrix[j][k] -= factor * matrix[i][k];
                    }
                }
            }
        }

        // Imprimir la solución
        System.out.println("La solución es:");
        for (int i = 0; i < rows; i++) {
            System.out.println("x" + (i+1) + " = " + matrix[i][cols-1]);
        }

        scanner.close();
    }
}
*/