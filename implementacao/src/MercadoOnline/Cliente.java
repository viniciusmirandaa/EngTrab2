package MercadoOnline;

import javax.swing.*;

public class Cliente {
    private String nomeCliente;
    private String endereco;
    private String cpf;

    String []vetCartao;
    String []auxVetCartao;
    int i = 0;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getInfoCartao() {
        return infoCartao;
    }

    public void setInfoCartao(String infoCartao) {
        this.infoCartao = infoCartao;
    }

    private String infoCartao;

    public void cadastro(){
        nomeCliente = JOptionPane.showInputDialog(null, "Insira o seu nome: ");
        endereco = JOptionPane.showInputDialog(null, "Insira o seu endereço: ");
        cpf = JOptionPane.showInputDialog(null, "Insira o seu CPF: ");

    }

    public boolean informarCartao(){
        infoCartao = JOptionPane.showInputDialog(null, "Insira a informação do seu cartão: (ex. 1234 1234 1234)");
        vetCartao = infoCartao.split(" ");
        for(String vet : vetCartao){
            auxVetCartao = vet.split("");
            if(auxVetCartao.length == 4){
                auxVetCartao = new String[0];
                i++;
            }
        }
        if(i == 3){
            vetCartao = new String[0];
            i = 0;
            return true;
        }else{
            vetCartao = new String[0];
            i = 0;
            return false;
        }
    }

    public boolean informaCartao(String cartao){
        infoCartao = cartao;
        vetCartao = infoCartao.split(" ");
        for(String vet : vetCartao){
            auxVetCartao = vet.split("");
            if(auxVetCartao.length == 4){
                auxVetCartao = new String[0];
                i++;
            }
        }
        if(i == 3){
            vetCartao = new String[0];
            return true;
        }else{
            vetCartao = new String[0];
            i = 0;
            return false;
        }
    }
}
