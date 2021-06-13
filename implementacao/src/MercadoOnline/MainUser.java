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
        Pagamento pagamento = new Pagamento();

        usuario.cadastro();

        String nome = JOptionPane.showInputDialog("Insira o nome do produto: ");
        String precoProduto = JOptionPane.showInputDialog("Insira o preço do produto: (ex. 7.50)");
        double preco = Double.parseDouble(precoProduto);
        String categoria = JOptionPane.showInputDialog("Insira a categoria do produto: ");
        String codigoDeBarras = JOptionPane.showInputDialog("Insira o código de barras do produto: ");
        int codigo = Integer.parseInt(codigoDeBarras);
        while (catalogo.verificaCodigo(codigo)) {
            codigoDeBarras = JOptionPane.showInputDialog("Redigite o código de barras do produto: ");
            codigo = Integer.parseInt(codigoDeBarras);
        }
        Produto p = new Produto(nome, preco, categoria, codigo);
        catalogo.cadastrarProduto(p);

        nome = JOptionPane.showInputDialog("Insira o nome do produto: ");
        precoProduto = JOptionPane.showInputDialog("Insira o preço do produto: (ex. 7.50)");
        preco = Double.parseDouble(precoProduto);
        categoria = JOptionPane.showInputDialog("Insira a categoria do produto: ");
        codigoDeBarras = JOptionPane.showInputDialog("Insira o código de barras do produto: ");
        codigo = Integer.parseInt(codigoDeBarras);
        while (catalogo.verificaCodigo(codigo)) {
            codigoDeBarras = JOptionPane.showInputDialog("Redigite o código de barras do produto: ");
            codigo = Integer.parseInt(codigoDeBarras);
        }
        Produto p2 = new Produto(nome, preco, categoria, codigo);
        catalogo.cadastrarProduto(p2);

        retornoMenu = catalogo.mostrarProduto();
        for (Produto produto : retornoMenu.keySet()) {
            carrinho.adicionarProdutos(produto, retornoMenu.get(p));
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
