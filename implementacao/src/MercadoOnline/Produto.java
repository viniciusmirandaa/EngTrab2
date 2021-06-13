package MercadoOnline;

import javax.swing.*;

public class Produto {
    private String nomeProduto;
    private double precoProduto;
    private Categoria categoria;
    private int codigoProduto;

    public enum Categoria {
        Refrigerante, Salgadinho, Chocolate, Leite, Vazio;

    }

    public static Categoria escolheOpcao(String opcao) {
        Categoria categoria;
        if (!opcao.equals(Categoria.Refrigerante.name()) && !opcao.equals(Categoria.Salgadinho.name())
                && !opcao.equals(Categoria.Chocolate.name()) && !opcao.equals(Categoria.Leite.name())) {
            categoria = Categoria.Vazio;
            return categoria;
        } else if (opcao.equals(Categoria.Refrigerante.name())) {
            categoria = Categoria.Refrigerante;
            return categoria;
        } else if (opcao.equals(Categoria.Salgadinho.name())) {
            categoria = Categoria.Salgadinho;
            return categoria;
        } else if (opcao.equals(Categoria.Chocolate.name())) {
            categoria = Categoria.Chocolate;
            return categoria;
        } else if (opcao.equals(Categoria.Leite.name())) {
            categoria = Categoria.Leite;
            return categoria;
        }
        categoria = Categoria.Vazio;
        return categoria;
    }

    public Produto(String nomeProduto, double precoProduto, Categoria categoria, int codigoProduto) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
}
