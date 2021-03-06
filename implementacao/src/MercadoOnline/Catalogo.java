package MercadoOnline;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Catalogo {
    public static ArrayList<Produto> listaProdutos = new ArrayList<>();
    Produto aux;


    public void cadastrarProduto(Produto... p) {
        for(Produto produto : p)
            listaProdutos.add(produto);
    }

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

    public boolean pesquisarProduto(int codigoParaPesquisar) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            aux = listaProdutos.get(i);
            if (aux.getCodigoProduto() == codigoParaPesquisar) {
                JOptionPane.showMessageDialog(null, "Produto: " + aux.getNomeProduto() + "\n"
                        + "Pre??o: " + aux.getPrecoProduto() + "\n" + "Categoria: " + aux.getCategoria() + "\n" + "C??digo produto: " + aux.getCodigoProduto());
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
}
