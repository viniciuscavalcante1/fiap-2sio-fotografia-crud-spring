# fiap-2sio-fotografia-crud-spring
Projeto desenvolvido ao longo do segundo ano de Sistemas de Informação na FIAP em 2023.

Para executar o projeto, é preciso ter instalado no computador o [Java](https://www.oracle.com/java/technologies/downloads/), alguma [IDE](https://www.jetbrains.com/idea/download/?section=windows) que consiga executar códigos em Java e também o banco de dados [MySQL](https://dev.mysql.com/downloads/installer/), da Oracle.

Assim que tiver tudo instalado, você pode tanto realizar o download do projeto aqui pelo GitHub clicando em Code > Download ZIP ou [clonar](https://docs.github.com/pt/repositories/creating-and-managing-repositories/cloning-a-repository) o repositório, com o seguinte comando no terminal, caso também tenha o [Git](https://git-scm.com/downloads) instalado em seu computador:

`git clone https://github.com/viniciuscavalcante1/fiap2sio-godigitalcode-spring.git`

Após isso, você terá o projeto instalado em seu computador. Para garantir que teremos todas as dependências necessárias para executar o projeto, é preciso instalar o [Maven](https://www.devmedia.com.br/introducao-ao-maven/25128), um gerenciador de dependências do Java. Ele poderá ser executado pela própria IDE, se você decidir usar o [IntelliJ IDEA](https://www.jetbrains.com/idea/download/?section=windows).

Com todas as dependências instaladas, basta rodar o arquivo `ApiApplication`, dentro da pasta `api > src > main > java > ApiApplication.java`. 

Para realizar o login, é necessário criar um usuário no banco de dados, na tabela `usuarios`. 
Sugiro que realize a seguinte operação no banco, pode ser pelo MySQL Workbench:

`INSERT INTO brunafotografia_api.usuarios VALUES ('vini@fotografia.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');`

As tabelas do banco são criadas automaticamente pelas Migrations do Spring, assim que você fizer a build do projeto. A senha é '123456', criptografada.

Com tudo isso, o projeto estará pronto para ser executado e testado.
Obrigado!
