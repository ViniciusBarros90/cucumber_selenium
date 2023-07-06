#language:pt
@test
Funcionalidade: Teste login Bugbank
  Cenario: Login com sucesso
    Dado que esteja na pagina inicial: "http://localhost:3000"
    E possuo cadastro
    Quando preencher email: "teste@teste.com.br" e senha: "teste"
    E clicar em fazer login
    Então valido que a pagina de boas vindas foi carregada


  Cenario: Login com sucesso 2
    Dado que esteja na pagina inicial: "http://localhost:3000"
    E possuo cadastro
    Quando preencher email: "teste@teste.com.br" e senha: "teste"
    E clicar em fazer login
        Então valido que a pagina de boas vindas foi carregada

@wip
  Cenario: Login com sucesso 3
    Dado que esteja na pagina inicial: "http://localhost:3000"
    E possuo cadastro
    Quando preencher email: "teste@teste.com.br" e senha: "teste"
    E clicar em fazer login
    Então valido que a pagina de boas vindas foi carregada