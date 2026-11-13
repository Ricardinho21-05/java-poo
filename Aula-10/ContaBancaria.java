public class ContaBancaria {

    private double saldo;

    public ContaBancaria(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {

        if (valor < 0) {
            throw new IllegalArgumentException("Valor negativo!");
        }

        saldo += valor;

    }

    public void sacar(double valor) {

        if (valor < 0) {
            throw new IllegalArgumentException("Valor negativo!");
        }

        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente!");
        }

        saldo -= valor;

    }

    public double getSaldo() {
        return saldo;
    }

}
