#language:pt
Funcionalidade: Teste login Bugbank
  Cenario: Login com sucesso
    Dado que esteja na pagina inicial: "http://localhost:3000"
    E preencho o cadastro com os dados
    |Email                |Nome       |Senha|Confirmacao|
    |teste10@teste.com.br |QA         |teste|teste      |
    |teste20@teste.com.br |QA         |teste|teste      |
    |teste30teste.com.br  |QA         |teste|teste      |

    Quando preencher email: "teste20@teste.com.br" e senha: "teste"
    E clicar em fazer login
    Então valido que a pagina de boas vindas foi carregada

