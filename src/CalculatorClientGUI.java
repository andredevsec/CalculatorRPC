import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClientGUI extends JFrame {
    private Calculator calculator;

    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;

    public CalculatorClientGUI() {
        try {
            // Conecta ao registro RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            calculator = (Calculator) registry.lookup("Calculator");

            // Configura a interface gráfica
            setTitle("Calculadora RPC");
            setSize(300, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(5, 2));

            // Campos de entrada
            add(new JLabel("Número 1:"));
            num1Field = new JTextField();
            add(num1Field);

            add(new JLabel("Número 2:"));
            num2Field = new JTextField();
            add(num2Field);

            // Botões de operação
            JButton addButton = new JButton("Adicionar");
            add(addButton);
            JButton subtractButton = new JButton("Subtrair");
            add(subtractButton);
            JButton multiplyButton = new JButton("Multiplicar");
            add(multiplyButton);
            JButton divideButton = new JButton("Dividir");
            add(divideButton);

            // Label de resultado
            add(new JLabel("Resultado:"));
            resultLabel = new JLabel("");
            add(resultLabel);

            // Ações dos botões
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    performOperation("add");
                }
            });

            subtractButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    performOperation("subtract");
                }
            });

            multiplyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    performOperation("multiply");
                }
            });

            divideButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    performOperation("divide");
                }
            });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao servidor RMI: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void performOperation(String operation) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (operation) {
                case "add":
                    result = calculator.add(num1, num2);
                    break;
                case "subtract":
                    result = calculator.subtract(num1, num2);
                    break;
                case "multiply":
                    result = calculator.multiply(num1, num2);
                    break;
                case "divide":
                    result = calculator.divide(num1, num2);
                    break;
            }

            resultLabel.setText(String.valueOf(result));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira números válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao executar operação: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorClientGUI().setVisible(true);
            }
        });
    }
}
