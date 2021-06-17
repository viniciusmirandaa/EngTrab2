package MercadoOnline;

import javax.swing.*;

public class MainAdmin {
    public static void main(String[] args) {

        //instanciando objetos
        Administrador adm = new Administrador("admin", "admin123");
        Catalogo catalogo = new Catalogo();
        OtimizacaoProdutos otimizacaoProdutos = new OtimizacaoProdutos();

        //declarando variáveis auxiliares
        boolean loop = true;
        Produto produto;
        Produto.Categoria retornoCategoria;
        int codigoProdutoExcluir;
        boolean opcaoInvalida = false;
        String respotaCategoriaInvalida;

        String usuario = JOptionPane.showInputDialog("Defina o nome de administrador: ");
        String senha = JOptionPane.showInputDialog("Defina a senha do administrador: ");

        while (!usuario.equals(adm.getNomeUsuario()) || !senha.equals(adm.getSenha())) {
            usuario = JOptionPane.showInputDialog("Redefina o nome de administrador: ");
            senha = JOptionPane.showInputDialog("Redefina a senha do administrador: ");
        }
        do {

            String resposta = JOptionPane.showInputDialog("Selecione a opção desejada. \n" + "Cadastrar produto. \n"
                    + "Excluir produto. \n" + "Alterar produto. \n" + "Pesquisar produto. \n" + "Otimizar estoque. \n" + "Sair do menu.");

            switch (resposta.charAt(0)) {
                case 'C':
                    String nome = JOptionPane.showInputDialog("Insira o nome do produto: ");
                    String precoProduto = JOptionPane.showInputDialog("Insira o preço do produto: (ex. 7.50)");
                    double preco = Double.parseDouble(precoProduto);
                    String categoria = JOptionPane.showInputDialog("Insira a categoria do produto: ");
                    retornoCategoria = Produto.escolheOpcao(categoria);
                    while (retornoCategoria.name().equals(Produto.Categoria.Vazio.name())) {
                        categoria = JOptionPane.showInputDialog("Coloque uma categoria de produtos válida, de forma que seja alguma dessas opções: \n"
                                + Produto.Categoria.Chocolate + "\n" + Produto.Categoria.Leite + "\n" + Produto.Categoria.Refrigerante + "\n" + Produto.Categoria.Salgadinho);
                        retornoCategoria = Produto.escolheOpcao(categoria);
                    }
                    String codigoDeBarras = JOptionPane.showInputDialog("Insira o código de barras do produto: ");
                    int codigo = Integer.parseInt(codigoDeBarras);
                    while (catalogo.verificaCodigo(codigo)) {
                        codigoDeBarras = JOptionPane.showInputDialog("Redigite o código de barras do produto: ");
                        codigo = Integer.parseInt(codigoDeBarras);
                    }
                    produto = new Produto(nome, preco, retornoCategoria, codigo);
                    catalogo.cadastrarProduto(produto);
                    break;
                case 'E':
                    do {
                        String cPE = JOptionPane.showInputDialog("Insira o código do produto para a exclusão: ");
                        codigoProdutoExcluir = Integer.parseInt(cPE);
                        if (catalogo.excluirProduto(codigoProdutoExcluir)) {
                            JOptionPane.showMessageDialog(null, "O produto foi removido com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Produto não existente, insira um novo código.");
                        }
                    } while (!catalogo.excluirProduto(codigoProdutoExcluir));
                    break;
                case 'A':
                    String cPA = JOptionPane.showInputDialog("Insira o código do produto para alterar: ");
                    int codigoAlterar = Integer.parseInt(cPA);
                    while (!catalogo.verificaCodigo(codigoAlterar)) {
                        cPA = JOptionPane.showInputDialog("Redigite o código de barras do produto: ");
                        codigoAlterar = Integer.parseInt(cPA);
                    }
                    String respostaAlterar = JOptionPane.showInputDialog("Selecione a opção desejada para realizar a alteração do produto. \n"
                            + "1 - Alterar nome. \n" + "2 - Alterar preço. \n" + "3 - Alterar nome e preço.");
                    switch (respostaAlterar) {
                        case "1":
                            nome = JOptionPane.showInputDialog("Insira o nome do produto: ");
                            catalogo.alterarProduto(codigoAlterar, nome);
                            break;
                        case "2":
                            precoProduto = JOptionPane.showInputDialog("Insira o preço do produto: (ex. 7.50)");
                            preco = Double.parseDouble(precoProduto);
                            catalogo.alterarProduto(codigoAlterar, preco);
                            break;
                        case "3":
                            nome = JOptionPane.showInputDialog("Insira o nome do produto: ");
                            precoProduto = JOptionPane.showInputDialog("Insira o preço do produto: (ex. 7.50)");
                            preco = Double.parseDouble(precoProduto);
                            catalogo.alterarProduto(codigoAlterar, nome, preco);
                            break;
                    }
                    break;
                case 'P':
                    String cPP = JOptionPane.showInputDialog("Insira o código do produto para pesquisar o produto: ");
                    int codigoProdutoPesquisar = Integer.parseInt(cPP);
                    while (!catalogo.verificaCodigo(codigoProdutoPesquisar)) {
                        cPA = JOptionPane.showInputDialog("Redigite o código de barras do produto: ");
                        codigoProdutoPesquisar = Integer.parseInt(cPA);
                    }
                    catalogo.pesquisarProduto(codigoProdutoPesquisar);
                    break;
                case 'O':
                    String categoriaNome = "";
                        for (Produto.Categoria cat : Produto.Categoria.values()) {
                            categoriaNome += cat.name() + "\n";
                        }
                    do {
                        String respostaCategoria = JOptionPane.showInputDialog("Selecione a categoria do produto que deseja otimizar: " + categoriaNome + "\n" + "Digite 1 para sair do programa");
                        switch (respostaCategoria.charAt(0)) {
                            case 'R':
                                if (!otimizacaoProdutos.tamanhoCategoria(Produto.Categoria.Refrigerante)) {
                                    JOptionPane.showMessageDialog(null, "A categoria selecionada não possui nenhum produto cadastrado.");
                                    respotaCategoriaInvalida = JOptionPane.showInputDialog("Você deseja continuar no menu Otimizar produto? \n" + "Sim/Não");
                                    switch (respotaCategoriaInvalida.charAt(0)) {
                                        case 's':
                                        case 'S':
                                            opcaoInvalida = true;
                                            break;
                                        case 'n':
                                        case 'N':
                                            opcaoInvalida = false;
                                            break;
                                    }
                                } else {
                                    otimizacaoProdutos.analiseProdutos(Produto.Categoria.Refrigerante);
                                    opcaoInvalida = true;
                                }
                                break;
                            case 'L':
                                if (!otimizacaoProdutos.tamanhoCategoria(Produto.Categoria.Leite)) {
                                    JOptionPane.showMessageDialog(null, "A categoria selecionada não possui nenhum produto cadastrado.");
                                    respotaCategoriaInvalida = JOptionPane.showInputDialog("Você deseja continuar no menu Otimizar produto? \n" + "Sim/Não");
                                    switch (respotaCategoriaInvalida.charAt(0)) {
                                        case 's':
                                        case 'S':
                                            opcaoInvalida = true;
                                            break;
                                        case 'n':
                                        case 'N':
                                            opcaoInvalida = false;
                                            break;
                                    }
                                } else {
                                    otimizacaoProdutos.analiseProdutos(Produto.Categoria.Leite);
                                    opcaoInvalida = true;
                                }
                                break;
                            case 'C':
                                if (!otimizacaoProdutos.tamanhoCategoria(Produto.Categoria.Chocolate)) {
                                    JOptionPane.showMessageDialog(null, "A categoria selecionada não possui nenhum produto cadastrado.");
                                    respotaCategoriaInvalida = JOptionPane.showInputDialog("Você deseja continuar no menu Otimizar produto? \n" + "Sim/Não");
                                    switch (respotaCategoriaInvalida.charAt(0)) {
                                        case 's':
                                        case 'S':
                                            opcaoInvalida = true;
                                            break;
                                        case 'n':
                                        case 'N':
                                            opcaoInvalida = false;
                                            break;
                                    }
                                } else {
                                    otimizacaoProdutos.analiseProdutos(Produto.Categoria.Chocolate);
                                    opcaoInvalida = true;
                                }
                                break;
                            case 'S':
                                if (!otimizacaoProdutos.tamanhoCategoria(Produto.Categoria.Salgadinho)) {
                                    JOptionPane.showMessageDialog(null, "A categoria selecionada não possui nenhum produto cadastrado.");
                                    respotaCategoriaInvalida = JOptionPane.showInputDialog("Você deseja continuar no menu Otimizar produto? \n" + "Sim/Não");
                                    switch (respotaCategoriaInvalida.charAt(0)) {
                                        case 's':
                                        case 'S':
                                            opcaoInvalida = true;
                                            break;
                                        case 'n':
                                        case 'N':
                                            opcaoInvalida = false;
                                            break;
                                    }
                                } else {
                                    otimizacaoProdutos.analiseProdutos(Produto.Categoria.Salgadinho);
                                    opcaoInvalida = true;
                                }
                                break;
                            case '1':
                                opcaoInvalida = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida.");
                                opcaoInvalida = true;
                                break;
                        }
                    } while (opcaoInvalida);
                    break;
                case 'S':
                    loop = false;
                    break;
                default: JOptionPane.showMessageDialog(null, "Opção inválida.");
                break;
            }
        } while (loop);
    }
}
