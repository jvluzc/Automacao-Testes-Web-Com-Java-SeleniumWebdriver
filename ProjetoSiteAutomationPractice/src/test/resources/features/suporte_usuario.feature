# language: pt

 @suporte-usuario
 Funcionalidade: Suporte ao Usuário
   Como um usuário do site automationpractice,
   Eu quero poder enviar uma mensagem para o suporte do site relatando o problema que estou tendo,
   Para poder aproveitar os produtos e serviços oferecidos pelo site.


  @suporte-usuario-sucesso
  Cenario: enviar mensagem de ajuda para o suporte do site com sucesso
    Dado que eu esteja na pagina de suporte ao usuario do site
    Quando preencho os campos ASSUNTO, EMAIL, ANEXAR ARQUIVO, REFERENCIA e MENSAGEM
    E clico no botao ENVIAR
    Entao vejo na tela um alerta de que a mensagem foi enviada para equipe do site

  @suporte-usuario-campo-obrigatório-branco
  Cenario: alerta de erro ao nao preencher campo obrigatório
    Dado que eu esteja na pagina de suporte ao usuario do site
    Quando preencho os campos ASSUNTO, EMAIL, REFERENCIA e ANEXAR ARQUIVO
    E deixo o campo MENSAGEM em branco
    E clico no botao ENVIAR
    Entao vejo na tela uma mensagem de que o campo MENSAGEM não pode ficar em branco

  @suporte-usuario-email-invalido
  Cenario: alerta de erro informando que o email é invalido
    Dado que eu esteja na pagina de suporte ao usuario do site
    Quando preencho os campos ASSUNTO, ANEXAR ARQUIVO, REFERENCIA e MENSAGEM
    E prencho o campo email com teste123.test
    E clico no botao ENVIAR
    Entao vejo na tela uma mensagem de que o email informado é inválido.

  @suporte-usuario-formato-arquivo-invalido
  Cenario: alerta de erro informando que o formato do arquivo é inválido
    Dado que eu esteja na pagina de suporte ao usuario do site
    Quando preencho os campos ASSUNTO, EMAIL, REFERENCIA e MENSAGEM
    E faço o upload de um arquivo em formato de VIDEO no campo ANEXAR ARQUIVO
    E clico no botao ENVIAR
    Entao vejo na tela uma mensagem de que o formato do arquivo é inválido.