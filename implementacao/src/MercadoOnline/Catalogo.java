package MercadoOnline;

import javax.swing.*;
import java.util.ArrayList;

public class Catalogo {
    public ArrayList<Produto> listaProdutos = new ArrayList<>();
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

    public boolean alterarProduto(String nome) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            aux = listaProdutos.get(i);
            if (aux.getNomeProduto().equals(nome)) {
                aux.setNomeProduto(nome);
                return true;
            }
        }
        return false;
    }

    public boolean alterarProduto(String nome, double preco) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            aux = listaProdutos.get(i);
            if (aux.getNomeProduto().equals(nome) || aux.getPrecoProduto() == preco) {
                aux.setNomeProduto(nome);
                aux.setPrecoProduto(preco);
                return true;
            }
        }
        return false;
    }

    public boolean alterarProduto(double preco) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            aux = listaProdutos.get(i);
            if (aux.getPrecoProduto() == preco) {
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

    public void mostrarProduto() {

        for (int i = 0; i < listaProdutos.size(); i++) {
            aux = listaProdutos.get(i);
            System.out.println("Produto: " + aux.getNomeProduto() + "\n"
                    + "Preço: " + aux.getPrecoProduto() + "\n" + "Categoria: " + aux.getCategoria());
        }
    }

    public boolean verificaCodigo(int codigo){
        for(int i = 0; i < listaProdutos.size(); i++){
            aux = listaProdutos.get(i);
            if(aux.getCodigoProduto() == (codigo)){
                return true;
            }
        }
        return false;
    }
}
