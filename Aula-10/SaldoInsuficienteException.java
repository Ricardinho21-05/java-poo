
public class SaldoInsuficienteException extends Exception {

    private double falta;

    public SaldoInsuficienteException(double falta) {

        super("Saldo insuficiente! Faltam R$ " + falta);

        this.falta = falta;

    }

    public double getFalta() {
        return falta;
    }

}

class Conta {

    private double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public void sacar(double valor)
            throws SaldoInsuficienteException {

        if (valor < 0) {
            throw new IllegalArgumentException("Valor negativo!");
        }

        if (valor > saldo) {

            double falta = valor - saldo;

            throw new SaldoInsuficienteException(falta);

        }

        saldo -= valor;

        System.out.println("Saque realizado!");

    }

    public double getSaldo() {
        return saldo;
    }

}

public class Banco {

    public static void main(String[] args) {

        Conta conta = new Conta(500);

        // Primeiro saque: válido
        try {

            conta.sacar(100);

        } catch (SaldoInsuficienteException e) {

            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        // Segundo saque: negativo
        try {

            conta.sacar(-50);

        } catch (SaldoInsuficienteException e) {

            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        // Terceiro saque: maior que o saldo
        try {

            conta.sacar(1000);

        } catch (SaldoInsuficienteException e) {

            System.out.println(e.getMessage());

            System.out.println("Valor que falta: R$ " + e.getFalta());

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        System.out.println("Saldo atual: R$ " + conta.getSaldo());

        System.out.println("Programa continua funcionando!");

    }

}
