# controle-manutencao-equipamentos

== passo a passo de como rodar a aplicação ==

* Realize o clone da aplicação
* Execute a classe "ControleManutencaoEquipamentosApplication"
* com a aplicação em execução, já é possível chamar os endpoints diponiveis no postman na pasta resources/postman

=============================================

Sistema para controle de manutentenção de equipamentos.

endpint para o swagger: http://localhost:8080/controle-manutencao-equipamentos/swagger-ui.html

O sistema é usado para gerenciar todos os equipamentos que irão passar por manutenção.

o Sistema possue 5 endpoints:

![BADGE](https://img.shields.io/static/v1?label=POST&message=/ordem-servicos&color=important)

Endpoint de cadastro de ordem de serviço.

Esse endpoint é responsável por criar a ordem de serviço do equipamento que passará por análise.

Payload
```
{
  "descricao": "string",
  "responsavel": "string",
  "cliente": {
    "nome": "string",
    "endereco": {
      "cidade": "string",
      "logradouro": "string",
      "numero": "string",
      "complemento": "string",
      "bairro": "string",
      "cep": "string"
    },
    "email": "string",
    "telefone": "string"
  },
  "equipamento": {
    "tipo": "string",
    "marca": "string",
    "problema": "string"
  },
  "acompanhamento": [
    {
      "descricao": "string",
      "termino": true
    }
  ]
}
```
Response
```
{
  "id": 0,
  "descricao": "string",
  "responsavel": "string",
  "dataCadastro": "2023-06-12",
  "dataInicio": "2023-06-12",
  "dataTermino": "2023-06-12",
  "cliente": {
    "nome": "string",
    "endereco": {
      "cidade": "string",
      "logradouro": "string",
      "numero": "string",
      "complemento": "string",
      "bairro": "string",
      "cep": "string"
    },
    "email": "string",
    "telefone": "string"
  },
  "equipamento": {
    "tipo": "string",
    "marca": "string",
    "problema": "string"
  },
  "acompanhamento": [
    {
      "descricao": "string",
      "data": "2023-06-12",
      "termino": true
    }
  ]
}
```

![BADGE](https://img.shields.io/static/v1?label=POST&message=/ordem-servicos/{idOrdemServico}/acompanhamento&color=important)

Endpoint para cadastro de acompanhamento de ordem de serviço.

Esse endpoint é utilizado para registrar os serviços feito na ordem de serviço exemplo: inicio/término do serviço ou qualquer interrupção que ocorrer.

Para cadastrar o serviço que está sendo realizado, o campo término deve estar preenchido como false (no momento que for feito o apontamento do primeiro serviço o campo dataInicio da ordem de 
serviço será preenchido com a data que está sendo realizado o apontamento do serviço).

Para apontar o final do serviço o campo término deve estar preenchido como true, mas caso o primeiro apontamento de serviço ainda não tenha sido feito,
será exibido uma mensagem informando que a ordem de serviço ainda não foi iniciada.

Payload
```
{
  "descricao": "string",
  "termino": true
}
```
Response
```
{
  "descricao": "string",
  "data": "2023-06-12",
  "termino": true
}
```

![BADGE](https://img.shields.io/static/v1?label=GET&message=/ordem-servicos&color=important)

Endpoint para consulta de relatório.

Por Esse endpoint é possível por consultar as ordens de serviço por cliente e/ou responsável, o response da consulta possue todos os dados da ordem de serviço.

Payload
```
{
    "responsavel": "string",
    "cliente": "string"
}
```

Response
```
[
  {
    "id": 0,
    "descricao": "string",
    "responsavel": "string",
    "dataCadastro": "2023-06-12",
    "dataInicio": "2023-06-12",
    "dataTermino": "2023-06-12",
    "cliente": {
      "nome": "string",
      "endereco": {
        "cidade": "string",
        "logradouro": "string",
        "numero": "string",
        "complemento": "string",
        "bairro": "string",
        "cep": "string"
      },
      "email": "string",
      "telefone": "string"
    },
    "equipamento": {
      "tipo": "string",
      "marca": "string",
      "problema": "string"
    },
    "acompanhamento": [
      {
        "descricao": "string",
        "data": "2023-06-12",
        "termino": true
      }
    ]
  }
]
```
![BADGE](https://img.shields.io/static/v1?label=GET&message=/ordem-servicos/{idOrdemServico}&color=important)

Endpoint para consultar as ordem de serviço por id.

O response da consulta possue todos os dados da ordem de serviço.

Response
```
{
  "id": 0,
  "descricao": "string",
  "responsavel": "string",
  "dataCadastro": "2023-06-12",
  "dataInicio": "2023-06-12",
  "dataTermino": "2023-06-12",
  "cliente": {
    "nome": "string",
    "endereco": {
      "cidade": "string",
      "logradouro": "string",
      "numero": "string",
      "complemento": "string",
      "bairro": "string",
      "cep": "string"
    },
    "email": "string",
    "telefone": "string"
  },
  "equipamento": {
    "tipo": "string",
    "marca": "string",
    "problema": "string"
  },
  "acompanhamento": [
    {
      "descricao": "string",
      "data": "2023-06-12",
      "termino": true
    }
  ]
}
```
![BADGE](https://img.shields.io/static/v1?label=GET&message=/ordem-servicos/pendentes&color=important)

Endpoint para consultar as ordens de serviço pendentes por responsável.

O response da consulta possue todos os dados da ordem de serviço.

Parâmetro
```
    responsavel: "String"
```
Response
```
[
  {
    "id": 0,
    "descricao": "string",
    "responsavel": "string",
    "dataCadastro": "2023-06-12",
    "dataInicio": "2023-06-12",
    "dataTermino": "2023-06-12",
    "cliente": {
      "nome": "string",
      "endereco": {
        "cidade": "string",
        "logradouro": "string",
        "numero": "string",
        "complemento": "string",
        "bairro": "string",
        "cep": "string"
      },
      "email": "string",
      "telefone": "string"
    },
    "equipamento": {
      "tipo": "string",
      "marca": "string",
      "problema": "string"
    },
    "acompanhamento": [
      {
        "descricao": "string",
        "data": "2023-06-12",
        "termino": true
      }
    ]
  }
]
```