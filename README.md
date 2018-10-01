# Login via Web Service Restful

Escreva um **Web Service Restful** que recebe um login e uma senha e mostra a mensagem "Autorizado" caso o login seja "admin" e a senha seja "r**t", ou "Não Autorizado" caso contrário.

Informação      | Valor
----------------|-----------------------------------------------------------------------
**URL**         | `http://localhost:8080/dcs-jaxrs-login/webresources/login/`**usuario**
**Método**      | `POST`
**Dados**       | **senha**
**Status Code** | `200` se autorizado ou `401` se não autorizado

**Atenção:** use um formulário HTML para entrar com o login e a senha e **AJAX** para fazer a chamada ao web service.
