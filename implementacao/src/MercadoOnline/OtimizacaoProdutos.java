package MercadoOnline;

import javax.swing.*;
import java.util.HashMap;

public class OtimizacaoProdutos {

    public HashMap<Produto, Integer> auxAnalise = new HashMap<>();
    private Produto.Categoria categoria;

    public boolean tamanhoCategoria(Produto.Categoria categoria) {
        for (Produto produto : CarrinhoDeCompras.produtosAnalise.keySet()) {
            if (produto.getCategoria().equals(categoria)) {
                auxAnalise.put(produto, CarrinhoDeCompras.produtosAnalise.get(produto));
            }
        }
        if (auxAnalise.size() >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public void analiseProdutos(Produto.Categoria categoria) {
        String concVendeuMenos = "";
        String concVendeuMenosUnidade = "";
        String concVendeuMais = "";
        String concVendeuMaisUnidade = "";
        int quantMaior = 0;
        int quantMenor = 0;
        int vendeuMais = 1;
        int vendeuMenos = 1;

        this.categoria = categoria;

        tamanhoCategoria(categoria);

        for (Produto p : auxAnalise.keySet()) {
            vendeuMenos = auxAnalise.get(p);
        }

        for (Produto produto : auxAnalise.keySet()) {
            if (auxAnalise.get(produto) > vendeuMais) {
                vendeuMais = auxAnalise.get(produto);
            } else if (auxAnalise.get(produto) < vendeuMenos) {
                vendeuMenos = auxAnalise.get(produto);
            }
        }

        for (Produto prod : auxAnalise.keySet()) {
            int auxVar1 = auxAnalise.get(prod);
            if (auxVar1 == vendeuMais) {
                quantMaior++;
                concVendeuMais += prod.getNomeProduto() + ", ";
                concVendeuMaisUnidade = prod.getNomeProduto();
            }
            if (auxVar1 == vendeuMenos) {
                quantMenor++;
                concVendeuMenos += prod.getNomeProduto() + ", ";
                concVendeuMenosUnidade = prod.getNomeProduto();
            }
        }

        JOptionPane.showMessageDialog(null, (quantMaior == 1 ? "O produto " + concVendeuMaisUnidade + " vendeu mais na categoria "
                + this.categoria : "Os produtos que mais venderam na categoria: " + this.categoria + "\n foram: " + concVendeuMais));

        JOptionPane.showMessageDialog(null, (quantMenor == 1 ? "O produto " + concVendeuMenosUnidade + " vendeu menos na categoria "
                + this.categoria : "Os produtos que menos venderam na categoria: " + this.categoria + "\n foram: " + concVendeuMenos));

        auxAnalise = new HashMap<>();
    }
}
