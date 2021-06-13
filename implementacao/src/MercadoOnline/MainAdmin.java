package MercadoOnline;

import javax.swing.*;

public class MainAdmin {
    public static void main(String[] args) {
        Administrador adm = new Administrador("admin", "admin123");
        Catalogo c = new Catalogo();
        boolean loop = true;
        Produto p;

        String usuario = JOptionPane.showInputDialog("Defina o nome de administrador: ");
        String senha = JOptionPane.showInputDialog("Defina a senha do administrador: ");

        while (!usuario.equals(adm.getNomeUsuario()) || !senha.equals(adm.getSenha())) {
            usuario = JOptionPane.showInputDialog("Redefina o nome de administrador: ");
            senha = JOptionPane.showInputDialog("Redefina a senha do administrador: ");
        }
        if (usuario.equals(adm.getNomeUsuario()) || senha.equals(adm.getSenha()))
            do {


                String resposta = JOptionPane.showInputDialog("Selecione a opção desejada. \n" + "Cadastrar produto. \n"
                        + "Excluir produto. \n" + "Alterar produto. \n" + "Pesquisar produto. \n" + "Sair do menu.");

                switch (resposta.charAt(0)) {
                    case 'C':
                        String nome = JOptionPane.showInputDialog("Insira o nome do produto: ");
                        String precoProduto = JOptionPane.showInputDialog("Insira o preço do produto: (ex. 7.50)");
                        double preco = Double.parseDouble(precoProduto);
                        String categoria = JOptionPane.showInputDialog("Insira a categoria do produto: ");
                        String codigoDeBarras = JOptionPane.showInputDialog("Insira o código de barras do produto: ");
                        int codigo = Integer.parseInt(codigoDeBarras);
                        while (c.verificaCodigo(codigo)) {
                            codigoDeBarras = JOptionPane.showInputDialog("Redigite o código de barras do produto: ");
                            codigo = Integer.parseInt(codigoDeBarras);
                        }
                        p = new Produto(nome, preco, categoria, codigo);
                        c.cadastrarProduto(p);
                        break;
                    case 'E':
                        String cPE = JOptionPane.showInputDialog("Insira o código do produto para a exclusão: ");
                        int codigoProdutoExcluir = Integer.parseInt(cPE);
                        if (c.excluirProduto(codigoProdutoExcluir)) {
                            JOptionPane.showMessageDialog(null, "O produto foi removido com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Produto não existente, insira um novo código.");
                        }
                        break;
                    case 'A':
                        String cPA = JOptionPane.showInputDialog("Insira o código do produto para alterar: ");
                        int codigoAlterar = Integer.parseInt(cPA);
                        while (!c.verificaCodigo(codigoAlterar)) {
                            cPA = JOptionPane.showInputDialog("Redigite o código de barras do produto: ");
                            codigoAlterar = Integer.parseInt(cPA);
                        }
                        String respostaAlterar = JOptionPane.showInputDialog("Selecione a opção desejada para realizar a alteração do produto. \n"
                                + "1 - Alterar nome. \n" + "2 - Alterar preço. \n" + "3 - Alterar nome e preço.");
                        switch (respostaAlterar) {
                            case "1":
                                nome = JOptionPane.showInputDialog("Insira o nome do produto: ");
                                c.alterarProduto(codigoAlterar, nome);
                                break;
                            case "2":
                                precoProduto = JOptionPane.showInputDialog("Insira o preço do produto: (ex. 7.50)");
                                preco = Double.parseDouble(precoProduto);
                                c.alterarProduto(codigoAlterar, preco);
                                break;
                            case "3":
                                nome = JOptionPane.showInputDialog("Insira o nome do produto: ");
                                precoProduto = JOptionPane.showInputDialog("Insira o preço do produto: (ex. 7.50)");
                                preco = Double.parseDouble(precoProduto);
                                c.alterarProduto(codigoAlterar, nome, preco);
                                break;
                        }
                        break;
                    case 'P':
                        String cPP = JOptionPane.showInputDialog("Insira o código do produto para pesquisar o produto: ");
                        int codigoProdutoPesquisar = Integer.parseInt(cPP);
                        c.pesquisarProduto(codigoProdutoPesquisar);
                        break;
                    case 'S':
                        loop = false;
                        break;
                }
            } while (loop);
        else {
            System.out.println("O nome de usuario e senha estão incorretos.");
        }
    }
}
