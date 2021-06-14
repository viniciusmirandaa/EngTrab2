package MercadoOnline;

import javax.swing.*;
import java.util.HashMap;

public class CarrinhoDeCompras {
    public HashMap<Produto, Integer> produtosCarrinho = new HashMap<>();
    public static HashMap<Produto, Integer> produtosAnalise = new HashMap<>();
    private static double totalCompra;
    private String mostrarCarrinho = "";


    public boolean adicionarProdutos(Produto p, int quantidade) {
        if (produtosCarrinho.containsKey(p.getNomeProduto())) {
            produtosCarrinho.replace(p, produtosCarrinho.get(p) + quantidade);
            produtosAnalise.replace(p, produtosAnalise.get(p) + quantidade);
            return true;
        } else {
            produtosAnalise.put(p, quantidade);
            produtosCarrinho.put(p, quantidade);
            return true;
        }
    }

    public boolean removerProduto(String nomeProduto, int quantidade) {
        for (Produto p : produtosCarrinho.keySet()) {
            if (p.getNomeProduto().equals(nomeProduto)) {
                produtosCarrinho.replace(p, produtosCarrinho.get(p) - quantidade);
                produtosAnalise.replace(p, produtosAnalise.get(p) - quantidade);
                return true;
            }
        }
        return false;
    }

    public void mostrarProdutosCarrinho() {
        for (Produto p : produtosCarrinho.keySet()) {
            String preco = String.valueOf(p.getPrecoProduto());
            mostrarCarrinho += p.getNomeProduto() + "  Preço: " + preco + "  Quantidade: " + produtosCarrinho.get(p) + "\n";
        }
        JOptionPane.showMessageDialog(null, mostrarCarrinho);
        mostrarCarrinho = "";
    }

    public double valorTotalCarrinho() {
        for (Produto produto : produtosCarrinho.keySet()) {
            totalCompra += produtosCarrinho.get(produto) * produto.getPrecoProduto();
        }
        double recept = totalCompra;
        totalCompra = 0;
        return recept;
    }
}
