package MercadoOnline;

import javax.swing.*;
import java.util.HashMap;

public class CarrinhoDeCompras {
    public HashMap<Produto, Integer> produtosCarrinho = new HashMap<>();
    public static HashMap<Produto, Integer> produtosAnalise = new HashMap<>();
    private static double totalCompra;

    public void analiseProdutos(){
        for(Produto produto : produtosAnalise.keySet()){
//            if()
        }
    }

    public boolean adicionarProdutos(Produto p, int quantidade) {
        if (produtosCarrinho.containsKey(p)) {
            produtosCarrinho.replace(p, produtosCarrinho.get(p) + quantidade);
            produtosAnalise.put(p, quantidade);
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
                produtosAnalise.replace(p, produtosAnalise.get(p) - quantidade);
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
