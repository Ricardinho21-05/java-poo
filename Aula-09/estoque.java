
public class Produto {

    private String codigo;
    private String nome;
    private String categoria;
    private int quantidade;
    private int estoqueMinimo;
    private double preco;

    public Produto(String codigo, String nome, String categoria,
                   int quantidade, int estoqueMinimo, double preco) {

        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
        this.preco = preco;

    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public double getPreco() {
        return preco;
    }

    public void vender(int quantidade) {
        this.quantidade -= quantidade;
    }

}
