import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorImpl calculator = new CalculatorImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Calculator", calculator);
            System.out.println("Servidor de calculadora pronto para receber chamadas.");
        } catch (Exception e) {
            System.err.println("Erro no servidor de calculadora: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
