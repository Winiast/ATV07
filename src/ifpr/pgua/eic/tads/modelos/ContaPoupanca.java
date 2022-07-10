package ifpr.pgua.eic.tads.modelos;

public class ContaPoupanca extends Conta {

    double valor;

    private double rendimento = 0.13; // 13 % Proximo a selic =p

    public ContaPoupanca(int numeroDaConta, int agencia, Pessoa pessoa, String senha, boolean ativa, double saldo) {
        super(numeroDaConta, agencia, pessoa, senha, ativa, saldo);
    }

    public ContaPoupanca(int numeroDaConta, int agencia, Pessoa pessoa, String senha, boolean ativa) {
        super(numeroDaConta, agencia, pessoa, senha, ativa, 0.0);
    }

    public void render() {
        valor = saldo * rendimento;
        this.saldo = saldo + valor;
    }
}
