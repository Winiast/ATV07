package ifpr.pgua.eic.tads.modelos;

public class ContaCorrenteEspecial extends Conta {

    private double limite;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public ContaCorrenteEspecial(int numeroDaConta, int agencia, Pessoa pessoa, String senha, boolean ativa,
            double saldo) {
        super(numeroDaConta, agencia, pessoa, senha, ativa, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo + limite) {
            saldo = saldo - valor;
            if (saldo < 0) {
                setLimite(limite - saldo);
                saldo = 0;
            }
            return true;
        } else {
            return false;
        }

    }

}
