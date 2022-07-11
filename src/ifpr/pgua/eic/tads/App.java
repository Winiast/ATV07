package ifpr.pgua.eic.tads;

import java.util.ArrayList;
import java.util.Scanner;

import ifpr.pgua.eic.tads.modelos.Banco;
import ifpr.pgua.eic.tads.modelos.ContaCorrente;
import ifpr.pgua.eic.tads.modelos.ContaCorrenteEspecial;
import ifpr.pgua.eic.tads.modelos.ContaPoupanca;
import ifpr.pgua.eic.tads.modelos.Pessoa;
import ifpr.pgua.eic.tads.modelos.PessoaPF;
import ifpr.pgua.eic.tads.modelos.PessoaPJ;

public class App {

    public static String menuGeral() {
        String str = "";

        str += "1 - Conta\n";
        str += "2 - Pessoa\n";
        str += "3 - Banco\n";
        str += "0 - Voltar\n";

        return str;

    }

    public static String menuBanco() {
        String str = "";

        str += "1 - Listar as pessoas\n";
        str += "2 - Listar as contas\n";
        str += "0 - Voltar\n";

        return str;
    }

    public static String menuConta() {
        String str = "";

        str += "1 - Criar conta\n";
        str += "2 - Depositar\n";
        str += "3 - Sacar\n";
        str += "4 - Ver dados\n";
        str += "0 - Sair\n";

        return str;
    }

    public static String menuPessoa() {
        String str = "";
        str += "1 - Cadastrar\n";
        str += "2 - Mostrar\n";
        str += "0 - Voltar\n";

        return str;

    }

    public static String menuTipoPessoa() {
        String str = "";
        str += "1 - Pessoa Juridica\n";
        str += "2 - Pessoa Fisica\n";
        str += "0 - Voltar\n";

        return str;

    }

    public static String menuTipoConta() {
        String str = "";
        str += "1 - Contas Correntes\n";
        str += "2 - Contas Especiais\n";
        str += "3 - Contas Poupancas\n";
        str += "0 - Voltar\n";

        return str;

    }

    public static String menuEscolhaConta() {
        String str = "";
        str += "1 - Conta Corrente\n";
        str += "2 - Conta Especial\n";
        str += "3 - Conta Poupanca\n";
        str += "0 - Voltar\n";

        return str;

    }

