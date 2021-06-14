package MercadoOnline;

import javax.swing.*;

public class Cliente {
    private String nomeCliente;
    private String endereco;
    private String cpf;
    private String infoCartao;
    private String[] vetCartao;
    private String[] auxVetCartao;
    private int index = 0;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void cadastro() {
        nomeCliente = JOptionPane.showInputDialog(null, "Insira o seu nome: ");
        endereco = JOptionPane.showInputDialog(null, "Insira o seu endereço: ");
        cpf = JOptionPane.showInputDialog(null, "Insira o seu CPF: ");
    }

    public boolean informaCartao() {
        infoCartao = JOptionPane.showInputDialog(null, "Insira a informação do seu cartão: (ex. 1234 1234 1234)");
        vetCartao = infoCartao.split(" ");
        for (String vet : vetCartao) {
            auxVetCartao = vet.split("");
            if (auxVetCartao.length == 4) {
                auxVetCartao = new String[0];
                index++;
            }
        }
        if (index == 3) {
            vetCartao = new String[0];
            index = 0;
            return true;
        } else {
            vetCartao = new String[0];
            index = 0;
            return false;
        }
    }

    public boolean informaCartao(String cartao) {
        infoCartao = cartao;
        vetCartao = infoCartao.split(" ");
        for (String vet : vetCartao) {
            auxVetCartao = vet.split("");
            if (auxVetCartao.length == 4) {
                auxVetCartao = new String[0];
                index++;
            }
        }
        if (index == 3) {
            vetCartao = new String[0];
            return true;
        } else {
            vetCartao = new String[0];
            index = 0;
            return false;
        }
    }
}
