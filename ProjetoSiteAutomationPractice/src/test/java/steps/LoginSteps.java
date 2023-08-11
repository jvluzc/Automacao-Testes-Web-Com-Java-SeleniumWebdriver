package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import pages.CadastroPage;
import pages.LoginPage;
import runner.RunCucumberTest;
import suport.Utils;

public class LoginSteps extends RunCucumberTest {

    LoginPage loginPage = new LoginPage();


    // 1 Cenario: login bem sucedido

    @Dado("^que estou na pagina de login do site$")
    public void pagina_login(){
        loginPage.acessar_pagina_principal_site();
        loginPage.acessar_pagina_login();
    }

    @Quando("^preencho os campos obrigatórios com valores válidos$")
    public void campos_obrigatorios_validos(){
        loginPage.email_login("guilhermesilvatest@teste.com.br");
        loginPage.senha_login("123456");
    }

    @Quando("^clico no botão ENTRAR$")
    public void click_botao_ENTRAR(){
        loginPage.botao_fazer_login();
    }

    @Entao("^tenho acesso a minha conta dentro do site$")
    public void minha_conta_site(){
        loginPage.minha_conta();
    }


    // 2 Cenario: email ainda nao cadastrado

    @Quando("^preencho o campo EMAIL com um email ainda não cadastrado$")
    public void preencher_email_nao_cadastrado(){
        loginPage.email_login (Utils.getEmailAleatorio());
    }

    @Quando("^preencho o campo SENHA com uma valor válido$")
    public void preencher_senha_valida(){
        loginPage.senha_login("123456");
    }

    @Entao("^aparece uma mensagem de erro na tela de falha na autenticação$")
    public void msg_email_nao_cadastrado(){
        loginPage.falha_autenticacao_email();
    }


    // 3 Cenario: senha inserida é inválida

    @Quando("^preencho o campo EMAIL com um email já cadastrado$")
    public void email_cadastrado(){
        loginPage.email_login("guilhermesilvateste@teste.com");
    }

    @Quando("^preencho o campo senha de forma inválida$")
    public void senha_inválida(){
        loginPage.senha_login("1234");
    }

    @Entao("^aparece uma mensagem na tela informando que a senha é invalida$")
    public void msg_senha_invalida(){
        loginPage.falha_autenticacao_senha();
    }


    // 4 Cenario: campo obrigatório não preenchido

    @Quando("^não prencho o campo senha$")
    public void campo_senha_branco(){
        loginPage.senha_login("");
    }

    @Entao("^aparece uma mensagem na tela de que o campo senha é obrigatório$")
    public void msg_campo_senha_obrigatorio(){
        loginPage.falha_senha_branco();
    }


    // 5 Cenario: recuperação de senha de um email já cadastrado

    @Dado("^clico em ESQUECEU SUA SENHA$")
    public void clico_em_ESQUECEU_SUA_SENHA(){
        loginPage.click_esqueceu_senha();
    }

    @Entao("^sou redirecionado para pagina de recuperaçao de senha$")
    public void pagina_recuperacao_de_senha(){
        loginPage.tela_recuperar_senha();
    }

    @Quando("^informo meu email já cadastrado no campo ENDEREÇO DE EMAIL$")
    public void informo_email_ja_cadastrado(){
        loginPage.email_recuperar_senha("guilhermesilvateste@teste.com");
    }

    @Quando("^clico em RECUPERAR SENHA$")
    public void clico_em_RECUPERAR_SENHA(){
        loginPage.click_botao_recuperar_senha();
    }

    @Entao("^uma mensagem de que um email para recuperar minha senha foi enviada para meu email$")
    public void msg_email_recuperacao_senha_enviado(){
        loginPage.confirmacao_email_recuperaao_senha_enviado();
    }


    // 6 Cenario: erro recuperação de senha de email não cadastrado

    @Quando("^informo um email ainda não cadastrado no campo ENDEREÇO DE EMAIL$")
    public void email_nao_cadastrado(){
        loginPage.email_recuperar_senha(Utils.getEmailAleatorio());
    }

    @Entao("^uma mensagem de erro aparece na tela de que nenhuma conta foi registrada com esse endereço de email$")
    public void msg_nenhuma_conta_registrada_com_email_informado(){
        loginPage.email_recuperar_senha_invalido();
    }


}
