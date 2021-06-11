package MercadoOnline;

import javax.swing.*;

public class CatalogoCliente {

    public void mostrarProduto() {

        Produto aux;
        Catalogo c = new Catalogo();

        JOptionPane.showMessageDialog(null, "Para comprar um produto digite sim ou SIM \n" + "Para não comprar digite não ou NÃO");

        for (int i = 0; i < c.listaProdutos.size(); i++) {
            aux = c.listaProdutos.get(i);
            String respostaMenu = JOptionPane.showInputDialog("Produto: " + aux.getNomeProduto() + "\n" + "Preço: " + aux.getPrecoProduto());
            switch (respostaMenu) {
                case "sim":
                case "SIM":
                    c.listaProdComprados.add(aux);
                    break;
                case "não":
                case "NÃO":
                    break;
            }
        }
    }
}
