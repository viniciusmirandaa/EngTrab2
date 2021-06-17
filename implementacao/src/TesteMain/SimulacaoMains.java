package TesteMain;

import MercadoOnline.*;

import javax.swing.*;
import java.util.HashMap;

public class SimulacaoMains {


    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        Cliente cliente = new Cliente();
        CatalogoCliente catalogoCliente = new CatalogoCliente();
        HashMap<Produto, Integer> retornoMenu;
        Pagamento pagamento = new Pagamento();
        OtimizacaoProdutos otimizacaoProdutos = new OtimizacaoProdutos();
        String respotaCategoriaInvalida;
        boolean opcao = true;
        int i = 0;

        Produto produto = new Produto("Coca Cola", 7, Produto.Categoria.Refrigerante, 1);
        Produto produto1 = new Produto("Fanta", 5, Produto.Categoria.Refrigerante, 2);
        Produto produto2 = new Produto("Dolly", 4, Produto.Categoria.Refrigerante, 3);
        Produto produto3 = new Produto("Jussara", 2, Produto.Categoria.Leite, 10);
        Produto produto4 = new Produto("Barriguinha Mole", 3, Produto.Categoria.Leite, 11);
        Produto produto5 = new Produto("Longa Vida", 2.50, Produto.Categoria.Leite, 12);
        Produto produto6 = new Produto("Garoto", 5, Produto.Categoria.Chocolate, 20);
        Produto produto7 = new Produto("Diamante Negro", 6, Produto.Categoria.Chocolate, 21);
        Produto produto8 = new Produto("Crunchy", 4.50, Produto.Categoria.Chocolate, 22);

        catalogo.cadastrarProduto(produto, produto1, produto2, produto3, produto4, produto5, produto6, produto7, produto8);

        cliente.cadastro();

        retornoMenu = catalogoCliente.mostrarProduto();
        for (Produto p : retornoMenu.keySet()) {
            carrinhoDeCompras.adicionarProdutos(p, retornoMenu.get(p));
        }

        boolean result = cliente.informaCartao();

        while (i <= 2) {
            if (!result) {
                String infCart = JOptionPane.showInputDialog("Redigite o número do cartão, de forma que seja válido: \n" + "Você tem " + (3 - i) + " tentativas.");
                result = cliente.informaCartao(infCart);
            }
            i++;
        }

        pagamento.finalizarCompra(result, cliente, carrinhoDeCompras);

        String categoriaNome = "";
        for (Produto.Categoria cat : Produto.Categoria.values()) {
            if(cat.equals(Produto.Categoria.valueOf(Produto.Categoria.Vazio.name()))){
                break;
            }
            categoriaNome += cat.name() + "\n";
        }

        do {
            String respostaCategoria = JOptionPane.showInputDialog("Selecione a categoria do produto que deseja otimizar: \n" + categoriaNome + "\n" + "Digite 1 para sair do programa");
            switch (respostaCategoria.charAt(0)) {
                case 'R':
                    if (!otimizacaoProdutos.tamanhoCategoria(Produto.Categoria.Refrigerante)) {
                        JOptionPane.showMessageDialog(null, "A categoria selecionada não possui nenhum produto cadastrado.");
                        respotaCategoriaInvalida = JOptionPane.showInputDialog("Você deseja continuar no menu Otimizar produto? \n" + "Sim/Não");
                        switch (respotaCategoriaInvalida.charAt(0)) {
                            case 's':
                            case 'S':
                                break;
                            case 'n':
                            case 'N':
                                opcao = false;
                                break;
                        }
                    } else {
                        otimizacaoProdutos.analiseProdutos(Produto.Categoria.Refrigerante);
                    }
                    break;
                case 'L':
                    if (!otimizacaoProdutos.tamanhoCategoria(Produto.Categoria.Leite)) {
                        JOptionPane.showMessageDialog(null, "A categoria selecionada não possui nenhum produto cadastrado.");
                        respotaCategoriaInvalida = JOptionPane.showInputDialog("Você deseja continuar no menu Otimizar produto? \n" + "Sim/Não");
                        switch (respotaCategoriaInvalida.charAt(0)) {
                            case 's':
                            case 'S':
                                break;
                            case 'n':
                            case 'N':
                                opcao = false;
                                break;
                        }
                    } else {
                        otimizacaoProdutos.analiseProdutos(Produto.Categoria.Leite);
                    }
                    break;
                case 'C':
                    if (!otimizacaoProdutos.tamanhoCategoria(Produto.Categoria.Chocolate)) {
                        JOptionPane.showMessageDialog(null, "A categoria selecionada não possui nenhum produto cadastrado.");
                        respotaCategoriaInvalida = JOptionPane.showInputDialog("Você deseja continuar no menu Otimizar produto? \n" + "Sim/Não");
                        switch (respotaCategoriaInvalida.charAt(0)) {
                            case 's':
                            case 'S':
                                break;
                            case 'n':
                            case 'N':
                                opcao = false;
                                break;
                        }
                    } else {
                        otimizacaoProdutos.analiseProdutos(Produto.Categoria.Chocolate);
                    }
                    break;
                case 'S':
                    if (!otimizacaoProdutos.tamanhoCategoria(Produto.Categoria.Salgadinho)) {
                        JOptionPane.showMessageDialog(null, "A categoria selecionada não possui nenhum produto cadastrado.");
                        respotaCategoriaInvalida = JOptionPane.showInputDialog("Você deseja continuar no menu Otimizar produto? \n" + "Sim/Não");
                        switch (respotaCategoriaInvalida.charAt(0)) {
                            case 's':
                            case 'S':
                                break;
                            case 'n':
                            case 'N':
                                opcao = false;
                                break;
                        }
                    } else {
                        otimizacaoProdutos.analiseProdutos(Produto.Categoria.Salgadinho);
                    }
                    break;
                case '1':
                    opcao = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        }while(opcao);
    }
}
