package ifpr.pgua.eic.tads.modelos;

public class PessoaPF extends Pessoa {

    private String cpf;

    public PessoaPF(String nome, int idade, String cpf, double salario) {
        super(nome, idade, salario);
        this.cpf = cpf;
    }

    public PessoaPF(String nome, int idade) {
        super(nome, idade, 0.0);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        String str = "";

        str = "PessoaPF[nome:" + nome + ", documento" + cpf + ", idade:" + idade + ", salario:" + salario + "]";

        return str;
    }

}
