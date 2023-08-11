package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import cucumber.api.java.pt.Entao;
import pages.SuporteUsuarioPage;
import runner.RunCucumberTest;

public class SuporteUsuarioSteps extends RunCucumberTest {

    SuporteUsuarioPage suporteUsuarioPage = new SuporteUsuarioPage();

    // 1 Cenario: enviar mensagem de ajuda para o suporte do site com sucesso

    @Dado("^que eu esteja na pagina de suporte ao usuario do site$")
    public void pagina_de_suporte_ao_usuario(){
        suporteUsuarioPage.pagina_principal();
        suporteUsuarioPage.pagina_suporte_usuario();
    }

    @Quando("^preencho os campos ASSUNTO, EMAIL, ANEXAR ARQUIVO, REFERENCIA e MENSAGEM$")
    public void preencho_campos_tela(){
        suporteUsuarioPage.selecione_assunto("Customer service");
        suporteUsuarioPage.email("guilhermesilvateste@teste.com");
        suporteUsuarioPage.referencia("Feature de Suporte ao Usuário Cenario 1");
        suporteUsuarioPage.anexar_arquivo("C:\\Users\\LNV\\IntelliJ IDEA\\Projeto01\\arquivos\\arquivo_Upload_PNG.png");
        suporteUsuarioPage.mensagem("Mensagem de teste relacionado a feature de suporte, feita por um usuario do site automationpractice");
    }

    @Quando("^clico no botao ENVIAR$")
    public void clico_botao_enviar(){
        suporteUsuarioPage.click_enviar();
    }

    @Entao("^vejo na tela um alerta de que a mensagem foi enviada para equipe do site$")
    public void msg_enviada_para_equipe_do_site(){
        suporteUsuarioPage.alerta_email_enviado_equipe_site();
    }


    // 2 Cenario: alerta de erro ao nao preencher campo obrigatório

    @Quando("^preencho os campos ASSUNTO, EMAIL, REFERENCIA e ANEXAR ARQUIVO$")
    public void campos_assunto_email_referencia_anexar(){
        suporteUsuarioPage.selecione_assunto("Webmaster");
        suporteUsuarioPage.email("guilhermesilvateste@teste.com");
        suporteUsuarioPage.referencia("Feature de Suporte ao Usuário Cenario 2");
        suporteUsuarioPage.anexar_arquivo("C:\\Users\\LNV\\IntelliJ IDEA\\Projeto01\\arquivos\\arquivo_Upload_JPG.jpg");
    }

    @Quando("^deixo o campo MENSAGEM em branco$")
    public void campo_MENSAGEM_branco(){
        suporteUsuarioPage.mensagem("");
    }

    @Entao("^vejo na tela uma mensagem de que o campo MENSAGEM não pode ficar em branco$")
    public void msg_campo_mensagem_obrigatório(){
        suporteUsuarioPage.alerta_msg_em_branco();
    }


    // 3 Cenario: alerta de erro informando que o email é invalido

    @Quando("^preencho os campos ASSUNTO, ANEXAR ARQUIVO, REFERENCIA e MENSAGEM$")
    public void campos_assunto_anexar_referencia_msg(){
        suporteUsuarioPage.selecione_assunto("Customer service");
        suporteUsuarioPage.anexar_arquivo("C:\\Users\\LNV\\IntelliJ IDEA\\Projeto01\\arquivos\\arquivo_Upload_PNG.png");
        suporteUsuarioPage.referencia("Feature de Suporte ao Usuário Cenario 3");
        suporteUsuarioPage.mensagem("Mensagem de teste relacionado a feature de suporte, feita por um usuario do site automationpractice");
    }

    @Quando("^prencho o campo email com teste123.test$")
    public void campo_email_invalido(){
        suporteUsuarioPage.email("teste123.test");
    }

    @Entao("^vejo na tela uma mensagem de que o email informado é inválido\\.$")
    public void vejo_na_tela_uma_mensagem_de_que_o_email_informado_é_inválido(){
        suporteUsuarioPage.alerta_email_invalido();
    }


    // 4 Cenario: alerta de erro informando que o formato do arquivo é inválido

    @Quando("^preencho os campos ASSUNTO, EMAIL, REFERENCIA e MENSAGEM$")
    public void campos_assunto_email_referencia_msg(){
        suporteUsuarioPage.selecione_assunto("Webmaster");
        suporteUsuarioPage.email("guilhermesilvateste@teste.com");
        suporteUsuarioPage.referencia("Feature de Suporte ao Usuário Cenario 4");
        suporteUsuarioPage.mensagem("Mensagem de teste relacionado a feature de suporte, feita por um usuario do site automationpractice");
    }

    @Quando("^faço o upload de um arquivo em formato de VIDEO no campo ANEXAR ARQUIVO$")
    public void upload_arquivo_formato_invalido(){
        suporteUsuarioPage.anexar_arquivo("C:\\Users\\LNV\\IntelliJ IDEA\\Projeto01\\arquivos\\arquivo_Upload_VIDEO.mp4");
    }

    @Entao("^vejo na tela uma mensagem de que o formato do arquivo é inválido\\.$")
    public void msg_formato_arquivo_invalido(){
        suporteUsuarioPage.alerta_formato_arquivo_invalido();
    }


}
