package MercadoOnline;

import javax.swing.*;
import java.util.HashMap;

public class CarrinhoDeCompras {
    public HashMap<Produto, Integer> produtosCarrinho = new HashMap<>();
    public HashMap<Produto, Integer> totalProdutos = new HashMap<>();
    private static double totalCompra;

    public boolean adicionarProdutos(Produto p, int quantidade) {
        if (produtosCarrinho.containsKey(p)) {
            produtosCarrinho.replace(p, produtosCarrinho.get(p) + quantidade);
            totalProdutos.put(p, quantidade);
            return true;
        } else {
            produtosCarrinho.put(p, quantidade);
            return true;
        }
    }

    public boolean removerProduto(String nomeProduto, int quantidade) {
        for (Produto p : produtosCarrinho.keySet()) {
            if (p.getNomeProduto().equals(nomeProduto)) {
                produtosCarrinho.replace(p, produtosCarrinho.get(p) - quantidade);
                return true;
            }
        }
        return false;
    }

    public void mostrarProdutosCarrinho() {
        for (Produto p : produtosCarrinho.keySet()) {
            JOptionPane.showMessageDialog(null, "Produto: " + p.getNomeProduto() + "\n"
                    + "Preço: " + p.getPrecoProduto() + "\n" + "Quantidade: " + produtosCarrinho.get(p));
        }
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
