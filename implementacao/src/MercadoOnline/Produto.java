package MercadoOnline;

public class Produto {
    private String nomeProduto;
    private double precoProduto;
    private String categoria;
    private int codigoProduto;

    public Produto(String nomeProduto, double precoProduto, String categoria, int codigoProduto) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.categoria = categoria;
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
}
