# Trabalho Final - HemoMax <picture><img src="Docs\images\hemomaxLogo.png" width = 45px height = 45px></picture>

> [!NOTE]
> Repositório voltado ao trabalho final das matérias:
> - Desenvolvimento Web BackEnd
> - Banco de Dados
> - Projeto Interdisciplinar I


## Sobre o Projeto
O projeto HemoMax se trata da criação de uma inteligência artificial como uma ferramenta de auxilio aos profissionais da área da saúde, tendo como objetivo básico e primordial é o desenvolvimento de um sistema de inteligência artificial, capaz de determinar com precisão diagnósticos, baseados em bioimagens relativas às amostras sangue dos pacientes.

## Descrição do Problema
O sangue é responsável por carregar uma variedade gigantesca de partículas pelo corpo, oxigênio, água, hormônios, entre outras, possibilitando a chegada dos compostos necessários para manutenção da vida celular. Considerando esse contexto e o desenvolvimento de metodologias científicas é notável a dificuldade e complexidade da análise deste composto, demandando tempo e esforço considerável para uma análise completa e confiável, que ainda sim estaria sujeita a falhas e problemas pontuais. A partir disso definimos esse como o ponto central para desenvolvimento do nosso projeto, ou seja, o problema que o nosso sistema buscará reduzir.

## Linguagens e Frameworks
- BackEnd: desenvolvido em Java com o Framework Spring Boot.
- SGBD: MySQL.
- REST API: Comunicação entre o FrontEnd e o BackEnd.

 ## Funcionalidades 
 - Cadastro de Administrador e de Biomédico: Criação dos logins e senhas para utilização do HemoMax.
 - Controle de acesso: Apenas aqueles com o login de Administrador terão permissão para remover ou alterar um login de membros da instituição.
 - Validação via Token: Cada requisição será enviada com um token para validação. Uma requisição que não possuir o token será desconsiderada.
 - Criptografia de senhas: Todas as senhas serão criptografadas antes de serem alocadas no banco de dados, garantindo a integridade dos dados.


## Estrutura
Para a construção do projeto, utilizamos a Arquitetura MVC (Model, View, Controller).

## Links dos videos
- BackEnd: https://youtu.be/8B0oUSQrEJ8

## Desenvolvedores
- Bernardo Buhr [@bernardobuhrmendonca](https://github.com/bernardobuhrmendonca)
- Caio Henrique [@Caiohbg01](https://github.com/Caiohbg01)
- Danilo Ramos [@RedPartyDan](https://github.com/RedPartyDan)
- Felipe Gurgel [@FelipeGA02](https://github.com/FelipeGA02)

