package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import runner.RunCucumberTest;
import suport.Utils;

public class SuporteUsuarioPage extends RunCucumberTest {

    private By botao_entrar = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info");
    private By botao_redireciona_suporte_usuario = By.id("contact-link");
    private By selecione_assunto_atendimento = By.id("id_contact");
    private By campo_email = By.id("email");
    private By campo_referencia = By.id("id_order");
    private By campo_anexar_arquivo = By.id("fileUpload");
    private By campo_mensagem = By.id("message");
    private By botao_enviar_msg = By.id("submitMessage");



    public void pagina_principal() {
        getDriver(Browser.CHROME);
        getDriver().get("http://www.automationpractice.pl/");
        Assert.assertTrue(getDriver().findElement(botao_entrar).isDisplayed());
    }

    public void pagina_suporte_usuario(){
        getDriver().findElement(botao_redireciona_suporte_usuario).click();
        Assert.assertTrue(getDriver().findElement(campo_mensagem).isDisplayed());
    }

    public void selecione_assunto(String assunto){
        Select seleciona_assunto = new Select(getDriver().findElement(selecione_assunto_atendimento));
        seleciona_assunto.selectByVisibleText(assunto);
    }

    public void email(String email){
        getDriver().findElement(campo_email).sendKeys(email);
    }

    public void referencia(String referencia){
        getDriver().findElement(campo_referencia).sendKeys(referencia);
    }

    public void anexar_arquivo(String caminho_arquivo){
        getDriver().findElement(campo_anexar_arquivo).sendKeys(caminho_arquivo);
    }

    public void mensagem(String mensagem){
        getDriver().findElement(campo_mensagem).sendKeys(mensagem);
    }

    public void click_enviar() {
        getDriver().findElement(botao_enviar_msg).click();
    }

    public void alerta_email_enviado_equipe_site(){
        By alerta_sucesso_msg_enviada = By.cssSelector("#center_column > p");
        String texto_alerta_sucesso_msg_enviada = getDriver().findElement(alerta_sucesso_msg_enviada).getText();
        Assert.assertEquals("Your message has been successfully sent to our team.", texto_alerta_sucesso_msg_enviada);
    }

    public void alerta_msg_em_branco(){
        By alerta_msg_branco = By.cssSelector("#center_column > div > ol");
        String texto_alerta_msg_branco = getDriver().findElement(alerta_msg_branco).getText();
        Assert.assertEquals("The message cannot be blank.", texto_alerta_msg_branco);
    }

    public void alerta_email_invalido(){
        By alerta_msg_email_invalido = By.cssSelector("#center_column > div > ol");
        String texto_alerta_msg_email_invalido = getDriver().findElement(alerta_msg_email_invalido).getText();
        Assert.assertEquals("Invalid email address.", texto_alerta_msg_email_invalido);
    }

    public void alerta_formato_arquivo_invalido(){
        By alerta_arquivo_invalido = By.cssSelector("#center_column > div > ol");
        String texto_alerta_arquivo_invalido = getDriver().findElement(alerta_arquivo_invalido).getText();
        Assert.assertEquals("Bad file extension", texto_alerta_arquivo_invalido);
    }


}
