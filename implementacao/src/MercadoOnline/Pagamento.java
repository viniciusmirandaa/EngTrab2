package MercadoOnline;

import javax.swing.*;

public class Pagamento {
    String comprovante = "";

    private void gerarComprovanteDeVenda(Cliente cliente, CarrinhoDeCompras carrinho) {
        for (Produto p : carrinho.produtosCarrinho.keySet()) {
            String preco = String.valueOf(p.getPrecoProduto());
            comprovante += "Nome: " + p.getNomeProduto() + "  Preço: " + preco + "\n";
        }
        JOptionPane.showMessageDialog(null, " Nome: " + cliente.getNomeCliente() + "\n Endereço: "
                + cliente.getEndereco() + "\n CPF: " + cliente.getCpf() + "\n Itens comprados: \n" + comprovante);

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
