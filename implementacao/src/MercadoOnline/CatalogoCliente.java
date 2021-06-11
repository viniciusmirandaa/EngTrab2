package MercadoOnline;

import javax.swing.*;
import java.util.ArrayList;

public class CatalogoCliente {

    public void mostrarProduto() {

        Produto aux;
        Catalogo c = new Catalogo();
        int i = 0;

        System.out.println(c.listaProdutos.size());

//        do {
//            JOptionPane.showMessageDialog(null, "Para comprar um produto digite sim ou SIM \n" + "Para não comprar digite não ou NÃO" + "\n" + "Para parar de comprar digite Sair.");
//            for (int x = 0; x < c.listaProdutos.size(); x++) {
//                aux = c.listaProdutos.get(x);
//                String respostaMenu = JOptionPane.showInputDialog("Produto: " + aux.getNomeProduto() + "\n" + "Preço: " + aux.getPrecoProduto());
//                switch (respostaMenu) {
//                    case "sim":
//                    case "SIM":
//                        c.listaProdComprados.add(aux);
//                        break;
//                    case "não":
//                    case "NÃO":
//                        break;
//                    case "Sair":
//                        return c.listaProdComprados;
//                }
//                i++;
//            }
//        } while (i < c.listaProdutos.size());
//        return c.listaProdComprados;
    }
}
