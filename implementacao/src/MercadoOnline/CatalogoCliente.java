package MercadoOnline;

import javax.swing.*;
import java.util.HashMap;

public class CatalogoCliente {

    Produto aux;
    HashMap<Produto, Integer> produtosComprados = new HashMap<>();

    public HashMap<Produto, Integer> mostrarProduto() {
        int i = 0;
        do {
            JOptionPane.showMessageDialog(null, "Para comprar um produto digite Sim \n" + "Para não comprar digite Não" + "\n" + "Para parar de comprar digite Sair.");
            for (int x = 0; x < Catalogo.listaProdutos.size(); x++) {
                aux = Catalogo.listaProdutos.get(x);
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
        } while (i < Catalogo.listaProdutos.size());
        return produtosComprados;
    }
}
