package MercadoOnline;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Catalogo {
    public ArrayList<Produto> listaProdutos = new ArrayList<>();
    public ArrayList<Produto> listaProdComprados = new ArrayList<>();
    HashMap<Produto, Integer> produtosComprados = new HashMap<>();
    Produto aux;


    public void cadastrarProduto(Produto p) {
        listaProdutos.add(p);
    }

    public boolean excluirProduto(int codigoParaExcluir) {

        for (int i = 0; i < listaProdutos.size(); i++) {
            aux = listaProdutos.get(i);
            if (aux.getCodigoProduto() == codigoParaExcluir) {
                listaProdutos.remove(aux);
                return true;
            }
        }
        return false;
    }

    public boolean alterarProduto(int codigo, String nome) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            aux = listaProdutos.get(i);
            if (aux.getCodigoProduto() == codigo) {
                aux.setNomeProduto(nome);
                return true;
            }
        }
        return false;
    }

    public boolean alterarProduto(int codigo, String nome, double preco) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            aux = listaProdutos.get(i);
            if (aux.getCodigoProduto() == codigo) {
                aux.setNomeProduto(nome);
                aux.setPrecoProduto(preco);
                return true;
            }
        }
        return false;
    }

    public boolean alterarProduto(int codigo, double preco) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            aux = listaProdutos.get(i);
            if (aux.getCodigoProduto() == codigo) {
                aux.setPrecoProduto(preco);
                return true;
            }
        }
        return false;
    }

    public boolean pesquisarProduto(int codigoParaExcluir) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            aux = listaProdutos.get(i);
            if (aux.getCodigoProduto() == codigoParaExcluir) {
                JOptionPane.showMessageDialog(null, "Produto: " + aux.getNomeProduto() + "\n"
                        + "Preço: " + aux.getPrecoProduto() + "\n" + "Categoria: " + aux.getCategoria() + "\n" + "Código produto: " + aux.getCodigoProduto());
                return true;
            }
        }
        return false;
    }

    public boolean verificaCodigo(int codigo) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            aux = listaProdutos.get(i);
            if (aux.getCodigoProduto() == codigo) {
                return true;
            }
        }
        return false;
    }

    public HashMap<Produto, Integer> mostrarProduto() {
        int i = 0;
        do {
            JOptionPane.showMessageDialog(null, "Para comprar um produto digite Sim \n" + "Para não comprar digite Não" + "\n" + "Para parar de comprar digite Sair.");
            for (int x = 0; x < listaProdutos.size(); x++) {
                aux = listaProdutos.get(x);
                String respostaMenu = JOptionPane.showInputDialog("Produto: " + aux.getNomeProduto() + "\n" + "Preço: " + aux.getPrecoProduto());
                switch (respostaMenu) {
                    case "Sim":
                    case "s":
                    case "S":
                    case "sim":
                    case "SIM":
                        String quantFrase = JOptionPane.showInputDialog("Insira a quantidade que deseja do produto");
                        int quantidade = Integer.parseInt(quantFrase);
                        produtosComprados.put(aux, quantidade);
                        break;
                    case "Não":
                    case "n":
                    case "N":
                    case "não":
                    case "nao":
                    case "NAO":
                        break;
                    case "SAIR":
                    case "Sair":
                        return produtosComprados;
                }
                i++;
            }
        } while (i < listaProdutos.size());
        return produtosComprados;
    }
}
