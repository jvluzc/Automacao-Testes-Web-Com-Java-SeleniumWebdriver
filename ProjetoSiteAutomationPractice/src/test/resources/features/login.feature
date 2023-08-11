# language: pt

 @login
 Funcionalidade: Login
   Como um usuário já cadastrado no site automationpractice,
   Eu quero entrar na minha conta,
   Para poder ter acesso aos produtos e serviços oferecidos pelo site.

  @login-sucesso
  Cenario: login bem sucedido
    Dado que estou na pagina de login do site
    Quando preencho os campos obrigatórios com valores válidos
    E clico no botão ENTRAR
    Entao tenho acesso a minha conta dentro do site

  @login-email-nao-cadastrado
  Cenario: email ainda nao cadastrado
    Dado que estou na pagina de login do site
    Quando preencho o campo EMAIL com um email ainda não cadastrado
    E preencho o campo SENHA com uma valor válido
    E clico no botão ENTRAR
    Entao aparece uma mensagem de erro na tela de falha na autenticação

  @login-senha-invalida
  Cenario: senha inserida é inválida
    Dado que estou na pagina de login do site
    Quando preencho o campo EMAIL com um email já cadastrado
    E preencho o campo senha de forma inválida
    E clico no botão ENTRAR
    Entao aparece uma mensagem na tela informando que a senha é invalida

  @login-campo-n-preenchido
  Cenario: campo obrigatório não preenchido
    Dado que estou na pagina de login do site
    Quando preencho o campo EMAIL com um email já cadastrado
    E não prencho o campo senha
    E clico no botão ENTRAR
    Entao aparece uma mensagem na tela de que o campo senha é obrigatório

  @login-recuperação-de-senha-email-cadastrado
  Cenario: recuperação de senha de um email já cadastrado
    Dado que estou na pagina de login do site
    E clico em ESQUECEU SUA SENHA
    Entao sou redirecionado para pagina de recuperaçao de senha
    Quando informo meu email já cadastrado no campo ENDEREÇO DE EMAIL
    E clico em RECUPERAR SENHA
    Entao uma mensagem de que um email para recuperar minha senha foi enviada para meu email

  @login-erro-recuperação-senha-email-nao-cadastrado
  Cenario: erro recuperação de senha de email não cadastrado
    Dado que estou na pagina de login do site
    E clico em ESQUECEU SUA SENHA
    Entao sou redirecionado para pagina de recuperaçao de senha
    Quando informo um email ainda não cadastrado no campo ENDEREÇO DE EMAIL
    E clico em RECUPERAR SENHA
    Entao uma mensagem de erro aparece na tela de que nenhuma conta foi registrada com esse endereço de email