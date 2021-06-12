package MercadoOnline;

import static org.junit.jupiter.api.Assertions.*;

class MainAdminTest {

    @org.junit.jupiter.api.Test
    void main() {
        Produto p = new Produto("Calça", 25, "Roupa", 1);
        Produto p1 = new Produto("Calça2", 25, "Roupa", 2);
        Produto p2 = new Produto("Calça3", 25, "Roupa", 3);
        Catalogo c = new Catalogo();
        CatalogoCliente cl = new CatalogoCliente();
        c.cadastrarProduto(p);
        c.cadastrarProduto(p1);
        c.cadastrarProduto(p2);
        assertEquals(3, Catalogo.listaProdutos.size());


//        assertEquals(3, c.getQuantidade());
    }
}