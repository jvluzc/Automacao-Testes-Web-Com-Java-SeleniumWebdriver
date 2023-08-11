# language: pt

 @cadastro
 Funcionalidade: Cadastro
   Como um novo usuario do site Demo Automation Testing,
   Eu quero poder realizar o meu cadastro na plataforma,
   Para poder ter acesso aos produtos e serviços oferecidos pelo site.

   @cadastro-sucesso
   Cenario: cadastro bem sucedido
     Dado que eu esteja na pagina de cadastro
     Quando eu preencho todos os campos presentes na tela de cadastro de forma valida
     E clico no botão REGISTRAR
     Entao sou redirecionado para minha conta dentro do site
     E aparece na tela a mensagem de SUA CONTA FOI CRIADA

   @cadastro-campo-obrigatorio-branco
   Cenario: campo obrigatório em branco
     Dado que eu esteja na pagina de cadastro
     Quando eu deixo o campo SOBRENOME em branco
     E preencho os campos SEXO, NOME, SENHA E DATA NASCIMENTO de forma valida
     E clico no botão REGISTRAR
     Entao aparece uma menssagem na tela de que o campo sobrenome é obrigatorio

   @cadastro-email-invalido
   Cenario: email informado é inválido
     Dado que eu esteja na pagina de cadastro
     Quando preencho os campos SEXO, NOME, SOBRENOME, SENHA E DATA NASCIMENTO de forma valida
     E preencho o campo EMAIL com o email test321gmail.com
     E clico no botão REGISTRAR
     Entao aparece uma menssagem de erro de que o email informado é invalido

   @cadastro-email-ja-cadastrado
   Cenario: email informado já está cadastrado em outra conta
     Dado que eu esteja na pagina de cadastro
     Quando preencho os campos SEXO, NOME, SOBRENOME, SENHA E DATA NASCIMENTO de forma valida
     E prencho o campo EMAIL com um email que já cadastrei anteriormente em outra conta
     E clico no botão REGISTRAR
     Entao aparece uma menssagem na tela de o email informado já está viculado a outra conta

   @cadastro-senha-invalida
   Cenario: senha inválida
     Dado que eu esteja na pagina de cadastro
     Quando preencho os campos SEXO, NOME, SOBRENOME, EMAIL e DATA NASCIMENTO de forma valida
     E prencho o campo SENHA com menos de 5 caracteres
     E clico no botão REGISTRAR
     Entao aparece uma menssagem de erro de que a senha informada é invalida