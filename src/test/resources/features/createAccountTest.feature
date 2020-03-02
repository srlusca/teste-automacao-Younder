#language: pt
#enconding: UFT-8
#author: Lucas Moreira

Funcionalidade: A description

  Contexto:

    Dado que eu acessei a pagina 'fakenamegenerator.com'
    E armazeno as informacoes necessarias do usuario para cadastrar-lo no gmail
    Quando sigo ate a pagina de 'Criar sua Conta do Google' e insiro as informacoes armazenadas

  @regression @ct01 @brasil
  Cenario: Validar mensagem de erro de retorno com o pais Brasil
    Entao seleciono o pais de 'Brasil' e insiro o telefone invalido

  @regression @ct02 @canada
  Cenario: Validar mensagem de erro de retorno com o pais de Canada
    Entao seleciono o pais de 'Canada' e insiro telefone invalido

  @regression @ct03 @uruguay
  Cenario: Validar mensagem de erro de retorno com o pais de Uruguay
    Entao seleciono o pais de 'Uruguay' e insiro telefone invalido
