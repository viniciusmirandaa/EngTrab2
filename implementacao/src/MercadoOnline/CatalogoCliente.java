package MercadoOnline;

import javax.swing.*;
import java.util.ArrayList;

public class CatalogoCliente {
    Catalogo catalogo = new Catalogo();
    public ArrayList<Produto> listaProdComprados = new ArrayList<>();
    public ArrayList<Produto> listaProd = new ArrayList<>();
    Produto aux;

    public void auxListaProd(Produto p) {
        listaProd.add(p);
    }

    public ArrayList<Produto> mostrarProduto() {
        int i = 0;
        do {
            JOptionPane.showMessageDialog(null, "Para comprar um produto digite sim ou SIM \n" + "Para não comprar digite não ou NÃO" + "\n" + "Para parar de comprar digite Sair.");
            for (int x = 0; x < listaProd.size(); x++) {
                aux = listaProd.get(x);
                String respostaMenu = JOptionPane.showInputDialog("Produto: " + aux.getNomeProduto() + "\n" + "Preço: " + aux.getPrecoProduto());
                switch (respostaMenu) {
                    case "sim":
                    case "SIM":
                    case "Sim":
                        listaProdComprados.add(aux);
                        break;
                    case "não":
                    case "NÃO":
                    case "Não":
                        break;
                    case "Sair":
                        return listaProdComprados;
                }
                i++;
            }
        } while (i < listaProd.size());
        return listaProdComprados;
    }
}
