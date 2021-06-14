package MercadoOnline;


import javax.swing.*;
import java.util.HashMap;

public class MainUser {

    public static void main(String[] args) {
        //instanciando objetos
        Cliente usuario = new Cliente();
        Catalogo catalogo = new Catalogo();
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        Pagamento pagamento = new Pagamento();
        CatalogoCliente catalogoCliente = new CatalogoCliente();

        //declarando variáveis auxiliares
        boolean loop = true;
        HashMap<Produto, Integer> retornoMenu;
        int i = 0;

        usuario.cadastro();

        retornoMenu = catalogoCliente.mostrarProduto();
        for (Produto produto : retornoMenu.keySet()) {
            carrinho.adicionarProdutos(produto, retornoMenu.get(produto));
        }

        carrinho.mostrarProdutosCarrinho();

        do {
            String respostaRemover = JOptionPane.showInputDialog("Deseja remover um produto do carrinho?\n" + "Sim/Não");
            switch (respostaRemover.charAt(0)) {
                case 'S':
                case 's':
                    String produto = JOptionPane.showInputDialog("Qual item deseja remover do carrinho?");
                    String quantidadeDesejada = JOptionPane.showInputDialog("Qual a quantidade do item você deseja remover?");
                    int quantidade = Integer.parseInt(quantidadeDesejada);
                    carrinho.removerProduto(produto, quantidade);
                    break;
                case 'N':
                case 'n':
                    loop = false;
                    break;
            }
        } while (loop);

        carrinho.mostrarProdutosCarrinho();

        boolean result = usuario.informarCartao();
        while (i <= 2) {
            if (!result) {
                String infCart = JOptionPane.showInputDialog("Redigite o número do cartão, de forma que seja válido: \n" + "Você tem " + (3 - i) + " tentativas.");
                result = usuario.informaCartao(infCart);
            }
            i++;
        }
        pagamento.finalizarCompra(result, usuario, carrinho);
    }
}
