package MercadoOnline;

import javax.swing.*;

public class Pagamento {
    String comprovante = "";

    private void gerarComprovanteDeVenda(Cliente cliente, CarrinhoDeCompras carrinho) {
        for (Produto p : carrinho.produtosCarrinho.keySet()) {
            String preco = String.valueOf(p.getPrecoProduto());
            comprovante += "Nome: " + p.getNomeProduto() + "  Preço: " + preco + "  Quantidade: " + carrinho.produtosCarrinho.get(p) + "\n";
        }
        JOptionPane.showMessageDialog(null, "Comprovante de venda");
        JOptionPane.showMessageDialog(null, "Nome: " + cliente.getNomeCliente() + "\nEndereço: "
                + cliente.getEndereco() + "\nCPF: " + cliente.getCpf() + "\nItens comprados: \n" + comprovante);
        JOptionPane.showMessageDialog(null, "Preço total do carrinho: " + carrinho.valorTotalCarrinho());
    }

    public boolean finalizarCompra(boolean resultInfo, Cliente c, CarrinhoDeCompras carrinhoDeCompras) {
        if (!resultInfo) {
            return false;
        } else {
            gerarComprovanteDeVenda(c, carrinhoDeCompras);
            return true;
        }
    }
}
