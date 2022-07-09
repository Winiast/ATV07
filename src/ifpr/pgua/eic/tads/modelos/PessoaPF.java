package ifpr.pgua.eic.tads.modelos;

public class PessoaPF extends Pessoa {

    private String cpf;

    public PessoaPF(String nome, int idade, String cpf, double salario) {
        super(nome, idade, salario);
        this.cpf = cpf;
    }

    public PessoaPF(String nome, String cpf, int idade) {
        super(nome, cpf, idade);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "PessoaPF []";
    }

}
