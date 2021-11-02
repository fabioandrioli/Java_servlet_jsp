# Java_servlet_jsp
Aprimorando os conhecimento em java web e jsp

 - Criando projeto
  - No editor eclipse vá em criar novo projeto.
  - Depois escreva dynamic web
  - Escolhe o tom cat que você configurou
  - escolha a opção next
  - marque a opção para criar o arquivo xml
  - Finalize o projeto

 - Depois que criar o projeto converta para projeto maven
 - Para isso crique com o botão direito em cima do projeto
 - Role até a opção configure
    - Escolha a opção converter to maven project.

# Arrumando aba do eclipse
- Mostre a aba package explore
- Para fazer isso, vá até configuração Window > show view
- Depois escreva explorer package.

# Criando o primeiro arquivo JSP
 - Dentro da pasta src/main/webapp.
 - Clique com o botão direito.
 - E crie um JSP.file

 # Rodando o projeto
 - Para rodar o projeto ele precisa ser adicionado ao server.
 - Clique com o botão direito no server (TOMCAT).
 - Selecione a opção ADD and REMOVE.
 - Adicione o projeto e depois vá em finish.
 - Depois você pode startar servidor.
 - Vá até a guia console, e veja em qual porta o servidor está
 - Geralmente no porta 8080.
 - Então acesso o servidor localhost:8080/nomedoprojeto

 # criação da SERVLETE
  - Clique com o botão direito em cima do src/main/java
  - Depois clique com o botão direito em new -> others -> escreva package, de o nome de servlets para o package.
  - Com o botão direito new -> others -> servlet.
  - Dependendo da sua versão do tom cat, a servlet vai importa ou do javax ou do jakarta.
  - o Atalho no eclipse para arrumar os imports corretamente é shifit + ctr + o

  # Criação da filter
  - Clique com o botão direito em cima do src/main/java
  - Depois clique com o botão direito em new -> others -> escreva package de o nome de filters para o package.
  - Com o botão direito new -> others -> filter.
  - Dependendo da sua versão do tom cat, a servlet vai importa ou do javax ou do jakarta.
  - o Atalho no eclipse para arrumar os imports corretamente é shifit + ctr + o
  
  # Banco, no filter é chamado a conexão com o banco
  - Após criar a classe de conexão.
  - Ela é instanciada na classe filter.

  # Como funciona
  - As clases dentro da pasta webapp são o frontend do sistema.
  - Ja as classes dentro src/main/java são o backend do sistema.
  - As servlets são o controle.

  # Adicionando dependencias
    - Caso você tenha convertido um projeto maven é comum que no arquivo pom.xml não apareça a tag <dependencies></dependencies>
    - Neste caso você terá que acionar ela manualmente.
    - depois dentro dela você adiciona a dependencia do mavem 
    - <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.11</version>
        </dependency>
    </dependencies>

