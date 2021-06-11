package MercadoOnline;

public class Administrador {
    private String nomeUsuario;
    private String senha;

    public Administrador(String nomeUsuario, String senha){
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }
}
