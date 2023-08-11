package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.RunCucumberTest;
import suport.Utils;

public class LoginPage extends RunCucumberTest {

    private By click_entrar = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info");
    private By campo_login_email = By.id("email");
    private By campo_login_senha = By.id("passwd");
    private By botao_entrar_login = By.id("SubmitLogin");
    private By recuperar_senha = By.cssSelector("#login_form > div > p.lost_password.form-group > a");

    private By campo_email_recuperar_senha = By.id("email");

    private By botao_recuperar_senha = By.cssSelector("#form_forgotpassword > fieldset > p > button");


    public void acessar_pagina_principal_site() {
        getDriver(Browser.CHROME);
        getDriver().get("http://www.automationpractice.pl/");
   }

    public void acessar_pagina_login() {
        getDriver().findElement(click_entrar).click();
        Assert.assertTrue(getDriver().findElement(botao_entrar_login).isDisplayed());
    }

    public void email_login(String email) {
        getDriver().findElement(campo_login_email).sendKeys(email);
    }

    public void senha_login( String senha) {
        getDriver().findElement(campo_login_senha).sendKeys(senha);
    }

    public void botao_fazer_login() {
        getDriver().findElement(botao_entrar_login).click();
    }

    public void minha_conta() {
        By estou_minha_conta = By.xpath("//*[@id=\"center_column\"]/div/div/ul/li[5]/a");
        Utils.esperarElementoEstarPresenteTela(estou_minha_conta, 7);
        Assert.assertTrue(getDriver().findElement(estou_minha_conta).isDisplayed());
    }

    public void falha_autenticacao_email(){
        By alerta_falha_na_autenticacao = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
        String texto_alerta_falha_autenticacao = getDriver().findElement(alerta_falha_na_autenticacao).getText();
        Assert.assertEquals("Authentication failed.", texto_alerta_falha_autenticacao);
    }

    public void falha_autenticacao_senha(){
        By alerta_senha_invalida = By.cssSelector("#center_column > div.alert.alert-danger > ol > li");
        String texto_alerta_falha_senha = getDriver().findElement(alerta_senha_invalida).getText();
        Assert.assertEquals("Invalid password.", texto_alerta_falha_senha);
    }

    public void falha_senha_branco(){
        By alerta_senha_branco = By.cssSelector("#center_column > div.alert.alert-danger > ol > li");
        String texto_alerta_senha_branco = getDriver().findElement(alerta_senha_branco).getText();
        Assert.assertEquals("Password is required.", texto_alerta_senha_branco);
    }

    public void click_esqueceu_senha(){
        getDriver().findElement(recuperar_senha).click();
    }

    public void tela_recuperar_senha() {
        Utils.esperarElementoEstarPresenteTela(botao_recuperar_senha, 7);
        Assert.assertTrue(getDriver().findElement(botao_recuperar_senha).isDisplayed());
    }

    public void email_recuperar_senha(String email) {
        getDriver().findElement(campo_email_recuperar_senha).sendKeys(email);
    }

    public void click_botao_recuperar_senha(){
        getDriver().findElement(botao_recuperar_senha).click();
    }

    public void confirmacao_email_recuperaao_senha_enviado() {
        By alerta_recuperacao_senha = By.cssSelector("#center_column > div > p");
        String texto_alerta_recuperacao_senha = getDriver().findElement(alerta_recuperacao_senha).getText();
        Assert.assertEquals("A confirmation email has been sent to your address: guilhermesilvateste@teste.com", texto_alerta_recuperacao_senha);
    }

    public void email_recuperar_senha_invalido() {
        By alerta_email_recuperacao_senha_invalido = By.cssSelector("#center_column > div > div > ol > li");
        String texto_email_recuperacao_senha_invalido = getDriver().findElement(alerta_email_recuperacao_senha_invalido).getText();
        Assert.assertEquals("There is no account registered for this email address.", texto_email_recuperacao_senha_invalido);
    }


}




