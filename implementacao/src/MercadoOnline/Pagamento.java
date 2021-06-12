package MercadoOnline;

import javax.swing.*;

public class Pagamento {
    CarrinhoDeCompras c = new CarrinhoDeCompras();


    public void gerarComprovanteDeVenda(Cliente cliente) {
        JOptionPane.showMessageDialog(null, "Nome: " + cliente.getNomeCliente());
        JOptionPane.showMessageDialog(null, "Endereço: " + cliente.getEndereco());
        JOptionPane.showMessageDialog(null, "CPF: " + cliente.getCpf());
        JOptionPane.showMessageDialog(null, "Itens comprados: ");
        for (Produto p : c.produtosCarrinho.keySet()) {
            JOptionPane.showMessageDialog(null, "Nome: " + p.getNomeProduto() + "\nPreço: " + p.getPrecoProduto());
        }
    }

    public boolean finalizarCompra(boolean resultInfo, Cliente c) {
        if (!resultInfo) {
            return false;
        } else {
            gerarComprovanteDeVenda(c);
            return true;
        }
    }
}
