package MercadoOnline;

import com.sun.security.ntlm.Client;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MainAdminTest {

    @Test
    void main() {
        Catalogo catalogo = new Catalogo();
        Cliente cliente = new Cliente();
        CatalogoCliente catalogoCliente = new CatalogoCliente();
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        OtimizacaoProdutos otimizacaoProdutos = new OtimizacaoProdutos();
        Pagamento pagamento = new Pagamento();
        HashMap<Produto, Integer> retornoMenu;
        int i = 0;
        Produto produto = new Produto("Coca Cola", 7, Produto.Categoria.Refrigerante, 1);
        Produto produto2 = new Produto("Fanta", 5, Produto.Categoria.Refrigerante, 2);
        Produto produto3 = new Produto("Dolly", 6, Produto.Categoria.Refrigerante, 3);
        Produto produto4 = new Produto("Garoto", 7, Produto.Categoria.Chocolate, 4);
        Produto produto5 = new Produto("Diamante Negro", 8, Produto.Categoria.Chocolate, 5);
        Produto produto6 = new Produto("Crunchy", 5, Produto.Categoria.Chocolate, 6);
        Produto produto8 = new Produto("Barriguinha Mole", 5, Produto.Categoria.Leite, 7);
        Produto produto7 = new Produto("Jussara", 5, Produto.Categoria.Leite, 8);
        Produto produto9 = new Produto("Longa Vida", 5, Produto.Categoria.Leite, 9);
        Produto produto10 = new Produto("Fofura", 5, Produto.Categoria.Salgadinho, 10);
        Produto produto11 = new Produto("Doritos", 8, Produto.Categoria.Salgadinho, 11);
        Produto produto12 = new Produto("Pringles", 13, Produto.Categoria.Salgadinho, 12);

        catalogo.cadastrarProduto(produto, produto2, produto3, produto4, produto5, produto6, produto7, produto8, produto9);
        catalogo.cadastrarProduto(produto10, produto11, produto12);

        cliente.cadastro();
        retornoMenu = catalogoCliente.mostrarProduto();
        for (Produto p : retornoMenu.keySet()) {
            carrinhoDeCompras.adicionarProdutos(p, retornoMenu.get(p));
        }

        boolean result = cliente.informarCartao();
        while (i <= 2) {
            if (!result) {
                String infCart = JOptionPane.showInputDialog("Redigite o número do cartão, de forma que seja válido: \n" + "Você tem " + (3 - i) + " tentativas.");
                result = cliente.informaCartao(infCart);
            }
            i++;
        }

        pagamento.finalizarCompra(result, cliente, carrinhoDeCompras);

        otimizacaoProdutos.analiseProdutos(Produto.Categoria.Chocolate);
        otimizacaoProdutos.analiseProdutos(Produto.Categoria.Refrigerante);
        otimizacaoProdutos.analiseProdutos(Produto.Categoria.Leite);
        otimizacaoProdutos.analiseProdutos(Produto.Categoria.Salgadinho);
    }
}