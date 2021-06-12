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

        usuario.cadastro();

        retornoMenu = catalogo.mostrarProduto();
        for (Produto p : retornoMenu.keySet()) {
            carrinho.adicionarProdutos(p, retornoMenu.get(p));
        }

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