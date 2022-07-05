package ifpr.pgua.eic.tads.modelos;

import java.util.ArrayList;

public class Banco {
    
    private String nome;
    private String telefone;
    private String cnpj;
    private ArrayList<Pessoa> pessoas;
    private ArrayList<ContaCorrente> contaCorrentes;
    private int qtdePessoas;
    private int qtdeContas;
  

    public Banco(String nome, String telefone, String cnpj) {
        this.nome = nome;
        this.telefone = telefone;
        this.cnpj = cnpj;
        pessoas = new ArrayList<Pessoa>();
        qtdePessoas = 0;
        contaCorrentes = new ArrayList<>();
        qtdeContas = 0;

    }


    public Pessoa buscarPessoa(String documento){
        for(int i=0;i<pessoas.size();i++){
            if(pessoas.get(i).getCpf().equals(documento)){
                return pessoas.get(i);
            }
        }

        return null;
    }

    public ContaCorrente buscarConta(int numero, int agencia){

        for(ContaCorrente conta:contaCorrentes){
            if(conta.getNumeroDaConta()==numero && conta.getAgencia()==agencia){
                return conta;
            }
        }

        return null;
    }


    public boolean cadastrarPessoa(Pessoa pessoa){
        if(buscarPessoa(pessoa.getCpf())== null){
            this.pessoas.add(pessoa);
            qtdePessoas += 1;
            return true;
        }

        return false;
        
    }

    public ArrayList<Pessoa> getPessoas(){
        return pessoas;
    }

    public boolean cadastarConta(ContaCorrente conta){
        if(buscarConta(conta.getNumeroDaConta(), conta.getAgencia())==null){
            this.contaCorrentes.add(conta);
            qtdeContas += 1;
            return true;
        }

        return false;
        
    }

    public ArrayList<ContaCorrente> getContaCorrentes(){
        return contaCorrentes;
    }
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



}
