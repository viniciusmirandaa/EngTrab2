package MercadoOnline;

import sun.applet.Main;

import javax.swing.*;

public class MainUser {

    public static void main(String[] args) {
        int i = 0;
        Cliente usuario = new Cliente();
        Catalogo c = new Catalogo();
        usuario.cadastro();
        c.mostrarProduto();

        boolean result = usuario.informarCartao();
        while(i <= 2) {
            if (!result) {
                String infCart = JOptionPane.showInputDialog("Redigite o número do cartão, de forma que seja válido: \n" + "Você tem " + (3 - i) + " tentativas.");
                usuario.informaCartao(infCart);
            }
            i++;
        }
    }


}
