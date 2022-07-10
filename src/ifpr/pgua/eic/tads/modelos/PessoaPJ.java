package ifpr.pgua.eic.tads.modelos;

public class PessoaPJ extends Pessoa {

    private String cnpj;

    public PessoaPJ(String nome, int idade, String cnpj, double salario) {
        super(nome, idade, salario);
        this.cnpj = cnpj;
    }

    public PessoaPJ(String nome, String cpf, int idade) {
        super(nome, cpf, idade);
    }

    public String getCpnj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        String str = "";

        str = "PessoaPF[nome:" + nome + ", CNPJ" + cnpj + ", idade:" + idade + ", salario:" + salario + "]";

        return str;
    }

}
