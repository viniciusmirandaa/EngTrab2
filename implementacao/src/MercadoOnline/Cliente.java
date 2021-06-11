package MercadoOnline;

import javax.swing.*;

public class Cliente {
    private String nomeCliente;
    private String endereco;
    private String cpf;

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
        endereco = JOptionPane.showInputDialog(null, "Insira o seu endeereco: ");
        cpf = JOptionPane.showInputDialog(null, "Insira o seu CPF: ");
        infoCartao = JOptionPane.showInputDialog(null, "Insira a informação do seu cartão: ");
    }
}
