package MercadoOnline;

import javax.swing.*;
import java.util.HashMap;

public class CarrinhoDeCompras {
    public HashMap<Produto, Integer> produtosCarrinho = new HashMap<>();
    public HashMap<Produto, Integer> auxAnalise = new HashMap<>();
    public static HashMap<Produto, Integer> produtosAnalise = new HashMap<>();
    private static double totalCompra;
    String mostrarCarrinho = "";
    int vendeuMais = 1;
    int vendeuMenos = 1;

    public void analiseProdutos(Produto.Categoria categoria) {
        for (Produto produto : produtosAnalise.keySet()) {
            if (produto.getCategoria().equals(categoria)) {
                auxAnalise.put(produto, produtosAnalise.get(produto));
            }
        }

        for (Produto produto : auxAnalise.keySet()) {
            if (auxAnalise.get(produto) > vendeuMais)
                vendeuMais = auxAnalise.get(produto);
            else if (auxAnalise.get(produto) < vendeuMais)
                vendeuMenos = auxAnalise.get(produto);
        }

        for (Produto produto : auxAnalise.keySet()) {
            if (auxAnalise.get(produto) == vendeuMais) {
                JOptionPane.showMessageDialog(null, "O produto " + produto.getNomeProduto() + " vendeu mais na categoria "
                        + produto.getCategoria());
                auxAnalise = new HashMap<>();
            } else if (auxAnalise.get(produto) == vendeuMenos) {
                JOptionPane.showMessageDialog(null, "O produto " + produto.getNomeProduto() + " vendeu menos na categoria "
                        + produto.getCategoria());
                auxAnalise = new HashMap<>();
            }
        }
    }

    public boolean adicionarProdutos(Produto p, int quantidade) {
        if (produtosCarrinho.containsKey(p)) {
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
