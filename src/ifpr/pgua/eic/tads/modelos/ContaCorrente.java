package ifpr.pgua.eic.tads.modelos;

public class ContaCorrente extends Conta {

    public ContaCorrente(int numeroDaConta, int agencia, Pessoa pessoa, String senha,
            boolean ativa, double saldo) {
        super(numeroDaConta, agencia, pessoa, senha, ativa, saldo);

    }

    public ContaCorrente(int numeroDaConta, int agencia, Pessoa pessoa, String senha,
            boolean ativa) {
        super(numeroDaConta, agencia, pessoa, senha, ativa, 0.0);
    }

}