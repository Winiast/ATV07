package ifpr.pgua.eic.tads.modelos;

import java.util.ArrayList;

public class Banco {

    private String nome;
    private String telefone;
    private String cnpj;
    private ArrayList<PessoaPJ> pessoasPJ;
    private ArrayList<PessoaPF> pessoasPF;
    private ArrayList<ContaCorrente> contaCorrentes;
    private ArrayList<ContaCorrenteEspecial> contaCorrenteEspecials;
    private ArrayList<ContaPoupanca> contaPoupancas;
    private int qtdePessoasPF, qtdePessoasPJ;
    private int qtdeContasCorrentes, qtdeContasCorrentesEspeciais, qtdeContasPoupancas;

    public Banco(String nome, String telefone, String cnpj) {
        this.nome = nome;
        this.telefone = telefone;
        this.cnpj = cnpj;
        pessoasPJ = new ArrayList<PessoaPJ>();
        pessoasPF = new ArrayList<PessoaPF>();
        qtdePessoasPF = 0;
        qtdePessoasPJ = 0;
        contaCorrentes = new ArrayList<>();
        contaCorrenteEspecials = new ArrayList<>();
        contaPoupancas = new ArrayList<>();
        qtdeContasCorrentes = 0;
        qtdeContasCorrentesEspeciais = 0;
        qtdeContasPoupancas = 0;
    }

    // PF
    public PessoaPF buscarPessoaPF(String documento) {
        for (int i = 0; i < pessoasPF.size(); i++) {
            if (pessoasPF.get(i).getCpf().equals(documento)) {
                return pessoasPF.get(i);
            }
        }

        return null;
    }

    // PJ
    public PessoaPJ buscarPessoaPJ(String documento) {
        for (int i = 0; i < pessoasPJ.size(); i++) {
            if (pessoasPJ.get(i).getCpnj().equals(documento)) {
                return pessoasPJ.get(i);
            }
        }

        return null;
    }

    public ContaCorrente buscarConta(int numero, int agencia) {

        for (ContaCorrente conta : contaCorrentes) {
            if (conta.getNumeroDaConta() == numero && conta.getAgencia() == agencia) {
                return conta;
            }
        }

        return null;
    }

    // PF
    public boolean cadastrarPessoaPF(PessoaPF pessoaPF) {
        if (buscarPessoaPF(pessoaPF.getCpf()) == null) {
            this.pessoasPF.add(pessoaPF);
            qtdePessoasPF += 1;
            return true;
        }

        return false;

    }

    // PJ

    public boolean cadastrarPessoaPJ(PessoaPJ pessoaPJ) {
        if (buscarPessoaPJ(pessoaPJ.getCpnj()) == null) {
            this.pessoasPJ.add(pessoaPJ);
            qtdePessoasPJ += 1;
            return true;
        }

        return false;

    }

    // PF
    public ArrayList<PessoaPF> getPessoasPF() {
        return pessoasPF;
    }

    // PJ

    public ArrayList<PessoaPJ> getPessoasPJ() {
        return pessoasPJ;
    }

    public boolean cadastarContaCorrente(ContaCorrente conta) {
        if (buscarConta(conta.getNumeroDaConta(), conta.getAgencia()) == null) {
            this.contaCorrentes.add(conta);
            qtdeContasCorrentes += 1;
            return true;
        }

        return false;

    }

    public boolean cadastarContaCorrenteEspecial(ContaCorrenteEspecial conta) {
        if (buscarConta(conta.getNumeroDaConta(), conta.getAgencia()) == null) {
            this.contaCorrenteEspecials.add(conta);
            qtdeContasCorrentesEspeciais += 1;
            return true;
        }

        return false;

    }

    public boolean cadastarContaPoupanca(ContaPoupanca conta) {
        if (buscarConta(conta.getNumeroDaConta(), conta.getAgencia()) == null) {
            this.contaPoupancas.add(conta);
            qtdeContasPoupancas += 1;
            return true;
        }

        return false;

    }

    public ArrayList<ContaCorrente> getContaCorrentes() {
        return contaCorrentes;
    }

    public ArrayList<ContaCorrenteEspecial> getContaCorrentesEspecials() {
        return contaCorrenteEspecials;
    }

    public ArrayList<ContaPoupanca> getContaPoupancas() {
        return contaPoupancas;
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
