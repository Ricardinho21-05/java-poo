public class Referencia {

    public static void main(String[] args) {

        // Criando uma conta
        ContaBancaria conta1 = new ContaBancaria("João", 1234, 1000.00);

        // A segunda variável recebe a referência do mesmo objeto
        ContaBancaria conta2 = conta1;

        // Depositando pela segunda variável
        conta2.depositar(500.00);

        // Imprimindo o saldo pela primeira variável
        conta1.exibirExtrato();

        ContaBancaria conta3 = null;

        conta3.exibirExtrato();
    }
}