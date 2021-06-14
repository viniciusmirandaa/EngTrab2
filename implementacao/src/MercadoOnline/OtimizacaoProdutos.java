package MercadoOnline;

import javax.swing.*;
import java.util.HashMap;

public class OtimizacaoProdutos {

    public HashMap<Produto, Integer> auxAnalise = new HashMap<>();
    int vendeuMais = 1;
    int vendeuMenos = 1;

    public void analiseProdutos(Produto.Categoria categoria) {
        for (Produto produto : CarrinhoDeCompras.produtosAnalise.keySet()) {
            if (produto.getCategoria().equals(categoria)) {
                auxAnalise.put(produto, CarrinhoDeCompras.produtosAnalise.get(produto));
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
            } else if (auxAnalise.get(produto) == vendeuMenos) {
                JOptionPane.showMessageDialog(null, "O produto " + produto.getNomeProduto() + " vendeu menos na categoria "
                        + produto.getCategoria());
            }
        }
        auxAnalise = new HashMap<>();
    }
}
