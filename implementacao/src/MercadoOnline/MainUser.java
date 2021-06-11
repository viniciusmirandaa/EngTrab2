package MercadoOnline;

public class MainUser {

    public static void main(String[] args) {
        Cliente usuario = new Cliente();
        CatalogoCliente catalogoCliente = new CatalogoCliente();
        boolean result = usuario.cadastro();
        catalogoCliente.mostrarProduto();

    }


}
