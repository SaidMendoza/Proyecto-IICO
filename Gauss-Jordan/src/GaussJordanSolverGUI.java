import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GaussJordanSolverGUI extends JFrame {

 private JLabel lblEtiqueta1;
    private JLabel lblEtiqueta2;
    private  JTextField rowsField;
    private  JTextField colsField;
    private JButton solveButton;
    private GridLayout layout;

    public GaussJordanSolverGUI() throws HeadlessException {
        super("Resolución de Matrices - Gauss-Jordan");
        layout = new GridLayout(3,2);
        this.setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(layout);
        lblEtiqueta1 = new JLabel("Número de Filas");
        this.add(lblEtiqueta1, 0);
        rowsField = new JTextField(30);
        this.add(rowsField,1);
        lblEtiqueta2 = new JLabel("Número de columnas");
        this.add(lblEtiqueta2, 2);
        colsField = new JTextField(30);
        this.add(colsField,3);
        solveButton = new JButton("Resolver");
        this.add(solveButton,4);
        JPanel panel = new JPanel();
 /*
    private JTextField rowsField;
    private JTextField colsField;
    private JButton solveButton;

    public GaussJordanSolverGUI() {
        setTitle("Resolución de Matrices - Gauss-Jordan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel rowsLabel = new JLabel("Número de filas:");
        rowsField = new JTextField(5);
        JLabel colsLabel = new JLabel("Número de columnas:");
        colsField = new JTextField(5);

        panel.add(rowsLabel, BorderLayout.WEST);
        panel.add(rowsField, BorderLayout.CENTER);
        panel.add(colsLabel, BorderLayout.EAST);
        panel.add(colsField, BorderLayout.SOUTH);

        solveButton = new JButton("Resolver");*/
        solveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                solveMatrix();
            }
        });

        add(panel, BorderLayout.CENTER);
        add(solveButton, BorderLayout.SOUTH);
    }

    private void solveMatrix() {
        int rows, cols;

        try {
            rows = Integer.parseInt(rowsField.getText());
            cols = Integer.parseInt(colsField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese números enteros válidos para filas y columnas.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String input = JOptionPane.showInputDialog("Ingrese el elemento en la posición (" + (i + 1) + ", " + (j + 1) + "):");
                try {
                    matrix[i][j] = Double.parseDouble(input);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingrese números válidos para los elementos de la matriz.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
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
                    JOptionPane.showMessageDialog(this, "No se puede resolver la matriz.", "Error", JOptionPane.ERROR_MESSAGE);
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

        // Mostrar la solución en una ventana de diálogo
        StringBuilder solutionBuilder = new StringBuilder();
        solutionBuilder.append("La solución es:\n");
        for (int i = 0; i < rows; i++) {
            solutionBuilder.append("x").append(i + 1).append(" = ").append(matrix[i][cols - 1]).append("\n");
        }
        JOptionPane.showMessageDialog(this, solutionBuilder.toString(), "Solución", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        GaussJordanSolverGUI gui = new GaussJordanSolverGUI();
        gui.setVisible(true);
    }
}