    public static void main(String[] args) throws Exception {
        ContaCorrente conta = null;
        ContaPoupanca contaPoupanca = null;
        ContaCorrenteEspecial contaCorrenteEspecial = null;
        Pessoa pessoa = null;
        PessoaPF pessoapf = null;
        PessoaPJ pessoapj = null;
        Banco banco = new Banco("Bamerindus", "009-0099", "001001/00-9");

        Scanner scan = new Scanner(System.in);
        int opcao;

        int numeroDaConta;
        int agencia;
        String documento;
        String senha;
        boolean ativa;
        double saldo, valor;

        String nome, cpf;
        int idade;
        double salario;
        int opcaoPessoa;
        int opcaoConta;

        do {
            System.out.println(menuGeral());
            opcao = scan.nextInt();
            scan.nextLine();
            if (opcao == 2) { // Menu da pessoa
                System.out.println(menuPessoa());
                opcao = scan.nextInt();
                scan.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("Escolha o tipo de pessoa que deseja cadastrar: ");
                        System.out.println(menuTipoPessoa());
                        opcaoPessoa = scan.nextInt();
                        if (opcaoPessoa == 1) {
                            System.out.println("Pesssoa Juridica ainda nao é permitida!");
                            break;
                        } else {
                            scan.nextLine();
                            System.out.println("Digite o nome:");
                            nome = scan.nextLine();
                            System.out.println("Digite o cpf:");
                            cpf = scan.nextLine();
                            System.out.println("Digite a idade:");
                            idade = scan.nextInt();
                            System.out.println("Digite o salario:");
                            salario = scan.nextDouble();

                            pessoapf = new PessoaPF(nome, idade, cpf, salario);

                            if (banco.cadastrarPessoaPF(pessoapf)) {
                                System.out.println("Cadastrada!");
                            } else {
                                System.out.println("Erro ao cadastrar. Documento repetido!");
                            }

                            break;
                        }

                    case 2:
                        System.out.println("Escolha o tipo de pessoa que deseja visualizar: ");
                        System.out.println(menuTipoPessoa());
                        opcaoPessoa = scan.nextInt();
                        if (opcaoPessoa == 1) {
                            System.out.println("Pesssoa Juridica ainda nao é permitida!");
                            break;
                        } else {
                            System.out.println("Detalhes da pessoa");
                            if (pessoapf != null) {
                                System.out.println(pessoapf);
                            } else {
                                System.out.println("Pessoa não criada!");
                            }
                            break;
                        }

                }
            } else if (opcao == 1) {

                System.out.println(menuConta());
                opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("Escolha o tipo de pessoa que deseja cadastrar uma conta: ");
                        System.out.println(menuTipoPessoa());
                        opcaoPessoa = scan.nextInt();
                        if (opcaoPessoa == 1) {
                            System.out.println("Pesssoa Juridica ainda nao é permitida!");
                        } else {
                            System.out.println("Digite o documento da pessoa:");
                            documento = scan.nextLine();
                            pessoapf = banco.buscarPessoaPF(documento);

                            System.out.println("Escolha o tipo de conta que deseja criar: ");
                            System.out.println(menuEscolhaConta());
                            opcaoConta = scan.nextInt();

                            if (pessoapf != null) {
                                System.out.println("Digite o número da conta:");
                                numeroDaConta = scan.nextInt();
                                scan.nextLine();
                                System.out.println("Digite a agência:");
                                agencia = scan.nextInt();
                                scan.nextLine();
                                System.out.println("Digite a senha:");
                                senha = scan.nextLine();

                                System.out.println("Está ativa (1-sim;0-não)");
                                opcao = scan.nextInt();
                                ativa = opcao == 1;
                                System.out.println("Quer informa o saldo? (1-sim;0-não)");
                                opcao = scan.nextInt();

                                if (opcao == 1) {
                                    System.out.println("Digite o saldo:");
                                    saldo = scan.nextDouble();
                                    switch (opcaoConta) {
                                        case 1:
                                            conta = new ContaCorrente(numeroDaConta, agencia, pessoa, senha, ativa,
                                                    saldo);
                                            break;
                                        case 2:
                                            contaCorrenteEspecial = new ContaCorrenteEspecial(numeroDaConta, agencia,
                                                    pessoa, senha,
                                                    ativa,
                                                    saldo);
                                            break;
                                        case 3:
                                            contaPoupanca = new ContaPoupanca(numeroDaConta, agencia,
                                                    pessoa, senha,
                                                    ativa,
                                                    saldo);
                                            break;
                                    }

                                } else {
                                    switch (opcaoConta) {
                                        case 1:
                                            conta = new ContaCorrente(numeroDaConta, agencia, pessoa, senha, ativa);
                                            break;
                                        case 2:
                                            contaCorrenteEspecial = new ContaCorrenteEspecial(numeroDaConta, agencia,
                                                    pessoa, senha,
                                                    ativa);
                                            break;
                                        case 3:
                                            contaPoupanca = new ContaPoupanca(numeroDaConta, agencia,
                                                    pessoa, senha,
                                                    ativa);
                                            break;
                                    }
                                }

                                switch (opcaoConta) {
                                    case 1:
                                        if (banco.cadastarContaCorrente(conta)) {
                                            pessoapf.setContaCorrente(conta);
                                            System.out.println("Conta criada!!");
                                        } else {
                                            System.out.println("Conta não criada!!");
                                        }
                                        break;

                                    case 2:
                                        if (banco.cadastarContaCorrenteEspecial(contaCorrenteEspecial)) {
                                            pessoapf.setContaCorrenteEspecial(contaCorrenteEspecial);
                                            System.out.println("Conta criada!!");
                                        } else {
                                            System.out.println("Conta não criada!!");
                                        }
                                        break;

                                    case 3:
                                        if (banco.cadastarContaPoupanca(contaPoupanca)) {
                                            pessoapf.setContaPoupanca(contaPoupanca);
                                            System.out.println("Conta criada!!");
                                        } else {
                                            System.out.println("Conta não criada!!");
                                        }
                                        break;
                                }

                            } else {
                                System.out.println("Pessoa não encontrada!!!");
                            }
                            break;
                        }

                    case 2:
                        System.out.println("Escolha o tipo de conta que deseja depositar:");
                        System.out.println(menuEscolhaConta());
                        opcaoConta = scan.nextInt();

                        System.out.println("Depositar!");

                        switch (opcaoConta) {
                            case 1:
                                if (conta != null) {
                                    System.out.println("Digite um valor:");
                                    valor = scan.nextDouble();
                                    if (conta.depositar(valor)) {
                                        System.out.println("Realizado!");
                                    } else {
                                        System.out.println("Não Realizado! Valor insuficiente!");
                                    }

                                } else {
                                    System.out.println("Não permitido! Crie uma conta!");
                                }
                                break;
                            case 2:
                                if (contaCorrenteEspecial != null) {
                                    System.out.println("Digite um valor:");
                                    valor = scan.nextDouble();
                                    if (contaCorrenteEspecial.depositar(valor)) {
                                        System.out.println("Realizado!");
                                    } else {
                                        System.out.println("Não Realizado! Valor insuficiente!");
                                    }

                                } else {
                                    System.out.println("Não permitido! Crie uma conta!");
                                }
                                break;

                            case 3:
                                if (contaPoupanca != null) {
                                    System.out.println("Digite um valor:");
                                    valor = scan.nextDouble();
                                    if (contaPoupanca.depositar(valor)) {
                                        System.out.println("Realizado!");
                                    } else {
                                        System.out.println("Não Realizado! Valor insuficiente!");
                                    }

                                } else {
                                    System.out.println("Não permitido! Crie uma conta!");
                                }
                                break;
                        }

                    case 3:
                        System.out.println("Escolha o tipo de conta que deseja sacar:");
                        System.out.println(menuEscolhaConta());
                        opcaoConta = scan.nextInt();

                        System.out.println("Sacar!");

                        switch (opcaoConta) {
                            case 1:
                                if (conta != null) {
                                    System.out.println("Digite um valor:");
                                    valor = scan.nextDouble();
                                    if (conta.sacar(valor)) {
                                        System.out.println("Realizado!");
                                    } else {
                                        System.out.println("Não realizado! Valor inválido ou insuficiente!");
                                    }

                                } else {
                                    System.out.println("Não permitido! Crie uma conta!");
                                }
                                break;
                            case 2:
                                if (contaCorrenteEspecial != null) {
                                    System.out.println("Digite um valor:");
                                    valor = scan.nextDouble();
                                    if (contaCorrenteEspecial.sacar(valor)) {
                                        System.out.println("Realizado!");
                                    } else {
                                        System.out.println("Não realizado! Valor inválido ou insuficiente!");
                                    }

                                } else {
                                    System.out.println("Não permitido! Crie uma conta!");
                                }
                                break;
                            case 3:
                                if (contaPoupanca != null) {
                                    System.out.println("Digite um valor:");
                                    valor = scan.nextDouble();
                                    if (contaPoupanca.sacar(valor)) {
                                        System.out.println("Realizado!");
                                    } else {
                                        System.out.println("Não realizado! Valor inválido ou insuficiente!");
                                    }

                                } else {
                                    System.out.println("Não permitido! Crie uma conta!");
                                }
                                break;
                        }

                    case 4:
                        System.out.println("Extrato!");
                        if (conta != null) {
                            System.out.println(conta);
                        } else {
                            System.out.println("Não existe conta criada!");
                        }

                        break;
                }
            } else if (opcao == 3) {
                System.out.println(menuBanco());
                opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Escolha o tipo de pessoa que deseja visualizar: ");
                        System.out.println(menuTipoPessoa());
                        opcaoPessoa = scan.nextInt();
                        if (opcaoPessoa == 1) {
                            System.out.println("Listar pessoas!");
                            ArrayList<PessoaPJ> lista = banco.getPessoasPJ();
                            for (int i = 0; i < lista.size(); i++) {
                                System.out.println(lista.get(i));
                            }
                            break;
                        } else {
                            System.out.println("Listar pessoas!");
                            ArrayList<PessoaPF> lista = banco.getPessoasPF();
                            for (int i = 0; i < lista.size(); i++) {
                                System.out.println(lista.get(i));
                            }
                            break;
                        }

                    case 2:
                        System.out.println("Escolha o tipo de conta que deseja visualizar: ");
                        System.out.println(menuTipoConta());
                        opcaoConta = scan.nextInt();
                        switch (opcaoConta) {
                            case 1:
                                System.out.println("Listar contas!");
                                ArrayList<ContaCorrente> contas = banco.getContaCorrentes();
                                for (int i = 0; i < contas.size(); i++) {
                                    System.out.println(contas.get(i));
                                }
                                break;

                            case 2:
                                System.out.println("Listar contas!");
                                ArrayList<ContaCorrenteEspecial> contasEspecials = banco.getContaCorrentesEspecials();
                                for (int i = 0; i < contasEspecials.size(); i++) {
                                    System.out.println(contasEspecials.get(i));
                                }
                                break;

                            case 3:
                                System.out.println("Listar contas!");
                                ArrayList<ContaCorrente> contasPoupancas = banco.getContaCorrentes();
                                for (int i = 0; i < contasPoupancas.size(); i++) {
                                    System.out.println(contasPoupancas.get(i));
                                }
                                break;
                        }

                }
            }

        } while (opcao != 0);

    }
}
