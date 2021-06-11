package MercadoOnline;

import javax.swing.*;
import java.util.HashMap;

public class CarrinhoDeCompras {
    public HashMap<Produto, Integer> produtosCarrinho = new HashMap<>();
    public HashMap<Produto, Integer> totalProdutos = new HashMap<>();
    private static double totalCompra;

    public boolean adicionarProdutos(Produto p, int quantidade){
        if (produtosCarrinho.containsKey(p)) {
            produtosCarrinho.replace(p, produtosCarrinho.get(p) + quantidade);
            totalProdutos.put(p,quantidade);
            return true;
        } else {
            produtosCarrinho.put(p, quantidade);
            return true;
        }
    }

    public boolean removerProduto(Produto p, int quantidade){
        if (produtosCarrinho.containsKey(p)) {
            produtosCarrinho.replace(p, produtosCarrinho.get(p) - quantidade);
            return true;
        } else {
            return false;
        }
    }

    public void mostrarItens(){
        for(Produto p : produtosCarrinho.keySet()){
            JOptionPane.showMessageDialog(null, "Produto: " + p.getNomeProduto() + "\n"
                    + "Preço: " + p.getPrecoProduto() + "\n" + "Categoria: " + p.getCategoria() + "\n" + "Código produto: " + p.getCodigoProduto());
        }
    }

    public double valorTotalCarrinho(){
        for(Produto produto : produtosCarrinho.keySet()){
            totalCompra += produtosCarrinho.get(produto) * produto.getPrecoProduto();
        }
        double recept = totalCompra;
        totalCompra = 0;
        return recept;
    }
}
