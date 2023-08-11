package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import runner.RunCucumberTest;
import suport.Utils;

public class CadastroPage extends RunCucumberTest {

    private By click_entrar = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info");

    private By email_criar_conta = By.id("email_create");

    private By botao_redireiona_tela_cadastro = By.id("SubmitCreate");

    private By Titulo_Mr = By.id("id_gender1");

    private By Titulo_Mrs = By.id("id_gender2");

    private By campo_nome = By.id("customer_firstname");

    private By campo_sobrenome = By.id("customer_lastname");

    private By campo_email = By.id("email");

    private By campo_senha = By.id("passwd");

    private By campo_selecione_dia_nascimento = By.id("days");

    private By campo_selecione_mes_nascimento = By.id("months");

    private By campo_selecione_ano_nascimento = By.id("years");

    private By botao_registro = By.id("submitAccount");



    public void acessar_pagina_principal_site() {
        getDriver(Browser.CHROME);
        getDriver().get("http://www.automationpractice.pl/");
    }

    public void acessar_pagina_cadastro() {
        getDriver().findElement(click_entrar).click();
        getDriver().findElement(email_criar_conta).sendKeys(Utils.getEmailAleatorio());
        getDriver().findElement(botao_redireiona_tela_cadastro).click();
        Utils.esperarElementoEstarPresenteTela(botao_registro, 7);
        Assert.assertTrue(getDriver().findElement(botao_registro).isDisplayed());
    }

    public void selecione_sexo_M_ou_F(String sexo) {
        if (sexo == "M") {
            getDriver().findElement(Titulo_Mr).click();
        } else if (sexo == "F") {
                getDriver().findElement(Titulo_Mrs).click();
            }
    }

    public void nome(String n) {
        getDriver().findElement(campo_nome).sendKeys(n);
    }

    public void sobrenome(String s) {
        getDriver().findElement(campo_sobrenome).sendKeys(s);
    }

    public void senha(String passwd) {
        getDriver().findElement(campo_senha).sendKeys(passwd);
    }

    public void data_aniversario(Integer dia, Integer mes, String ano) {
        Select selecione_dia = new Select(getDriver().findElement(campo_selecione_dia_nascimento));
        selecione_dia.selectByIndex(dia);

        Select selecione_mes = new Select(getDriver().findElement(campo_selecione_mes_nascimento));
        selecione_mes.selectByIndex(mes);

        Select selecione_ano = new Select(getDriver().findElement(campo_selecione_ano_nascimento));
        selecione_ano.selectByValue(ano);
    }

    public void click_registrar() {
        getDriver(). findElement(botao_registro).click();
    }

    public void minha_conta() {
        By estou_minha_conta = By.xpath("//*[@id=\"center_column\"]/div/div/ul/li[5]/a");
        Utils.esperarElementoEstarPresenteTela(estou_minha_conta, 7);
        Assert.assertTrue(getDriver().findElement(estou_minha_conta).isDisplayed());
    }

    public void msg_cadastro_sucesso() {
        By alerta_cadastro_realizado = By.cssSelector("#center_column > p.alert.alert-success");
        String texto_cadastro_realizado = getDriver().findElement(alerta_cadastro_realizado).getText();
        Assert.assertEquals("Your account has been created.", texto_cadastro_realizado);
    }

    public void sobrenome_branco(){
        Assert.assertTrue(getDriver().findElement(campo_sobrenome).isDisplayed());
    }


    public void msg_sobrenome_obrigatorio() {
        By alerta_sobrenome_n_preenchido = By.xpath("//*[@id=\"center_column\"]/div/ol/li");
        String texto_sobrenome_obrigatorio = getDriver().findElement(alerta_sobrenome_n_preenchido).getText();
        Assert.assertEquals("lastname is required.", texto_sobrenome_obrigatorio);
    }

    public void email(String email){
        getDriver().findElement(campo_email).clear();
        getDriver().findElement(campo_email).sendKeys(email);
    }

    public void msg_email_invalido(){
        By alerta_email_invalido = By.xpath("//*[@id=\"center_column\"]/div/ol/li");
        String texto_email_invalido = getDriver().findElement(alerta_email_invalido).getText();
        Assert.assertEquals("email is invalid.", texto_email_invalido);
    }

    public void msg_email_vinculado_outra_conta() {
        By alerta_email_ja_cadastrado = By.cssSelector("#center_column > div > ol > li");
        String texto_email_ja_cadastrado = getDriver().findElement(alerta_email_ja_cadastrado).getText();
        Assert.assertEquals("An account using this email address has already been registered.", texto_email_ja_cadastrado);
    }

    public void msg_senha_invalida() {
        By alerta_senha_invalida = By.cssSelector("#center_column > div > ol > li");
        String texto_senha_invalida = getDriver().findElement(alerta_senha_invalida).getText();
        Assert.assertEquals("passwd is invalid.", texto_senha_invalida);
    }


}
