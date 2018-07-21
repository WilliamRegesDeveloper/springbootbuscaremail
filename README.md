## Projeto SpringBoot para Sincronizar Emails

A idéia desse código fonte é fazer com que o aplicativo sincronize
de tempos em tempos com um servidor de email buscando assim anexos
em sua caixa de entrada.


## Objetivo do app
Existe clientes que trabalham bastante com email e anexos e muitos 
desses anexos são xml de notas fiscais. O objetivo desse código 
é buscar esses xml e fazer com que seja gravado em algum repositório
podendo ser em pastas locais, remotas ou banco de dados. Isso depende
bastante de quem implementar esse código.


## Funcionamento
Esse app contém um schedule como serviço configurado para rodar de tempos em tempos
buscando email em algum servidor pop pre configurado no arquivo applicaton.properties


## Tecnologia utilizada
O protótipo desse app foi construido com as seguintes tecnologias da
ferramenta STS SpringBoot:

* Java 8;
* Framework Spring e SpringBoot;
* JavaMail;
* Protocolos SMTP e POP;
* Maven;
