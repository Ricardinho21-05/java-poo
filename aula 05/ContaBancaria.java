public class ContaBancaria {

    String titular;
    int numero;
    double saldo;

    // Construtor
    public ContaBancaria(String titular, int numero, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
    }

    // Método para depositar
    public void depositar(double valor) {
        saldo = saldo + valor;
        System.out.println("Depósito realizado com sucesso!");
    }

    // Método para sacar
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo = saldo - valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    // Método para exibir o extrato
    public void exibirExtrato() {
        System.out.println("Titular: " + titular);
        System.out.println("Número da conta: " + numero);
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("-------------------------");
    }
}