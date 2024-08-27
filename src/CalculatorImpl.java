import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    protected CalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        double result = a + b;
        log("Add", a, b, result);
        return result;
    }

    @Override
    public double subtract(double a, double b) throws RemoteException {
        double result = a - b;
        log("Subtract", a, b, result);
        return result;
    }

    @Override
    public double multiply(double a, double b) throws RemoteException {
        double result = a * b;
        log("Multiply", a, b, result);
        return result;
    }

    @Override
    public double divide(double a, double b) throws RemoteException {
        if (b == 0) {
            log("Divide", a, b, "Erro: Divisão por zero");
            throw new RemoteException("Divisão por zero não é permitida.");
        }
        double result = a / b;
        log("Divide", a, b, result);
        return result;
    }

    private void log(String operation, double a, double b, Object result) {
        System.out.println(LocalDateTime.now() + " - Operação: " + operation + ", Parâmetros: [" + a + ", " + b + "], Resultado: " + result);
    }
}
