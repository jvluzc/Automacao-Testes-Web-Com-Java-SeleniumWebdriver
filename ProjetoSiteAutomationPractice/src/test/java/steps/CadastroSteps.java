package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.CadastroPage;
import runner.RunCucumberTest;

public class CadastroSteps extends RunCucumberTest {

    CadastroPage cadastroPage = new CadastroPage();

    // Cenario 1: cadastro bem sucedido

    @Dado("^que eu esteja na pagina de cadastro$")
    public void pagina_de_cadastro() {
        cadastroPage.acessar_pagina_principal_site();
        cadastroPage.acessar_pagina_cadastro();
    }

    @Quando("^eu preencho todos os campos presentes na tela de cadastro de forma valida$")
    public void campos_tela_de_cadastro() {
        cadastroPage.selecione_sexo_M_ou_F("M");
        cadastroPage.nome("Alexandre");
        cadastroPage.sobrenome("Ventura");
        cadastroPage.senha("Sants18466@G123");
        cadastroPage.data_aniversario(30, 8,"1983");
    }

    @Quando("^clico no botão REGISTRAR$")
    public void btn_registrar() {
        cadastroPage.click_registrar();
    }

    @Entao("^sou redirecionado para minha conta dentro do site$")
    public void redireciona_minha_conta_site() {
        cadastroPage.minha_conta();
    }

    @Entao("^aparece na tela a mensagem de SUA CONTA FOI CRIADA$")
    public void msg_conta_criada_com_sucesso() {
        cadastroPage.msg_cadastro_sucesso();
    }


    //Cenario 2: campo obrigatório em branco

    @Quando("^eu deixo o campo SOBRENOME em branco$")
    public void campo_sobrenome_em_branco(){
        cadastroPage.sobrenome_branco();
    }

    @Quando("^preencho os campos SEXO, NOME, SENHA E DATA NASCIMENTO de forma valida$")
    public void preencho_demais_campos_forma_valida(){
        cadastroPage.selecione_sexo_M_ou_F("F");
        cadastroPage.nome("Rosana");
        cadastroPage.senha("Mellsssgsuw6563g6@#1234");
        cadastroPage.data_aniversario(4, 5,"1964");
    }

    @Entao("^aparece uma menssagem na tela de que o campo sobrenome é obrigatorio$")
    public void msg_campo_sobrenome_obrigatorio(){
        cadastroPage.msg_sobrenome_obrigatorio();
    }


    // Cenario 3: email informado é inválido

    @Quando("^preencho os campos SEXO, NOME, SOBRENOME, SENHA E DATA NASCIMENTO de forma valida$")
    public void campos_cadastro_menos_email() {
        cadastroPage.selecione_sexo_M_ou_F("F");
        cadastroPage.nome("Sarah");
        cadastroPage.sobrenome("Donatto");
        cadastroPage.senha("S@raH5j12310");
        cadastroPage.data_aniversario(5,10, "1992");
    }

    @Quando("^preencho o campo EMAIL com o email test321gmail.com$")
    public void email_pagina_cadastro() {
        cadastroPage.email("test321gmail.com");
    }

    @Entao("^aparece uma menssagem de erro de que o email informado é invalido$")
    public void msg_de_erro_email_invalido() {
        cadastroPage.msg_email_invalido();
    }


    // Cenario 4: email informado já está cadastrado em outra conta

    @Quando("^prencho o campo EMAIL com um email que já cadastrei anteriormente em outra conta$")
    public void prencho_com_email_ja_cadastrado(){
        cadastroPage.email("sarahtest@teste.com");
    }

    @Entao("^aparece uma menssagem na tela de o email informado já está viculado a outra conta$")
    public void msg_email_informado_ja_viculado_a_outra_conta(){
        cadastroPage.msg_email_vinculado_outra_conta();
    }


    // Cenario 5 : senha inválida

    @Quando("^preencho os campos SEXO, NOME, SOBRENOME, EMAIL e DATA NASCIMENTO de forma valida$")
    public void campos_cadastro_menos_senha(){
        cadastroPage.selecione_sexo_M_ou_F("M");
        cadastroPage.nome("Jefferson");
        cadastroPage.sobrenome("Feitosa da Silva");
        cadastroPage.data_aniversario(2,4, "1973");
    }

    @Quando("^prencho o campo SENHA com menos de 5 caracteres$")
    public void prencho_campo_senha_invalida(){
        cadastroPage.senha("1234");
    }

    @Entao("^aparece uma menssagem de erro de que a senha informada é invalida$")
    public void msg_senha_informada_invalida(){
        cadastroPage.msg_senha_invalida();
    }


}
