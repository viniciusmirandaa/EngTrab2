package MercadoOnline;


import javax.swing.*;
import java.util.HashMap;

public class MainUser {

    public static void main(String[] args) {
        int i = 0;
        HashMap<Produto, Integer> retornoMenu;
        Cliente usuario = new Cliente();
        Catalogo catalogo = new Catalogo();
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        boolean loop = true;
        usuario.cadastro();

        retornoMenu = catalogo.mostrarProduto();
        for (Produto p : retornoMenu.keySet()) {
            carrinho.adicionarProdutos(p, retornoMenu.get(p));
        }
        String respostaRemover = JOptionPane.showInputDialog("Deseja remover um produto do carrinho?\n" + "Sim/Não");
        do {
            switch (respostaRemover.charAt(0)) {
                case 'S':
                    String produto = JOptionPane.showInputDialog("Qual item deseja remover do carrinho?");
                    String quantidadeDesejada = JOptionPane.showInputDialog("Qual item deseja remover do carrinho?");
                    int quantidade = Integer.parseInt(quantidadeDesejada);
                    carrinho.removerProduto(produto, quantidade);
                    break;
                case 'N':
                    loop = false;
                    break;

        }while(loop);

        boolean result = usuario.informarCartao();
        while (i <= 2) {
            if (!result) {
                String infCart = JOptionPane.showInputDialog("Redigite o número do cartão, de forma que seja válido: \n" + "Você tem " + (3 - i) + " tentativas.");
                usuario.informaCartao(infCart);
            }
            i++;
        }
    }
}
