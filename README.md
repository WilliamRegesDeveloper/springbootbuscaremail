## Projeto Leitura de Anexo de Email

A idéia desse protótipo de código fonte é fazer com que o aplicativo faça download
de tempos em tempos com um servidor de email buscando assim anexos em sua caixa de 
entrada como xml de notas, grave e envie reposta para outro email informando o 
download bem sucedido.


## Objetivo do app
Existe clientes que trabalham bastante com email e anexos e muitos 
desses anexos são xml de notas fiscais. O objetivo desse código 
é buscar esses xml e fazer com que seja gravado em algum repositório
podendo ser em pastas locais, remotas ou banco de dados. Isso depende
bastante de quem implementar esse código.


## Funcionamento
Esse app contém um schedule como serviço configurado para rodar de tempos em tempos
buscando email em algum servidor pop pre configurado no arquivo applicaton.properties.
O servidor de envio de email também tem parametros de configuração no arquivo application.properties


## Tecnologia utilizada
O protótipo desse app foi construido com as seguintes tecnologias da
ferramenta STS SpringBoot:

* Java 8;
* Framework Spring e SpringBoot;
* JavaMail;
* Protocolos SMTP e POP;
* Maven;

## Links do material base

* [Baeldung](http://www.baeldung.com/spring-email)
